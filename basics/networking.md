# Networking and roboRIO

roboRIO is configured with mdns using static IP configuration. This improves performance and removes potential DHCP issues during competitions.

- IP address is based on team number: 10.49.15.x
- Subnet mask: 255.255.255.0
- Range 1 through 19 is for robot, driver station, and equipment used in competition.
  - .1: radio
  - .2: roborio
  - .5: driver station
  - .10: Jetson
  - .11: Axis camera

RoboRio mDNS IP address (requires [MS Silverlight](https://www.microsoft.com/silverlight/)): roboRIO-4915-FRC.local

## Radio configuration
See [instructions from 2016 robot.] (https://github.com/Spartronics4915/2016-Stronghold/wiki/Installing-Radio-Firmware)

See [instructions from 2017 robot.] (https://github.com/Spartronics4915/2017-STEAMworks/wiki/Axis-Camera)

## Camera configuration
See [instructions from 2016 robot.](
https://github.com/Spartronics4915/2016-Stronghold/wiki/Setting-up-the-Axis-Camera)

## Configuring PCs and Macs for mdns
For Macs: if you have issues connecting to robot network try this via Terminal

```networksetup -setv6off Wi-Fi```

To change IP on Windows computers use Control Panel's network status and local area network settings for TCP/IP configuration.

To change IP on Mac computers: Click "Open Network Preferences" under the wifi settings. Click "Advanced". Click "TCP/IP". Set Configure IPv4 to "Manually" to be able to set your custom IP in "IPv4 Address".

And, remember -- ping is your friend! From Terminal check if you can see the robot
```ping 10.49.15.2```
