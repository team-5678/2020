package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;

/**
 * A subsystem that repersents the ball shooter on the robot.
 */
public class Shooter extends SubsystemBase
{
    private final Spark shooterMotor;

    public Shooter()
    {
        shooterMotor = new Spark(RobotMap.Shooter.MOTOR_PORT);
    }

    /**
     * Shoots the ball
     */

    public void shoot()
    {
        shooterMotor.set(RobotMap.Shooter.MOTOR_SPEED);
    }
    

    // Stops the motor
    public void stop()
    {
        shooterMotor.stopMotor();
    }
}
