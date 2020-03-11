/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Climber;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * The RetractClimber command operates the climb retraction function of the robot.
 */
public class RetractClimber extends CommandBase
{
    private Climber m_climber;

    /**
     * Creates a new instance of our retraction command.
     */
    public RetractClimber(Climber climber)
    {
        addRequirements(climber);
        m_climber = climber;
    }

    /**
     * Initializes the retraction command.
     */
    @Override
    public void initialize()
    {
    }

    /**
     * Runs the climb motor in reverse speed periodically until the command is finished.
     */
    @Override
    public void execute()
    {
        // Retract the climber.
        m_climber.retract();
    }

    /**
     * Stops the retraction once the command has been interrupted or has ended.
     */
    @Override
    public void end(boolean interrupted)
    {
        // Stop the climber.
        m_climber.stop();
    }

    /**
     * Returns true when the command is finished running.
     */
    @Override
    public boolean isFinished()
    {
        return false;
    }
}