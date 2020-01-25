package frc.robot;

/**
 * The RobotMap class contains subclasses with the assigned pins for each system.
 * General pins are put in the main class.
*/
public final class RobotMap
{
    // This assumes that we only want one joystick:
    public static final int JOYSTICK = 0;

    public static enum RobotModes
    {
        DISABLED, AUTONOMOUS, TELEOP, TEST
    }

    public static class Drivetrain
    {
        public static final int LEFT_FRONT_MOTOR = 1;
        public static final int RIGHT_FRONT_MOTOR = 2;
        public static final int LEFT_REAR_MOTOR = 3;
        public static final int RIGHT_REAR_MOTOR = 4;
    }
}