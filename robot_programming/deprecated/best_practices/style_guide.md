# Spartronics Programming Style Guide

Consistent and aggressively enforced code style helps reduce errors and conflicting code.

## Automatic Code Formatting

Visual Studio Code has a built-in code formatter. This will format code based on Visual Studio Code's own preferences. We have a custom formatting file included with our repository (eclipse-formatting.xml) that tells Visual Studio Code to use our guidelines instead of its.

@XXX how to do this

## Code Formatting

Despite Java not requireing the use of newlines and indents and being able to auto-format code, it is generally good practice to be able to write legible code without relying on an auto-formatter. This section details formatting for different parts of Java.

### Spacing

There are three ways to indent code: using two spaces, using four spaces, and using hard tabs. Using four spaces as indents is a standard used by most organizations. Spartronics follows this standard.
By default, Visual Studio Code will enter in four spaces when the tab button is pressed.

**Do not use hard tabs.**

### Squiggly Braces

If / Else statements, For statements, and other functions with squiggly braces `{ }` should have every squiggly on a new line. Additionally, there should be a newline between every "group" of if / else statements (statements that use each other). This style is called "Allman". We use it for debugging, to easily spot any errors caused by bracket misplacement.

```java
if (condition)
{
    code
}
else if (condition)
{
    code
}
else
{
    code
}

if (condition)
{
    code
}
```

### Comments

Comments are used to go into detail about a line or chunk of code, *which has some functionality that isn't inherently obvious.* Comments are not needed in situations where it is easy to tell what the code does - don't use them to explain basic functionalities of Java, for example `System.out.println();`. Comments about a chunk of code should be on their own separate line before the code block. Comments about a particular line should be entered on the same line, after the code.

Single-line comments should have spaces bordering `//`. A tab should be used between the last part of the code and `//`, which will line up the comment with the rest of them. A space should be inserted  directly after `//` but before writing.

```java
public class InterestingCode
{
    // This is a comment before a large chunk of code, explaining what it does
    public static InterestingCode getInstance()
    {
        System.out.println("Hello, world!");    // This comment should explain some aspect of the code that is not instantly noticable.
    }
}
```

Multi-line comments are used for long comments generally detailing how to use a whole system. There should be a multiline comment at the top of code in each file, underneath any `package` and `import` statements, giving an overview of the subsystem and how to use it. Any helpful information (position of limit switches, for example) should be also included in this comment.

### Trailing Spaces

A good practice, although not required or enforced, is to delete trailing spaces at the ends of lines. Trailing whitespace should be avoided because it can cause issues with multi-line Strings and some compilers. Visual Studio Code offers [an extension](https://marketplace.visualstudio.com/items?itemName=shardulm94.trailing-spaces) to help deal with them.

~~~~

@TODO naming conventions for motor naming (no more left_back...)
@TODO section on tips for logging and debugging
