# Inheritance

<!-- TOC -->

- [Inheritance](#inheritance)
  - [What is Inheritance?](#what-is-inheritance)
  - [Conclusion](#conclusion)

<!-- /TOC -->

Possibly the most important and the most difficult to understand concept that we use is that of _inheritance_.

## What is Inheritance?

Inheritance, at its core, is a ~~convoluted~~ way of reusing code.

Different objects often have many similar characteristics between them - for instance, both a `House` and a `Skyscraper` have `floors`, `walls`, `doors`, `paint`... the list goes on and on. If we're programming a construction simulator, it makes no sense to treat `House`s and `Skyscraper`s as completely separate classes. Imagine a Venn diagram between the characteristics of a `House` and a `Skyscraper` - all the overlapping content, you'd have to write (and maintain!) twice. If you did that for everything in your construction simulator, your codebase would quickly become nothing but redundant code.

But inheritance lets us sidestep those redundencies, and only write what's overlapping _once_, no matter the number of classes using it.

```java
// This abstract Building class _must_ be extended to be used.
public abstract class Building {
    public abstract int floors; // This variable _must_ be overwritten.
    public int walls = 4;

    public getWalls() {
        return walls;
    }
    public getFloors() {
        return floors;
    }
}

// This House class _inherits_ the methods and variables of the Building.
public class House extends Building {
    floors = 1;
    private int residents = 3;
    public getResidents() {
        return residents;
    }
}

// You can extend regular classes, too!
public class Cottage extends House {
    private enum Size {
        small, medium, large
    }
    Size size = Size.small;

    public getSize() {
        return size;
    }
}

public class Skyscraper extends Building {
    floors = 20;

    @Override   // The @Override syntax is just a marker.
    public getWalls() {
        return walls - 1;
    }
}
```

There's a keyword called `abstract` in there. Essentially what it does is force subclasses (your `House`s and `Skyscraper`s) to write their own `floors` variable. When used on the `Building` class, it means you can't take an instance of the `Building` - you _have_ to extend `Building`.

The `extends` keyword specifies a class to inherit member variables and methods from. This can be an `abstract` class or a regular class. The way fields and member variables are inherited is very similar to if you copied and pasted the content of the inherited class into the new class, and it's useful to think of it as such.

Say we take instances of `House` and `Skyscraper`. Not only can we call new methods defined in their respective classes, but we can call the methods that were unchanged from their superclass.

Right now, the `Skyscraper` class has **overridden** the `getWalls` method. Instead of returning the `walls` variable, it returns one less. Before the method, the author prepended it with `@Override` (a JavaDoc convention). This isn't strictly needed to compile, but it is a nice way to keep track of / let others know that you're overriding a superclass method. If the original `getWalls` method from `Building` is needed, it can still be accessed with `super.getWalls`. `super` refers to the `superclass` (`Building`, in this case) of the class it is called in.

```java
mHouse.getWalls();
mHouse.getResidents(); // All of these calls work!
mSkyscraper.getWalls();
```

<!-- TODO: Composition? -->

## Conclusion

This just about wraps up our Java lessons. At this point, it's time to move on and start writing robot code - or, if you'd like, you can read the next and final section on advanced Java functionality (which includes new variable types, like the `enum` used above).

Before starting the Robot Programming curriculum, take some time to read Lesson 0 - which should help you map your conceptual understanding of Java to the structure of our robot code, and the structure of our robot code to its physical hardware and electronics.

Congratulations on making it through the Java tutorials!
