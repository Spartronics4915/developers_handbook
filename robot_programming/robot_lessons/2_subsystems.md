# Lesson 2: Subsystems

<!-- TOC -->

- [Lesson 2: Subsystems](#lesson-2-subsystems)
  - [What is a Subsystem?](#what-is-a-subsystem)
    - [Constructing a Subsystem](#constructing-a-subsystem)
    - [Adding Methods](#adding-methods)
    - [Outputting Data](#outputting-data)

<!-- /TOC -->

## What is a Subsystem?

Subsystems are the basic unit of robot organization in the command-based paradigm.

Every robot that we design has "subsystems" of hardware that work together to serve a purpose. For example, on our 2017 robot, we had a **drivetrain**, a **climber**, an **agitator**, a **launcher**, and a **gear manipulator**. These are treated as seperate units by the mechanics, and we adopt this structure in our code.

The purpose of this is to provide modularity - it's much more difficult to program a robot if it's all in one class file.
Additionally, command-based programming allows for "locks" on subsystems, so that for example the agitator can't be both agitating and _not_ agitating at the same time. But we'll get more into that later - the important takeaway is that subsystems are collections of hardware operating as _units_ of the robot.

Subsystems have a general structure to them.
A barebones subsystem would look like this:

```java
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    // Creates a new ShooterSubsystem.
    public ShooterSubsystem() {

    }

    // Example actions as methods go here...
    // public void raiseArm()

    public void outputTelemetry() {

    }
}
```

We'll go over every part of this.

### Constructing a Subsystem

That `ShooterSubsystem` method is the _constructor_ (a Java term you should be familiar with). You're going to use this to _initialize_ the hardware controlled by your subsystem.

**¡ojo!** It's _very bad_ to initialize the same hardware twice. You **cannot** have the same sensor or motor in two subsystems - but it's still possible to use it in both.

As a matter of fact, you've already done this with the `TalonSRX` motor last lesson. This is essentially the same concept - define the motor member variable outside of the constructor, and initialize it inside the constructor.

- Try doing that now with a TalonSRX. Make sure you use the correct port.

### Adding Methods

We talked earlier about how subsystems are _units of hardware that serve a common purpose_. The subsystem controlls and coordinates this hardware.

Be careful! You want these actions to be **as simple as possible.** Instead of having an action that, say, makes the robot climb, break it into individual actions. If this was CHAOS (our 2019 robot), you'd have four actions - extending and retracting the front set of pneumatics, and extending and retracting the back set of pneumatics.

We allow our subsystem to be controlled by public methods. You should design a public interface that best "fits" the underlying hardware in an easy-to-use way (for the caller). Note that all the "timing" of the methods is controlled by the commands.

_Commands_, which we'll talk about and use in the next lesson, call into these public methods. Additionally:
> Subsystems also serve as the backbone of the CommandScheduler’s resource management system. Commands may declare resource requirements by specifying which subsystems they interact with; the scheduler will never concurrently schedule more than one command that requires a given subsystem. An attempt to schedule a command that requires a subsystem that is already-in-use will either interrupt the currently-running command (if the command has been scheduled as interruptible), or else be ignored.

- You should put a couple of public methods into your subsystem that run the motor at a varying velocity and "unjam" the shooter by running the motor backwards. One should be `void shootBall(double dutyCycle)`, and the other should be `void unjam()`.
- Now put code into each method to control the TalonSRX appropriately.
- Now add some code to make the motor only run forward, regardless of input, in the `shootBall` method.

<!-- Note: this is not relevant if we aren't using SpartronicsSubsystem yet -->
### Outputting Data

The last method is one called `outputTelemetry` - this method is our way of _logging_ data about the robot. This is called repeatedly in very short time intervals to provide us with up-to-date data. This information is sent back to the dashboard and used for debugging. You should log information about the state of your subsystem in this method.

<!-- Wait, should we overload just one method instead? -->
Our convention is to use the methods `dashboardPutBoolean`, `dashboardPutNumber`, and `dashboardPutString` to send out logs. Each one of those takes a descriptive `String`, followed by either a `boolean`, `int`, or `String` (guess which method takes which!).

- Send back some information about what the motor is currently doing and find where that information on the Network Tables page of the dashboard.
