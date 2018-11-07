# Method Definitions
You've now called a number of methods, like `Math.max(2.0, 3.0);`, but how would you define such a method?

_(This method returns the larger of the two numbers you pass in, by the way. In this example, it would return `3.0`.)_

A little bit like this:

```java
public class Math {
  public static double max(double a, double b) {
    if (a > b) {
      return a;
    }
    return b;
  }
}
```

Let's break this down.

## Method Signature
The method's _signature_ is the following: `public static double max(double a, double b)`

The signature says what the method takes, and what the method returns, along with other information that we'll cover later.
 1. `public`: This means that the method can be called outside of the `Math` class. We'll cover this more in chapter 6.
 2. `static`: We'll cover this more in chapter 6.
 3. `double`: This method returns a `double`. This can be any data type (`int`, `String`, etc.) _or_ `void`, which means that the method returns nothing.
 4. `max(double a, double b)`: The method is called max, and takes two parameters: `a`, which is a `double`, and `b` which is also a `double`.


## Return Keyword
There's another new peice of syntax here: the `return` keyword. The idea is that when you `return`, the method immediately exits at that point. If the return type of your method is `void`, you can just do `return;`. If the return type is _not_ `void`, you must return something of the appropriate data type. E.g. if your return type is `double`, this will work: `return 3.1;`, but this will not: `return "foo";`.

## Conclusion
Here are your PracticeIt problems:
 1. [Method call and signature error correction](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter3/s3-Oops3-errors)
 2. [Method call and return value error correction](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter3/s12%2DTemperature%2Derrors)
