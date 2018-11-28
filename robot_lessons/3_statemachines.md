# Lesson 3: State Machines (and Subsystems)
In this lesson we will explore how one can define a _state machine_ in one's code, and the anatomy of a subsystem.

## State Machine Definition
There are a couple of steps to defining a state machine. We should have already presented information about state machines in the abstract, so this section will only explain how you can represent a state machine in your code.

### State enums
The first thing you need to do is define two `enum` types. One for your wanted state, and one for your system state.

An `enum` is a special type that must be one of a couple of values. It is short for enumeration. For example, if I define an `enum` like this:

```java
public enum WantedState {
  // It is convention to fully capitalize enum values, and use underscores for spaces
  CLOSED,
  INTAKE,
  EJECT,
}
```

I now have a type called `WantedState`. If I make a variable of type `WantedState`, I can set its value **only** to either `EAT`, or `SLEEP`. For example:

```java
public WantedState mWantedState = WantedState.CLOSED;
```

I could also then set the value of `mWantedState` to `WantedState.INTAKE` (or `WantedState.EJECT`). I **cannot** set it to any other value.

I also need to define another `enum`, called `SystemState`. With the wanted states I defined above, I would have the following:

```java
public enum SystemState {
  CLOSING,
  INTAKING,
  EJECTING,
}

public SystemState mSystemState = SystemState.CLOSING;
```

You may notice that we have to both define the contents of the enum, and make a variable that holds an enum value. This is an important distinction: the `public enum SystemState {...}` part defines what's in the enum, but it does not hold a value. You must make a variable of type `SystemState` to actually hold the `enum`'s value. This is very much like the distinction between a `class` and an `object` (instance of a class).

This is why we have two variables in our subsystem to hold the `SystemState` and the `WantedState`. If we put this all together, we get the following:

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
Now that you have a system state and wanted state, you need to be able to change system state, based on chaning wanted state.

The first step of this is pretty simple:

```java
public static void setWantedState(WantedState ws) {
  mWantedState = ws;
}
```

This will set the wanted state, but not the system state. We need a method to handle state transitions. Another requirement of this method is that you _cannot_ go straight from `CLOSING` to `EJECTING`. You must intake in between. We can define this method as follows:

```java
private SystemState defaultStateTransfer() {
    SystemState newState = mSystemState;
    switch (mWantedState)
    {
        case CLOSED:
            newState = SystemState.CLOSING;
            break;
        case INTAKE:
            newState = SystemState.INTAKING;
            break;
        case EJECT:
            // We can only go to ejecting if our current system state is SystemState.INTAKING
            if (mSystemState == SystemState.INTAKING) {
              newState = SystemState.EJECTING;
            }
            break;
        default:
            newState = SystemState.CLOSING;
            break;
    }
    return newState;
}
```

This uses some sytax you may have not seen before: `switch`. Fortunately, this embodies a relatively familiar concept. The `switch` statement matches a variable to a set of values, like a large chain of `if` and `else if`s. For example, the following are equivalent:

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

One important note here is that if we don't include the `break` keyword after each branch in the `switch`, that `case` will fallthrough to the next `case`.

Now, if we call this method after someone has called `setWantedState`, we will get to the appropriate system state.

### Acting on states and putting it all together
As you can see above, were changing a lot of variables, but we're not _doing_ anything with them. Also, where does `defaultStateTransfer` get called?

Let's introduce your subsystem's loop:

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
