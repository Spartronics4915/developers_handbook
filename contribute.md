# Contribution Guidelines

The goal of this document is to go above and beyond the information present in
the [FRC Control System documentation](http://wpilib.screenstepslive.com/s/4485)
provided by WPI. Content should be full of links to important external sources
(including to the WPI documentation), helpful diagrams, code examples and
thorough easy to follow instructions.

When adding content to this document, include it in the appropriate directory,
or subdirectory if necessary. The top-level files are:

* [README.md](README.md)    - the first introduction to the document
* [SUMMARY.md](SUMMARY.md)  - the table of contents and required by GitBook
* contribute.md             - the document contribution guidelines
* [todo.md](todo.md)        - a placeholder for content to be added to the document

For content to be included in the GitBook, it must be in a markdown file
(extension .md) and be included as a bullet pointed link in SUMMARY.md.

## Naming Conventions

**File and folder names will be lowercase only, and will separate words using
underscores.** Keep file and folder names short when possible.

## Subdirectories

Each top level directory is roughly a large chapter of the document. These
chapters can have subsections which either are individual markdown files or
its own subdirectory, depending on the size of the subsection.

Images should be included in a separate directory named images/
at the same level as the markdown page they are contained in.
If multiple markdown files
reference the same image, the image file should be contained in the highest
appropriate images/ directory.

Code examples should be included in a separate subdirectory for
each top level directory where appropriate. Code examples are never to be
linked to like other markdown files - instead, links to these code examples
should be directed at their location on [Spartronics4915's repository on
GitHub](https://github.com/Spartronics4915/developers_handbook).

## Markdown Syntax
@TODO include examples of markdown syntax
### Embed to images
<pre><code>![some_image_title](images/some_image_title.png)</code></pre>
### Link to a heading on the same page
Note: header name is in lower case
<pre><code>[Link_Name](#header_name)</code></pre>
