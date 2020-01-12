package com.spartronics4915.learnyouarobot.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.spartronics4915.learnyouarobot.Lesson;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Robot extends TimedRobot {

    Lesson mShooter = new Lesson();
    Joystick mJoy = new Joystick(0);

    @Override
    public void robotInit() {
    }

    @Override
    public void teleopInit() {
        if (!mJoy.getRawButton(1)) {
            mShooter.shootBall(mJoy.getY());
        } else {
            mShooter.unjam();
        }
    }

    @Override
    public void teleopPeriodic() {

    }
}
