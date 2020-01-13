# Methods

## Command Constructors

```java
public ArcadeDriveCommand()
{
    super("Arcade Drive Command");
    this.robotDrive = Robot.robotDrive;
    requires(robotDrive);
}
```

A command's constructors are the only methods of the command that can take in custom parameters. That is because all the other methods ( **initialize()**, **execute()**, **isFinished()**, **end()** and **interrupted()** ) are required to be overloaded without parameters by the interface that commands implement.

In your constructor, you want to set any instance variables that your command will need. A common practice is to initialize an instance of the subsystem in the constructor to increase the readability of your code.

If you have multiple commands that only vary in a few parameters, it is a good idea to instead use one command class that has a constructor to set those parameters. This cuts down on Command class files and increases the readability of your code.

```
requires(Subsystem system)
```

It is important that you call requires(Subsystem) for each subsystem that your command uses so that the Scheduler does not try to run multiple commands that control the same subsystem. When a command's start() method is ran by the Scheduler, it checks to see if there are any commands currently running that require the same subsystems as the new command. For each command that it finds, it checks if the command is interruptible. If any of the commands are not interruptible, the new command is not added to the Scheduler. Otherwise, the old commands interrupted() methods are ran and then the new command is added to the Scheduler.

```
Command()
Command(String name)
Command(double timeout)
Command(String name, double timeout)
```

There are 4 superclass constructors that belong to Command. They can be used to set the name of the command's instance or the duration that the command will run (the timeout). The default name of an instance of a command is the name of the class. You can only set the name of a command instance using Command's constructor, but you can set the timeout using setTimeout(double seconds).

**IMPORTANT: NEVER USE ANY LONG OR UNENDING LOOPS IN COMMANDS:**

___

## The initialize() method.

```java
public void initialize()
{
    System.out.println("CommandName initialized");
}
```

When a command is added to the Scheduler, initialize() is the first method called and is only called once. It cannot take any parameters, so in order to add variability to the command, variables must be controlled by the constructor. If your command does exactly one thing, all functionality should be in the initialize() method.

For maximum readability of your code, the initialize() method should only call subsystem methods, and call as few as possible. It shouldn't call methods of subsystems your command does not require.

___

## The execute() method

```java
public void execute()
{
    robotDrive.drive();
}
```

The execute() method of each running command is called repeatedly by the Scheduler approximately every 20ms. Commands that need to control motors during some time interval will need to include their functionality within this method. It is especially important to make method calls to control motors in this method, as any motors that are uncontrolled can cause a safety error and stop your robot.

For maximum readability of your code, the execute() method should only call subsystem methods, and should call as few as possible. It shouldn't call methods of subsystems the command does not require.

___

## The isFinished() method

```java
public boolean isFinished()
{
    boolean shouldQuit = true;
    return shouldQuit;
}
```

The isFinished() method of each running command is called repeatedly by the Scheduler approximately every 20ms, after the execute() method. isFinished() returns a boolean, which the Scheduler uses to determine if it should remove the command from the current process. Methods that only require one method call to initialize() should return **true** in isFinished(). Default commands that are always running do not need to quit, and as such, they should return **false**.

It is important that it is clear when your command should quit on its own. However, isFinished() is not checked when a command is interrupted. When another command is started that requires the same subsystem, the method interrupted() determines what happens.

___

## The end() method

*An example of an end() method:*

```java
public void end()
{
    robotDrive.stop();
}
```

The end() method is called exactly once at the end of a method's normal execution. It is only called by the Scheduler if isFinished() returns **true**, and after end() is completed, cancel() is called removing the command from the Scheduler. You can call end() in other methods in the command, but this will not cancel the command.

If there is something that needs to happen at the end of your execution, it should be done here.

___

## The interrupted() method

```java
public void interrupted()
{
    end();
}
```

The interrupted method is only called if the command is interruptible when another command is started that shares a required subsystem. If this command is interruptible, then it is important that anything that must occur for the command before being removed from the scheduler is accounted here. Because the **end()** method also shares a similar purpose, most **interrupted()** methods only call **end()**.

___
