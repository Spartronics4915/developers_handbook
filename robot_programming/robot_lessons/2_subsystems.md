# Lesson 2: Subsystems

## What is a Subsystem?

Subsystems are the basic unit of robot organization in the command-based paradigm.

Every robot that we design has "subsystems" of hardware that work together to serve a purpose. For example, on our 2017 robot, we had a **drivetrain**, a **climber**, an **agitator**, a **launcher**, and a **gear manipulator**. These are treated as seperate units by the mechanics, a convention which we adopt and use in our code.

The purpose of this is to provide modularity - it's much more difficult to program a robot if it's all in one class file.
Additionally, command-based programming allows for "locks" on subsystems, so that for example the agitator can't be both agitating and _not_ agitating at the same time. But we'll get more into that later - the important takeaway is that subsystems are collections of hardware operating as _units_ of the robot.

Subsystems have a general structure to them.
A barebones subsystem would look like this:

```java
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {

    // Creates a new ExampleSubsystem.
    public ExampleSubsystem() {

    }

    // Example actions as methods go here...
    // public void raiseArm()

    public void outputTelemetry() {

    }
}
```

We'll go over every part of this.

### Constructing a Subsystem

That `ExampleSubsystem` method is the _constructor_ (a Java term you should be familiar with). You're going to use this to _initialize_ the hardware controlled by your subsystem.

**¡ojo!** Note that it's _very bad_ to initialize the same hardware twice. You **cannot** have the same sensor or motor in two subsystems - but it's still possible to use it in both.

As a matter of fact, you've already done this with the `TalonSRX` motor last lesson. This is essentially the same concept - define the motor outside of the constructor, and initialize it inside the constructor.

- Try doing that now with a TalonSRX. Make sure you use the correct port.

### Creating Actions

We talked earlier about how subsystems are _units of hardware that serve a common purpose_. That "purpose" is expressed in actions.

Be careful! You want these actions to be **as simple as possible.** Instead of having an action that, say, makes the robot climb, break it into individual actions. If this was CHAOS (our 2019 robot), you'd have four actions - extending and retracting the front set of pneumatics, and extending and retracting the back set of pneumatics.

_Commands_, which we'll talk about and use in the next lesson, call into these methods. Additionally:
> Subsystems also serve as the backbone of the CommandScheduler’s resource management system. Commands may declare resource requirements by specifying which subsystems they interact with; the scheduler will never concurrently schedule more than one command that requires a given subsystem. An attempt to schedule a command that requires a subsystem that is already-in-use will either interrupt the currently-running command (if the command has been scheduled as interruptible), or else be ignored.

- Suppose your motor is controlling an arm. What actions might you need for it? Implement them. Remember what you learned in Lesson 1.

- Now suppose this same motor instead controls a frisbee launcher. What different actions do you need? How are these similar and different from what you would do for an arm?

<!-- Note: this is not relevant if we aren't using SpartronicsSubsystem yet -->
### Outputting Data

The last method is one called `outputTelemetry` - this method is our way of _logging_ data about the robot. This is called repeatedly in very short time intervals to provide us with remarkably accurate data. On a real robot, this information is sent back to the dashboard and used for debugging.

<!-- Wait, should we overload just one method instead? -->
Our convention is to use the methods `dashboardPutBoolean`, `dashboardPutNumber`, and `dashboardPutString` to send out logs. Each one of those takes a descriptive `String`, followed by either a `boolean`, `int`, or `String` (guess which method takes which!).

- What kind of data would be good to send back to the driver? Implement this. Remember to look into the methods available for the TalonSRX.
