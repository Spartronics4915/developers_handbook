# Classes and Objects

<!-- TOC -->

- [Classes and Objects](#classes-and-objects)
  - [What's a Class?](#whats-a-class)
    - [Public vs. Private](#public-vs-private)
    - [Concept: Encapsulation](#concept-encapsulation)
    - [Concept: Immutable Variables](#concept-immutable-variables)
    - [In the Scope of Things](#in-the-scope-of-things)
  - [Constructing Objects from Classes](#constructing-objects-from-classes)
    - [Concept: Static Members](#concept-static-members)
    - [Concept: Constructor Methods](#concept-constructor-methods)
  - [Conclusion](#conclusion)

<!-- /TOC -->

## What's a Class?

You may have heard that Java is an _object oriented_ language, as compared to a more _procedural_ language like C. For our purposes, this means that a lot of the code you'll be using and writing will be based around **classes** and the **objects** they create. Object-oriented programming works very nicely with code that controls physical objects - like the motors and sensors of a robot.

Writing a **class** in Java is a lot like programatically creating a blueprint of a house. While a blueprint by itself doesn't do too much, you can take that blueprint and create an actual house from it later.

![House Blueprint](images/blueprint.png)

Let's take a look at an example `House` class:

```java
class House {
    private String address; // A private field called address
    public String color;
    public final int floors; // A public final field called floors

    // This is a "constructor" method that takes a color and constructs the class.
    public House(String shade) {
        address = "1600 Pennsylvania Avenue";
        color = shade;
        floors = 3;
    }

    // This "setter" method changes the value of the `address` field.
    public void setAddress(String changed) {
        address = changed;
    }

    // All this "getter" method does is return the value of the `address` field.
    public String getAddress() {
        return address;
    }

    // All this "getter" method does is return the value of the `color` field.
    public String getColor() {
        return color;
    }
}
```

Wow, what a strange lump of code. You might have noticed that this `House` class doesn't contain the `main` method you've been wrapping your previous code in. That's because this `House` is not a complete program - rather, it's a series of instructions on how to make a `House` **object**.

A class is composed of _methods_ - like `setAddress()` and `getAddress()` above, and _fields_ - like the variables `address` and `floors`. Fields are a special term for variables within a class. These are also called _member variables_ and _member methods_.

### Public vs. Private

All of the `House` class's **fields** and **methods** are prefixed with either `public` or `private`. These are called _access modifiers_, and they control whether other parts of your program are allowed to see and modify those fields and methods.

The `public` _access modifier_ allows a field or method to be accessed by anything that has access to the overall class. It's the least protective modifier and should be used when you don't care what accesses your fields and methods.

The `private` _access modifier_, on the other hand, doesn't allow modification or even access to anything outside of the class or method. If you have a sensitive variable (such as the address of a house) that you don't want external classes changing, `private` is the modifier for the job.

`public` and `private` can also be used on classes themselves to much the same effect. This is useful alongside inheritance, which you'll take a look at in the next lesson.

### Concept: Encapsulation

At this point, you might be thinking that that `getAddress` method seems kind of silly. Wouldn't it be easier to just make the `address` variable public?

```java
public String getAddress() {
    return address;
}
```

This _encapsulation_ method is like creating a protective shield (or capsule) around our variables. If we decided to make `address` public, anyone with access to a `House` could modify them. But by making a `private` variable and then allowing access through a method, it's available to everyone, but only the `House` class can modify it.


### Concept: Immutable Variables

Something similar to encapsulation is the `final` access modifier. A variable that's marked with `final` can only be assigned a value **once**. Trying to change a `final` variable will throw an access error. This is super helpful for physical constants - you don't want to be changing the number of floors in a house willy-nilly!

```java
public final int floors;
...
    floors = 3;
```

The big difference between having a `public final` field and encapsulation is that while they both restrict access, `final` variables are _completely immutable_ - even within its own class. For this reason, you'll see the use of encapsulation much more often.

### In the Scope of Things

So we've talked about how access modifiers like `public` and `private` can change how a field or method is accessible, but _where_ they're written or defined also affects the accessibility. (from here on out, we're going to talk about accessibility as **scope**)

```java
public void foo() {
    String scoped = "This String stays within the scope of foo.";
}

System.out.println(scoped); // Throws an error!

```

One example of scope that you might already be familiar with is _method scope_. If a variable is created within a method, it can't be accessed from outside that method. The fields of classes follow much the same principle. Scope is also affected by the `static` keyword, but we'll get more into that later. <!-- TODO: elaborate, examples -->

## Constructing Objects from Classes

Let's hop back to the lack of a `main` method in our class.

> This `House` is not a complete program - rather, it's a series of instructions on how to make a `House` **object**.

So, what is an object, and how do we make one from a class?

What if I told you you'd been using objects this whole time without even knowing it?

Take a look at the code below.

```java
House myHouse = new House("white"); // This is how you construct an object.
```

Immediately, you should see some similarities to something else you've been doing a lot of - creating `String` variables. This is because `String` is actually a class - and all of the `String myString = "This is my String!";` variables you've created are objects. In turn, the methods you've been calling on `String`s - like `myString.length()` - are actually _member methods of the String class_. (`int` and so forth are primitives, and not exactly objects, but we went over that earlier).

Here is an alternative way of defining a `String` variable:

```java
String classicString = "This is my String!"; // These are pretty much the same thing.
String constructedString = new String("This is also my String!");
// I say "pretty much" because they're slightly different at a deep level.
// If you're interested, read this: https://stackoverflow.com/a/3299217
```

Put more concretely, _an object is an **instance** of a class_. They're like the houses made from that `House` blueprint we talked about earlier. They're also **tangible** - in real life, you could reach out in touch one.

In our programming world, this means that you can _call methods_ on them. All of your `House` member methods must be called on an instance of the `House` class (a `House` object). Calling `House.getAddress()` would result in an error, just like how calling `String.length()` isn't useful.

### Concept: Static Members

However, Java has an exception to this. If we wanted to make a method that is allowed to be called on the class itself, we would use the `static` keyword:

```java
public static String getAddress() {
    return "1600 Pennsylvania Avenue"; // `address` is out of scope!
}
```

If we know that `getAddress()` is always going to return `"1600 Pennsylvania Avenue"`, then why should we have to construct a full object?

It's important to note that if we tried to access `address` in this static method it would result in an error, because there's no way to access member variables (fields) from static methods. However, you _can_ access static member variables:

```java
public class House {
    private String address = "1600 Pennsylvania Avenue";
    private static int floors = 2; // Note the `static` keyword

    public static int getFloors() { // This will return 2.
        return floors;
    }

    public static String getAddress() { // !!! This doesn't work!
        return address;
    }
}
```

The key takeaway here is that we can only access variables and methods on an object, unless they are `static`.

### Concept: Constructor Methods

A keen reader might have noticed that `public House(String shade)` does not specify a return type. This is not a syntax error - it's a special type of member method, called a **constructor**. It is called whenever we make an instance (a new object) of this class. Each object must be instantiated using the `new` keyword before the constructor.

```java
House myHouse;
myHouse = new House("white"); // To make a new "white" house.
```

In this case, we're passing `"white"` to the constructor, which takes it and sets the `color` variable to it. This is a good example of when to _not_ use static methods - if we attempted to call `getColor` without having constructed an object, our `House` class wouldn't have a color to return to us.

![House Blueprint](images/blueprint.png)

The constructor's power comes from letting us create different objects from the same class. In the blueprint metaphor, this is like being able to create multiple different colored houses from the same blueprint.

## Conclusion

That was a lot. Classes and objects take some time and practice to fully understand, so don't be shy to refer back to this lesson.
