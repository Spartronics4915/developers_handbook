# The If Statement
Now that we can define data and move it around, how do we check what it is?
The `if` statement is the most common way to do that.

Let's break down a common `if` statement:

```java
int foo = 3;
int bar = 9;
if (foo == 9) {
    System.out.println(bar);
}
```

This checks if `foo`'s value is equal to 9, if it is then it prints the value of
`bar`. If we ran this program, it would output nothing, because the statement
`foo == 9` evaluates to `false` when `int foo = 3;`.

A very important thing to understand here is that the `if` statement only takes
a `boolean`. If we tried to do `if (3)` we would get an error, because 3 is not
a `boolean`. (If you recall, a boolean is a data type that can only be true or false).

There are a few operators that compare values and "return" a boolean
(they are **not** methods though). Here's a table of them (they should look familiar):

| Operator | Name |
| -------- | ---- |
| `==` | Equals |
| `!=` | Not equals |
| `>` or `<` | Greater/less than |
| `>=` or `<=` | Greater/less than or equal to |

Here's a few examples of these:

```java
// This program prints fizz is greater than buzz!

double fizz = 3.9;
int buzz = 3;
if (if fizz > buzz) {
    System.out.println("fizz is greater than buzz!");
}
```

```java
// This program prints Programming is cool!

double baz = 3;
double bin = 9;
if (Math.pow(baz, 2) == 9) {
    System.out.println("Programming is cool!");
}
```

There are also two conditional operators that compare booleans:

| Operator | Name | Example |
| -------- | ---- | ------- |
| `&&` | Conditional AND | `true && true` evaluates to true |
| `❘❘` | Conditional OR | `true && false` evaluates to false |

Also important to note is the logical compliment operator: `!`.
It just turns a true value to false. For example:

```java
boolean foo = false;
if (!foo) {
    System.out.println("foo is false!");
}
```

This example would output foo is false! because `!false` is `true`.

## Else and Else If
What if you want one if statement to depend on the value of another?

You could do the following if you want the second statement to get run _only_
if the first statement doesn't run:

```java
// This will only print Second statement.

boolean foo = false;
int bar = 3;
if (foo) {
    System.out.println("First statement.")
}

if (!foo && bar == 3) {
    System.out.println("Second statement.")
}
```

The above works, but it's much more elegant to use the `else if` statement:

```java
// This will print Second statement.

boolean foo = false;
int bar = 3;
if (foo) {
    System.out.println("First statement.")
} else if (bar == 3) {
    System.out.println("Second statement.")
}
```

Or, if you don't care that `bar == 3`, just that the previous statement didn't
run, you can use the `else` statement:

```java
// This will print Second statement.

boolean foo = false;
if (foo) {
    System.out.println("First statement.")
} else {
    System.out.println("Second statement.")
}
```

Notice that `else` and `else if` must immediately follow the end of an `if`
statement body.

## Equality Caveats
An important thing to note is that the equality operator (`==`)
compares _primitive_ types' values, but it does not compare the value of
non-primitive types, it compares their pointer (memory address) instead.

Because of this, you shouldn't compare non-primitive types using `==` if you
want to compare their values.

There are 8 primitive types, and they all start with lower case letters:
`int`, `double`, `boolean`, `short`, `long`, `float`, `char`, and `byte`.
The only non-primitive we've covered is `String`.

It is for that reason that the following does not print anything:

```java
String foo = "foo";
String fooTwo = "foo";
if (foo == fooTwo) {
    System.out.println("This will never print anything.");
}
```

This is because `String` is not a primitive, and we're not comparing the values
of those two strings. Instead, you should call a method on those strings: `equals`.
For example, calling `foo.equals("foo");"` would return true.
_Please note that not all objects have an `equals` method._

If we want to make the earlier example work, we would do the following:

```java
String foo = "foo";
String fooTwo = "foo";
if (foo.equals(fooTwo)) {
    System.out.println("This will get printed out.");
}
```

## Conclusion
Go ahead and do the  following PracticeIt problems:
 1. [If statement syntax](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter4/s3%2DifStatementSyntax)
 2. [If statements and method parameters](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter4/s6%2DifElseMystery2)
 3. [if statements and method parameters](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter4/s6%2DifElseMystery2)
