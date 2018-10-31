# Contribution Guidelines

The goal of this document is to go above and beyond the information present in
the [FRC Control System documentation](http://wpilib.screenstepslive.com/s/4485)
provided by WPI. Content should be full of links to important external sources
(including to the WPI documentation), helpful diagrams, code examples and
thorough easy to follow instructions.

When adding content to this document, include it in the appropriate directory,
or subdirectory if necessary. The top-level files are:

* [README.md](README.md)         - the first introduction to the document
* [SUMMARY.md](SUMMARY.md)       - the table of contents and required by GitBook
* [contribute.md](contribute.md) - the document contribution guidelines
* [todo.md](todo.md)             - a placeholder for content to be added to the document

For content to be included in the GitBook, it must be in a markdown file
(extension .md) and be included as a bullet pointed link in SUMMARY.md.

## Naming Conventions

**File and folder names will be lowercase only, and will separate words using
underscores.** Keep file and folder names short when possible. The only
exception to lowercase file names is in the case of README.md and SUMMARY.md.

## Subdirectories

Each top level directory is roughly a large chapter of the document. These
chapters can have subsections which either are individual markdown files or
its own subdirectory, depending on the size of the subsection. The file that
is intended as the first file read in each directory and subdirectory
should be named README.md so that GitHub will automatically display it.

Images should be included in a separate directory named images/
at the same level as the markdown page they are contained in.
If multiple markdown files
reference the same image, the image file should be contained in each
appropriate images/ directory.

Code examples should be included in a separate subdirectory for
each top level directory where appropriate. Code examples are never to be
linked to like other markdown files - instead, links to these code examples
should be directed at their location on [Spartronics4915's repository on
GitHub](https://github.com/Spartronics4915/developers_handbook).

## Markdown Syntax

Markdown is a basic word syntax system commonly used for web development.
It's simple syntax makes it ideal for writing for a variety of different
browsers and interpreters.

[Markdown-Cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
is an excellent guide to the basics of markdown syntax and is highly
recommended for anyone who is interested in contributing to this document.

You can use any plain text editor to read and edit .md files. One powerful
editor for this purpose is [Atom](atom.io), made by GitHub. It has a robust
plugin system, allowing for a fully customizable and hackable text editor.
It also features a built in Markdown preview feature to view the resulting
markdown live. [Visual Studio Code](https://code.visualstudio.com) also has
a preview function, accessable by the shortcut (Ctrl + K, V).

### Markdown Basics

**Excluding links, raw line length should be no longer than 80 characters.**
Insert newlines in paragraphs to remove line wrapping and improve the ability
to read and contribute to this document from a variety of editors. Link
syntax that is longer than 80 characters can be left unbroken.

#### Line breaks

```
Markdown treats one line break like a space - this allows us to format
the raw document for easy reading.

To separate into a paragraph, you must use two line breaks.

This sentence contains one line break.

This sentence contains
two line breaks.
```

#### Text

```
Italics: *word* or _word_
Bold: **word** or __word__
Bold and Italic: ***word** or ___word___
```

#### Headers

```
# Header 1
## Header 2
### Header 3
etc.
```

#### Lists

Unordered - use either * or -.

```
* Entry
- Entry
    * Subentry
- Another entry
* A final entry
```

Ordered - use numbers. Markdown will automatically present it in increasing
order beginning at 1.

```
1. First entry
2. Second entry
    1. First subentry
3. Third entry
4. Fourth and final entry
```

Make sure to use four spaces / tabs. Markdown sometimes breaks unordered lists otherwise.

#### Links

```
[Text for link](link_address)
```

You can use this link system for a lot of different things.

* To link to an external website, replace link_address
with the desired web address.

* To link to another markdown file in the document, replace link_address
with the relative path of the file.

* To link to a header in the same document, replace link_address
with #header-name, where header-name is the text of the header in lowercase
and with all spaces replaced with '-'. Use only one '#' regardless of the
level of header.

#### Code Blocks and Syntax Highlighting

Code blocks disable Markdown syntax and puts code in nice little readable boxes.

```Inline `code` has `back-ticks` around it.```

Inline `code` has `back-ticks` around it.

    ```
    Multi-line code blocks have
    triple back-ticks around them.
    ```

```
Multi-line code blocks have
triple back-ticks around them.
```

Many websites also support using

\`\`\`language

\`\`\`

to create syntax higlighting. For example,

    ```java

    public class math {
        public static void main(String[] args) {
            double three = add(1.0, 2.0);
            System.out.println(three);
        }
        public static double add (double a, double b) {
            return a + b;
        }
    }

    ```

produces

```java

public class math {
    public static void main(String[] args) {
        double three = add(1.0, 2.0);
        System.out.println(three);
    }
    public static double add (double a, double b) {
        return a + b;
    }
}

```