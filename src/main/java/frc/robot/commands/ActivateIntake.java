/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

/**
 * An example command that uses an example subsystem.
 */
public class ActivateIntake extends CommandBase
{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Intake m_intake;

    /**
     * Creates an Actvating Intake commmand instance.
     *
     * @param subsystem The subsystem used by this command.
     */
    public ActivateIntake(Intake intake)
    {
        m_intake = intake;
        addRequirements(intake);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize()
    {
        m_intake.intakeBall();
        System.out.println("\nIntake has been activated\n");
    }


    // Stops the motors when the command is interrupted (when the button isn't held down).
    @Override
    public void end(boolean interrupted)
    {
        m_intake.stop();
        System.out.println("\nActivate Intake has ended\n");
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished()
    {
        return true;
    }
}
