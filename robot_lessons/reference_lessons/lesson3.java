package com.spartronics4915.learnyouarobot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.spartronics4915.learnyouarobot.robot.Logger;
import com.spartronics4915.learnyouarobot.robot.Subsystem;
import com.spartronics4915.learnyouarobot.robot.loops.ILooper;
import com.spartronics4915.learnyouarobot.robot.loops.Loop;

public class Lesson extends Subsystem
{

    private static Lesson mInstance = null;

    public static Lesson getInstance()
    {
        if (mInstance == null)
        {
            mInstance = new Lesson();
        }
        return mInstance;
    }

    public enum WantedState
    {
        CLOSED, INTAKE, EJECT,
    }

    private enum SystemState
    {
        CLOSING, INTAKING, EJECTING,
    }

    private WantedState mWantedState = WantedState.CLOSED;
    private SystemState mSystemState = SystemState.CLOSING;

    private TalonSRX mIntakeMotor = null;
	private DoubleSolenoid mEjectSolenoid = null;

    private Lesson()
    {
        boolean success = true;
        try
        {
            // Instantiate your hardware here
            mIntakeMotor = new TalonSRX(14);
			mEjectSolenoid = new DoubleSolenoid(1, 2);
        }
        catch (Exception e)
        {
            success = false;
            logException("Couldn't instantiate hardware", e);
        }

        logInitialized(success);
    }

    private Loop mLoop = new Loop()
    {

        @Override
        public void onStart(double timestamp)
        {
            synchronized (Lesson.this)
            {
                mWantedState = WantedState.CLOSED;
                mSystemState = SystemState.CLOSING;
            }
        }

        @Override
        public void onLoop(double timestamp)
        {
            synchronized (Lesson.this)
            {
				DoubleSolenoid.Value solenoidValue = DoubleSolenoid.Value.kOff;

			    SystemState newState = defaultStateTransfer();
                switch (mSystemState)
                {
                    case INTAKING:
                        mIntakeMotor.set(ControlMode.PercentOutput, 1.0);
                        break;
					case EJECTING:
						mIntakeMotor.set(ControlMode.PercentOutput, -1.0);
						solenoidValue = DoubleSolenoid.Value.kReverse;
                    case CLOSING:
						if (newState == SystemState.EJECTING)
							newState = mSystemState;
                        stop();
                        break;
                    default:
                        Logger.error("Unhandled system state!");
                }
                mSystemState = newState;

				mEjectSolenoid.set(solenoidValue);
            }
        }

        @Override
        public void onStop(double timestamp)
        {
            synchronized (Lesson.this)
            {
                stop();
            }
        }
    };

    private SystemState defaultStateTransfer()
    {
        SystemState newState = mSystemState;
        switch (mWantedState)
        {
            case CLOSED:
                newState = SystemState.CLOSING;
                break;
            case INTAKE:
                newState = SystemState.INTAKING;
                break;
			case EJECT:
				newState = SystemState.EJECTING;
				break;
            default:
                newState = SystemState.CLOSING;
                break;
        }
        return newState;
    }

    public synchronized void setWantedState(WantedState wantedState)
    {
        mWantedState = wantedState;
    }

    @Override
    public void registerEnabledLoops(ILooper enabledLooper)
    {
        enabledLooper.register(mLoop);
    }

    @Override
    public boolean checkSystem()
    {
        return false;
    }

    @Override
    public void outputTelemetry()
    {

    }

    @Override
    public void stop()
    {
        // Stop your hardware here
        mIntakeMotor.set(ControlMode.PercentOutput, 0.0);
    }

    // This method would not normally be in a subsystem (it would be in Robot), but
    // you need to edit it to get user input
    public void teleopPeriodic(Joystick joystick)
    {
        if (joystick.getRawButtonPressed(1))
        {
            this.setWantedState(WantedState.INTAKE);
        }
        else if (joystick.getRawButtonPressed(2))
        {
            this.setWantedState(WantedState.CLOSED);
        }
		else if (joystick.getRawButtonPressed(3))
		{
			this.setWantedState(WantedState.EJECT);
		}
    }
}
