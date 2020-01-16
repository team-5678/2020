/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * RobotContainer represents the class which handles subsystems & commands for the robot.
 * Main functions of the robot should be handled here.
 */
public class RobotContainer
{
    private final Drivetrain m_driveTrain = new Drivetrain();
    private final ExampleCommand m_autoCommand = new ExampleCommand(m_driveTrain);

    /**
     * Instantiates the RobotContainer instances and sets up some of the functions of the robot.
     */
    public RobotContainer()
    {
        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * This method defines button->command mappings for the physical joystick.
     */
    private void configureButtonBindings()
    {
    }

    /**
     * This method handles the periodic functions of the robot. Currently, all this does is invoke the drive train.
     */
    public void periodic()
    {
        // Call the drive train's periodic method.
        m_driveTrain.periodic();
    }

    /**
     * This method returns the main autonomous command.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        // An ExampleCommand will run in autonomous.
        return m_autoCommand;
    }
}
