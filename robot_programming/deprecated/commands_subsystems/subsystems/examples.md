# Subsystem Examples

Included in the GitHub hosting of this document are some example Subsystem files from past years. Here we will go into detail as to reasoning behind the choices made in the code, their ramifications, and finally alternatives.

## DriveTrain.java, mecanum edition

For the Recycle Rush competition, Spartronics 4915's robot GAEA used a mecanum based drive train, which provides additional control systems when it comes to steering.

The main autonomous commands we used that year were the following:
* Move straight a desired distance
* Move left or right a desired distance
* Rotate 90º in place
* Stop wheels from moving

These together make up the bulk of our autonomous commands when it came to moving on the field. These commands took numbers as input, which we would pull from constants to keep the command execution consistent.

During the tele-op period, we only needed one command to take input from the driver's joystick and use that to control the drivetrain. Because we wouldn't ever want to override this operation, we made that command never finish, meaning it would constantly run it's execute method (below). And by designing the drivetrain subsystem to work best with commands, the resulting command is only two lines long, compared to the actual code the command is running.

```java
// In MecanumDriveCommand.java
Joystick joystickDrive; // This object is the driver's joystick which controls the driving of the robot.

// Called once when this Command runs the first time
protected void initialize()
{
    // Initializes the joystick so that we can read the user's input
    joystickDrive = Robot.oi.driveStick;
}

// Called repeatedly when this Command is scheduled to run
protected void execute()
{
    // We pass the joystick directly to our mecanumDrive method, which extracts
    // the important information about direction and spin and controls the motors appropriately
    Robot.driveTrain.mecanumDrive(joystickDrive);
}
```

The mecanumDrive method is much more complicated, because of how we use the joystick data. We found that using the raw values of the joystick axes was not desirable for direct control of the drivetrain steering because it would not be easy to control with precision, as you would have to control speed and direction with the one input device. To improve driving, we scale these values based on a slider on the joystick (the throttle).

In addition, we found that turning was difficult at times, but did not want to have the robot changing orientation during the normal course of play. Because of this, we added a twist scale which could be toggled based on a button input, which would dampen or raise the rate of rotation.

Once we calculated all of the parameters (forward, horizontal, and rotational motion) we pass these parameters into the mecanumDrive_Cartesian method inherited from the RobotDrive class (since the drivetrain's robotDrive object is an instance of RobotDrive). However, if the FieldMode parameter is set, instead it drives using the gyroscope to automatically adjust the direction of motion so that forward on the joystick always drives in the same direction. Most importantly, if the parameters are all below a set threshold, the robot will not move at all, cutting down on motor wear.

```java
/**
 * Drives a mecanum drivetrain in the direction of the joystick pointed
 * Since the motors are enabled to use their encoders in RobotMap, each motor
 * should go at the speeds that they need to more accurately.
 * Because of this, we do not want to use setMaxOutput, because the value set in
 * RobotMap.java is needed to be the same.
 *
 * @param joystick Joystick controlling the robot movement
 */
public void mecanumDrive(Joystick joystick)
{

    // First we extract the important values from the joystick.
    // In order: Left/Right, Forward/Back, Rotation, and the button value
    // that determines if the robot should spin at full speed or not.
    double joystickX = joystick.getAxis(Joystick.AxisType.kX);
    double joystickY = joystick.getAxis(Joystick.AxisType.kY);
    double joystickTwist = joystick.getAxis(Joystick.AxisType.kTwist);
    boolean speedButton = joystick.getRawButton(SPEED_BUTTON);

    // Determines the rate of rotation;
    // double DEFAULT_TWIST_SCALE = 0.5;
    double twistScale = DEFAULT_TWIST_SCALE;

    // If the speedButton is held down, the twistScale is raised to 1 (full)
    if (speedButton)
    {
        twistScale = 1;
    }

    // Here we get the throttle slider's raw value (between -1 and 1) and
    // shift its range of values to .2 to 1 - this would be better as
    // a method that utilizes constants.
    double throttle = 0.40 * (-joystick.getThrottle()) + 0.60;

    // Here we set the X and Y values to zero if they are below a threshold.
    // This is important so that we aren't passing small values that the
    // motors cannot execute.
    // DEFAULT_BUFFER = 0.2
    if (Math.abs(joystickX) <= DEFAULT_BUFFER)
    {
        joystickX = 0;
    }
    if (Math.abs(joystickY) <= DEFAULT_BUFFER)
    {
        joystickY = 0;
    }

    // SECTOR_15º_RATIO is the tangent of 15 degrees - what this means
    // is if the joystick is pointing in a 30 degree cone left or right,
    // strafeOnly is set to true, and if it's pointing in a 30 degree cone
    // up or down, forwardOnly is set to true.
    boolean strafeOnly = (Math.abs(joystickY) < SECTOR_15º_RATIO * Math.abs(joystickX));
    boolean forwardOnly = (Math.abs(joystickX) < SECTOR_15º_RATIO * Math.abs(joystickY));

    // DEFAULT_BUFFER = 0.2
    double bufferX = DEFAULT_BUFFER;
    double bufferY = DEFAULT_BUFFER;
    double bufferZ = DEFAULT_BUFFER;

    // Increases the deadzone buffer of the other directions if the robot should strafeOnly or go forwardOnly
    if (strafeOnly)
    {
        bufferY *= DOUBLE;
        bufferZ *= DOUBLE;
    }
    if (forwardOnly)
    {
        bufferX *= DOUBLE;
        bufferZ *= DOUBLE;
    }

    // If these values are less than their buffer values, then they are
    // flagged to be set to zero.
    boolean deadZoneX = Math.abs(joystickX) < bufferX;
    boolean deadZoneY = Math.abs(joystickY) < bufferY;
    boolean deadZoneTwist = Math.abs(joystickTwist) < bufferZ;

    // joystickX is set to zero if its absolute value was less than bufferX
    if (deadZoneX) joystickX = 0;
    // joystickY is set to zero if it's absolute value was less than bufferY
    // or the robot should only strafe left/right.
    if (deadZoneY || strafeOnly) joystickY = 0;
    // joystickTwist is set to zero if it's absolute value was less than
    // bufferZ or it should only strafe left/right.
    if (deadZoneTwist || strafeOnly) joystickTwist = 0;

    // Scale the resulting values by multiplying them against the throttle,
    // allowing the driver to reduce the robot's speed by a single scalar.
    // Also adjusts the turning rate by multiplying it with twistScale.
    double throttleX = throttle*joystickX;
    double throttleY = throttle*joystickY;
    double throttleTwist = throttle*twistScale*joystickTwist;

    // If all of the inputs are within their deadzone's, then the robot will stop moving.
    if (deadZoneX && deadZoneY && deadZoneTwist)
    {
        robotDrive.stopMotor();
    }
    else if (fieldMode)
    {
        // If the robot is in field mode (set by another command), it will
        // also pass a gyroscope angle along with the scaled parameters.
        robotDrive.mecanumDrive_Cartesian(throttleX, throttleY, throttleTwist, trackGyro());
    }
    else
    {
        // Uses the scaled parameters with the default mecanum drive method in RobotDrive.java
        robotDrive.mecanumDrive_Cartesian(throttleX, throttleY, throttleTwist, 0);
    }
}
```
