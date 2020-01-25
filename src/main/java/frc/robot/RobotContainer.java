/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.subsystems.Drivetrain;

import java.util.Set;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * RobotContainer represents the class which handles subsystems & commands for the robot.
 * Main functions of the robot should be handled here.
 */
public class RobotContainer
{
    private Robot m_robot;
    public Joystick m_joystick;
    private final Drivetrain m_driveTrain = new Drivetrain(this);
    private Set<SubsystemBase> m_subsystems;

    /**
     * Instantiates the RobotContainer instances and sets up some of the functions of the robot.
     */
    public RobotContainer(Robot robot)
    {
        // Store the robot.
        m_robot = robot;

        // Initialize our joystick configuration.
        initializeJoystick();

        // Throw each of our subsystems into our set.
        m_subsystems.add(m_driveTrain);
    }

    /**
     * This method sets up the joystick & defines button->command mappings.
     */
    private void initializeJoystick()
    {
        // Instantiate the joystick.
        m_joystick = new Joystick(RobotMap.JOYSTICK);
    }

    /**
     * This method sets each subsystem up for teleop mode.
     * This calls each subsystem to schedule commands.
     */
    public void teleopInit()
    {
        // Call each subsystem to manage their command scheduling.
        for (SubsystemBase subsystem : m_subsystems)
        {
            subsystem.register();
        }
    }

    /**
     * This method indicates if a command should stop based on the expected mode.
     * @return whether to stop or not
     */
    public boolean flag(RobotMap.RobotModes mode)
    {
        if (mode == RobotMap.RobotModes.AUTONOMOUS && !m_robot.isAutonomous())
        {
            return true;
        }
        else if (mode == RobotMap.RobotModes.DISABLED && !m_robot.isDisabled())
        {
            return true;
        }
        else if (mode == RobotMap.RobotModes.TELEOP && !m_robot.isOperatorControl())
        {
            return true;
        }
        else if (mode == RobotMap.RobotModes.TEST && !m_robot.isTest())
        {
            return true;
        }

        return false;
    }

    /**
     * This method returns the main autonomous command.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand()
    {
        // There is currently no autonomous command.
        return null;
    }
}
