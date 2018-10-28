# If Statments
Now that we can define data and move it around, how do we check what it is? The `if` statement is the most common way to do that.

Let's break down a common `if` statement:
```java
int foo = 3;
int bar = 9;
if (foo == 9) {
	System.out.println(bar);
}
```

This checks if `foo`'s value is equal to 9, if it is then it prints the value of `bar`. If we ran this program, it would output nothing, because the statement `foo == 9` evaluates to `false` when `int foo = 3;`.

A very important thing to understand here is that the `if` statement only takes a `boolean`. If we tried to do `if (3)` we would get an error, because 3 is not a `boolean`. (If you recall, a boolean is a data type that can only be true or false).

There are a few operators that compare values and "return" a boolean (they are **not** methods though). Here's a table of them (they should look familiar):

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

There are also two conditonal operators that compare booleans:

| Operator | Name | Example |
| -------- | ---- | ------- |
| `&&` | Conditional AND | `true && true` evaluates to true |
| `||` | Conditional OR | `true && false` evaluates to false |

Also important to note is the logical compliment operator: `!`. It just turns a true value to false. For example:

```java
boolean foo = false;
if (!foo) {
	System.out.println("foo is false!");
}
```

This example would output foo is false! because `!false` is `true`.

## Else and Else If
What if you want one if statement to depend on the value of another?

You could do this if you want the second statement to get run _only_ if the first statement doesn't run:

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

This isn't _that_ confusing here, but you're still duplicating code, which is something we like to avoid in programming. Instead, you can use the `else if` statement:

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

Or, if you care that `bar == 3`, just that the previous statement didn't run, you can do the following:

```java
// This will print Second statement.

boolean foo = false;
if (foo) {
	System.out.println("First statement.")
} else {
	System.out.println("Second statement.")
}
```

## Equality Caveats
An important thing to note is that the equality operator (`==`) compares _primitive_ types' values, but it does not compare the value of non-primitive types. Primitive types all start with lower case letters: `int`, `double`, `boolean`, etc. You do know a non-primitive type though: `String`.

It is for this reason that the following does not print anything:

```java
String foo = "foo";
String fooTwo = "foo";
if (foo == fooTwo) {
	System.out.println("This will never print anything.");
}
```

This is because `String` is not a primitive, and we're not comparing the values of those two strings. Instead, you should call a method on those strings: `equals`. You can, for example, call `foo.equals("foo");", and that would return true. If we want to make the example work, we would do the following:

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
