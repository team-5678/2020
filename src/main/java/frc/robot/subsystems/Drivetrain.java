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
    private double robotSpeed = RobotMap.Drivetrain.DriveSpeeds.FULL_SPEED;
    private int m_driveDirection = 1;

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
        // This drives the X axis of the robot based upon either an assigned speed
        // (between 0.0-1.0 for forward or opposite range for backwards)
        // or the joystick's Y axis. Same goes for the Y axis of the robot.
        // Speeds or rotation doubles are multiplied by a speed setting we want to limit by.
        // The final speed is multiplied by the direction
        // (times 1 for normal direction, -1 for opposite).
        m_drive.arcadeDrive((xSpeed * robotSpeed) * m_driveDirection, (zRotation * robotSpeed) * m_driveDirection);

        // Drive numbers for debugging/statistics:
        SmartDashboard.putNumber("Current X speed", ((robotSpeed * xSpeed) * m_driveDirection));
        SmartDashboard.putNumber("Current Z rotation", ((robotSpeed * zRotation) * m_driveDirection));
     }

     /**
      * This method toggles the active driving direction of the robot.
      */
      public void toggleDirection()
      {
         // Set the drive direction to the negative of itself.
         // (just 1 to -1 or -1 to 1)
         m_driveDirection = -1 * m_driveDirection;
      }

     /**
      * Stops the motors on the drivetrain
      */
     public void stop()
     {
        // Stop the drivetrain.
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
        switch(motorID)
        {
           case RobotMap.Drivetrain.DriveMotor.LEFT_FRONT_MOTOR : return leftFrontEncoder;

           case RobotMap.Drivetrain.DriveMotor.RIGHT_FRONT_MOTOR : return rightFrontEncoder;

           case RobotMap.Drivetrain.DriveMotor.LEFT_REAR_MOTOR : return leftRearEncoder;

           case RobotMap.Drivetrain.DriveMotor.RIGHT_REAR_MOTOR : return rightRearEncoder;

           default : return null;

        }
     }

     
}
