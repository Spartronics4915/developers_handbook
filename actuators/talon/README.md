
# Introduction to Talon SRX
The Talon SRX speed controller is a CAN-enabled "smart motor controller" from Cross The Road Electronics/VEX Robotics. The Talon SRX can be controlled over the CAN bus or PWM interface. When using the CAN bus control, this device can take inputs from limit switches and potentiometers, encoders, or similar sensors in order to perform advanced control such as limiting or PID(F) closed loop control on the device. Features at a high-level:

- Onboard closed-loop PID control algorithm
- Breakout board for wiring a quadrature encoder or limit switch
- Support for CAN bus or PWM interface

![Talon SRX](images/talon_srx.png)

## What is CAN?
CAN, Controller Area Network, provides a network that helps multiple CAN devices communicate with one another without a host computer. Each of the devices on the network has a CAN controller chip and is therefore intelligent, and all devices can see all transmitted messages. Each device can decide if a message is relevant or if it should be filtered.

CAN was first created for automotive use, so its most common application is in-vehicle electronic networking. Medical equipment manufacturers use CAN as an embedded network in medical devices.

## Why CAN over PWM?
@TODO why choose CAN over PWM
The Talon SRX’s Data Port and CAN bus features make it the most capable motor controller available for competition robotics. The Data Port allows Quadrature Encoders, Limit Switches and Analog Sensors to be connected directly to the motor controller. Sensors that are connected through the Data Port are directly processed by the Talon SRX.
It allows up to 63 Talon SRXs to be daisy chained – this means Talon SRXs can plug into each other and only require a single output on the primary robot controller.
One of the simplest ways to control a Talon SRX is using a Pulse Width Modulation (PWM) signal. Unlike CAN bus control, using PWM requires that each Talon SRX must be individually connected to a different output on the system’s primary robot controller – Talon SRXs cannot be daisy chained in PWM mode. When using PWM to control the Talon SRX, only limit switches (or equivalent binary switches) may be used with the Data Port. Encoders or Analog sensors cannot be used.

## Reference Documentation
- [Talon SRX Home](http://www.ctr-electronics.com/talon-srx.html#product_tabs_technical_resources)
- [Talon Users Guide](http://www.ctr-electronics.com/Talon%20SRX%20User's%20Guide.pdf)
- [Talon Software Reference Manual Manual](http://www.ctr-electronics.com/Talon%20SRX%20Software%20Reference%20Manual.pdf)

# Setup & Troubleshooting
Use roboRIO Web-based Configuration page to setup and debug Talon SRX.

- Device ID for a given Talon
- Firmware update
- Monitoring and debugging device operation

See tips and tools for [Debugging](#debugging).

## Wiring
_From [Talon Users Guide](http://www.ctr-electronics.com/Talon%20SRX%20User's%20Guide.pdf), section 1.3.2.2_

>Teams should consult the FRC game rules for CAN wiring requirements. However it is recommended to use yellow for CANH and green for CANL for the following reasons...
- Makes robot inspection and troubleshooting easier.
- The colors match what is labeled on the FRC Robot Controller, Power Distribution Panel, and Pneumatic Control Module.
- The colors match the Talon SRX cable harness.
AWG 22 or similar gauge wiring can be used. An electric drill can be used to twist the CANH/CANL wire pair.

> The Talon SRX’s mounting location should be chosen to allow for adequate air flow around the heat fins and sides of the case. For maximum heat dissipation it is recommended that the Talon SRX be securely mounted to a robot’s metal frame – this allows the robot to be used as a giant heat sink to aid in cooling.

## roboRIO Web-based Configuration Tool
Silverlight is required to access the web-based configuration tool (no Chrome support!). Note, manual refresh of the page is required after configuration changes.
```
http://roborio-XXXX-frc.local
```
Checking the “Light Device LED” and pressing “Save” can be used to identify which physical Talon SRX is selected.

## Device IDs and Names
A Talon SRX can have a device ID from 0 to 62. 63 is reserved for broadcast.
> Regardless of the programming language, device ID is programmatically used for specifying which Talon SRX you are  controlling.

```java
// Example: drive train left motor is on device ID 10
 private static final int DRIVE_TRAIN_LEFT_MASTER_10 = 10;
 public static CANTalon leftMaster10 = new CANTalon(DRIVE_TRAIN_LEFT_MASTER_10);
```

Custom name can be assigned to a Talon SRX using the roboRIO web configuration tool, such as 'Drive Motor 10' for easy debugging.

## Firmware Update
Firmware updates are done using the FRC roboRIO Web-based Configuration. Check [Talon SRX Home](http://www.ctr-electronics.com/talon-srx.html#product_tabs_technical_resources) for latest firmware.
> Firmware version is checked at the competition. Make sure all firmware is updated and versions verified prior to competition.

## Debugging and Troubleshooting
Also see [Talon Users Guide](http://www.ctr-electronics.com/Talon%20SRX%20User's%20Guide.pdf) Troubleshooting, section 3

### Understanding Blink Codes
See [Talon Users Guide](http://www.ctr-electronics.com/Talon%20SRX%20User's%20Guide.pdf) Blink Codes, section 2.3

![Talon SRX Blink Codes](images/blink_codes.png)

### Talon is behaving erratically...
Make sure no two Talons are configured to use the same device ID. Use roboRIO Web-based Configuration page to review Talons' device IDs.

# Talon SRX Modes
CANTalon.TalonControlMode lists the supported modes. See this API for additional info regarding how device is configured or device supports PID.

roboRIO web-based configuration's self-test can be used to confirm the desired mode of the Talon SRX. Make sure the robot is enabled.

Supported modes:
- Current
- Disabled
- Follower
- MotionProfile
- PercentVbus
- Position
- Speed
- Voltage

## PercentVBus

## Speed

## Position

## Follower/Slave

# Configuring Talon SRX
roboRIO web-based configuration tool has options to configure Talons. However, as a principle, robot code has to programmatically configure Talons to ensure proper operation. As _garbage in, garbage out_ states, make sure as a programmer you know how Talons are configured.

## WPILib APIs
WPI library provides APIs to program Talons for PWM or CAN-mode. For CAN mode, use _CANTalon_, for PWM use _TalonSRX_.

This document uses CANTalon and WPILib's Java APIs.

## Break & Coast Modes
The Talon SRX has two modes: Brake and Coast.
- When a neutral signal is applied to the Talon SRX in Brake mode, the motor will resist rotation, especially high speed rotation.
- When a neutral signal is applied to the Talon SRX in Coast mode, Back-EMF will not be generated, so the motor’s rotation will not be affected by the Talon SRX.

**In general, Talon SRX will be configured for Brake mode.**

## Feedback Devices
Talon SRX supports many feedback devices, such as Quadrature Encoder, Analog Encoder (or any continuous 3.3V analog sensor), Analog Potentiometer.

### Quadrature Encoder
> If Quadrature is selected, the decoding is done in 4x mode. Additionally the Talon can be put into counter mode where edges on Quadrature A are counted, if the selected FeedbackDevice is changed to “Count Rising Edge” or “Count Falling Edge”.

### Analog Potentiometer
> Analog feedback sensors, or sensors that provide a variable voltage to represent position, are also supported. Some devices are continuous and wrap around from 3.3V back to 0V. For these sensors choose “Analog Encoder” so that these wrap arounds are detected and counted. For other sensors (like potentiometers) that do not wrap around the voltage signal, choose “Analog Potentiometer”.

### CTR Magnetic Encoder
> The CTRE Magnetic Encoder is actually two sensor interfaces packaged into one (pulse width and quadrature encoder). Therefore the sensor provides two modes of use: absolute and relative.
> The advantage of absolute mode is having a solid reference to where a mechanism is without re-tare-ing or re-zero-ing the robot. The advantage of the relative mode is the faster update rate. However both values can be read/written at the same time. So a combined strategy of seeding the relative position based on the absolute position can be used to benefit from the higher sampling rate of the relative mode and still have an absolute sensor position.

## Follower Mode
> Any given Talon SRX on CAN bus can be instructed to “follow” the drive output of another Talon SRX. This is done by putting a Talon SRX into “slave” mode and specifying the device ID of the “Master Talon” to follow. The “Slave Talon” will then mirror the output of the “Master Talon”. The “Master Talon” can be in any mode: closed-loop, voltage percent (duty-cycle), motion profile control mode, or even following yet another Talon SRX.

## Soft Limits
>Soft limits can be used to disable motor drive when the “Sensor Position” is outside of a specified range. Forward throttle will be disabled if the “Sensor Position” is greater than the Forward Soft Limit. Reverse throttle will be disabled if the “Sensor Position” is less than the Reverse Soft Limit. The respective Soft Limit Enable must be enabled for this feature to take effect.

Soft limits can be set programmatically, or using roboRIO web-based configuration tool.

## Talon Update Frequency
In CAN mode, Talon SRX default update rate control frequency is 10ms. This value can be programmatically changed during CANTalon construction. Status signals include, which also are pollable from roboRIO web-based tool:
- Quadrature Encoder Position, Velocity, Index Rise Count, Pin States (A, B, Index)
- Analog-In Position, Analog-In Velocity, 10bit ADC Value,
- Battery Voltage, Current, Temperature
- Fault states, sticky fault states,
- Limit switch pin states
- Applied Throttle (duty cycle) regardless of control mode.
- Applied Control mode: Voltage % (duty-cycle), Position/Velocity closed-loop, or slave follower. - Brake State (coast vs brake)
- Closed-Loop Error, the difference between closed-loop set point and actual position/velocity.
- Sensor Position and Velocity, the signed output of the selected Feedback device (robot must select a Feedback device, or rely on default setting of Quadrature Encoder).

See WPILib for the APIs to retrive various status information. Examples include:

```java
double quadEncPos = motor10.getEncPosition();

```

## Encoders
@TODO: digital or analog encoder (ex. potentiometer)

## Forward and Reverse Limit Switches
@TODO: limit switch explanation

# Programming CANTalon
## Constructing a CANTalon Object
```java
CANTalon motor10 = new CANTalon(10); // device ID to match roboRIO configuration page
```
See WPILib for constructor details.

## Setting Control Mode

```java
motor10.changeControlMode(TalonControlMode.Speed); // configures Speed mode
```
## Setting PID
@TODO PID

## Setting Ramp Rate
Set ramp rate to prevent instantenous changes in throttle.

```java
motor10.setVoltageRampRate(6.0) // 0V to 6V in 1 sec
```
> The Talon SRX internally expresses the (Voltage) Ramp Rate in throttle units per 10ms (see Section 17.6). As a result, at the minimum (slowest) ramp rate, the time from zero-to-full-throttle is 10.23 seconds. This is derived from 1 throttle unit per 10ms. In terms of voltage per second, this is equivalent to 1.173 V per second or 9.77% per second. When choosing an initial ramp rate avoid specifying a rate that is slower than this limitation. Choosing a slower rate than what’s possible will cause the programming API to truncate the calculated result to zero throttle units per 10ms, leading to the effect of no ramp at all.

## Selecting Feedback Device
For soft limit and closed-loop features, Talon SRX requires a feedback device. Default value is Quadrature Encoder.

> Once a “Feedback Device” is selected, the “Sensor Position” and “Sensor Velocity” signals will update with the output of the selected feedback device. It will also be multiplied by (-1) if “Reverse Feedback Sensor" is asserted programmatically.
> Alternatively the output of the closed loop logic can also be inverted if necessary.

setFeedbackDevice() can be used to select Quadrature Encoder, Analog Encoder (or any continuous 3.3V analog sensor) or Analog Potentiometer.

```java
motor10.setFeedbackDevice(FeedbackDevice.QuadEncoder);
motor10.reverseSensor(true);  // pass true to reverse feedback sensor signal; false if not
motor10.reverseOutput(false);  // pass true to reverse motor direction
```

Though one may thing that the sensor health can be determined using isSensorPresent(), in reality it is device specific.

```java
motor10.isSensorPresent(FeedbackDevice.QuadEncoder);
switch(status) {
  case FeedbackStatusPresent:
    break;
  case FeedbackStatusNotPresent:
    break;
  case FeedbackStatusUnknown:
    break;
}
```
From wpilib implementation, we find out that it is difficult to tell device status for QuadEncoder, AnalogPot, and AnalogEncoder.
```java
public FeedbackDeviceStatus isSensorPresent(FeedbackDevice feedbackDevice) {
  FeedbackDeviceStatus retval = FeedbackDeviceStatus.FeedbackStatusUnknown;
  /* detecting sensor health depends on which sensor caller cares about */
  switch(feedbackDevice){
    case QuadEncoder:
    case AnalogPot:
    case AnalogEncoder:
    case EncRising:
    case EncFalling:
      /* no real good way to tell if these sensor
        are actually present so return status unknown. */
      break;
    case PulseWidth:
    case CtreMagEncoder_Relative:
    case CtreMagEncoder_Absolute:
      /* all of these require pulse width signal to be present. */
      if( CanTalonJNI.IsPulseWidthSensorPresent(m_handle) == 0 ){
        /* Talon not getting a signal */
        retval = FeedbackDeviceStatus.FeedbackStatusNotPresent;
      }else{
        /* getting good signal */
        retval = FeedbackDeviceStatus.FeedbackStatusPresent;
      }
      break;
  }
  return retval;
}
```


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

# Programming Tips
## Encoders doesn't reset

## Encoders oppositive of the motor direction
reverseSensor() to keep sensor and motor in phase for proper limit switch and closed loop functionality.

## Multiple Talons and a Single Sensor
> There are many uses where a mechanism requires multiple Talon SRXs but a single sensor. For example, a single-side of a tank-drive or a shooter-wheel powered by two motors.
The recommended strategy for these mechanisms is to...
- Connect the sensor to one of the Talons. This Talon will be referred to the “master” T alon.
- Set the supplemental Talon(s) to slave/follower mode and follow the device ID of the “master” Talon. See Section 9.1 for details.
- Select PercentVoltage Mode on the “master” Talon. Write a test robot application to drive the “master” Talon manually and confirm all slave Talon(s) correctly follow by watching the LEDs on all involved Talon SRXs. This can be done without motors connected. Consult Talon User’s Guide to avoid damaging Talons by incorrectly wiring inputs/outputs.
- Next, connect the motors to all involved Talons. Consult Talon User’s Guide to avoid damaging Talons by incorrectly wiring inputs/outputs. Test to make sure all motors drive in the correct directions. For example, when drive a shooter wheel, the motors may be oriented to require each motor to drive in opposite directions. If this is the case signal the slave Talon to reverse its output (Section 9.1.4). Do not use excessive motor output. Otherwise you may stall your motors if the slave and master Talon are driving against each other.
- Instrument the Sensor Position or Velocity using the roboRIO Web-based Configuration Page Self-Test, or print/plot the values. Ensure that sensor moves in a positive direction when master Talon is given positive forward throttle (green LEDs).
- Now that the motor(s) and sensor orientation has been confirmed, select the desired control mode of the master Talon. Any of the closed-loop/motion-profile control modes can be used.
- When using Velocity Closed-Loop, Current Closed-Loop, or MotionProfile Control Mode, be sure to calculate the F gain when all slave Talon/motors are connected and used.
