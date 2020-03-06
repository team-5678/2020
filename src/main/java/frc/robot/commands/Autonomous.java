/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A command to be ran during autonomous (Currently blank)
 */
public class Autonomous extends CommandBase
{
    private Shooter m_shooter;
    private Drivetrain m_drive;
    private double m_autoMode;
    private boolean m_finished;
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    /**
     * Creates a new instance of our autonomous command.
     */
    public Autonomous(Shooter shooter, Drivetrain drivetrain)
    {
        addRequirements(shooter, drivetrain);
        m_shooter = shooter;
        m_drive = drivetrain;
    }

    // Prints to the console that the command has started
    @Override
    public void initialize()
    {
        // This gets the autonomous mode from SmartDashboard.
        // 0 = do nothing, 1 = drive, 2 = shoot.
        m_autoMode = SmartDashboard.getNumber("Auto Mode", 0.0);
    }

    
    @Override
    public void execute()
    {
        if (m_autoMode == 1)
        {
            // Drive forward at quarter speed.
            m_drive.arcadeDrive(RobotMap.Drivetrain.DriveSpeeds.QUARTER_SPEED, 0.0);
        }
        else if (m_autoMode == 2)
        {
            // Run the shooter.
            m_shooter.shoot();
        }

        // Stop executing.
        m_finished = true;
    }

    // Prints to the console that the command has stopped
    @Override
    public void end(boolean interrupted)
    {
        System.out.println("Autonomous has stopped!\n");
        m_shooter.stop();
        m_drive.stop(); 
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished()
    {
        return m_finished;
    }
}
