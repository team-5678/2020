/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A command to be ran during autonomous (Currently blank)
 */
public class Autonomous extends CommandBase
{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    /**
     * Creates a new instance of our autonomous command.
     */
    public Autonomous()
    {
        addRequirements();
    }

    // Prints to the console that the command has started
    @Override
    public void initialize()
    {
        System.out.println("Autonomous is running!\n");
    }

    
    @Override
    public void execute()
    {
    }

    // Prints to the console that the command has stopped
    @Override
    public void end(boolean interrupted)
    {
        System.out.println("Autonomous has stopped!\n");
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
