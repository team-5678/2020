/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A command to be ran during autonomous (Currently blank)
 */
public class Autonomous extends CommandBase
{
    private Shooter m_shooter;
    private Drivetrain m_drive;
    private Timer m_timer;
    private boolean m_finished;
    private boolean m_driving;
    private boolean m_new = true;

    /**
     * Creates a new instance of our autonomous command.
     */
    public Autonomous(Shooter shooter, Drivetrain drivetrain)
    {
        // Add our requirements.
        addRequirements(shooter, drivetrain);

        // Set our shooter and drivetrain.  
        m_shooter = shooter;
        m_drive = drivetrain;
    }

    /**
     * Initializes the autonomous command.
     */
    @Override
    public void initialize()
    {
        // Initialize our timer.
        m_timer = new Timer();
    }

    /**
     * Runs the functions necessary for autonomous.
     */
    @Override
    public void execute()
    {
        if (m_new)
        {
            // We are just starting autonomous, so let's begin by driving forward
            // at quarter speed for 3 seconds.
            m_driving = true;

            // Start the timer.
            m_timer.start();

            // We are no longer new.
            m_new = false;
        }

        if (m_driving)
        {
            // Drive forward at quarter speed.
            m_drive.arcadeDrive(RobotMap.Drivetrain.DriveSpeeds.HALF_SPEED, 0.0);
        }
        else
        {
            m_shooter.shoot();
        }

        // If 3 seconds have elapsed while we are driving, stop driving and shoot.
        if (m_timer.hasElapsed(3.0))
        {
            // Don't drive anymore.
            m_driving = false;
        }
        
        // If 5 seconds have elapsed, stop shooting and finish autonomous.
        if (m_timer.hasElapsed(5.0))
        {
            // Stop the timer.
            m_timer.stop();

            // Set finished to true.
            m_finished = true;
        }
    }

    /**
     * Ends the autonomous command and stops any active subsystems.
     */
    @Override
    public void end(boolean interrupted)
    {
        // Stop the shooter and drivetrain.
        m_shooter.stop();
        m_drive.stop(); 
    }

    /**
     * Returns true when autonomous is completed.
     */
    @Override
    public boolean isFinished()
    {
        return m_finished;
    }
}