package com.spartronics4915.learnyouarobot.robot;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.spartronics4915.learnyouarobot.robot.ShooterSubsystem;

public class StopCommand extends CommandBase {

    private ShooterSubsystem mShooterSubsystem;

    public StopCommand() {
        mShooterSubsystem = ShooterSubsystem.getInstance();
    }

    public void initialize() {
        mShooterSubsystem.stop();
    }

    public void execute() {
    }

    public void end(boolean interrupted) {
    }

    public boolean isFinished() {
        return true;
    }

    public void outputTelemetry() {

    }
}
