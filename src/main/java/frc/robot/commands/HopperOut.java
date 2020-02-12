/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Hoppersubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class HopperOut extends Command {
  public HopperOut() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Hoppersubsystem.HopperIn.set(ControlMode.PercentOutput, .5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    System.out.println("Finished " + Robot.m_oi.button3.get());
    return !Robot.m_oi.button3.get();

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Hoppersubsystem.HopperIn.set(ControlMode.PercentOutput, 0);
    System.out.println("End: " + Robot.m_oi.button3.get());
  }
}