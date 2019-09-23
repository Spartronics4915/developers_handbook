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

A goal is to make this eventually accessible on our team website.

@TODO pull from old codebase wikis

## Table of Contents
- [ ] [The Developer Handbook](README.md)

### [Introduction to Programming](introductory_programming/README.md)
  - [ ] [Setting up your work environment](introductory_programming/environment_setup.md)

#### [An Introduction to Version Control](robot_programming/git_intro/README.md)
  - [x] [Introducing Git and GitHub](introductory_programming/git_intro/git_about.md)
  - [x] [Git Fundamentals](introductory_programming/git_intro/git_fundamentals.md)
  - [x] [Next Level Git](introductory_programming/git_intro/git_advanced.md)
  - [x] [Git Flow](introductory_programming/git_intro/git_flow.md)
    - move to robot code?
  - [x] [FAQ: git, vi, bash shell](introductory_programming/git_intro/git_faq.md)

#### [Java Lessons](introductory_programming/java_lessons/README.md)
  - [ ] [Lesson 1: Introductory Syntax](introductory_programming/java_lessons/1_syntax.md)
  - [ ] [Lesson 2: Variables and Datatypes](introductory_programming/java_lessons/2_variables_datatypes.md)
  - [ ] [Lesson 3: Method Calls](introductory_programming/java_lessons/3_method_calls.md)
  - [ ] [Lesson 4: The If Statement](introductory_programming/java_lessons/4_if_statement.md)
  - [ ] [Lesson 5: Method Definitions](introductory_programming/java_lessons/5_method_definitions.md)
  - [ ] [Lesson 6: Classes](introductory_programming/java_lessons/6_classes.md)
    - [ ] not complete
  - [ ] [Lesson 7: Inheritance](introductory_programming/java_lessons/7_inheritance.md)
    - [ ] extra not complete
  - [ ] [Helpful Programming Resources](introductory_programming/java_lessons/resources.md)

### [Robot Programming](robot_programming/README.md)
- [ ] [What is a Robot?](robot_programming/robot_code.md)

#### [Best Practices](introductory_programming/best_practices/README.md)
  - [ ] [Contribute](introductory_programming/best_practices/contribute.md)
  - [ ] [Developer Process](introductory_programming/best_practices/dev_process.md) @todo move
  - [ ] [Style Guide](introductory_programming/best_practices/style_guide.md)

#### [Command-Based Programming](robot_programming/command-based_programming/README.md) <!--[What is Command Based programming?](https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599732-what-is-command-based-programming)-->
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
  - I have no clue what to put here.
  - Similar structure to java_lessons?
  - This is Declan's and Jeffrey's forte.

### [Vision?](vision/README.md)
  - What's vision for? (similar to introduction to programming/readme)
  - https://github.com/Spartronics4915/Vision

### [Bling](arduino_development/README.md)
  - Compile resources

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

### [Data Analysis](data_analysis/README.md)
  - During the preseason?
  - Include the app?

### [Scouting App](scouting_app/README.md) <!--haha-->
  - Part of Data Analysis?












## Structure

This handbook is broken up into se

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
    Create and print out joystick input.
    Set a motors power from Joystick input
    Set multiple motors from Joystick input
    Discuss classes
    Make a Subsystem
    a. Start with Drive Train
    Make a Command

## First meeting

Introduction to programming, then split into two groups to talk about java programming and robot programming
Everybody from last year sits through robot programming to learn about the new structure

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
