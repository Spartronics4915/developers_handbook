# Spartronics Developer Handbook

@TODO: Everything past table of contents

This handbook is compiled by Spartronics 4915, Bainbridge Island WA, USA.
It is intended as a guide for FRC programming teams specifically using
Java and Git.

Alongside the different chapters are code examples for better understanding
of the concepts in the section.

This handbook is presented using
[Gitbook](https://spartronics4915.gitbook.io/developer-handbook/)
and is written in Github Flavored Markdown. For information on how to
contribute to this document, read contribute.md which contains the writing
guide for this book, as well as how to use markdown.

@TODO pull from old codebase wikis

## Table of Contents
  - [ ] [The Developer Handbook](README.md)

### [Introduction to Programming](introductory_programming/README.md)
  - [ ] [Setting up your work environment](introductory_programming/environment_setup.md)

### [An Introduction to Version Control](git_introduction/README.md)
  - [x] [Introducing Git and GitHub](git_introduction/git_about.md)
  - [x] [Git Fundamentals](git_introduction/git_fundamentals.md)
  - [x] [Next Level Git](git_introduction/git_advanced.md)
  - [x] [Git Flow](git_introduction/git_flow.md)
  - [x] [FAQ: git, vi, bash shell](git_introduction/git_faq.md)
  - [ ] [GitHub Projects](git_introduction/git_projects.md)

### [An Introduction to Java](java_programming/README.md)
  - [x] [Lesson 1: Introductory Syntax](java_programming/1_syntax.md)
  - [x] [Lesson 2: Variables and Datatypes](java_programming/2_variables_datatypes.md)
  - [x] [Lesson 3: Method Calls](java_programming/3_method_calls.md)
  - [x] [Lesson 4: The If Statement](java_programming/4_if_statement.md)
  - [x] [Lesson 5: Method Definitions](java_programming/5_method_definitions.md)
  - [x] [Lesson 6: Classes](java_programming/6_classes_and_objects.md)
  - [ ] [Lesson 7: Inheritance](java_programming/7_inheritance.md)
  - [ ] [Helpful Programming Resources](java_programming/resources.md)

### [Robot Programming](robot_programming/README.md)
  - [ ] [What is a Robot?](robot_programming/robot_code.md)

#### [Best Practices](robot_programming/best_practices/README.md)
  - [ ] [Contribute](introductory_programming/best_practices/contribute.md)
  - [ ] [Developer Process](introductory_programming/best_practices/dev_process.md) @todo move
  - [ ] [Style Guide](introductory_programming/best_practices/style_guide.md)

#### [Command-Based Programming](robot_programming/commands_subsystems/README.md) <!--[What is Command Based programming?](https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599732-what-is-command-based-programming)-->
  - [ ] What is a Subsystem?
    - One system vs. two: intake and intake wheels example
  - [ ] What is a Command?
  - [ ] More on Subsystems
    - Default Commands
  - [ ] Lesson: Using Commands
  - [ ] Scheduling Commands
    - Sequential and Parallel commands (or whatever the rewrite says)
  - [ ] Lesson: Scheduling Commands
  - [ ] Using sensor feedback with PID
    - PIDSubsystem(?)
    - PIDCommand(?)
  - [ ] Lesson: Using sensor feedback
  - [ ] Actuators
    - [ ] Motors, in depth
    - [ ] Pneumatics
    - [ ] Servos
  - [ ] Constructors and Initialization
    - [ ] Singletons
  - [ ] Lesson: Actuators and Constructors

#### [Hardware Overview](robot_programming/hardware_overview/README.md)
  - [ ] [Actuators](robot_programming/hardware_overview/actuators/README.md)
    - [ ] Talon SRX <!--+ capabilities-->
      - Programming Talon SRX
        - @TODO: kind of on-the-nose? change name
      - Troubleshooting
        - @TODO: every major hardware piece should have a troubleshooting section
    - [ ] Servos
    - [ ] Pneumatics <!--Capabilities-->
      - The PCM
      - Programming
      - Using boolean variables
      - Troubleshooting
  - [ ] [Sensors](robot_programming/hardware_overview/sensors/README.md)
    - Types of sensors
    - When to use what
    - Implementation in code
    - Troubleshooting
  - [ ] roboRIO
    - Networking
      - roboRIO web-based configuration access
      - radio programming
      - wireless access port
    - Flashing
    - Troubleshooting

#### Development Process
  - [ ] Development Flow
    - [ ] design -> PoA -> design review -> coding -> QA -> code review -> merge
  - [ ] Using Git
    - Commit often
    - Commit descriptors
    - Pull requests (? already covered ?)
    - GitHub Projects
  - [ ] Coding Conventions
    - Best Practices
    - Naming
    - Variables (no magic numbers!!)
    - Organization
    - Comments
    - Avoiding redundant redundancy
  - [ ] Collaborative Development
    - Working with your peers
      - Pair coding
      - be clear
    - Working between subteams
      - RobotMap (? what is this ?)
      - Electronics
        - Wiring Diagram
        - @Peter - visual MAP of the robot
      - CAD
        - Link to updated robot CAD
  - [ ] Catching your failures
    - More on initialization <!--from command-based_programming-->
    - Try / Except blocks
    - Logging and Debugging
      - Test Mode (even I don't know what this is)
  - [ ] Competition Readiness
    - @TODO: move... somewhere?
    - Competition Checklist
      - https://github.com/Spartronics4915/2016-Stronghold/wiki/Competition-Checklist

### [ ] [Exploring WPILIBj](exploring_wpilibj/README.md)
  - [ ] Other types of robots
    - Timed, State Machines, etc
  - [ ] Different types of drives
    - http://www.simbotics.org/resources/mobility
    - Six-wheel Drop Center
    - West Coast
      - https://www.chiefdelphi.com/t/west-coast-drive/91749/4
    - TANK
    - Rocker / Slide
      - https://johnvneun.com/blog/2019/1/3/x019-prototype
    - Mechanum
      - Vectors yes
    - Holonomic
      - mmm
    - Swerve
      - Fill with %MATHS%

### [Path Planning and Autonomous](path_planning_and_autonomous/README.md)
  - This is Declan's and Jeffrey's forte.

### [Vision](vision/README.md)
  - What's vision for? (similar to introduction to programming/readme)
  - https://github.com/Spartronics4915/Vision
  -

### [Embedded Development](embedded_development/README.md)
  - Compile resources
  - This is bling

### [Web Development](web_development/README.md)
  - [ ] SmartDashboard & NetworkTables
  - [ ] Team Website
    - How GitHub Pages works
      - Sourcing from a main repository
      - Uploading docs pages from other repositories
        - Show 2019-DeepSpace / 2020-InfiniteRecharge
        - Get Vision up there
    - How Jekyll works
    - How forestry.io works
      - Marketing pitch
      - How to publish articles
        - Mention WYSIWYG
      - How to upload webpages
    - Get input from Binnur
  - [ ] Resources
    - https://internetingishard.com/
    - https://j-james.me/interneting-is-hard/

### [Data Analysis](data_analysis/README.md)
  - During the preseason?
  - Include the app?

## Structure

For new students who have never programmed, or have programmed just not in Java, we recommend they start with the `introductory_lessons` folder.
If you're confident in Java, `robot_programming` is designed for you. It has a curriculum on commands and subsystems, how to use our version control system, and other general stuff idk

### Robot Lessons
Robot lessons teach programmers who know Java how to program our robots. PID

- Hardware / I/O
    - RoboRIO
    - Motors
    - Sensors
    -
- Command-based programming
    - Subsystems
    - Commands
- Robot Lessons
    - These should be example things to do with a robot, and a testbed.
    - For example, make a motor spin. Control it with a joystick. Create a subsystem. Make a command.

1646's method

    Create a motor and set its power
    a. Set to 1
    b. Set to 0
    c. Set to -1
    d. Set to 0.5
    Create and print out Joystick input.
    Set a motors power from Joystick input
    Set multiple motors from Joystick input
    Discuss classes
    Make a Subsystem
    a. Start with Drive Train
    Make a Command

## Introduction.md
- What is embedded development about?
- How is this different than dear-old-java?
- Keys to success: knowing what is going on under the hood
- Spartronics development
- Coding style
- Git workflow

### What does it take to build a robot?
- 100% marketing! Without marketing, we have no budget and no presence. Their efforts magnifies our build efforts
- 60-20-20! There is only so much you can do for faulty mechanical design in electronics or software!
    - 60% mechanical
    - 20% electronics
    - 20% programming
- 30-70!
    - 30% is your robot
    - 70% is your driving team
- At the end of the match, did you do what you said you were going to do?
