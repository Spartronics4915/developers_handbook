package com.spartronics4915.learnyouarobot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Lesson extends IterativeRobot {
	TalonSRX motor;
	TalonSRX motorTwo;
	Joystick joystick;

	boolean isMotorToggledOn = false;

	@Override
	public void robotInit() {
		motor = new TalonSRX(3); // Motor is CAN ID 3
		motorTwo = new TalonSRX(4);
		joystick = new Joystick(0);
	}

	@Override
	public void autonomousPeriodic() {
		motor.set(ControlMode.PercentOutput, 0.5);
		motorTwo.set(ControlMode.PercentOutput, 1.0);
	}

	@Override
	public void teleopInit() {
		
	}

	@Override
	public void teleopPeriodic() {
		if (joystick.getRawButton(1)) isMotorToggledOn = !isMotorToggledOn;

		motor.set(ControlMode.PercentOutput, joystick.getY());
		motorTwo.set(ControlMode.PercentOutput, isMotorToggledOn ? 1.0 : 0.0);
	}
}
