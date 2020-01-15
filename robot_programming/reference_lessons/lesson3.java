package com.spartronics4915.learnyouarobot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.spartronics4915.learnyouarobot.robot.ShooterSubsystem;

public class Lesson extends CommandBase {

    // A subsystem variable goes here
    private ShooterSubsystem mShooterSubsystem;
    private int count;

    // Creates a new ShootCommand (it's called Lesson here).
    public Lesson() {
        // Subsystems are set here
        mShooterSubsystem = ShooterSubsystem.getInstance();
        count = 0;
    }

    public void initialize() {
        // Code you want to run upon start
        mShooterSubsystem.stop();
    }

    public void execute() {
        // Code you want to run over and over
        mShooterSubsystem.shootBall(0.5);
    }

    public void end(boolean interrupted) {
        if (interrupted) {
            // Code you want to run if a command is interrupted
            mShooterSubsystem.stop();
        }
        else {
            // Code you want to run if a command finishes normally
            mShooterSubsystem.stop();
        }
    }

    public boolean isFinished() {
        // What is the finish condition?
        if (count == 200)
            return true;
        else
            count++;
        return false;
    }

    public void outputTelemetry() {

    }
}
