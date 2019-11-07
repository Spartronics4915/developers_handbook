# Lesson 2: Variables and Datatypes

This section will further explore the concept of data types, and introduce _variables_.

## Data Types

As we said in the last section, every piece of data you define in Java has a _type_. We already introduced the `int` and `String` types, but there are some more that we're going to be showing you here.

~_We're only introducing **primitive** types here \(String is technically not a_ _primitive, more on that later\), but there are other more complex types that are_ _defined in classes that we'll discuss later_

Here is a table of some common data types \(4 are primitives\):

| Name | Example Literal | Explanation |
| :--- | :--- | :--- |
| `int` | `3` | An integer. |
| `float` | `3.1` | A real number. |
| `double` | `3.1` | A real number; the _double_ precision version of a `float`. Prefer this over a float whenever possible. |
| `boolean` | `true` | Either `true` or `false`. |
| `String` | `"foo"` | Holds textual data. |

Each of these types can hold a limited set of data. An `int` can contain neither `foo` nor `3.1`. The numerical types also have a maximum number they can hold; this is why `double` is called double: it is _double_ the precision of a `float`. \(When choosing between a `double` and a `float`, choose a `double` unless you have specific a reason not to.\)

## Variables

You've probably taken algebra, and seen variables before. Often, they're called x or y. We have variables in programming too, but they're a bit different than what you see in math class:

1. Variables in math are assumed to contain all complex numbers, while variables

   in Java must have their type explicitly stated, and can hold data other than numbers.

2. Math problems are often short, so you can usually get away with using relatively meaningless single letter variable names. Most programs we write are longer and have more moving parts than these math problems, so in our context single letter variable names are considered vauge and bad \(unless you're [Arthur Whitney](http://kparc.com/b/)\). You should try to give your variables clear names that say what they contain \(without being needlessly verbose or redundant\).

### Declaring Variables

Now that we have an idea of what variables are, how do we declare them? In math, we use the equals sign to denote both assignment and equality. In programming, `=` only denotes assignment \(`==` is what tests for equality, which we'll talk about later.\)

_Many of the variable names below would be considered bad names if you used them_ _in robot code. We're using names like foo just because it's an example. If we_ _were to define a variable that holds an object for the left motor in real robot_ _code though, we would **not** call it foo \(we would probably call it_ `leftMotor`_, or_ `mLeftMotor`_\)_

So, here's an example of declaring an `int` \(integer\) variable with the name `x` and the value `3`.

```java
public class Example {    public static void main(String[] args) {        int x = 3;    }}
```

That's it! The format is `<variable type> <variable name> = <value>;`.

Here's an excerpt of a program that declares a String variable named bar with the value `I'm a string`:

```java
String bar = "I'm a string!";
```

### Using Variables

If we have a variable named `bar`, what can we do with it? Well, we can use it where ever we would otherwise use a literal.

For example, to put prepend the value `A string!` to the variable called `bar` above \(which has the value `I'm a string`\), we would do the following:

```java
String bar = "I'm a string!";bar = "A string! " + bar; // bar now equals `A string! I'm a string!`
```

You can, of course, do arithmetic too:

```java
int foo = 3;foo = 12 / foo; // foo now equals 4
```

## Conclusion

Now that you've read over that, take some time to do the following PracticeIt problems:

1. [Variable declarations](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter2/s6-declareRealNumberSyntax)
2. [Data types](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter2/s7-fitnessVariables)
3. [Variable declarations](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter2/s8-studentVariables)
4. [Variable declarations and use](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter2/s20-Receipt)

   If you're only going to do one of these, do this one.

   _Hint: You need to replace_ `38 + 40 + 30` _with a variable._

