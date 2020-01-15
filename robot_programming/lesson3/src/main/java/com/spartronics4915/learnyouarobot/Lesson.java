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
    }

    public void initialize() {
        // Code you want to run upon start
    }

    public void execute() {
        // Code you want to run over and over
    }

    public void end(boolean interrupted) {
        if (interrupted) {
            // Code you want to run if a command is interrupted
        }
        else {
            // Code you want to run if a command finishes normally
        }
    }

    public boolean isFinished() {
        // What is the finish condition?
    }

    public void outputTelemetry() {

    }
}
