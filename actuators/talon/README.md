
# Introduction to Talon SRX
The Talon SRX speed controller is a CAN-enabled "smart motor controller" from Cross The Road Electronics/VEX Robotics. The Talon SRX can be controlled over the CAN bus or PWM interface. When using the CAN bus control, this device can take inputs from limit switches and potentiometers, encoders, or similar sensors in order to perform advanced control such as limiting or PID(F) closed loop control on the device.
- Onboard closed-loop PID control algorithm
- Breakout board for wiring a quadrature encoder or limit switch

![Talon SRX](images/talon_srx.png)

## What is CAN?
CAN, Controller Area Network, provides a network that helps multiple CAN devices communicate with one another without a host computer. Each of the devices on the network has a CAN controller chip and is therefore intelligent. All devices on the network see all transmitted messages. Each device can decide if a message is relevant or if it should be filtered.

CAN was first created for automotive use, so its most common application is in-vehicle electronic networking. Medical equipment manufacturers use CAN as an embedded network in medical devices
## Reference Documentation
- [Talon SRX Home](http://www.ctr-electronics.com/talon-srx.html#product_tabs_technical_resources)
- [Talon Users Guide](http://www.ctr-electronics.com/Talon%20SRX%20User's%20Guide.pdf)
- [Talon Software Reference Manual Manual](http://www.ctr-electronics.com/Talon%20SRX%20Software%20Reference%20Manual.pdf)

# Setup & Troubleshooting
Use roboRIO Web-based Configuration page to setup Talon SRX. See Networking section @TODO add networking section

- Number the Talon SRX using the website
- Update firmware
- Wire

Also see tips and tools for [Debugging](#debugging)
## Wiring
_From [Talon Users Guide](http://www.ctr-electronics.com/Talon%20SRX%20User's%20Guide.pdf), section 1.3.2.2_

>Teams should consult the FRC game rules for CAN wiring requirements. However it is recommended to use yellow for CANH and green for CANL for the following reasons...
- Makes robot inspection and troubleshooting easier.
- The colors match what is labeled on the FRC Robot Controller, Power Distribution Panel, and Pneumatic Control Module.
- The colors match the Talon SRX cable harness.
AWG 22 or similar gauge wiring can be used. An electric drill can be used to twist the CANH/CANL wire pair.

## roboRIO Web Configuration and Monitoring
Silverlight is required to access the web-based configuration tool (no Chrome support!). Note, manual refresh of the page is required after configuration changes.
<pre><code>http://roborio-XXXX-frc.local</code></pre>
Checking the “Light Device LED” and pressing “Save” can be used to identify which physical Talon SRX is selected.

## Device IDs and Names
A Talon SRX can have a device ID from 0 to 62. 63 is reserved for broadcast.
> Regardless of the programming language, device ID is programmatically used for specifying which Talon SRX you are  controlling.
<pre><code>
// Example: drive train left motor is on device ID 10
 private static final int DRIVE_TRAIN_LEFT_MASTER_10 = 10;
 public static CANTalon leftMaster10 = new CANTalon(DRIVE_TRAIN_LEFT_MASTER_10);
</code></pre>

Using the roboRIO web configuration utility, also give a custom name for the Talons, such as 'Drive Motor 10' for easy debugging.

## Debugging
See [Talon Users Guide](http://www.ctr-electronics.com/Talon%20SRX%20User's%20Guide.pdf) Troubleshooting, section 3

### Blink Codes
See [Talon Users Guide](http://www.ctr-electronics.com/Talon%20SRX%20User's%20Guide.pdf) Blink Codes, section 2.3

![Talon SRX Blink Codes](images/blink_codes.png)

## Firmware Update
Firmware updates are done using the FRC roboRIO Web-based Configuration. Check [Talon SRX Home](http://www.ctr-electronics.com/talon-srx.html#product_tabs_technical_resources) for latest firmware.
> Firmware version is checked at the competition. Make sure all firmware is updated and versions verified prior to competition.

## Troubleshooting
### Talon is behaving erratically...
Make sure no two Talons are configured to use the same device ID. Use roboRIO Web-based Configuration page to review Talons' device IDs.

# Configuration
## Break & Coast Modes
The Talon SRX has two modes: Brake and Coast.
- When a neutral signal is applied to the Talon SRX in Brake mode, the motor will resist rotation, especially high speed rotation.
- When a neutral signal is applied to the Talon SRX in Coast mode, Back-EMF will not be generated, so the motor’s rotation will not be affected by the Talon SRX.

**In general, Talon SRX will be configured for Brake mode.**
