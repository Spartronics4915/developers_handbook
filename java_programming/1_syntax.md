# Lesson 1: Introductory Syntax

Welcome to the Spartronics Java lessons! Work your way through these chronologically, and skip over any parts you already know. At the end of each lesson there are PracticeIt problems; you should do them unless you're already completely skipping the lesson \(if you are skipping the lesson, trying the problems is still recommended, because they will either be easy and quick, or they'll highlight areas you need to improve\).

## Introduction

Consider the following program:

```java
public class HelloWorld {    public static void main(String[] args) {        System.out.println("Hello, world!");    }}
```

What do you think this example does? Take a moment to think about it.

Is it easier if I hide some parts of it, like this \(the below is not a valid Java program, you need the whole thing as shown above\):

```java
System.out.println("Hello, world!");
```

Ok, as you may have guessed, this program calls a _function_ \(more on these later\) that prints `Hello, world!` \(for robot programming, `Hello, world!` would show up on the RIOLog, but this isn't really important now. On other platforms it would show up on the terminal or console.\)

Let's break down this program a little more.

## Statements

A program is a set of instructions. In Java, we call each of these instructions **statements**. Each statement ends with a semicolon \(`;`\).

For our purposes, in Java, statements are executed sequentially. In our Hello World program, `System.out.println("Hello, world!");` was a statement.

## Whitespace and comments

In the above program you can that certain parts are indented. In some languages, indentation means something, but in Java it is ignored. You should still indent your code \(using tabs or spaces\), because it makes it easier to read.

Another thing that's ignored are comments. They are usually used to explain or _comment_ on some code. If a piece of code is confusing, or does something surprising or non-obvious, you should use a comment.

There are two kinds of comments: 1. Single line comments, which begin with `//` and go until the end of the line. 2. Multi line comments, which begin with `/*` and go until `*/` is found.

An example of both would look like this:

```java
public class HelloWorld {    public static void main(String[] args) {        System.out.println("Hello, world!"); // This is a single line comment        /*        This        comment        has        multiple lines.        // I can even put a single line comment *inside* a multiline comment! Commentception!?!?!?        */    }}
```

## Curly braces

Curly braces \(`{` and `}`\) can be seen in our above Hello World program. There's a couple of things about them to understand:

1. They **enclose** things \(they always enclose a _scope_, a concept we'll

   discuss later\)

2. Every opening brace \(`{`\) has a corresponding closing brace \(`}`\).

   Mismatched braces are a common source of errors.

If you think of them like enclosures \(in our Hello World program, they enclose the `HelloWorld` class, and the `main` method\) you'll be good for now.

## Literals

In the Hello World program, you can see the following

```java
"Hello, world!"
```

This is a String literal. A String is the name we use in programming for text; it's a sequence of characters we _string_ together. A literal allows you to hardcode specific values in your program.

In this case we type `"Hello, world!"`, but that is stored in the computer's memory as `Hello, world!`. The quotes indicate that you're entering a String literal, they are not part of the resulting string's value. If we didn't have quotes, we couldn't differentiate String literals from regular old code, so you always need them. Single quotes \(`'`\) indicate a different literal, so you should use double quotes exclusively when you want a String literal.

There are literals of other _data types_ too. One example of a data type is an `int` \(integer\). 3, for example, is an integer. In Java, a literal representing 3 would look like this:

```java
3
```

You will encounter more and more data types and literals as you continue in your Java adventures, but that's all you need for now.

## Arithmetic and Concatenation

Now that we can represent data in Java with literals, we should also learn some basic operations on it. Java supports most arithmetic as you have seen it in math.

Here are operators that you can use on `int`s, and `double`s \(a data type we will learn more about soon\).

| Operator | Operation Name | Example | Result |
| :--- | :--- | :--- | :--- |
| `+` | Addition | `4 + 2` | `6` |
| `-` | Addition | `4 - 2` | `2` |
| `*` | Multiplication | `4 * 2` | `8` |
| `/` | Division | `4 / 2` | `2` |

In Java, these operators only really apply to numerical types, with one exception: The `+` operator also _concatenates_ Strings. Concatenation means putting two pieces of text together; if I concatenate `foo` and `bar`, I get `foobar`. You can see it in action below:

```java
System.out.println("foo" + "bar"); // Prints foobar
```

```java
System.out.println("foo" + 3); // Prints foo3
```

## Conclusion

You just saw _a lot_. Much of it may not make sense. The idea is that you have some exposure, and something to refer back to. If you're ready to practice these concepts, go ahead and do the following PracticeIt problems:

1. [`System.out.println`](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter1/s7-outputSyntax)
2. [Literals](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter2/s1-legalIntLiterals)
3. [Basic syntax and error correction](https://practiceit.cs.washington.edu/problem/view/bjp4/chapter1/s19-SecretMessage-errors)

