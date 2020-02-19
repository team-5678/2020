/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;


/**
 * The DriverStation class is the subsystem which sets up the driver station of the robot.
 */
public class DriverStation extends SubsystemBase
{
  private Joystick m_joystick;
  /**
   * Instantiates a DriverStation instance.
   */
  public DriverStation()
  {
    m_joystick = new Joystick(RobotMap.Joystick.PORT);
  }

  /**
   * Gets our joystick's current X axis position
   * @return X axis position
   */
  public double getXaxis()
  {
    return m_joystick.getX();
  }

  /**
   * Gets our joystick's Y axis position
   * @return Y axis position
   */
  public double getYaxis()
  {
    return m_joystick.getY();
  }

  /**
   * Binds a button number as a joystick button object. Can be used to bind a command to a certain button.
   * @return joystick button instance
   */
  public JoystickButton getJoystickButton(int button)
  {
    return new JoystickButton(m_joystick, button);
  }

  public POVButton getPOVButton(int povAngle)
  {
    return new POVButton(m_joystick, povAngle);
  }

  public Joystick getJoystick()
  {
    return m_joystick;
  }
}


