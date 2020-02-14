package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;

/**
 * A subsystem that repersents the ball intake on the robot.
 */
public class Shooter extends SubsystemBase
{
    private final Spark m_shooterMotor;

    public Shooter()
    {
        m_shooterMotor = new Spark(RobotMap.Shooter.MOTOR);
    }

    /**
     * Shoots the ball
     */

    public void shoot()
    {
        m_shooterMotor.set(RobotMap.Shooter.MOTOR_SPEED);
    }
    

    // Stops the motor
    public void stop()
    {
        m_shooterMotor.stopMotor();
    }
}