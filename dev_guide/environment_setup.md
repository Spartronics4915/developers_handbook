# Setting Up your Development and Build Environment

<!-- TOC -->

- [Setting Up your Development and Build Environment](#setting-up-your-development-and-build-environment)
  - [Installation](#installation)
    - [Windows](#windows)
    - [MacOS](#macos)
    - [Debian-based systems](#debian-based-systems)
  - [Post-Installation Testing](#post-installation-testing)
    - [Common Issues](#common-issues)
    - [Recommended VS Code extensions and settings](#recommended-vs-code-extensions-and-settings)
  - [Generic Installation](#generic-installation)
    - [Visual Studio Code](#visual-studio-code)
      - [Extensions](#extensions)
    - [Java](#java)
      - [For Windows users](#for-windows-users)
      - [For macOS users](#for-macos-users)
      - [For Linux users](#for-linux-users)

<!-- /TOC -->

[Screensteps Live instructions](https://wpilib.screenstepslive.com/s/currentCS/m/getting_started/l/999999-installing-c-and-java-development-tools-for-frc#windows)

## Installation

- Download the latest WPILib release for your operating system from [GitHub.](https://github.com/wpilibsuite/allwpilib/releases)

### Windows
- Uninstall the WPILib extension in VS Code if installed.
- Extract the downloaded ZIP file and run the installer.
- Continue through the prompts. If you have VS Code already downloaded, it's
  recommended to select your existing download.
- Set the `java.home` variable
  - The `java.home` variable tells VS Code where to find the Java installation.
  - Click the WPILib icon in the top right, and enter in "Set VS Code". Select
    the `WPILib: Set VS Code Java Home to FRC Home` (This setting only affects
    Visual Studio Code).

### MacOS
- [Install Visual Studio Code](https://code.visualstudio.com) (unless already installed).
  - Double click on the ZIP file to expand it and copy the "Visual Studio Code"
    file to the Applications folder.
- [Download and install the latest (Mac) WPILib release.](https://github.com/wpilibsuite/allwpilib/releases)
  Because of the size of this file, someone should have a predownloaded version.
  - Unzip and untar the downloaded file by locating it in Finder, doubleclicking
  to remove the .gz extension, and doubleclicking again to remove the .tar extension.
  - Create a new folder called "frc2019" in your home (~) directory, and copy the
  contents of the untarred folder (WPILib_Mac-201X.X.X) to that folder.
  - Open a terminal window, `cd` to `~/frc2019/tools`, and run `python ToolsUpdater.py`.
- Install the extensions for Visual Studio Code.
  - Open VS Code, and press `Cmd+Shift+P` to bring up the *Command Palette*.
  - Start typing in "Install from VSIX" and select the option `Extensions: Install from VSIX`.
  - Install, *in this order*, `Cpp.vsix`, `JavaLang.vsix`, `JavaDeps.vsix`, `JavaDebug.vsix`, and `WPILib.vsix`.
    All these are located at `~/frc2019/vsCodeExtensions`.
- Set the `java.home` variable
  - The `java.home` variable tells VS Code where to find the Java installation.
  - Click the WPILib icon in the top right, and enter in "Set VS Code". Select
    the `WPILib: Set VS Code Java Home to FRC Home` (This setting only affects
    Visual Studio Code).

### Debian-based systems

- Install Visual Studio Code through a package manager or from [Microsoft's website.](https://code.visualstudio.com)
- [Download and install the latest (Linux) WPILib release.](https://github.com/wpilibsuite/allwpilib/releases)
    Because of the size of this file, someone should have a predownloaded version.
  - Unzip and untar the downloaded file.
  - Create a new folder called "frc2019" in your home (~) directory, and copy the
    contents of the untarred folder (WPILib_Linux-201X.X.X) to that folder.
  - Open a terminal window, `cd` to `~/frc2019/tools`, and run `python3 ToolsUpdater.py`.
- Install the extensions for Visual Studio Code.
  - Open VS Code, and press `Ctrl+Shift+P` to bring up the *Command Palette*.
  - Start typing in "Install from VSIX" and select the option `Extensions: Install from VSIX`.
  - Install, *in this order*, `Cpp.vsix`, `JavaLang.vsix`, `JavaDeps.vsix`, `JavaDebug.vsix`, and `WPILib.vsix`.
    All these are located at `~/frc2019/vsCodeExtensions`.
- Set the `java.home` variable
  - The `java.home` variable tells VS Code where to find the Java installation.
  - Click the WPILib icon in the top right, and enter in "Set VS Code". Select
  the `WPILib: Set VS Code Java Home to FRC Home` (This setting only affects
  Visual Studio Code).

## Post-Installation Testing
- Clone a repository set up for this year
  (example: `git clone https://github.com/dbadb/2019-DeepSpace.git`)
- Open the *folder* in VS Code
- Run `./gradlew` in the repository
- Run `./gradlew jar` in the repository
  - This downloads the JAR files necessary for deploying code
- Connect to robot WiFi
- Press `Shift+F5` to `WPILib: Deploy Robot Code`.

### Common Issues
- Stuck on `XX% - Starting Java Language Server`
  - This takes a while! 90% of the time, it's starting, but slowly.
    - On Linux, you can view the Java processes with `ps -ef | fgref java`.
  - If the problem persists, try restarting Visual Studio Code.
- Cannot find `ctre.something`
  - Running `./gradlew jar` should gather those dependancies.
- `Various Windows process errors`
  - Try rebooting. Seriously.

### Recommended VS Code extensions and settings

- [Trailing Spaces](https://marketplace.visualstudio.com/items?itemName=shardulm94.trailing-spaces)
  - `"trailing-spaces.highlightCurrentLine": false,`
  - `"trailing-spaces.trimOnSave": true,`
- [Todo Tree](https://marketplace.visualstudio.com/items?itemName=Gruntfuggly.todo-tree)
  - `"todo-tree.regex": "((@|//|#|<!--|;|/\\*|^)\\s*($TAGS)|^\\s*- \\[ \\])",`
  - `"todo-tree.expanded": true,`
  - `"todo-tree.tags": ["TODO", "FIXME", "XXX", "DONE", "BUG", "!!!", "HACK", "NOTE", "FAQ", "IDEA" ],`
- [markdownlint](https://marketplace.visualstudio.com/items?itemName=DavidAnson.vscode-markdownlint)
  - `"markdownlint.config": {"MD006": false, "MD007": false, "MD013": true,`
      `"MD022": false, "MD026": false, "MD032": false, "MD040": false },`

## Generic Installation

If you have already installed using the above steps, ***Go No Further!***
This section was made before the `allwpilib` packages, but is useful for people
with weird operating systems.

### Visual Studio Code

[Download Visual Studio Code from here for most operating systems.](https://code.visualstudio.com/download)

If on an Arch-based Linux distribution, VS Code is also available in the community
repository as `code`.

#### Extensions

- [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) -
    open up the Extensions sidebar, and search "java". It's in the top five results.
- WPILib Extension
    - [Download the latest WPILib Extension.](https://github.com/wpilibsuite/vscode-wpilib/releases/latest/)
    - Open the Extensions sidebar (Ctrl+Shift+X)
    - Click the three dots in the upper right corner of the Extensions sidebar
    - Hit `Install from VSIX...`
    - Navigate to the WPILib extension you downloaded, and click `Install`.

### Java
Download and install the Java 11 JDK or the OpenJDK version.

[Oracle's Java 11 JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)

#### For Windows users

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

#### For macOS users

1) Run `echo $JAVA_HOME` to check if the variable is already set
   (JAVA_HOME tells your computer where Java is)
2) If the output is empty, edit the `.bash_profile` and add `export JAVA_HOME=$(/usr/libexec/java_home)`
3) Now you need to restart your bash file: `source .bash_profile`
4) Check that the variable has been set again with `echo $JAVA_HOME`.

#### For Linux users
In Visual Studio Code, add this line at the top of your `settings.json`.

`"java.home": "/usr/lib/jvm/default-java",`

If this location doesn't work, `cd` to `/usr/lib/jvm/` and poke around there.
Common problems include slight distro differences, the wrong / multiple Java
versions, and wonky `$JAVA_HOME`s.