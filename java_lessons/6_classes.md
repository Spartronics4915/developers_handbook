# Classes and Objects

# **THIS IS A WORK IN PROGRESS**

You may have heard that Java is an _object oriented_ language. For our purposes, this means that Java has classes and objects.

Classes are like the blueprints that objects are made of. It's like I have a blueprint for a house. I have one blueprint, and I can make many houses from it. In this analogy, I have one class from which I make many objects.

More specifically, objects are composed of _fields_ (member variables) and _methods_. Each object must be constructed (instantiated) using the `new` keyword. Let's break down the following example:

```java
public class MotorController {
  private int mAddress; // Private member variable (field) called mAddress
  public String name; // *Public* member variable (field) called name

  // Constructor method that takes the controller's address
  public MotorController(int address) {
    mAddress = address;
    name = "Motor Controller";
  }

  // This method just returns the value of mAddress
  public int getAddress() {
    return mAddress;
  }
}
```

## Constructor Methods and `new`
A keen reader might have noticed that `public MotorController(int address)` does not specify a return type. This is not, however, a syntax error. This is a special type of method called the constructor. It is called whenever we make an instance (a new object) of this class.

To make a `new` `MotorController`:
```java

```

## Member Variables

## Class vs. Object
As you can see, we define all of this as a class called MotorController. However, if I called `MotorController.getAddress()`, that would be an error. That is because I am calling that method on the class, but I really need to call it on an _object_ (instance) of the class. To do that, I need to use the `new` keyword, and make a new `MotorController` object. I would do that like this:

```java
MotorController motor = new MotorController(3);
System.out.println(motor.getAddress());
```

If I wanted to make a method that is allowed to be called on the class itself, I would use the `static` keyword:

```java
public static int getAddress() {
  return 3;
}
```

It is important to note that if tried to access `mAddress` in this static method, it would result in an error, because there's no way to access member variables from static methods. However, you can access static

The key concept here is that I can access variables and methods on a class, or an object, but
