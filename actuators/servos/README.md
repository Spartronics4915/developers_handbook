# Servo motors
Servo motors (or "Hobby servos") are small motors that can rotate in an arc to
position or actuate a mechanism. They do not rotate continuously (unless
modified to do so), but instead can be positioned to a known angle under program
control. The servo is not particularly strong or fast, but is very easy to use,
and it provides a simple system that can reliably position a mechanical system
without the need for additional sensors such as potentiometers or encoders.

## Connections
A servo motor requires only three connections to the RoboRio: Power, Ground, and
Signal. It is connected to a PWM channel, in the same way an older PWM-based
motor controller would be. The power line gives the energy for the movement, and
a PWM waveform on the signal line directs the servo to the angle it should move
to. The duty cycle of the PWM signal indicates the angle of rotation, and to
hold the servo still the RoboRio must keep sending the same PWM signal.

## Uses
The servo can actuate a mechanism, such as releasing a spring-loaded device. Or
it could be used to push an object, such as to nudge a ball into a lanuncher's
spinning wheels.
