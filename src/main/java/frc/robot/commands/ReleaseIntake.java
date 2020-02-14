/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

/**
 * Command that releases the a ball from the intake
 */
public class ReleaseIntake extends CommandBase
{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Intake m_intake;

    /**
     * Creates our command instance.
     *
     * @param intake The intake used by this command.
     */
    public ReleaseIntake(Intake intake)
    {
        m_intake = intake;
        addRequirements(intake);
    }

    // Is ran once on activation. Releases from the intake.
    @Override
    public void initialize()
    {
        m_intake.releaseBall();
    }

    // Called every time the scheduler runs while the command is scheduled. (default and empty, not needed in this command)
    @Override
    public void execute()
    {
         
    }

    // Stops the motors when the command is interrupted (when the button isn't held down).
    @Override
    public void end(boolean interrupted)
    {
        m_intake.stop();
    }

    // Returns true when the command should end. (default)
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
