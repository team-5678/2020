/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/**
 * A command to shoot the ball out of the robot
 */
public class ShootBall extends CommandBase
{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    private Shooter m_shooter;
    private Intake m_intake;

    /**
     * Creates a new instance of our ball shooter command.
     * @param shooter use the shooter subsystem
     */
    public ShootBall(Shooter shooter, Intake intake)
    {
        addRequirements(shooter, intake);
        m_shooter = shooter;
        m_intake = intake;
    }

    // Runs the motors to shoot the ball, to be called by a button trigger
    @Override
    public void execute()
    {
        m_shooter.shoot();
        m_intake.intakeBall();
        System.out.println("Shooter and intake have ran!\n");
    }



    // Stops the motors when the command ends
    @Override
    public void end(boolean interrupted)
    {
        m_shooter.stop();
        m_intake.stop();
        System.out.println("Shooter and intake have stopped!\n");
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
