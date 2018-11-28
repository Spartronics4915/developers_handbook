# Flashing the roboRIO and radio

1. [Install the FRC Update Suite](http://wpilib.screenstepslive.com/s/4485/m/13810/l/599669-installing-the-frc-2017-update-suite-all-languages)
    - The license key is in the FIRST-themed manila-sized folder (with the 2017
        sticker) in the programming bucket in the electronics room.
        Next to the other ones.
    - While there, get the USB A->B ("printer") cable from the drawer marked
        "USB A to B cable" next to the laptop cabinet.

2. [Image the roboRIO](http://wpilib.screenstepslive.com/s/4485/m/13503/l/144984-imaging-your-roborio)
    - Always use the USB cable to image.
    - The IP will be 172.22.11.2
    - The hostname will be roboRIO-FRC-4915.local (assuming the
    team number is 4915, as it should be)
    - Go to the roboRIO's admin page at its hostname and give it a static IP of 10.49.15.2

3. [Download the radio flashing tool](https://usfirst.collab.net/sf/frs/do/listReleases/projects.wpilib/frs.frc_radio_configuration_utility)
    following the steps [here](http://wpilib.screenstepslive.com/s/4485/m/13503/l/144986-programming-your-radio-for-home-use)
    - Pick the latest version and choose the .exe without the _IL extension (Israel)
    - **Unplug the radio's power**.
    - Connect your computer to the ethernet port furthest from the power jack.
    - Run the flashing tool
    - Go to the radio's address in a browser, and configure a wifi network.

4. [Install Java on the robot](http://wpilib.screenstepslive.com/s/4485/m/13503/l/599747-installing-java-8-on-the-roborio-using-the-frc-roborio-java-installer-java-only)
    - Either use the USB cord (probably should) or Ethernet, but not both at once.
    - Jack has an Oracle account, `java@phroa.net / Spartronics4915`.
