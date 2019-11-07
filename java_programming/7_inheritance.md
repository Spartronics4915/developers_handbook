# Lesson 7: Inheritance

* [Inheritance](7_inheritance.md#inheritance)
  * [What is Inheritance?](7_inheritance.md#what-is-inheritance)
  * [Using SpartronicsLib](7_inheritance.md#using-spartronicslib)

Possibly the most important and the most difficult to understand concept that we use is that of _inheritance_. Inheritance allows us to

## What is Inheritance?

Different objects often have many similar characteristics betwween them - for instance, both a `House` and a `Skyscraper` **are** `Building`s and **have** `walls` and `doors`. If we're programming a construction simulator, it makes no sense to treat `House`s and `Skyscraper`s as completely seperate classes. They both would have a `height`, `walls`, `doors`, a number of `floors`, and methods interacting with all of these. Imagine a Venn diagram between a `House` and a `Skyscraper` - all the overlapping content you'd have to write twice. If you did that for everything in your construction simulator, your codebase would quickly fill up with redundant code.

But inheritance lets us sidestep those redundencies, and only write what's overlapping _once_, no matter the amount of classes using it.

```java
public abstract class Building {  public abstract int floors;  public int walls = 4;  public getWalls() {    return walls;  }  public getFloors() {    return floors;  }}public class House extends Building {  floors = 1;  private int residents = 3;  public getResidents() {    return residents;  }}public class Skyscraper extends Building {  floors = 20;  @Override  public getWalls() {    return walls - 1;  }}
```

There's a keyword called `abstract` in there. Essentially what it does is force subclasses \(your `House`s and `Skyscraper`s\) to write their own floors variable. When used on the `Building` class, it means you can't take an instance of the `Building` - you _have_ to extend `Building`.

Say we take instances of `House` and `Skyscraper`. Not only can we call new methods defined in their respective classes, but we can call the methods that were unchanged from their superclass.

Right now, the `Skyscraper` class has **overridden** the `getWalls` method. Instead of returning the `walls` variable, it returns one less. Before the method, the author prepended it with `@Override` \(a JavaDoc convention\). This isn't strictly needed to compile, but it is a nice way to keep track of / let others know that you're overriding a superclass method. If the original `getWalls` method from `Building` is needed, it can still be accessed with `super.getWalls`. `super` refers to the `superclass` \(`Building`, in this case\) of the class it is called in.

```java
mHouse.getWalls();mHouse.getResidents(); // All of these calls work!mSkyscraper.getWalls();
```

This concept applies to our robot code. For example, we have a seperate class for different types of IR sensors - `A21IRSensor`, `A41IRSensor`, and `A51IRSensor`. Each sensor is different, however, they all share some similar or identical methods. Each one of these IR sensors **extends** the `IRSensor` base class.

## Using SpartronicsLib

Starting this year \(2020\), we've moved much of our game-independent codebase into a new GitHub repository, [SpartronicsLib](https://github.com/Spartronics4915/SpartronicsLib).

@TODO Complete

