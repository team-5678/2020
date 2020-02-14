/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.DriverStation;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A command to drive the robot during teleop
 * 
 */
public class Drive extends CommandBase
{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Drivetrain m_drivetrain;
    private final DriverStation m_driverstation;

    /**
     * Inits our command for the drive train
     *
     * @param drivetrain the drive train sub system
     * @param driverstation the driverstation sub system that includes the joystick
     */
    public Drive(Drivetrain drivetrain, DriverStation driverstation)
    {
        m_drivetrain = drivetrain;
        m_driverstation = driverstation;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(drivetrain, driverstation);
    
    }

    // Called when the command is initially scheduled. (Not used for this command)
    @Override
    public void initialize()
    {
    }

    // Drives using the joystick the robot while the command is running
    @Override
    public void execute()
    {
        m_drivetrain.arcadeDrive(m_driverstation.getYaxis(), m_driverstation.getXaxis());
    }

    // Stops the drive train
    @Override
    public void end(boolean interrupted)
    {
        m_drivetrain.stop();
    }

    // Returns true when the command should end. (Command never ends)
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
