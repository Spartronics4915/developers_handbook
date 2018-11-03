package com.spartronics4915.learnyouarobot;

import edu.wpi.first.wpilibj.IterativeRobot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Lesson extends IterativeRobot {
	TalonSRX motor;

	@Override
	public void robotInit() {
		motor = new TalonSRX(14); // Motor is CAN ID 14
	}

	@Override
	public void teleopInit() {

	}

	@Override
	public void teleopPeriodic() {
		motor.set(ControlMode.PercentOutput, 0.5); // Run the motor at 50%
	}
}
