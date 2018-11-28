# Talon SRX Capabilities
Please refer to [programmer's manual](http://www.ctr-electronics.com/Talon%20SRX%20Software%20Reference%20Manual.pdf)
for full description of capabilities and programming examples.

## roboRIO Web-based Configuration Tool
roboRIO web-based configuration tool has options to configure Talons. However,
as a principle, robot code programmatically configures Talons to ensure proper
operation. As _garbage in, garbage out_ states, as a programmer you need to know
how your Talons are configured.

### Storing Configuration Settings
See Talon SRX programming guide: Persistent storage and Reset/Startup behavior

> All settings in the Motor Control Profile (MCP) are saved persistently in flash. Additionally there are two complete Motor Control Profiles. Teams that use a constant set of values can simply set them using the roboRIO Web-based Configuration, and they will “stick” until they are changed again.

## WPILib APIs
WPI library provides APIs to program Talons for PWM or CAN-mode. For CAN mode,
use _CANTalon_, for PWM use _TalonSRX_.

This document refers to CANTalon and WPILib's Java APIs.

## Talon SRX Update Frequency
In CAN mode, Talon SRX default update rate control frequency is 10ms. This value
can be programmatically changed during CANTalon construction. Status signals
include, which also are pollable from roboRIO web-based tool:

- Quadrature Encoder Position, Velocity, Index Rise Count, Pin States (A, B, Index)
- Analog-In Position, Analog-In Velocity, 10bit ADC Value,
- Battery Voltage, Current, Temperature
- Fault states, sticky fault states,
- Limit switch pin states
- Applied Throttle (duty cycle) regardless of control mode.
- Applied Control mode: Voltage % (duty-cycle), Position/Velocity closed-loop,
    or slave follower. - Brake State (coast vs brake)
- Closed-Loop Error, the difference between closed-loop set point and actual position/velocity.
- Sensor Position and Velocity, the signed output of the selected Feedback
    device (robot must select a Feedback device, or rely on default setting of
    Quadrature Encoder).

See [WPILib APIs](http://first.wpi.edu/FRC/roborio/release/docs/java/) to
retrive various status information.

### How fast can I control just ONE Talon SRX?
> The fastest control frame rate that can be specified is 1ms. That means that the average period at which the throttle/set point can be updates is 1ms. This will increase bus utilization by approximately 15%, which is acceptable if the number of Talon SRXs is few. Always check the CAN bus performance metrics in the Driver Station when doing this.

## Talon SRX Control Modes

```java
// TalonControlMode includes:
public enum TalonControlMode implements CANSpeedController.ControlMode {
    PercentVbus(0), Position(1), Speed(2), Current(3), Voltage(4), Follower(5), MotionProfile(6), Disabled(15);
```

### What is a Closed-Loop Control System?
A closed-loop control system,  also known as a feedback control system, where
there there is one or more feedback loops between system' output and its input.
The 'feedback' received is used to adjust and maintain the desired output of the
system. Example would be a cruise control in a car, where regardless of the
changes to the landscape, cruise control maintains the set speed.

Closed-loop controls require a feedback device, i.e. sensors, and PID settings.
See PID section for more information @ TODO insert link to PID

### Talon SRX Closed-Loop Modes
_CANTalon.TalonControlMode_ lists the supported modes. Supported Talon SRX
closed-loop modes are:

- Position closed-loop
  - Maintains a target position
  - For an example, see Spartronics 2015 elevator code
- Velocity (or speed) closed-loop
  - Maintains a target velocity, i.e. speed
  - For an example, see Spartronics 2016 drive train code
- Current closed-loop
  - Maintains a target current draw
- Motion profile control mode
  - Allow fine control of position and speed throughout a motion profile trajectory

roboRIO web-based configuration's self-test can be used to confirm the desired
mode of the Talon SRX. Make sure the robot is enabled.

### Peak/Nominal Closed-Loop Output and Allowable Error
Since firmware 2.0, The Talon SRX supports bounding the output of the
Closed-Loop modes. See WPI APIs for setting peak output and nominal output values.

- Peak Output: The “maximal” or “strongest” motor output allowed during
- closed-loop. These settings are useful to reduce the maximum velocity of the
- mechanism, and can make tuning the closed-loop simpler.
- Nominal Output: The “minimal” or “weakest” motor output allowed during
- closed-loop if the “Closed-Loop Error” is nonzero and outside of the
- “Allowable Closed-Loop Error”.

```java
//The parameters are expressed in voltage where +12V represents full forward, and -12V represents full reverse.
// Note: in web-based configuration tool, parameters are expressed in native units where +1023 represents full forward, and -1023 represents full reverse.
void	configNominalOutputVoltage(double forwardVoltage, double reverseVoltage)
void	configPeakOutputVoltage(double forwardVoltage, double reverseVoltage)
```

- Allowable Closed-Loop Error: Specifying an allowable closed-loop error will
    result in neutral motor output regardless of the calculated result.

```java
// In this example, specifying 409 corresponds to 9.985% of a rotation or 35.95 degrees (assuming 4096 units per rotation, such as 1024CPR encoder or CTRE Mag Encoder).
_talon.setAllowableClosedLoopErr(409);
```

## Other Supported Modes

### PercentVBus or PercentVoltage Mode
Default control mode. Motor output is expressed in output volts, and Talon will
modulate the output based on battery voltage measurement. PercentVBus is percent
of the battery voltage requested, i.e. it doesn't translate to a specific speed
or strength. With _arcadeDrive()_, the joystick values are scaled to PercentVBus
values; +1.0 is %100 voltage request, which is ~12V for a fully charged battery.

**Important: battery output will vary 20% or more (especially under heavy loads).**
**Therefore, output of the motors in this mode will vary at least that much.**
**Don't expect PercentVBus setting over a fixed period of time to produce**
**reproducable results time and time again.**

>When using CANTalons in Percent VBus control mode, ensure the set value stays between -1 and +1. A value outside of this range will cause a wraparound condition causing the throttle to reverse direction.

### Follower Mode
> Any given Talon SRX on CAN bus can be instructed to “follow” the drive output of another Talon SRX. This is done by putting a Talon SRX into “slave” mode and specifying the device ID of the “Master Talon” to follow. The “Slave Talon” will then mirror the output of the “Master Talon”. The “Master Talon” can be in any mode: closed-loop, voltage percent (duty-cycle), motion profile control mode, or even following yet another Talon SRX.

### Disabled
Motor controls are disabled.

## Feedback Devices
Talon SRX supports many feedback devices, such as Quadrature Encoder, Analog Encoder (or any continuous 3.3V analog sensor), Analog Potentiometer.

### Quadrature Encoder
Default feedback device.
> If Quadrature is selected, the decoding is done in 4x mode. Additionally the Talon can be put into counter mode where edges on Quadrature A are counted, if the selected FeedbackDevice is changed to “Count Rising Edge” or “Count Falling Edge”.

### Quadrature Encoder Position
> When measuring the position of a Quadrature Encoder, the position is measured in 4X encoder edges. For example, if a US Digital Encoder with a 360 cycles per revolution (CPR) will count 1440 units per rotation when read using “Encoder Position” or “Sensor Position”.
> The velocity units of a Quadrature Encoder is the change in Encoder Position per TvelMea (TvelMeas=0.1sec). For example, if a US Digital Encoder (CPR=360) spins at 20 rotations per second, this will result in a velocity of 2880 (28800 position units per second).

###  Analog Encoder vs Analog Potentiometer
> When Analog Potentiometer is selected, the 10 bit Analog to Digital Converter (ADC) converts the 0 to 3.3V signal present on the analog input pin to a value between 0 and 1023.

> When Analog Encoder is selected, the same conversion takes place, but rollovers to and from the min/max voltage are tracked so that analog sensors can be used as *relative sensors*. If an overflow is detected (1023 => 0), the position signal transitions (1023 => 1024). Likewise an underflow (0=>1023) is interpreted as (0 => -1). This is useful when using an analog encoder and allowing it to exceed the max turn count. This way an analog encoder can be used as a continuous relative sensor.

### Analog Potentiometer
> Analog feedback sensors, or sensors that provide a variable voltage to represent position, are also supported. Some devices are continuous and wrap around from 3.3V back to 0V. For these sensors choose “Analog Encoder” so that these wrap arounds are detected and counted. For other sensors (like potentiometers) that do not wrap around the voltage signal, choose “Analog Potentiometer”.

### Analog Potentiometer Position
> When measuring the position of a 3.3V Analog Potentiometer, the position is measured as a 10 bit ADC value. A value of 1023 corresponds to 3.3V. A value of 0 corresponds to 0.0V.
> The velocity units of a 3.3V Analog Potentiometer is the change in Analog Position per TvelMea (TvelMeas=0.1sec). For example if an Analog Potentiometer transitions from 0V to 3.3V (1023 units) in one second, the Analog Velocity will be 102.

### Analog Encoder, “Analog-In Position”
> Like 3.3V Analog Potentiometers, the 10 bit ADC is used to scale [0 V, 3.3 V] => [0, 1023]. However when the Analog Encoder “wraps around” from 1023 to 0, the Analog Position will continue to 1024. In other words, the sensor is treated as “continuous”.
> The velocity units of a 3.3V Analog Encoder is the change in Analog Position per 100ms (TvelMeas=0.1sec). For example if an Analog Encoder transitions from 0V to 3.3V (1023 units) in one second, the Analog Velocity will be 102.

### CTR Magnetic Encoder
> The CTRE Magnetic Encoder is actually two sensor interfaces packaged into one (pulse width and quadrature encoder). Therefore the sensor provides two modes of use: absolute and relative.
> The advantage of absolute mode is having a solid reference to where a mechanism is without re-tare-ing or re-zero-ing the robot. The advantage of the relative mode is the faster update rate. However both values can be read/written at the same time. So a combined strategy of seeding the relative position based on the absolute position can be used to benefit from the higher sampling rate of the relative mode and still have an absolute sensor position.

### Using relative sensors...
> When using relative sensors for closed-loop control, it’s always good practice to design in a way to re-zero your robot. Regardless of how/where relative sensors are connected (robot controller IO, Talon SRX, etc...), there is always the potential for sensors to “walk” or “drift” due to...
>
- Mechanical slip issues
- Skipped gear teeth in chain
- Intermittent electrical connections (harness gets damaged in middle of a match)
- Power cycle robot when armatures are not in their “home” position.
- Remote resets of robot controller when armatures are not in their “home” position.

> A common solution to this is to design a way in the gamepad logic to force your robot into a “manual mode” where the driver/arm operator can manually servo motors to a home position and press a button (or button combination) to re-zero (or set to the “home” position values) all involved sensors.

## Other Configurations

### Soft Limits
> Soft limits can be used to disable motor drive when the “Sensor Position” is outside of a specified range.
- Forward throttle will be disabled if the “Sensor Position” is greater than the
- Forward Soft Limit.
- Reverse throttle will be disabled if the “Sensor Position” is less than the
- Reverse Soft Limit.

> The respective Soft Limit Enable must be enabled for this feature to take effect.

Soft limits can be set programmatically, or using roboRIO web-based
configuration tool.

### Forward and Reverse Limit Switches
@TODO: limit switch explanation

### Brake & Coast Modes
The Talon SRX has two modes: Brake and Coast.
- When a neutral signal is applied to the Talon SRX in Brake mode, the motor
    will resist rotation, especially high speed rotation.
- When a neutral signal is applied to the Talon SRX in Coast mode, Back-EMF will
    not be generated, so the motor’s rotation will not be affected by the Talon SRX.

In general, we configure Talon SRXs for Brake mode.
