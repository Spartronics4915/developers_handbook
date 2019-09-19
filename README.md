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

## SUMMARY

- [Introduction](README.md)

- [Robot Lessons](robot_lessons/README.md)
  - [Lesson 1: Motors](robot_lessons/1_motors.md)
  - [Lesson 3: Subsystems and State Machines](robot_lessons/3_statemachines.md)

- [Java Lessons](java_lessons/README.md)
  - [Lesson 1: Introductory Syntax](java_lessons/1_syntax.md)
  - [Lesson 2: Variables and Datatypes](java_lessons/2_variables_datatypes.md)
  - [Lesson 3: Method Calls](java_lessons/3_method_calls.md)
  - [Lesson 4: The If Statement](java_lessons/4_if_statement.md)
  - [Lesson 5: Method Definitions](java_lessons/5_method_definitions.md)

- [Git Introduction](git_intro/README.md)
    - [Introducing Git and GitHub](git_intro/git_about.md)
    - [Git Fundamentals](git_intro/git_fundamentals.md)
    - [Next Level Git](git_intro/git_advanced.md)
    - [FAQ: git, vi, bash shell](git_intro/git_faq.md)

- [Development Guidelines](dev_guide/README.md)
    - [Flashing Components](dev_guide/flashing.md)
    - [Spartronics Git Workflow](dev_guide/git_flow.md)
    - [Spartronics Development Process](dev_guide/dev_process.md)
    - [Spartronics Programming Style Guide](dev_guide/style_guide.md)
    - [Visual Studio Code and the Build System](dev_guide/environment_setup.md)
    - [Collaborative Development](dev_guide/collaboration.md)
    - [Competition Readiness](dev_guide/competitions.md)
    - [Networking Setup](basics/networking.md)
    - [Robot Programming](basics/robot_code.md)
    - [WPILib Overview](basics/wpilib_overview.md)
    - [Resources](basics/resources.md)

- [Command Based Programming](commands_subsystems/README.md)
    - [Commands](commands_subsystems/commands/README.md)
        - [Methods](commands_subsystems/commands/methods.md)
    - [Subsystems](commands_subsystems/subsystems/README.md)
        - [Subsystem Examples](commands_subsystems/subsystems/examples.md)
    - [Scheduler](commands_subsystems/scheduler/README.md)

- [Actuators](actuators/README.md)
    - [Talon SRX](actuators/talon/README.md)
        - [Capabilities of Talon SRX](actuators/talon/capabilities.md)
        - [Programming Talon SRX](actuators/talon/programming.md)
        - [Troubleshooting Talon SRX](actuators/talon/troubleshooting.md)
    - [Servos](actuators/servos/README.md)

- [Data Analysis](data_analysis/README.md)

- [Contribute!](contribute.md)
