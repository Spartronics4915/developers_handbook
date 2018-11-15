# Enabling Collaborative Development

@TODO section on how to structure code and other best practices
to enable collaborative development where all code can reside in
master, regardless of subsystem availability.
@TODO include release process, with tags
@TODO include wiring diagram
@TODO include recommended port configurations

Random bits to clean and organize

## Best practices: Programming and All...

### Building Two Robots
- Ensure both robots' motors are configured and wired identically
  to avoid switching profiles.

<<<<<<< HEAD
### Rework these....
=======
<<<<<<< HEAD
### Rework these....
=======
### Rework these.... @ TODO
>>>>>>> 6a150585dda34f5d85c825022abd9f18f86e7246
>>>>>>> 36a0c05f08a56b4e20ab4e13f9c7b11047273305
**Sensor Inputs**: All sensor inputs should be checked for range values.

**Actuator outputs**: All method outputs should be checked for range as
not to exceed the range input to actuators

**Comments**: There should be enough comments such that if they were grouped
together anyone would understand what the program was supposed to do

**Failures**: All code should consider what to do in a failure condition.
This would include out of range, stuck in a loop, external processes take
too long due to failure, communications errors, etc

**NO MAGIC NUMBERS**. All constant numbers should be associated with a variable
and a comment on where the number came from.

**Code Style**: Follow the programming style guide in the handbook. A consistent
style is beneficial when other members of our team and other teams read your code.

## Program Development Best Practices

### Code Review:
- All code should be reviewed by software sub-team and sub-team mentor.
  More than the author needs to understand the code.
- Code review consists of checking the following:
    - Input range check
    - Output range check
- Check for magic numbers (Are they documented? Better: Make them a constant variable?)
<<<<<<< HEAD
    - Check that any code written is already done in FIRST library
- Comments document why the program is written as it is
    - Is the code backed up?
=======
<<<<<<< HEAD
    - Check that any code written is already done in FIRST library
- Comments document why the program is written as it is
    - Is the code backed up?
=======

    - Check if any code written is already done in FIRST library

- Comments document why the program is written as it is

    - Check if the code is backed up

>>>>>>> 6a150585dda34f5d85c825022abd9f18f86e7246
>>>>>>> 36a0c05f08a56b4e20ab4e13f9c7b11047273305
- ***Does the code meet the robot function requirements!!!!!***
