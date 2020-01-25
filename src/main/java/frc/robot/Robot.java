/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The Robot class is the main management class of the robot.
 * The VM automatically instantiates this class and calls the necessary overridden methods.
 */
public class Robot extends TimedRobot
{
    private Command m_autonomousCommand;
    private RobotContainer m_robotContainer;

    /**
     * This method is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit()
    {
        // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
        // autonomous chooser on the dashboard.
        m_robotContainer = new RobotContainer(this);
    }

    /**
     * This method is automatically ran periodically to invoke the scheduler to run periodic commands
     * and subsystem periodic methods.
     */
    @Override
    public void robotPeriodic()
    {
        // Runs the CommandScheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.
        CommandScheduler.getInstance().run();
    }

    /**
     * This method is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit()
    {
    }

    /**
     * This method is called periodically during Disabled mode.
     */
    @Override
    public void disabledPeriodic()
    {
    }

    /**
     * This autonomous runs our robot container's autonomous command.
     */
    @Override
    public void autonomousInit()
    {
        m_autonomousCommand = m_robotContainer.getAutonomousCommand();

        // Schedule the autonomous command (example).
        if (m_autonomousCommand != null)
        {
            m_autonomousCommand.schedule();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic()
    {
    }

    /**
     * This method is called whenever the robot enters Teleop mode.
     */
    @Override
    public void teleopInit()
    {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (m_autonomousCommand != null)
        {
            m_autonomousCommand.cancel();
        }

        // Call our container.
        m_robotContainer.teleopInit();
    }

    /**
     * This method is called periodically during operator/driver control.
     */
    @Override
    public void teleopPeriodic()
    {
    }

    @Override
    public void testInit()
    {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This method is called periodically during test mode.
     */
    @Override
    public void testPeriodic()
    {
    }
}
