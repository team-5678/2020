/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The Drivetrain class is the subsystem which manages the driving operation of the robot.
 */
public class Drivetrain extends SubsystemBase
{
    private Joystick m_joystick;
    private DifferentialDrive m_drive;

    /**
     * Instantiates a Drivetrain instance.
     */
    public Drivetrain()
    {
        // First, instantiate our single Joystick.
        m_joystick = new Joystick(RobotMap.Drivetrain.JOYSTICK);

        // Instantiate each individual motor.
        SpeedController leftFrontMotor = new CANSparkMax(RobotMap.Drivetrain.LEFT_FRONT_MOTOR, MotorType.kBrushless);
        SpeedController rightFrontMotor = new CANSparkMax(RobotMap.Drivetrain.RIGHT_FRONT_MOTOR, MotorType.kBrushless);
        SpeedController leftRearMotor = new CANSparkMax(RobotMap.Drivetrain.LEFT_REAR_MOTOR, MotorType.kBrushless);
        SpeedController rightRearMotor = new CANSparkMax(RobotMap.Drivetrain.RIGHT_REAR_MOTOR, MotorType.kBrushless);

        // Now, group those motors into speed controller groups based on whether they are on the right or left sides.
        SpeedControllerGroup left = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
        SpeedControllerGroup right = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);

        // Finally, instantiate our DifferentialDrive instance with those speed controller groups.
        m_drive = new DifferentialDrive(left, right);
    }

    /**
     * The periodic method uses our differential drive to move the motors and drive the robot.
     */
    @Override
    public void periodic()
    {
        // Use the current values of our joystick to arcade drive.
        m_drive.arcadeDrive(m_joystick.getX(), m_joystick.getY());
    }
}
