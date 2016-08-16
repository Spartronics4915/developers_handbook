# Subsystem Examples

Included in the GitHub hosting of this document are some example Subsystem
files from past years. Here we will go into detail as to reasoning behind
the choices made in the code, their ramifications, and finally alternatives.

## DriveTrain.java, mecanum edition

For the Recycle Rush competition, Spartronics 4915's robot GAEA used
a mecanum based drive train, which provides additional control systems
when it comes to steering.

The main autonomous commands we used that year were the following:
* Move straight a desired distance
* Move left or right a desired distance
* Rotate 90º in place
* Stop wheels from moving

These together make up the bulk of our autonomous commands when it came to
moving on the field. These commands took numbers as input, which we would
pull from constants to keep the command execution consistent.

During the tele-op period, we only needed one command to take input
from the driver's joystick and use that to control the drivetrain.
Because we wouldn't ever want to override this operation, we made that
command never finish, meaning it would constantly run it's execute method
(below). And by designing the drivetrain subsystem to work best with
commands, the resulting execute method is only two lines long, compared
to the actual code the command is running.

```java
// Called repeatedly when this Command is scheduled to run
protected void execute() {
    Joystick joystickDrive = Robot.oi.driveStick;
    Robot.driveTrain.mecanumDrive(joystickDrive);
}
```

```java
/**
 * Drives a mecanum drivetrain in the direction of the joystick pointed
 * Since the motors are enabled to use their encoders in RobotMap, each
 * motor should go at the speeds that they need to more accurately. Because
 * of this, we do not want to use setMaxOutput, because the value set in
 * RobotMap.java is needed to be the same.
 *
 * @param joystick Joystick controlling the robot movement
 */
public void mecanumDrive(Joystick joystick) {

    double joystickX = joystick.getAxis(Joystick.AxisType.kX);
    double joystickY = joystick.getAxis(Joystick.AxisType.kY);
    double joystickTwist = joystick.getAxis(Joystick.AxisType.kTwist);
    boolean speedButton = joystick.getRawButton(SPEED_BUTTON);

    double twistScale = DEFAULT_TWIST_SCALE;

    if (speedButton) {
        twistScale = 1;
    }

    throttle = 0.40 * (-joystick.getThrottle()) + 0.60;
    debugger.logError(LoggerNames.DRIVETRAIN, "Throttle Value: " + throttle);

    if (Math.abs(joystickX) <= 0.2) {
        joystickX = 0;
    }
    if (Math.abs(joystickY) <= 0.2) {
        joystickY = 0;
    }

    boolean strafeOnly = (Math.abs(joystickY) < SECTOR_15º_RATIO * Math.abs(joystickX));
    boolean forwardOnly = (Math.abs(joystickX) < SECTOR_15º_RATIO * Math.abs(joystickY));

    double bufferX = DEFAULT_BUFFER;
    double bufferY = DEFAULT_BUFFER;
    double bufferZ = DEFAULT_BUFFER;

    if (strafeOnly) {
        bufferY *= DOUBLE;
        bufferZ *= DOUBLE;
    }
    if (forwardOnly) {
        bufferX *= DOUBLE;
        bufferZ *= DOUBLE;
    }

    boolean deadZoneX = Math.abs(joystickX) < bufferX;
    boolean deadZoneY = Math.abs(joystickY) < bufferY;
    boolean deadZoneTwist = Math.abs(joystickTwist) < bufferZ;

    if (deadZoneX) joystickX = 0;
    if (deadZoneY || strafeOnly) joystickY = 0;
    if (deadZoneTwist || strafeOnly) joystickTwist = 0;

    double throttleX = throttle*joystickX;
    double throttleY = throttle*joystickY;
    double throttleTwist = throttle*twistScale*joystickTwist;

    //Gyro Tracking and debug
    Robot.driveTrain.trackGyro();


    if (deadZoneX && deadZoneY && deadZoneTwist) {
        robotDrive.stopMotor();
    } else if (fieldMode) {
        robotDrive.mecanumDrive_Cartesian(throttleX, throttleY, throttleTwist, gyroHeading);
    } else {
        robotDrive.mecanumDrive_Cartesian(throttleX, throttleY, throttleTwist, 0);
    }
}
```
