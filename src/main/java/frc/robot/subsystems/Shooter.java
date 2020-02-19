package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Spark;

/**
 * A subsystem that repersents the ball shooter on the robot.
 */
public class Shooter extends SubsystemBase
{
    private final Spark shooterMotorLeft;
    private final Spark shooterMotorRight;

    public Shooter()
    {
        shooterMotorLeft = new Spark(RobotMap.Shooter.MOTOR_LEFT);
        shooterMotorRight = new Spark(RobotMap.Shooter.MOTOR_RIGHT);
    }

    /**
     * Shoots the ball
     */

    public void shoot()
    {
        shooterMotorLeft.set(RobotMap.Shooter.MOTOR_SPEED);
        shooterMotorRight.set(-RobotMap.Shooter.MOTOR_SPEED);
    }
    

    // Stops the motor
    public void stop()
    {
        shooterMotorLeft.stopMotor();
        shooterMotorRight.stopMotor();
    }
}