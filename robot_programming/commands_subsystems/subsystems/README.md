# Subsystems

A subsystem is a isolated set of components of your robot. They are required
for the robot's Scheduler to manage which commands are operating and which
should be stopped to prevent instruction conflicts. In addition, they enable
better code development by using an object oriented approach to designing a
custom robot.

For example, the most common subsystem that is present on every robot is
a drivetrain subsystem. While it only consists of a few motor controllers
(usually), making it a subsystem allows you to add a variety of methods
to add specialized functionality, resulting in easier command creation.
In addition, since the drivetrain code is contained in a single file,
recycling code from year to year is easier.

Another common subsystem is some form of a manipulator subsystem. Every
robot game requires interaction with a game element, and that requires
a grabber, roller, puncher, or who knows what. This manipulator can be
controlled by one or more subsystems, depending on how many separate
control systems are required. For a simple pneumatic puncher that controls
a single solenoid, one subsystem suffices. An elevator that also grabs onto
crates to lift up and down can be better divided into two separate subsystems,
one to handle the motion up and down with a motor, another to handle the
grabbing action. It is important to break up this functionality into
multiple subsystems because commands will interrupt other commands that
require the same subsystem, which will lead to unintended processes being
interrupted.

## How to make a Subsystem

All subsystems extend the [abstract Subsystem
class](http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/command/Subsystem.html),
meaning they must override the method **initDefaultCommand()**.

```java
public void initDefaultCommand()
{
    setDefaultCommand(new ArcadeDriveCommand());
}
```

This method does not need functionality, you must simply include it in your
class. In it you can call **setDefaultCommand(Command)** to give
the Scheduler a command that should be constantly ran by this subsystem.
However, the command must require this subsystem. Passing ***null*** to
**setDefaultCommand(Command)** will remove any default commands from
the subsystem.

Besides overriding **initDefaultCommand()**, your subsystem is fully
custom. You can make your own constructors, methods, instance variables,
or subclasses for your subsystem. Ideally, your subsystem should be properly
designed so that the commands that use the subsystem are as simple as possible.
This means your commands should call a single method from your subsystem in
each stage of it's execution.

## Subsystem Internals

The best way to design the true functionality of a subsystem is to identify
what it does by determining the commands you will need to make. These
will come in two categories - autonomous commands and tele-operated commands.
The autonomous commands must be controlled by some discrete input, best
represented as an integer, while the tele-operated commands are controlled
by joystick input or triggered with a button in most cases. As such, creating
multiple methods for the same function can be beneficial if they take
different inputs.

Once the functionality of your subsystem is decided, you must make sure
that you create *private* instance variables for any important actuators
or sensors in your subsystem. The most important thing to include in every
subsystem is any motors that the subsystem controls, especially for the
drivetrain. Safety protocols *will* kick in if you are not sending
instructions to your motors
(RobotDrive Output Not Updated Often Enough). In addition,
having easy access to critical sensors makes your code more concise and
easy to read.

You can initialize these variables in the subsystem's constructor, or you can
initialize them where they are declared.

See the next page for detailed discussion of some of the example files
provided in this repository.
