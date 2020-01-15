# Lesson 5: Scheduling Commands

<!-- TOC -->

- [Lesson 5: Scheduling Commands](#lesson-5-scheduling-commands)
  - [How do I schedule commands?](#how-do-i-schedule-commands)
  - [Using the Command Scheduler](#using-the-command-scheduler)
    - [The schedule() Method](#the-schedule-method)
    - [The Scheduler Run Sequence](#the-scheduler-run-sequence)
      - [Step 1: Poll Command Scheduling Buttons](#step-1-poll-command-scheduling-buttons)
      - [Step 2: Run/Finish Scheduled Commands](#step-2-runfinish-scheduled-commands)
      - [Step 3: Schedule Default Commands](#step-3-schedule-default-commands)
    - [Command Event Methods](#command-event-methods)
      - [onCommandInitialize](#oncommandinitialize)
      - [onCommandExecute](#oncommandexecute)
      - [onCommandFinish](#oncommandfinish)
      - [onCommandInterrupt](#oncommandinterrupt)
  - [Extending your knowledge](#extending-your-knowledge)

<!-- /TOC -->

## How do I schedule commands?

The `CommandScheduler` is the class responsible for actually running commands. Each iteration (ordinarily once per 20ms, or 50 times a second), the scheduler polls all registered buttons, schedules commands for execution accordingly, runs the command bodies of all scheduled commands, and ends those commands that have finished or are interrupted.

## Using the Command Scheduler

The `CommandScheduler` is a singleton like our subsystems, meaning that it is a globally-accessible class with only one instance.
Accordingly, in order to access the scheduler, you must call the `CommandScheduler.getInstance()` command.

For the most part, you don't have to call scheduler methods directly - almost all important scheduler methods have convenience wrappers elsewhere (e.g. in the Command and Subsystem interfaces).

However, there is one exception: you must call `CommandScheduler.getInstance().run()` from the `robotPeriodic()` method of their Robot class. If this is not done, the scheduler will never run, and the command framework will not work.

### The schedule() Method

![Scheduling Commands](images/schedulingcommands.png)

To schedule a command, you call the `schedule()` method. This method takes a command (and, optionally, a specification as to whether that command is interruptible), and attempts to add it to list of currently-running commands, pending whether it is already running or whether its requirements are available. If it is added, its `initialize()` method is called.

### The Scheduler Run Sequence

![Scheduler Control Flow Diagram](images/schedulercontrolflow.png)

What does a single iteration of the scheduler’s `run()` method actually do? The following section walks through the logic of a scheduler iteration.

#### Step 1: Poll Command Scheduling Buttons

First, the scheduler polls the state of all registered buttons to see if any new commands that have been bound to those buttons should be scheduled. If the conditions for scheduling a bound command are met, the command is scheduled and its `initialize()` method is run.

#### Step 2: Run/Finish Scheduled Commands

Secondly, the scheduler calls the `execute()` method of each currently-scheduled command, and then checks whether the command has finished by calling the `isFinished()` method. If the command has finished, the `end()` method is also called, and the command is de-scheduled and its required subsystems are freed.

Note that this sequence of calls is done in order for each command - thus, one command may have its `end()` method called before another has its `execute()` method called. Commands are handled in the order they were scheduled.

#### Step 3: Schedule Default Commands

Finally, any registered Subsystem has its default command scheduled (if it has one). Note that the `initialize()` method of the default command will be called at this time.

<!-- TODO: talk about default commands earlier -->

### Command Event Methods

Occasionally, it is desirable to have the scheduler execute a custom action whenever a certain command event (initialization, execution, or ending) occurs. This can be done with the following three methods:

#### onCommandInitialize

The `onCommandInitialize` method runs a specified action whenever a command is initialized.

#### onCommandExecute

The `onCommandExecute` method runs a specified action whenever a command is executed.

#### onCommandFinish

The `onCommandFinish` method runs a specified action whenever a command finishes normally (i.e. the isFinished() method returned true).

#### onCommandInterrupt

The `onCommandInterrupt` method runs a specified action whenever a command is interrupted (i.e. by being explicitly canceled or by another command that shares one of its requirements).

## Extending your knowledge

@TODO
