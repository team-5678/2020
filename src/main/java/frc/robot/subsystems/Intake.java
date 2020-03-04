package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;

/**
 * A subsystem that repersents the ball intake on the robot.
 */
public class Intake extends SubsystemBase
{
    private final Spark m_intakeMotor;

    public Intake()
    {
        m_intakeMotor = new Spark(RobotMap.Intake.MOTOR_PORT);
    }

    /**
     * Intakes the ball
     */
    public void intakeBall()
    {
        
        m_intakeMotor.set(-RobotMap.Intake.MOTOR_SPEED); // can be adjusted later if needed
    }

    /**
     * Pushes the ball out of the intake, spins the motor in reverse
     */
    public void releaseBall()
    {

        m_intakeMotor.set(RobotMap.Intake.MOTOR_SPEED); // can be adjusted later if needed
    }

    // Stops the motor
    public void stop()
    {
        m_intakeMotor.stopMotor();
    }
}