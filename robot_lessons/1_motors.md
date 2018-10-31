# Lesson 1: Motors
This lesson will introduce basic motor control, and class instantiation.

## Class Setup
First, we need to set up our class so that it gets run by WPILib.
You can do that like this:

```java
import edu.wpi.first.wpilibj.IterativeRobot;

public class Lesson extends IterativeRobot {
    @Override
    public void robotInit() {

    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {

    }
}

```

In the above code, `robotInit` will get called once by WPILib, when the robot
starts. `autonomousInit` will get called every time autonomous starts (there's
also a very similar method called `teleopInit`; what do you think that does?).
`autonomousPeriodic` will get called every time the robot receives a message
from the driver station, about every 20 milleseconds, or 50 times per second.

A structure like this will be in every robot you work on (usually the class is
called `Robot`), but on larger codebases you will probably not directly interact
with these methods.

## Instantiating motors
In this example we're going to be controlling a TalonSRX motor controller,
which will drive a motor.
This is important to know because that's the motor controller class you have to use.

What do I mean by that? How do you use a motor controller class?

As you may know, we can *instantiate* (make a new instance, or object) of
a class by using the `new` keyword. A basic example of making a new instance of
a `TalonSRX` and storing it in a variable looks like this:

```java
TalonSRX motor; // Make the variable
motor = new TalonSRX(3); // Instantiate a motor controller object on CAN ID 3
```

The idea here is that we have a variable which holds an instance of a `TalonSRX`
class, and we have to make a new `TalonSRX` to put in it. An important piece of
this to understand is that `TalonSRX` takes a parameter in its constructor (a
constructor is like a special function that sets up a new instance of a class).
This is the `3` in `new TalonSRX(3)`. This 3 is the ID (on the CAN bus)
of the motor controller; it's like an address for motors.

## Moving motors
Now that we have a variable called `motor` that holds a `TalonSRX` object in it,
we can call methods on it.

One of these methods is `set`, which is defined as the following:
`public void set(ControlMode mode, double outputValue)`.
It sets the output of a motor.

This means that it's a method that other classes can access (`public`), that
returns nothing (`void`), which takes a `ControlMode`, and an output value (a `double`).

If we set our control mode to `ControlMode.PercentOutput`, and our output value
to `0.5`, the motor will run at 50% power for as long as we call the
`set` method with those parameters.

This would look like the following:

```java
TalonSRX motor; // Make the variable
motor = new TalonSRX(3); // Instantiate a motor controller object on CAN ID 3
motor.set(ControlMode.PercentOutput, 0.5); // Run the motor at 50%
```

## Putting it into our class
To put this all together, we have to fit it into our existing class.

First we need to instantiate our `TalonSRX`. We *don't* want to instantiate it
every 20ms in `autonomousPeriodic`, and we don't even want to instantiate
it every time autonomous starts (`autonomousInit`), so we should put it in `robotInit`.

That would look like this:

```java
@Override
public void robotInit() {
  TalonSRX motor = new TalonSRX(3);
}
```

Now we just call `motor.set` in `autonomousPeriodic`
(if we don't call `set` a lot the motor will stop). Right?

**Wrong!** How do we access `motor` in `autonomousPeriodic` if it's only
defined in `robotInit`? Well, you can make it a *member variable* of your
class, which means that all of the class's methods can access it.

That looks like this:

```java
public class Lesson extends IterativeRobot {
  TalonSRX motor;

  // Methods go here
}
```

All of this together looks like this:

```java
import edu.wpi.first.wpilibj.IterativeRobot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Lesson extends IterativeRobot {
    TalonSRX motor;

    @Override
    public void robotInit() {
        motor = new TalonSRX(3); // Motor is on CAN ID 3
    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {
        motor.set(ControlMode.PercentOutput, 0.5);
    }
}

```

## Extending knowledge
In this section we're going to ask you to do something without giving you the code.

### Inverting our motor
Now that we have this set up, what if you want to reverse the output of
the motor? You could just change 0.5 to -0.5, but that can rapidly become
confusing when you need to reverse it again (this may seem unlikely, but
once things get more complex it can happen). Instead of unary negation,
there's a method that will do this for us: [`setInverted`](https://www.ctr-electronics.com/downloads/api/java/html/com/ctre/phoenix/motorcontrol/can/BaseMotorController.html#setInverted-boolean-).
Just call `motor.setInverted`, and you can reverse the motor's output.

 - Now that you know that, go ahead and invert the motor's output.

### Doing it again
What if we have another motor on CAN address 4, and we don't want to
invert that motor but we *do* want to run it at 100%?

 - Go ahead and make a `motorTwo` variable, and set it to 100% in `autonomousPeriodic`.

### Incorporating driver input
How would we make this respond to driver input?

Let's introduce another class: [`Joystick`](http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/Joystick.html)

As you can see from that javadoc, the signature of `Joystick`'s constructor looks like this

```java
public Joystick(int port)
```
_(This is **not** a method, which is why there's nothing specifying return type, like `void`, in the constructor signature)_

That means we can instantiate a `Joystick` object on a port of our choosing. If you don't remember the syntax for instantiating objects, take a look at what we did to instantiate a `TalonSRX` object above.

There's just two other methods you should know:
 1. [`getY`](http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/GenericHID.html#getY--), which gets the joystick's value on the Y-axis (forward and backward).
 2. [`getRawButton`](http://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/wpilibj/GenericHID.html#getRawButton-int-), which gets the status of a button. This takes a parameter, so be sure to read the javadoc!

Before you do the following exercises, you will need to import the `Joystick` class by adding the following line to the top of your file:

```java
import edu.wpi.first.wpilibj.Joystick;
```

  - Make it so that the first motor's output is based on the value of the joystick's Y-axis. You should instantiate your joystick on port 1.
	- Allow your second motor to be toggled by pressing a button. This means that when you press the button if the motor is on it turns off, and if the motor is off it turns on. You should check the value of button 1.

The above are the most difficult and least guided exercises. Be sure to ask questions and look up things you don't know.
