/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * The DriveCommand is executed periodically to drive the robot.
 */
public class DriveCommand extends CommandBase
{
    private final Drivetrain m_driveTrain;

    /**
     * Instantiates a new DriveCommand.
     *
     * @param driveTrain The Drivetrain subsystem used by this command.
     */
    public DriveCommand(Drivetrain driveTrain)
    {
        // Store our drive train.
        m_driveTrain = driveTrain;

        // Declare subsystem dependencies.
        addRequirements(driveTrain);
    }

    /**
     * Called when the command is initially scheduled.
     */
    @Override
    public void initialize()
    {
    }

    /**
     * Called every time the scheduler runs while the command is scheduled.
     */
    @Override
    public void execute()
    {
        // Make sure we aren't executing if we're done.
        if (isFinished())
        {
            return;
        }

        // Use the current values of our joystick to arcade drive.
        m_driveTrain.m_drive.arcadeDrive(m_driveTrain.m_container.m_joystick.getX(), m_driveTrain.m_container.m_joystick.getY());
    }

    /**
     * Called once the command has ended or was interrupted.
     */
    @Override
    public void end(boolean interrupted)
    {
    }

    /**
     * Returns true when the command has ended.
     */
    @Override
    public boolean isFinished()
    {
        if (m_driveTrain.m_container.flag(RobotMap.RobotModes.TELEOP))
        {
            return true;
        }

        return false;
    }
}
