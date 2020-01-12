package com.spartronics4915.learnyouarobot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.spartronics4915.lib.SpartronicsSubsystem;

public class ShooterSubsystem extends SubsystemBase {

    TalonSRX mMotor;

    // Creates a new ShooterSubsystem (it's called Lesson here).
    public ShooterSubsystem() {
        mMotor = new TalonSRX(14);
    }

    // Example actions as methods go here...
    // public void raiseArm()

    public void shootBall(double dutyCycle) {
        mMotor.set(ControlMode.PercentOutput, dutyCycle);
    }

    public void unjam() {
        mMotor.set(ControlMode.PercentOutput, -0.5);
    }

    public void stop() {
        mMotor.set(ControlMode.PercentOutput, 0.0);
    }

    public void outputTelemetry() {

    }
}
