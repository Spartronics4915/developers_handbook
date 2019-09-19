# Spartronics Developer Handbook

_Work in-progress..._

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

## Summary, but different

- [The Developer Handbook](README.md)

- [Introduction to Programming](introductory_programming/README.md) @FIXME: does not exist
  - [What is a robot?](introductory_programming/robot_code.md)
  - [Setting up your work environment](introductory_programming/environment_setup.md)

  - [Java Lessons](introductory_programming/java_lessons/README.md)
    - [Lesson 1: Introductory Syntax](introductory_programming/java_lessons/1_syntax.md)
    - [Lesson 2: Variables and Datatypes](introductory_programming/java_lessons/2_variables_datatypes.md)
    - [Lesson 3: Method Calls](introductory_programming/java_lessons/3_method_calls.md)
    - [Lesson 4: The If Statement](introductory_programming/java_lessons/4_if_statement.md)
    - [Lesson 5: Method Definitions](introductory_programming/java_lessons/5_method_definitions.md)
    - [Lesson 6: Classes](introductory_programming/java_lessons/6_classes.md) @TODO: not complete
    - [Lesson 7: Inheritance](introductory_programming/java_lessons/7_inheritance.md) @TODO: extra not complete

  - [Git Introduction](introductory_programming/git_intro/README.md)
    - [Introducing Git and GitHub](introductory_programming/git_intro/git_about.md)
    - [Git Fundamentals](introductory_programming/git_intro/git_fundamentals.md)
    - [Next Level Git](introductory_programming/git_intro/git_advanced.md)
    - [FAQ: git, vi, bash shell](introductory_programming/git_intro/git_faq.md)
    - [Using GitHub Projects](introductory_programming/git_intro/git_projects.md) @TODO: not started
    - [TODO](introductory_programming/git_intro/git_flow.md) @XXX: what is this?
    - [TODO](introductory_programming/git_intro/git_setup.md) @XXX: what is this?

  - [Best Practices](introductory_programming/best_practices/README.md)
    - [Contribute](introductory_programming/best_practices/contribute.md)
    - [Developer Process](introductory_programming/best_practices/dev_process.md)
    - [Style Guide](introductory_programming/best_practices/style_guide.md)

  - [Helpful Programming Resources](introductory_programming/resources.md)

- [Robot Programming](robot_programming/README.md)

  - [Command Based Programming](commands_subsystems/README.md) @TODO: all of commands are outdated
    - [Commands](commands_subsystems/commands/README.md)
      - [Methods](commands_subsystems/commands/methods.md)
    - [Subsystems](commands_subsystems/subsystems/README.md)
      - [Subsystem Examples](commands_subsystems/subsystems/examples.md)
    - [Scheduler](commands_subsystems/scheduler/README.md)

  - [Hardware Overview](robot_programming/hardware_overview/README.md)
    - [Actuators](robot_programming/hardware_overview/actuators/README.md)
      - [Talon SRX](robot_programming/hardware_overview/actuators/talon/README.md)
        - [Capabilities of Talon SRX](robot_programming/hardware_overview/actuators/talon/capabilities.md)
        - [Programming Talon SRX](robot_programming/hardware_overview/actuators/talon/programming.md)
        - [Troubleshooting Talon SRX](robot_programming/hardware_overview/actuators/talon/troubleshooting.md)
      - [Servos](robot_programming/hardware_overview/actuators/servos/README.md)
    - [Sensors](robot_programming/hardware_overview/sensors/README.md)

  - [Robot Lessons](robot_programming/robot_lessons/README.md)
    - [Lesson 1: Motors](robot_programming/robot_lessons/1_motors.md)
    - [Lesson 3: Subsystems and State Machines](robot_programming/robot_lessons/3_statemachines.md)

  - [Collaborative Development](robot_programming/collaboration.md)
  - [Competition Readiness](robot_programming/competitions.md)
  - [Flashing Components](robot_programming/flashing.md)
  - [WPILib Overview](robot_programming/wpilib_overview.md)
  - [Networking Setup](robot_programming/networking.md)

<!--advanced projects section-->
<!--idk what else to call them-->
- [Data Analysis](data_analysis/README.md)
- [Bling](bling/README.md)
- [Scouting App](scouting_app/README.md)
- [Web Development](web_development/README.md)
- [Path Planning and Autonomous](path_planning_and_autonomous/README.md)
- [Vision?](https://github.com/Spartronics4915/Vision)

## Structure

We follow a "three paths" approach to

### Introductory Lessons
The goal of these lessons is to teach people who have never had any experience with Java before how to code, while still including some higher-level concepts.
This _needs_ to be engaging.

- Setting up your environment
- An Introduction to Version Control
- Flow
    - Coding Style
    - Best Practices
- Java Lessons <!--Is it worth using Codecademy?-->
    - Syntax
    - Variables and Datatypes
    - Method Calls
    - If Statements
    - Method Definitions
    - Classes
    - Inheritance

Sprinkling in projects like text-based games, simple uses of classes is _important_.

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

### Advanced Lessons <!--for lack of a better name-->

- Autonomous
- Data Analysis
- Website

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

# What does it take to build a robot?
- 100% marketing! Without marketing, we have no budget and no presence. Their efforts magnifies our build efforts
- 60-20-20! There is so much you can do for faulty mechanical design in electronics or software!
    - 60% mechanical
    - 20% electronics
    - 20% programming
- 30-70!
    - 30% is your robot
    - 70% is your driving team
- At the end of the match, did you do what you said you were going to do?


## TODOs

Place holder for things to add to the guide

### Actuators

### Commands Subsystems

- Scheduler: Know your master...
- Commands
- Subsystems
    - One system vs. two: intake and intake wheels example
- Diving into Subsystems
    - Drivetrain and template code
        - Subsystem
        - Commands
- Describe different types of robot (Iterative, Timed...)
- Describe different drives (tank, swerve...)

### Dev Guide

- Git and Github workflow
- Development process
    - design -> PoA -> design review -> coding -> QA -> code review -> merge
    - Code organization
    - Naming
    - Musts for collaborative development
        - RobotMap
        - try/except blocks
    - Logging and Debugging
        - Test Mode
- Competition Checklist
- SmartDashboard & Network Tables
- Driver Station Logs
- Camera Setup
- Safety
- Robot code
    - Initialization sequencing
    - Autonomous Vs. Teleop
- Add any username/password to configure the robot
    - roboRIO web-based configuration access
    - radio programming
    - wireless access port

### Git Intro

### Java Lessons

### Robot Lessons

### Website Lessons

3128's ./resources/website.md/ is useful

- Overview of how our website works
    - Where to find resources
    - How to publish articles on it
    - How to upload webpages
- Quick overview of how to use HTML + CSS
    - JavaScript warning
    - JavaScript Overview
