# Lesson 3: State Machines (and Subsystems)
In this lesson we will explore how one can define a _state machine_ in one's code, and the anatomy of a subsystem.

## State Machine Definition
There are a couple of steps to defining a state machine. We should have already presented information about state machines in the abstract, so this section will only explain how you can represent a state machine in your code.

### State enums
The first thing you need to do is define two `enum` types. One for your wanted state, and one for your system state.

An `enum` is a special type that must be one of a couple of values. "Enum" is short for enumeration. For example, if I define an `enum` like this:

```java
public enum WantedState {
  // It is convention to fully capitalize enum values, and use underscores for spaces
  CLOSED,
  INTAKE,
  EJECT,
}
```

I now have an `enum` type called `WantedState`. If I make a variable of type `WantedState`, I can set its value **only** to either `CLOSED`, `INTAKE`, or `EJECT`. Variables holding `enum`s look like this:

```java
public WantedState mWantedState = WantedState.CLOSED;
```

I could also then set the value of `mWantedState` to `WantedState.INTAKE` (or one of the other two values).

I also need to define another `enum`, called `SystemState`. With the wanted states I defined above, I would have the following:

```java
public enum SystemState {
  CLOSING,
  INTAKING,
  EJECTING,
}

public SystemState mSystemState = SystemState.CLOSING;
```

You may notice that we have to both define the contents of the enum, and make a variable that holds an enum value. This is an important distinction: the `public enum SystemState {...}` part defines what's in the enum, but it does not hold a value. It is like a blueprint. You must make a variable of type `SystemState` to actually hold the `enum`'s value. (This is very much like the distinction between a `class` and an `object`). This is why we will have two variables in our subsystem to hold the `SystemState` and the `WantedState`.

If we put this all together, we get the following:

```java
public enum WantedState {
  CLOSED,
  INTAKE,
  EJECT,
}

public enum SystemState {
  CLOSING,
  INTAKING,
  EJECTING,
}

public WantedState mWantedState = WantedState.CLOSED;
public SystemState mSystemState = SystemState.CLOSING;
```

### State transfer
Now that you have a system state and wanted state, you need to be able to change the wanted state, which will in turn change the system state.

The first step of this is pretty simple:

```java
public static void setWantedState(WantedState ws) {
  mWantedState = ws;
}
```

This will set the wanted state, but not the system state. We need a method to handle state transitions to set the system state. We can define a method to change system state based on wanted state as follows:

```java
private SystemState defaultStateTransfer() {
    SystemState newState = mSystemState;
    switch (mWantedState) {
        case CLOSED:
            newState = SystemState.CLOSING;
            break;
        case INTAKE:
            newState = SystemState.INTAKING;
            break;
        case EJECT:
            newState = SystemState.EJECTING;
            break;
        default:
            newState = SystemState.CLOSING;
            break;
    }
    return newState;
}
```

This uses some syntax you may have not seen before: `switch`. Fortunately, this embodies a relatively familiar concept. The `switch` statement matches a variable to a set of values, like a large chain of `if` and `else if`s. For example, the following are equivalent:

```java
int foo = 1;

if (foo == 1) {
  System.out.println("foo is 1");
} else if (foo == 2) {
  System.out.println("foo is 2");
} else {
  System.out.println("foo is neither 1 nor 2")
}
// The above is equivalent to:
switch (foo) {
  case 1:
    System.out.println("foo is 1");
    break; // If we don't include the break statement, this case will fallthrough to the next case (e.g. "foo is 1" and "foo is 2" would both be printed)
  case 2:
    System.out.println("foo is 2");
    break;
  default:
    System.out.println("foo is neither 1 nor 2");
}
```

One important thing to note here is that if we don't include the `break` keyword at the end of each `case` in the `switch`, that `case` will fallthrough to the next `case`. (See the comment in the code snippet above for more explanation).

Now, if we call `handleDefaultStateTransfer` method after someone has called `setWantedState`, we will get to the appropriate system state.

### Acting on states and putting it all together
As you can see above, we're changing a lot of variables, but we're not actually _doing_ anything with them. Also, where does `defaultStateTransfer` get called?

Well, we actually do things (and call `defaultStateTransfer`) in your subsystem's `Loop`. Here's what a skeleton of that might look like:

```java
private Loop mLoop = new Loop() {
    @Override
    public void onStart(double timestamp) {
        synchronized (Lesson.this) {
            mWantedState = WantedState.CLOSED;
            mSystemState = SystemState.CLOSING;
        }
    }

    @Override
    public void onLoop(double timestamp) {
        synchronized (Lesson.this) {

        }
    }

    @Override
    public void onStop(double timestamp) {
        synchronized (Lesson.this) {

        }
    }
};
```

At the beginning of autonomous or teleop, the `onStart` method is called. During autonomoous and teleop, approximately every 1/100th of a second, `onLoop` is called. Finally, when autonomous or teleop ends, `onStop` is called.

We run motors and other hardware based on the system state. This happens inside the `onLoop` method. An example of that method (with hardware control added) for this hypothetical subsystem would be:

```java
@Override
public void onLoop(double timestamp) {
  synchronized (Lesson.this) {
    SystemState newState = defaultStateTransfer();
    switch (mSystemState) {
    case INTAKING:
      mIntakeMotor.set(ControlMode.PercentOutput, 1.0);
      break;
    case EJECTING:
      mIntakeMotor.set(ControlMode.PercentOutput, -1.0);
      break;
    case CLOSING:
      stop();
      break;
    default:
      Logger.error("Unhandled system state!");
    }
    mSystemState = newState;
  }
}
```

We now have two very similar looking switch statements, but you should keep in mind that the `onLoop` method handles `SystemState`s, while the `handleDefaultStateTransfer` method handles `WantedState`s.

All of this together looks like [this](./lesson3/src/main/java/com/spartronics4915/learnyouarobot/Lesson.java). You can also open this up in `learnyouarobot`. (That example does not include the `EJECT`/`EJECTING` states. See below for more information in this regard.)

### Driver input and other methods
You may be wondering who calls `setWantedState`. In the actual robot code, `setWantedState` is called from the main `Robot` loop and the various autonomous modes, and you probably won't see much of the calling code. However, in this lesson, there's a special method in your subsystem called `teleopPeriodic`. This method is passed a `Joystick`, so you can set wanted state based on joystick input. This could look like the below code:

```java
public void teleopPeriodic(Joystick joystick) {
    if (joystick.getRawButtonPressed(1)) {
        this.setWantedState(WantedState.INTAKE);
    } else if (joystick.getRawButtonPressed(2)) {
        this.setWantedState(WantedState.CLOSED);
    } else if (joystick.getRawButtonPressed(3)) {
    this.setWantedState(WantedState.EJECT);
    }
}
```

You may also notice a couple of other methods in your subsystem with empty bodies. These have a definite purpose, but are out of the scope of this lesson. Ask a mentor or experienced student about them if you're curious.

## Extending knowledge
Now we're going to ask you to do something, without giving you the code. Ask mentors for help when you're stuck!

### Adding ejecting states
We're going to make it so that we have a new ejecting state, which runs the motor backwards instead of forwards. The steps are as follows:

 1. Add a wanted state called `EJECT`, and system state called `EJECTING` in the appropriate `enum`s.
 2. Handle the `EJECT` `WantedState` in the `handleDefaultStateTransfer` method.
 3. Handle the `EJECTING` `SystemState`, by running the motor backwards, in the `onLoop` method.
 4. Set the wanted state to `EJECT` when `joystick.getRawButtonPressed(3)` is `true` in `teleopPeriodic`.

### Restricting state transitions
New requirement in from the engineering team! It's bag day, they've been up all night, and they realized that the robot explodes if the intake goes straight from `CLOSING` to `EJECTING` (the test robot has also taken on a new and attractive charcoal color). Your mission, if you choose to accept it, is to disallow transitions from `CLOSING` directly to `EJECTING` (i.e. the driver **must** go from `CLOSING` -> `INTAKING` -> `EJECTING`). The steps are as follows:

 1. In `onLoop`, when the system state is `CLOSING` and the `newState == SystemState.EJECTING`, set `newState` to `SystemState.CLOSING` instead.

### Pneumatics!
The engineering team just added a pneumatic cylinder to the intake! When we're `EJECTING`, you need to make the pneumatic cylinder go out. When the intake is not ejecting, the cylinder should be in. Please be careful with the pneumatic cylinder, it's pretty _heckin' **speedy**_. Anyway, these are the steps:

 1. Make a new variable at the top of your subsystem class (below the definition of `mPrimaryMotor`). Name the variable `mEjectSolenoid`, it should be of the type `DoubleSolenoid`. Set its initial value to `null`.
 2. In your subsystem's constructor, set the value of `mEjectSolenoid` to `new DoubleSolenoid(1, 2)`.<!-- TODO: Is 1 and 2 right? -->
 3. In your `onLoop` method, add a variable of the type `DoubleSolenoid.Value` called `solenoidValue`, and set its initial value to `DoubleSolenoid.Value.kOff`.<!-- TODO: Is kOff right? -->
 4. If the `SystemState` is `EJECTING`, set `solenoidValue` to `DoubleSolenoid.Value.kReverse`.<!-- TODO: Is kReverse right? -->
 5. At the bottom of `onLoop`, after your `switch` statement, but still in the `synchronized` block, [set the solenoid](http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/DoubleSolenoid.html#set-edu.wpi.first.wpilibj.DoubleSolenoid.Value-) to `solenoidValue`.
