package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The Limelight subsystem is in charge of the visual-processing for the robot, primarily important for autonomous operation.
 */
public class Limelight extends SubsystemBase
{
    // The Limelight constructor initializes the subsystem.
    public Limelight()
    {
        // First off, let's get our network table.
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

        // Now, we want to enable the camera.
        table.getEntry("camMode").setNumber(1);

        // Also, we don't want the LED at all.
        table.getEntry("ledMode").setNumber(1);
        
        // Finally, make sure we are in "split" mode so we can see everything.
        table.getEntry("stream").setNumber(0);

        // Display camera stream to ShuffleBoard
        //SmartDashboard.putNumber("Camera", NetworkTableInstance.getDefault().getTable("limelight"));

    }
}