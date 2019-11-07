package com.spartronics4915.learnyouarobot.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.spartronics4915.learnyouarobot.robot.ShooterSubsystem;

public class ShootCommand extends CommandBase {

    private ShooterSubsystem mShooterSubsystem;

    public ShootCommand() {
        mShooterSubsystem = ShooterSubsystem.getInstance();
    }

    public void initialize() {
    }

    public void execute() {
        mShooterSubsystem.shootBall(0.5);
    }

    public void end(boolean interrupted) {
        mShooterSubsystem.stop();
    }

    public boolean isFinished() {
        return false;
    }

    public void outputTelemetry() {

    }
}
