/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The Drivetrain class is the subsystem which manages the driving operation of the robot.
 */
public class Drivetrain extends SubsystemBase
{
    private DifferentialDrive m_drive;
    private double robotSpeed = RobotMap.Drivetrain.DriveSpeeds.HALF_SPEED;

    // encoder objects
    private CANEncoder leftFrontEncoder;
    private CANEncoder rightFrontEncoder;
    private CANEncoder leftRearEncoder;
    private CANEncoder rightRearEncoder;
    

    /**
     * initializes our drivetrain instance.
     */
    public Drivetrain()
    {
        // Instantiate each individual motor.
        SpeedController leftFrontMotor = new CANSparkMax(RobotMap.Drivetrain.DriveMotor.LEFT_FRONT_MOTOR, MotorType.kBrushless);
        SpeedController rightFrontMotor = new CANSparkMax(RobotMap.Drivetrain.DriveMotor.RIGHT_FRONT_MOTOR, MotorType.kBrushless);
        SpeedController leftRearMotor = new CANSparkMax(RobotMap.Drivetrain.DriveMotor.LEFT_REAR_MOTOR, MotorType.kBrushless);
        SpeedController rightRearMotor = new CANSparkMax(RobotMap.Drivetrain.DriveMotor.RIGHT_REAR_MOTOR, MotorType.kBrushless);

        leftFrontEncoder = ((CANSparkMax) leftFrontMotor).getEncoder();
        rightFrontEncoder = ((CANSparkMax) rightFrontMotor).getEncoder();
        leftRearEncoder = ((CANSparkMax) leftRearMotor).getEncoder();
        rightRearEncoder = ((CANSparkMax) rightRearMotor).getEncoder();


        // Now, group those motors into speed controller groups based on whether they are on the right or left sides.
        SpeedControllerGroup left = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
        SpeedControllerGroup right = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);

        // Finally, instantiate our DifferentialDrive instance with those speed controller groups.
        m_drive = new DifferentialDrive(left, right);
    }

    /**
     * This method uses our differential drive to move the motors and drive the robot.
     */
    
     public void arcadeDrive(double xSpeed, double zRotation)
     {
        m_drive.arcadeDrive(xSpeed * robotSpeed, zRotation * robotSpeed);
        SmartDashboard.putNumber("Current X speed", (robotSpeed * xSpeed)); // testing line, trying to see what works and what doesnt
        SmartDashboard.putNumber("Current Z rotation", (robotSpeed * zRotation));
     }

     /**
      * Stops the motors on the drivetrain
      */
     public void stop()
     {
        m_drive.stopMotor();
     }

     /**
      * Sets the speed of the robot by using the speed set command.
      * @param speed imported speed from the change speed command, is set to the robotspeed instance var.
      */
     public void setSpeed(double speed)
     {
        this.robotSpeed = speed;
        SmartDashboard.putNumber("Speed Modifier: ", this.robotSpeed);
     }



     public CANEncoder getEncode(int motorID)
     {
         if (motorID == RobotMap.Drivetrain.DriveMotor.LEFT_FRONT_MOTOR) {
            return leftFrontEncoder;

         } else if (motorID == RobotMap.Drivetrain.DriveMotor.LEFT_REAR_MOTOR) {
            return leftRearEncoder;

         } else if (motorID == RobotMap.Drivetrain.DriveMotor.RIGHT_FRONT_MOTOR) {
            return rightFrontEncoder;

         } else if (motorID == RobotMap.Drivetrain.DriveMotor.RIGHT_REAR_MOTOR) {
            return rightRearEncoder;

         } else {
            return null;
         }
     }

     
}
