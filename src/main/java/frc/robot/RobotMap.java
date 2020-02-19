package frc.robot;

/**
 * The RobotMap class contains subclasses with the assigned pins, buttons, or speeds for each system.
*/
public final class RobotMap
{

    public static class Drivetrain
    {
        public static class DriveMotor
        {
            public static final int LEFT_FRONT_MOTOR = 0;
            public static final int RIGHT_FRONT_MOTOR = 1;
            public static final int LEFT_REAR_MOTOR = 2;
            public static final int RIGHT_REAR_MOTOR = 3;
        }

        public static class DriveSpeeds
        {
            public static final double QUARTER_SPEED = 0.25;
            public static final double HALF_SPEED = 0.5;
            public static final double THREE_FOURTHS_SPEED = 0.75;
            public static final double FULL_SPEED = 1.0;
        }

    }

    public static class Intake
    {
        public static final int MOTOR = 4; // temp posistion
        public static final double MOTOR_SPEED = 0.5;
    }

    public static class Shooter
    {
        public static final int MOTOR_LEFT = 10; // temp posistion
        public static final int MOTOR_RIGHT = 9; // temp posistion
        public static final double MOTOR_SPEED = 1.0; // temp posistion, runs at full speed, be careful!
        
    }

    public static class Joystick
    {
        // This assumes that we only want one joystick:
        public static final int PORT = 0;

        public static class Buttons
        {
            // Intake related buttons
            public static final int INTAKE_BUTTON = 0; // temp posistion, stright up of the POV hat
            public static final int REVERSE_BUTTON = 180; // temp posistion, stright down of the POV hat

            // Speed change buttons
            public static final int QUARTER_SPEED_BUTTON = 1; // temp posistion
            public static final int HALF_SPEED_BUTTON = 2; // temp posistion
            public static final int THREE_FOURTHS_SPEED_BUTTON = 3; // temp posistion
            public static final int FULL_SPEED_BUTTON = 4; // temp posistion

            // Shooter related buttons
            public static final int SHOOT_BUTTON = 10; // temp posistion
        
        }
    }



    
}