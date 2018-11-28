# Setting Up your Development and Build Environment

<!-- TOC -->

- [Setting Up your Development and Build Environment](#setting-up-your-development-and-build-environment)
    - [Visual Studio Code](#visual-studio-code)
        - [Installation](#installation)
        - [Extensions](#extensions)
            - [Required Extensions:](#required-extensions)
            - [Recommended Extensions](#recommended-extensions)
        - [Recommended Settings](#recommended-settings)
            - [Trailing Spaces extension](#trailing-spaces-extension)
            - [Todo Tree extension](#todo-tree-extension)
            - [markdownlint extension](#markdownlint-extension)
    - [Java](#java)
        - [Telling Visual Studio Code where Java is](#telling-visual-studio-code-where-java-is)
        - [For Windows users:](#for-windows-users)
        - [For macOS users:](#for-macos-users)
        - [For Linux users:](#for-linux-users)
    - [Git](#git)
        - [Installing Git](#installing-git)
        - [Configuring Git](#configuring-git)

<!-- /TOC -->

## Visual Studio Code

### Installation
[Download Visual Studio Code from here for most operating systems.](https://code.visualstudio.com/download)

If on an Arch-based Linux distribution, VS Code is also available in the community
repository as `code`.

### Extensions

#### Required Extensions:
- [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) -
    open up the Extensions sidebar, and search "java". It's in the top five results.
- [WPILib](https://github.com/wpilibsuite/vscode-wpilib/releases/tag/v2019.0.0-alpha-4)
    - Download the latest **alpha** of the WPILib Extension.
    - Open the Extensions sidebar (Ctrl+Shift+X)
    - Click the three dots in the upper right corner of the Extensions sidebar
    - Hit `Install from VSIX...`
    - Navigate to the WPILib extension you downloaded, and click `Install`.

#### Recommended Extensions
- [Trailing Spaces](https://marketplace.visualstudio.com/items?itemName=shardulm94.trailing-spaces)
- [Todo Tree](https://marketplace.visualstudio.com/items?itemName=Gruntfuggly.todo-tree)
- [markdownlint](https://marketplace.visualstudio.com/items?itemName=DavidAnson.vscode-markdownlint)

### Recommended Settings
- `"editor.quickSuggestions": {"other": false, "comments": false,`
    `"strings": false },`

#### Trailing Spaces extension
- `"trailing-spaces.highlightCurrentLine": false,`
- `"trailing-spaces.trimOnSave": true,`

#### Todo Tree extension
- `"todo-tree.regex": "((@|//|#|<!--|;|/\\*|^)\\s*($TAGS)|^\\s*- \\[ \\])",`
- `"todo-tree.expanded": true,`
- `"todo-tree.tags": ["TODO", "FIXME", "XXX", "DONE", "BUG", "!!!", "HACK", "NOTE", "FAQ", "IDEA" ],`

#### markdownlint extension
- `"markdownlint.config": {"MD006": false, "MD007": false, "MD013": true,`
    `"MD022": false, "MD026": false, "MD032": false, "MD040": false },`

## Java
This year we will be using Java 11. You're going to need the
**Java Development Kit (JDK)**. You can download
[Oracle's Java 11 JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html),
but the OpenJDK also will work. Download the JDK and install it.

### Telling Visual Studio Code where Java is

### For Windows users:

1) Locate your Java installation directory
   - It should be something like `C:\Program Files\Java\jdk1.11.0_65`
   - You can also type `where java` in the command prompt
2) Do one of the following:
   - **Windows 7** - Right click **My Computer** and select `Properties > Advanced`
   - **Windows 8** - Go to `Control Panel > System > Advanced System Settings`
   - **Windows 10** - Search for **Environmental Variables** then select
        **Edit the system environmental variables**
3) Click the **Environmental Variables** button
4) Under **System Variables**, click **New**
5) In the **Variable Name** field, enter `JAVA_HOME`
6) In the **Variable Value** field, enter your **shortened** JDK installation path.

**Shortened Path Names** are the first six characters, followed by `~number`
depending on the alphabetical order. For example,
`C:\Program Files\Java\jdk1.11.0_65` shortens to `C:\Progra~1\Java\jdk1.11.0_65`.

### For macOS users:

1) Run `echo $JAVA_HOME` to check if the variable is already set
   (JAVA_HOME tells your computer where Java is)
2) If the output is empty, edit the `.bash_profile` and add `export JAVA_HOME=$(/usr/libexec/java_home)`
3) Press `Ctrl + X` to exit and `Ctrl + Y` to save your changes.
4) Now you need to restart your bash file: `source .bash_profile`
5) Check that the variable has been set again with `echo $JAVA_HOME`.

### For Linux users:
In Visual Studio Code, add this line at the top of your `settings.json`.

`"java.home": "/usr/lib/jvm/default",`

## Git

### Installing Git
If you haven't already, download and install Git from [here.](https://git-scm.com/)
On macOS and most Linux systems, Git comes preinstalled by default.

Once you've installed Git, you're going to need to configure it.

### Configuring Git

It's helpful if everyone knows who you are when working in groups.
Git's `user.name` and `user.email` options help us tell who you are when `commit`ing
any code.

`git config --global user.name "FirstName LastName"` will set your name.
The `--global` tag sets it for all Git projects, not just one repository.

`git config --global user.email "your@email.com"` sets an email associated with
your commits. **It is important to use the email you signed up with GitHub with.**

Finally, check that you have entered in the correct username and email with
`git config --list`.