# Programming CANTalon
Important, please refer to [programmer's manual](http://www.ctr-electronics.com/Talon%20SRX%20Software%20Reference%20Manual.pdf) for full description of capabilities and programming examples.

## Units: Native vs Human-Readable
The Talon’s firmware uses a native unit set for the various signals. However the programming API allows for conversion into human-readable units, such as rotations and RPM. Depending on sensor selection, this may require the application to inform the API the resolution of the sensor using configuration routines.

Robot API supports unit scaling so sensor position/velocity and closed-loop target position and velocity can be expressed in rotations and RPM. roboRIO Web-based config also will decode in rotations and RPM.

**See Units and Signal Definitions in programmer's manual.**

## Motor Safety
From Motor Safety Helper section in the programmer's manual:

> The Motor Safety feature works in a similar manner as the other motor controllers. The goal is to set an expiration time to a given motor controller, such that, if the Set()/set() routine is not called within the expiration time, the motor controller will disable. Additionally the DS will report the error and the roboRIO Web-based Configuration Self-Test will report kDisabled as the mode. As a result, the set routine must be called periodically for sustained motor drive when motor safety is enabled.

> Be sure to test that the time between enabling Motor Safety features, and the first Set()/set() call is small enough to not risk accidently timing out. Calling Set()/set() immediately after enabling the feature can be used to ensure transitioning into the enabled modes doesn’t intermittently cause a timeout.
> Even if tripping the motor-safety expiration time is not an expected condition, it’s best to re- enable the motors somewhere in the source so that the timeouts can be reset easily, for example in AutonInit()/TeleopInit(). That way normal robot functionality can be safely resumed after a motor controller expires (usually during source-level debugging).
> Additionally if source-level debugging is not required (for example during a competition or if logging-style debugging is preferred) the motor-safety enable can be turned off.

_setSafeyEnabled()_ can be used to turn on this feature. _setExpiration()_ can be used to set the expiration time. The default expiration time is typically 100ms.

### RobotDrive
> Higher level class types such as RobotDrive have their own motor safety objects. Although CANTalon safety features default _off_, the higher level drive objects tend to default safety enable to on. If you are still witnessing disabled motor drive behavior and Motor Safety Driver Station Log Messages then you may need to call setSafetyEnabled(false) (or similar routines/VI) on RobotDrive objects as well. Keep in mind that disabling safety enable means that motor drive is allowed to continue if a source-level breakpoint halts program flow. Take the necessary precautions to debug the robot safely or alternatively only enable motor safety features when performing source level debugging.

### set() for Motor Safety
> Ensure robot application calls Set() on each Talon at least once per loop. Avoid strategies that attempt to write the Talon set-output “only when it changes”. There is no cost to updating the set-output of the Talon SRX using the robot API, and often such strategies trip the motor-safety
features

# Programming Closed-Loop Modes
## Programming Velocity-Closed Loop
For examples see:
- https://github.com/CrossTheRoadElec/FRC-Examples and see Velocity Closed-Loop Walkthrough section in Talon SRX programmers manual
- 2016 Spartronics drive train implementation
- @TODO include link to Talon SRX speed mode

## Programming Position Closed-Loop
For examples see:
- https://github.com/CrossTheRoadElec/HERO-Examples
- 2015 Spartronics elevator implementation

# Configuring Feedback Devices
## Quadrature Encoder
@TODO sample code on how to configure quadrature encoder

# WPI APIs
## Constructing a CANTalon Object
```java
// Constructors
CANTalon(int deviceNumber)  // CAN id of the Talon SRX
CANTalon(int deviceNumber, int controlPeriodMs) // The period in ms to send the CAN control frame. Period is bounded to [1ms,95ms].
CANTalon(int deviceNumber, int controlPeriodMs, int enablePeriodMs) // The period in ms to send the enable control frame. Period is bounded to [1ms,95ms]. This typically is not required to specify, however this could be used to minimize the time between robot-enable and talon-motor-drive.

// Example CANTalon object connected to device #10
CANTalon motor10 = new CANTalon(10); // device ID to match roboRIO configuration page
```

## Setting Control Mode
@TODO clean up
> After calling a Talon SRX object’s changeMode() function, the Talon SRX mode is set to disabled until the Set()/set() routine is called. This is to ensure the robot application has a chance to pass a new target set point before the new control mode is applied. Any call to changeMode() should be immediately followed with a Set()so that motor drive is not set to neutral.
This ensures that when the robot application changes a Talon’s mode, it also specifies the throttle/set-point/or slave ID for the new mode to ensure all the necessary information is set for the mode switch.

```java
motor10.changeControlMode(TalonControlMode.Speed); // configures Speed mode
```
## Selecting Feedback Device
For soft limit and closed-loop features, Talon SRX requires a feedback device. Default value is Quadrature Encoder.

> Once a “Feedback Device” is selected, the “Sensor Position” and “Sensor Velocity” signals will update with the output of the selected feedback device. It will also be multiplied by (-1) if “Reverse Feedback Sensor" is asserted programmatically.
> Alternatively the output of the closed loop logic can also be inverted if necessary.

setFeedbackDevice() can be used to select Quadrature Encoder, Analog Encoder (or any continuous 3.3V analog sensor) or Analog Potentiometer.

```java
motor10.setFeedbackDevice(FeedbackDevice.QuadEncoder);
motor10.reverseSensor(true);  // pass true to reverse feedback sensor signal; false if not
motor10.reverseOutput(false);  // pass true to reverse motor direction
motor10.isSensorPresent(FeedbackDevice.QuadEncoder); // sensor status of the feedback device
```

Not all sensor types support the ability to read feedback device status _isSensorPresent()_. The supported sensor types are: CTRE Mag Encoder, Pulse-Width Encoded. All other signals will return _FeedbackStatusUnknown_.

> In order for limit switches and closed-loop features to function correctly the sensor and motor has to be “in-phase”. This means that the sensor position must move in a positive direction as the motor controller drives positive throttle. To test this, first drive the motor manually (using gamepad axis for example). Watch the sensor position either in the roboRIO Web-based Configuration Self-Test, or by calling GetSensorPosition() and printing it to console. If the “Sensor Position” moves in a negative direction while Talon SRX throttle is positive (blinking green), then use the “Reverse Feedback Sensor” signal to multiply the sensor position by (-1). Then retest to confirm “Sensor Position” moves in a positive direction with positive motor drive.

## Setting Follower Mode

```java
// 1. instantiate CANTalon objects
leftMaster10 = new CANTalon(DRIVE_TRAIN_LEFT_MASTER_10);
leftFollower11 = new CANTalon(DRIVE_TRAIN_LEFT_FOLLOWER_11);
// 2. change mode to follower for the following motor
leftFollower11.changeControlMode(CANTalon.TalonControlMode.Follower);
// 3. indicate the master motor to follow
leftFollower11.set(leftMaster10.getDeviceID());
// 4. optional: invert the output of the slave to match master
leftFollower11.reverseOutput(true);
```

## Soft Limits
With a feedback device, soft limits can be used to disable motor drive when a sensor position is outside of a specified range. Forward throttle will be disabled if the “Sensor Position” is greater than the Forward Soft Limit. Reverse throttle will be disabled if the “Sensor Position” is less than the Reverse Soft Limit.

```java
leftMaster10.setForwardSoftLimit(1000);     //specify limit
leftMaster10.enableForwardSoftLimit(true);  // enable soft limit for forward throttle
leftMaster10.setReverseSoftLimit(-1000);
leftMaster10.enableReverseSoftLimit(true);
```

## Setting Sensor Position
Depending on the sensor selected, the user can modify the “Sensor Position”. This is particularly useful when using a Quadrature Encoder (or any *relative sensor*) which needs to be “zeroed” or “home-ed” when the robot is in a known position.
**Note: We observed that zero-ing a quadrature encoder can be delayed, and code needs to take that into account.**

Setting this signal when “Analog Potentiometer” is selected has no effect.

```java
leftMaster10.setPosition(0);     // set sensor position to zero
```

## get() vs. getEncPosition() vs. getPosition()
Multiple APIs exist for similar functions.
- _getEncPosition()_: The API that fetches latest values for Encoder (Quadrature) and Analog-In (potentiometer or a continuous analog sensor) reflect the pure decoded values sent over CAN bus (every 100ms). If the 100ms update rate is not sufficient, it can be overridden to a faster rate.
- _getPosition()_ or_ getSpeed()_: Position or speed of sensor that is currently providing feedback. Selecting a sensor will cause the Talon SRX to mux the appropriate sensor to the closed-loop logic, the soft limit logic, to the “Sensor Position” and “Sensor Velocity” signals (update 20ms). Since “Sensor Position” and “Sensory Velocity” are updated faster (20ms) they can also be used for processing sensor information instead of overriding the frame rates.
- _get()_: Gets the current status of the Talon (usually a sensor value).
  - In Current mode: returns output current.
  - In Speed mode: returns current speed.
  - In Position mode: returns current sensor position.
  - In PercentVbus and Follower modes: returns current applied throttle.

### get()
  ```java
  /**
   * Gets the current status of the Talon (usually a sensor value).
   *
   * In Current mode: returns output current. In Speed mode: returns current
   * speed. In Position mode: returns current sensor position. In PercentVbus
   * and Follower modes: returns current applied throttle.
   *
   * @return The current sensor value of the Talon.
   */
  public double get() {
    switch (m_controlMode) {
      case Voltage:
        return getOutputVoltage();
      case Current:
        return getOutputCurrent();
      case Speed:
        return ScaleNativeUnitsToRpm(m_feedbackDevice,CanTalonJNI.GetSensorVelocity(m_handle));
      case Position:
        return ScaleNativeUnitsToRotations(m_feedbackDevice,CanTalonJNI.GetSensorPosition(m_handle));
      case PercentVbus:
      default:
        return (double) CanTalonJNI.GetAppliedThrottle(m_handle) / 1023.0;
    }
  }
```

### set()
```java
/**
   * Sets the appropriate output on the talon, depending on the mode.
   *
   * In PercentVbus, the output is between -1.0 and 1.0, with 0.0 as stopped.
   * In Follower mode, the output is the integer device ID of the talon to
   * duplicate.
   * In Voltage mode, outputValue is in volts.
   * In Current mode, outputValue is in amperes.
   * In Speed mode, outputValue is in position change / 10ms.
   * In Position mode, outputValue is in encoder ticks or an analog
   * value, depending on the sensor.
   *
   * @param outputValue The setpoint value, as described above.
   */
  public void set(double outputValue);
```

## Setting Ramp Rate
Set ramp rate to prevent instantenous changes in throttle.

```java
motor10.setVoltageRampRate(6.0) // 0V to 6V in 1 sec
```
> The Talon SRX internally expresses the (Voltage) Ramp Rate in throttle units per 10ms (see Section 17.6). As a result, at the minimum (slowest) ramp rate, the time from zero-to-full-throttle is 10.23 seconds. This is derived from 1 throttle unit per 10ms. In terms of voltage per second, this is equivalent to 1.173 V per second or 9.77% per second. When choosing an initial ramp rate avoid specifying a rate that is slower than this limitation. Choosing a slower rate than what’s possible will cause the programming API to truncate the calculated result to zero throttle units per 10ms, leading to the effect of no ramp at all.
> The Talon SRX natively represents Ramp Rate as the change in throttle per TRampRate (TRampRate=10ms). Throttle is represented as a 10bit signed value (1023 is full forward, -1023 is full reverse). For example, if the robot application requires motor drive ramping from 0% to 100% to take one second of ramping, the result Ramp Rate would be ( [1023 – 0] / 1000ms X TRampRate) or 10 units.
> The programming API made available in LabVIEW and C++/Java performs the scaling into appropriate units (Voltage or percent).
