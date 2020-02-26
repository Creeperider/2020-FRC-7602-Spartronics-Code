/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Hoppersubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;

public class HopperIntake extends Command {
  public HopperIntake() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Trigger: " + Robot.m_oi.trigger.get());
    System.out.println("out: " + Robot.m_oi.button3.get());
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("EXE: " + Robot.m_oi.trigger.get());
    System.out.println("EXE#: " + Robot.m_oi.button3.get());
// if(Robot.m_oi.stick.getTrigger()){
      Hoppersubsystem.HopperIn.set(ControlMode.PercentOutput, -.60);
  //  } else {
       
 //   }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !Robot.m_oi.Hout.get();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("End: " + Robot.m_oi.trigger.get());
    System.out.println("End#: " + Robot.m_oi.button3.get());
    Hoppersubsystem.HopperIn.set(ControlMode.PercentOutput, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
