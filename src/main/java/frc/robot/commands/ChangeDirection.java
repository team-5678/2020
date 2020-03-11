/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

/**
 * The ChangeDirection command changes the active driving direction of the robot.
 */
public class ChangeDirection extends CommandBase
{
    private final Drivetrain m_driveTrain;

    /**
     * Creates our ChangeDirection instance.
     *
     * @param driveTrain The drive train used by this command.
     */
    public ChangeDirection(Drivetrain driveTrain)
    {
        m_driveTrain = driveTrain;
        addRequirements(driveTrain);
    }

    /**
     * Changes the direction on the drivetrain.
     */
    @Override
    public void execute()
    {
        // Toggle the direction on the drivetrain.
        m_driveTrain.toggleDirection();
    }

    /**
     * Ends the command.
     */
    @Override
    public void end(boolean interrupted)
    {
    }

    /**
     * Returns true when the command is completed.
     */
    @Override
    public boolean isFinished()
    {
        return false;
    }
}