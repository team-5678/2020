package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;

/**
 * The Climber subsystem manages the task of climb for the robot.
 */
public class Climber extends SubsystemBase
{
    private final Spark m_climbMotor;

    /**
     * Creates an instance of the Climber class and sets up the climber.
     */
    public Climber()
    {
        // Instantiate the climb motor with the assigned port.
        m_climbMotor = new Spark(RobotMap.Climber.MOTOR_PORT);
    }

    /**
     * Runs the climber.
     */
    public void climb()
    {
        // Set the motor to the assigned speed.
        m_climbMotor.set(RobotMap.Climber.MOTOR_SPEED);
    }

    /**
     * Retracts the climber.
     */
    public void retract()
    {
        // Retract the climber by setting the motor to the negative of the assigned speed.
        m_climbMotor.set(-RobotMap.Climber.MOTOR_SPEED);
    }

    /**
     * Stops the climb motor.
     */
    public void stop()
    {
        // Stop the climb motor.
        m_climbMotor.stopMotor();
    }
}