/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
// Sub system imports
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.DriverStation;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Limelight;

// Command imports
import frc.robot.commands.ActivateIntake;
import frc.robot.commands.ReleaseIntake;
import frc.robot.commands.SpeedChange;
import frc.robot.commands.Autonomous;
import frc.robot.commands.Drive;
import frc.robot.commands.ShootBall;

/**
 * RobotContainer represents the class which handles subsystems & commands for the robot.
 * Main functions of the robot should be handled here.
 */
public class RobotContainer
{
    // sub system inits
    private final Drivetrain m_driveTrain = new Drivetrain();
    private final Intake m_intake = new Intake();
    private final DriverStation m_drivestation = new DriverStation();
    private final Shooter m_shooter = new Shooter();
    private final Limelight m_limelight = new Limelight();

    // Command inits
    private final Drive m_drive = new Drive(m_driveTrain, m_drivestation);
    private final Autonomous m_autoCommand = new Autonomous();


    /**
     * Instantiates the RobotContainer instances and sets up some of the functions of the robot.
     */
    public RobotContainer()
    {
        // Configure the button bindings
        configureButtonBindings();
        CommandScheduler.getInstance().setDefaultCommand(m_driveTrain, m_drive); // sets drive to always be running in the scheduler 

    }

    /**
     * This function runs and initializes commands when a certain button is pressed
     */
    private void configureButtonBindings()
    {
        // Intake triggers button triggers
        m_drivestation.getPOVButton(RobotMap.Joystick.Buttons.INTAKE_BUTTON).whileHeld(new ActivateIntake(m_intake));
        m_drivestation.getPOVButton(RobotMap.Joystick.Buttons.REVERSE_BUTTON).whileHeld(new ReleaseIntake(m_intake));

        // Drive speed change button triggers
        //m_drivestation.getJoystickButton(RobotMap.Joystick.Buttons.QUARTER_SPEED_BUTTON).whenPressed(new SpeedChange(m_driveTrain, RobotMap.Drivetrain.DriveSpeeds.QUARTER_SPEED));
        m_drivestation.getJoystickButton(RobotMap.Joystick.Buttons.HALF_SPEED_BUTTON).whenPressed(new SpeedChange(m_driveTrain, RobotMap.Drivetrain.DriveSpeeds.HALF_SPEED));
        m_drivestation.getJoystickButton(RobotMap.Joystick.Buttons.THREE_FOURTHS_SPEED_BUTTON).whenPressed(new SpeedChange(m_driveTrain, RobotMap.Drivetrain.DriveSpeeds.THREE_FOURTHS_SPEED));
        m_drivestation.getJoystickButton(RobotMap.Joystick.Buttons.FULL_SPEED_BUTTON).whenPressed(new SpeedChange(m_driveTrain, RobotMap.Drivetrain.DriveSpeeds.FULL_SPEED));

        // Shooter triggers
        m_drivestation.getJoystickButton(RobotMap.Joystick.Buttons.SHOOT_BUTTON).whileHeld(new ShootBall(m_shooter, m_intake));
    }

    /**
     * This method handles the periodic functions of the robot. 
     */
    public void periodic()
    {
    
    }

    /**
     * Returns the command that wil be ran during autonomous
     * @return autonomous command
     */

   public Command getAutonomousCommand()
    {
        // An example command will run in autonomous.
        return m_autoCommand;
    } 
    
    /** Holding on to this return command just in case we need it
     * 
     * Returns the command that will be ran during the teleop period
     * @return teleop command
     *
    public Command getTeleOpCommand()
    {
        return m_drive;
    } */
}
