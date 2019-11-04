# Lesson 3: Commands

In this lesson, you'll be learning what _commands_ are, why we use them, and how to create them.

<!-- TOC -->

- [Lesson 3: Commands](#lesson-3-commands)
  - [What is a Command?](#what-is-a-command)
  - [Architecture of a Command](#architecture-of-a-command)
    - [Subsystem Requirements](#subsystem-requirements)
    - [The `initialize()` method](#the-initialize-method)
    - [The `execute()` method](#the-execute-method)
    - [The `isFinished()` method](#the-isfinished-method)
    - [The `end()` method](#the-end-method)
    - [Command Decorators](#command-decorators)
  - [Extending your Knowledge](#extending-your-knowledge)

<!-- /TOC -->

## What is a Command?

Commands are simple state machines that perform high-level robot functions using the methods defined by subsystems.
In plainer English, commands run some combination of _subsystem actions_. In our case, we'll be calling the subsystem actions that you made in the previous lesson. You can think of commands as wrappers for subsystems, where we

But you might be thinking, why use commands at all? Why not just call subsystems directly, like we did in the previous lesson?


An example of a command is shown below.

```java
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Agitator extends CommandBase {

    private Agitator mAgitator;

    public Agitator() {
        mAgitator = Agitator.getInstance();
        addRequirements(mAgitator);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        if interrupted {

        }
        else {

        }
    }

    @Override
    public boolean isFinished() {

    }
}
```

## Architecture of a Command

We've got five default methods shown here: the Constructor, `initialize()`, `execute()`, `end(boolean interrupted)`, and `isFinished()`. Both the Construtor and `isFinished()` are important to general aspects of the subsystem. The rest of the methods correspond to the state of the command.
If a command is running, it has to be doing one of three things: **initializing**, **executing**, or **ending**. We'll take a look at what all of these entail.

### Subsystem Requirements

```java
public class Agitator extends CommandBase {

    private Agitator mAgitator;

    public Agitator() {
        mAgitator = Agitator.getInstance();
        addRequirements(mAgitator);
    }
```

In some documentation, you may see examples where the subsystem is passed through the constructor. Because of our _singleton_ subsystem structure (only one instance of a subsystem is running at any given time), we bypass this and construct our subsystem directly.

But we're looking at the `addRequirements()` method. The whole concept behind commands, and the reason we use them, is the idea that only _one_ command can be using a subsystem at any given time. Multiple commands can be running at the same time, but their subsystem dependencies cannot overlap.

This ensures that, for example, we won't end up with two different pieces of code attempting to set the same motor controller to different values at the same time. Additionally, commands can require _multiple subsystems_ in order to function - a `FireBall` command may require the use of both the `Agitator` and `Launcher` subsystems.

If a new command is scheduled that requires a subsystem that is already in use, it will either _interrupt_ the currently-running command that requires that subsystem (if the command is interruptible), or else it will not be scheduled.

___

### The `initialize()` method

```java
// An example initialize() method
@Override
public void initialize() {
    Agitator.calibrate();
}
```

The `initialize()` function is where we put code to put a subsystem in a known state for execution. It differs from the `execute()` method, as it is _not_ a loop - `initialize()` is run exactly **once** per time the command is called, and is run before `execute()`. It cannot take any parameters, so in order to add variability to the command, variables must be controlled by the constructor. Note that if you ever interrupt a command - we'll get more into what that entails later - this method still runs.

If your command uses pneumatics, they should be controlled here, or with great caution in `execute()`. Unlike motors, you want to (at the risk of robot damage) set pneumatics to a position only _once_.

___

### The `execute()` method

```java
// An example execute() method
@Override
public void execute() {
    Agitator.agitate();
}
```

The execute method is called repeatedly (approximately 50 times per second) while the command is scheduled.
Anything that needs to run _continuously_ - controlling motors, for example - should be put in here. It is especially important to control motors only in this method, as any motors that are only set to a non-zero value once can cause a safety error and stop your robot.

For maximum readability of your code, the `execute()` method should only call subsystem methods, and should call as few as possible. It shouldn't call methods of subsystems the command does not require.

Note that it's important to _never_ use any long or unending loops in any of these functions.

___

### The `isFinished()` method

```java
// An example isFinished() method
@Override
public boolean isFinished() {
    return false;
}
```

`isFinished()` is exactly what it sounds like: it checks whether or not the command has finished running. As soon as the specified conditions are met, it returns `true`.

It's important that it is clear when your command should quit on its own. Methods that only need a call to `initialize()` (for example, setting pneumatics) should always return **true**.
Note that `isFinished()` is called after `initialize()` and `execute()`, so even if your `isFinished()` always returns true, the command will still run.
If you have a command that you want to always run unless it's interrupted (like an agitator, for example), your `isFinished()` should always return **false**.

However, `isFinished()` is not checked when a command is _interrupted_.

___

### The `end()` method

```java
// An example end() method
@Override
public void end(boolean interrupted) {
    if interrupted {
        System.out.print("Interrupted");
    }
    else {
        System.out.print("Not interrupted");
    }
    Agitator.stop()
}
```

The `end()` function is run exactly once, when the command finishes. This can happen in two ways: `isFinished()` returns true, or the command is _interrupted_.

The method argument specifies the manner in which the command ended (`true` for interrupted, `false` or void for `isFinished()`); you can use this to differentiate the behavior of the command and deal with the interruption or lack of one accordingly.

The end block should be used to “wrap up” command state in a neat way, such as setting motors back to zero or reverting a solenoid actuator to a “default” state. In the above example's case, we're merely outputting whether it was interrupted or not, and stopping the Agitator in both contexts. However, in practice, we may want entirely seperate functionality for being interrupted or stopped by `isFinished()`.

Note that the act of calling `end()` by itself does not cancel the command; that power is handled exclusively by the Scheduler. You'll learn much more about how the Scheduler handles Commands in Lesson 5.

___

### Command Decorators

Within the Command interface, there's the concept of _decorators_. A decorator is a method that can be called that gives additional functionality to the command, such as adding a timeout or denoting commands to run in parallel with it. These options are typically set through the constructor, and a comprehensive list can be found on the [WPILIBj Docs](https://first.wpi.edu/FRC/roborio/development/docs/java/edu/wpi/first/wpilibj2/command/Command.html). (hint: decorators are described as "decorating" the command)

___

## Extending your Knowledge

Now that we've gone over all the aspects of a Command, you're ready to write your own. This time, you'll be using the previous methods you wrote in the Subsystem lesson (LIST THEM HERE) and constructing commands around them.

@TODO: Ideas for Command practice. They'll depend on what robot we're using. And the previous lesson.
