# Method (Function) Calls
You're probably familiar with functions from your math class: you pass the
function an input (in f(x) this is the x), and you get an output (this is f(x),
or y; in programming the output you get is often called the return value).
Java has something similar, with a few twists.

Here are a couple of major differences:
 1. In Java, we call functions _methods_. Think of them as the same thing.
 2. In math, a function has one input and one output. In Java, a function may
   have 0 or more inputs and 0 or 1 outputs.
 3. In math, functions are deterministic (for input x, f(x) will always output y)
   and have no side effects (pure functions).
   In Java, functions are not deterministic (for input x, f(x) can output  _anything_),
   and have side effects (they may modify the state of other parts of the program).

You've actually already seen method calls. Remember this?

```java
public class HelloWorld {
    public static void main(String[]) {
        System.out.println("Hello, world!");
    }
}
```

`System.out.println` is a method call in this example (we're calling a method called `println`).
Here, it's taking a `String`, returning nothing (a return of nothing is also called `void`)

As you can see, the syntax for methods is relatively simple: `<function name>(<function parameters>)`.

Another useful set of functions are defined in the `Math` class.
Exponentiation can be performed with the `Math.pow` method (pow as in power).
The method's signature is `public static double pow(double base, double exponent)`.
This means that it takes two doubles, and returns (outputs) a double.
Don't worry about fully understanding every part of the method signature yet.

Here's how you would call that:

```java
Math.pow(3.0, 2.0); // Returns 9.0
```

## Conclusion
Here are the PracticeIt problems for this section:
 1. [Method calls without parameters or returns](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter1/e7%2DMantra)
 2. [Complex method structure](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter1/s23%2DStrange)
 3. [Method parameters](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter3/s2%2DMysteryNums)
 4. [Tricky variables and method calls](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter3/s15%2DmathExpressions2)
   _`Math.sqrt` is square root, `Math.min` gets the smallest of the two numbers_
   _you pass in, and `Math.round` rounds the number you pass in to the closest `int`._
   _When this asks for "grade =", it is asking for the value of the `grade` variable at that line._
