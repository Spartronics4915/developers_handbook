package com.spartronics4915.learnyouarobot.robot;

import com.spartronics4915.learnyouarobot.Lesson;
import com.spartronics4915.learnyouarobot.robot.loops.Looper;
import com.spartronics4915.learnyouarobot.robot.Logger;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Arrays;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class Robot extends IterativeRobot
{

    private Looper mEnabledLooper = new Looper();
    private Looper mDisabledLooper = new Looper();

    private SubsystemManager mSubsystemManager = null;

    private final Joystick mJoystick = new Joystick(0);

    private Lesson mLessonSubsystem = null;

    private static final String kRobotLogVerbosityKey = "Robot/Verbosity";

    public Robot()
    {
        Logger.logRobotConstruction();
    }

    @Override
    public void robotInit()
    {
        try
        {
            Logger.logRobotInit();

            try (InputStream manifest =
                    getClass().getClassLoader().getResourceAsStream("META-INF/MANIFEST.MF"))
            {
                // build a version string
                Attributes attributes = new Manifest(manifest).getMainAttributes();
                String buildStr = "by: " + attributes.getValue("Built-By") +
                        "  on: " + attributes.getValue("Built-At") +
                        "  (" + attributes.getValue("Code-Version") + ")";
                SmartDashboard.putString("Build", buildStr);
                SmartDashboard.putString(kRobotLogVerbosityKey, "NOTICE"); // Verbosity level

                Logger.notice("=================================================");
                Logger.notice(Instant.now().toString());
                Logger.notice("Built " + buildStr);
                Logger.notice("=================================================");

            }
            catch (IOException e)
            {
                SmartDashboard.putString("Build", "version not found!");
                Logger.warning("Build version not found!");
                DriverStation.reportError(e.getMessage(), false);
            }

            try
            {
                mLessonSubsystem = Lesson.getInstance();

                mSubsystemManager = new SubsystemManager(
                        Arrays.asList(mLessonSubsystem));
                mSubsystemManager.registerEnabledLoops(mEnabledLooper);
                mSubsystemManager.registerDisabledLoops(mDisabledLooper);
            }
            catch (Exception e)
            {
                // Try to avoid "robots don't quit" if there's a bug in subsystem init
                Logger.logThrowableCrash("ERROR Couldn't instantiate subsystems", e);
            }
        }
        catch (Throwable t)
        {
            Logger.logThrowableCrash(t);
            throw t;
        }
    }

    @Override
    public void disabledInit()
    {
        SmartDashboard.putString("Match Cycle", "DISABLED");

        try
        {
            Logger.logDisabledInit();
            Logger.setVerbosity(SmartDashboard.getString(kRobotLogVerbosityKey, "NOTICE"));

            mEnabledLooper.stop();
            
            mDisabledLooper.start();
        }
        catch (Throwable t)
        {
            Logger.logThrowableCrash(t);
            throw t;
        }
    }

    @Override
    public void teleopInit()
    {
        SmartDashboard.putString("Match Cycle", "TELEOP");

        try
        {
            Logger.logTeleopInit();
            Logger.setVerbosity(SmartDashboard.getString(kRobotLogVerbosityKey, "NOTICE"));

            mDisabledLooper.stop();
            mEnabledLooper.start();
        }
        catch (Throwable t)
        {
            Logger.logThrowableCrash(t);
            throw t;
        }
    }

    @Override
    public void disabledPeriodic()
    {
        SmartDashboard.putString("Match Cycle", "DISABLED");

        try
        {
            outputToSmartDashboard();

        }
        catch (Throwable t)
        {
            Logger.logThrowableCrash(t);
            throw t;
        }
    }

    @Override
    public void teleopPeriodic()
    {
        SmartDashboard.putString("Match Cycle", "TELEOP");

        try
        {
            mLessonSubsystem.teleopPeriodic(mJoystick);

            outputToSmartDashboard();
        }
        catch (Throwable t)
        {
            Logger.logThrowableCrash(t);
            throw t;
        }
    }

    public void outputToSmartDashboard()
    {
        mSubsystemManager.outputToTelemetry();
        mEnabledLooper.outputToSmartDashboard();
    }
}
