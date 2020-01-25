/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotContainer;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
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
    public RobotContainer m_container;
    public DifferentialDrive m_drive;
    private DriveCommand m_driveCommand = new DriveCommand(this);

    /**
     * Instantiates a Drivetrain instance.
     */
    public Drivetrain(RobotContainer container)
    {
        // First, store the RobotContainer value.
        m_container = container;

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
     * Initializes our drive command & schedules it.
     */
    @Override
    public void register()
    {
        // Schedule the drive command.
        m_driveCommand.schedule();
    }
}
