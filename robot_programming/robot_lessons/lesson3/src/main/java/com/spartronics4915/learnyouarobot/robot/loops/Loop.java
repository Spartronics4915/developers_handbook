package com.spartronics4915.learnyouarobot.robot.loops;

/**
 * Interface for loops, which are routine that run periodically in the robot
 * code (such as periodic gyroscope
 * calibration, etc.)
 */
public interface Loop
{

    public void onStart(double timestamp);

    public void onLoop(double timestamp);

    public void onStop(double timestamp);
}
