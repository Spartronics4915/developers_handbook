import edu.wpi.first.wpilibj.IterativeRobot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Lesson extends IterativeRobot {
	TalonSRX motor;

	@Override
	public void robotInit() {
		motor = new TalonSRX(3); // Motor is CAN ID 3
	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {
		motor.set(ControlMode.PercentOutput, 0.5);
	}
}
