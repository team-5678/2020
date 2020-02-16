/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A command to change the speed of the robot
 * 
 */
public class SpeedChange extends CommandBase
{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    
    private final double speed;
    private final Drivetrain m_drivetrain;

    /**
     * Inits our command for changing the speed
     *
     * @param drivetrain imports the drivetrain subsystem
     * @param speed imports the new speed that the drive train should drive at
     */

    public SpeedChange(Drivetrain driveTrain, double speed)
    {
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(driveTrain);
        this.speed = speed;
        this.m_drivetrain = driveTrain;
    }

    @Override
    public void initialize()
    {
        m_drivetrain.setSpeed(this.speed);

    }

    /*/ Sets the speed varible to the drive train subsystem
    @Override
    public void execute()
    {
        m_drivetrain.setSpeed(this.speed);
    }
*/
    @Override
    public void end(boolean interrupted)
    {
        System.out.println("\nSpeed Command Ended\n");
    }
    
    // Returns true when the command should end.
    @Override
    public boolean isFinished()
    {
        return true;
    }
}
