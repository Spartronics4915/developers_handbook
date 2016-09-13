# What is a Robot?
The word "robot" was popularized by the Czech playwright Karel Capek in his 1921
play Rossum's Universal Robots. The word "robot" resulted from combining the
Czech words _rabota_, meaning "obligatory work" and _robotnik_, meaning "serf."
However, field of robotics is much more than obligatory labor.

It is said that Isaac Asimov, was the first to use the term _robotics_, based
on Capek's term _robot_. For our purpose:

> A _robot_ is an autonomous or teleoperated system which exists in the physical
> world, can sense its environment, and can act on it to achieve some goals.

- _Autonomous_ robots act on the basis of its own decisions, given input
from its environment as applicable, and is not controlled by a human
- _Teleoperated_ robots are externally controlled by humans, from a distance

## Sensors
Just as people do, robots sense their environment via sensors. Sensors
provide a means of perceiving surroundings in order to get
information from the world. Examples of sensors include proximity sensors,
cameras, encoders, and position sensors.

## Control Systems and Control Theory
Control systems are what makes a machine function as intended, based on the
input from sensors. Control theory is the study of this dynamic system
-- how to manipulate inputs of a system to obtain the desired
effect on the output of the system.

The design of a control system generally involves the following steps:
1. Given the desired system behavior (such as moving an arm to a specific
position), decide what types of sensors and actuators are needed, and where
they need to be placed
2. Identify performance characteristics (such as the desired speed and the
effects of inertia during the behavior), and design the control system
3. Tune the control system as needed

### Open-Loop Systems
Open-loop systems is where the system cannot correct the input parameters based
on other factors, and are completely driven by the initial input parameter. As
an example, a drivetrain control code that is timing based, i.e. moves forward
for a specified period, does not take into account other factors such as
battery voltage or terrain conditions, both of which will affect total distance
actually travelled.

### Closed-Loop Systems
Closed-loop or feedback control systems compensate for environmental effects on
the system by measuring the output response, feeding that back to the control
system to compare that response to the input, and making corrections in the
input as needed. Closed-loop systems are less sensitive to noise and changes in
the environment. As an example, a car's cruise control adjusts for changes in
the terrain and head-winds by adjusting the throttle setting to maintain the
set speed.

# Robot Programming
The fundamental challenge of all robotics is a method of controlling the robot.
How do you move the arm from one location to another? How far did the robot move
before stopping? How do you tell where the robot is, without an separate viewer
looking at it?

To start with, you need to know where the robot is relative to its environment.
A robot can only gain this information based on measurements returned by its
sensors, and can only change its state through the application of its
control signals. There are many different ways a robot may monitor its
environment: proximity sensors, light sensors, encoders, cameras, etc.
Thus, one of the first steps in control system design is to interpret sensor
readings, and from these readings make decisions.

Using its sensors, the robot must try estimate the state of the environment
as well as its own state. Though these estimates will not be 100% accurate or
comprehensive, they need to be enough for the robot to base all of its
decisions on. For instance, from its proximity sensors and wheel tickers
(encoders), the robot must try to guess the following:

  - the direction to obstacles
  - the distance from obstacles
  - the position of the robot
  - the heading of the robot
  - the speed of the robot

With these estimations, the robot will make decisions for how it should carry
out its designated behavior, and then execute on these decisions. Continuing
the example from before, with the information about the relative positions
of obstacles around the robot, a robot can develop a path to navigate through
difficult terrain without impacting anything.

A robot is a dynamic system. The state of the robot, the readings of its
sensors, and the effects of its control signals are in constant flux.
With that, the control process is a three-step loop:

  1. Measure the "error" between where you are and where you want to be
  2. Apply control signals proportional on the difference measured
  3. If the goal has not been reached, go back to step 1 and repeat

These steps are repeated over and over until we have achieved our goal. The
more times we can do this per second, the finer control we will have over
the system, and the more precise the resulting behaviors will be.

## Robot Components
The robot's main components are:
- A physical body with mechanisms of locomotion, effectors, and actuators so it
can manipulate items in its environment
- Sensors to measure/perceive factors in its environment and its internal states
- A controller to process information and oversee these actions so desired
goals are achieved

WPILibrary and Command-based programming allows us to model and program our
robot and its components.

## Operating robot systems with no feedback from sensors
It is possible to design mechanisms that are stable in a limited number of
discrete states, and can be moved between states by a reliable actuator,
such that it is not necessary to add sensors for
feedback. For example, a pneumatic cylinder has only two states,
retracted and extended, and if other components of the robot do not
depend on the actuator state then it can be safely controlled without feedback
(open-loop). However, if other subsystems require this actuator to be in a
specific position before they can operate,
some sort of sensor feedback should be used, such as a limit switch.

## Operating simplistic systems with feedback
The control system can operate a simple on/off switch for a subsystem, either
moving it or holding it still.
This differs from the previous example, where the mechanism rigidly enforces
the states of the system, as it is possible
to stop motion in many different positions (states). This can be accomplished
by adding a sensor to indicate position
(such as a potentiometer or a limit switch), then turning on a motor until the
sensor reads back the desired value
from the sensor. This operation can be performed as follows:
  - Turn on the motor
  - Repeatedly test the sensor to see if the value is reached
  - Turn off the motor

This type of control works well for slow-moving systems, where the mechanism
can tolerate the motor being activated
for a period of time AFTER the sensor has been reached. For this to work well,
we must characterize the motion of the
system over time, and compare that to the time it takes to read the sensor in
the "polling loop".
If the motion will activate the sensor (ie, limit switch) for less than 100ms,
but it takes 200ms to read the sensor each
time through the loop, it is possible to miss the limit switch reading
entirely, and the motor will keep running forever.
However, if the limit switch stays active for several seconds, and the
mechanism is not damaged by a 200ms delay, then
this simple control loop is a good choice.

## Operating the robot with feedback from sensors (PID control)
Without feedback the robot is limited to using timing to determine if it's gone
far enough, turned enough, or is going fast enough. For more complicated
mechanisms however, it is almost impossible to reliably position arms, raise
elevators, or spin shooters in repeatable and predictable manners without some
form of feedback.

PID (Proportional, Integral, and Differential) control is a method used in
closed-loop systems for feedback control.
As an example, a potentiometer is an analog device that returns voltage that is
proportional to its position.
To move the arm to a desired position:
  - Predetermine what the potentiometer voltage should be at that preset point
  - Read the current angle (voltage) and compute the error from the desired
  position
  - Run the motor in the direction that reduces error, with an output dependent
  on the current error as well as previous errors.
  - Keep adjusting until the set point is reached and error is near zero

A properly tuned PID loop will enable precise adjustments of any control output
in a shorter time, meaning faster aiming, more reliable grabbing, and better
battery efficiency. Because the system is using measured sensor feedback, the
system will self-correct when external forces affect the actuator,
automatically returning to the set-point even after being pushed by another
robot. Since the PID loop can run all the time, it can also hold a position
without the need for braking or other mechanical controls.

It is important to realize that the PID control loop will always use power and
perform calculations while active, and that power will be dissipated in the
motor (or other actuator), resulting in excess heat, along with battery
voltage drop. It is wise to disable the PID control 
loop when it is not needed, such as when
an actuator is parked or locked by a mechanical brake.


WPILibrary simplifies many of these steps for FIRST FRC programmer.

# References
- The Robotics Primer by Maja J Mataric
