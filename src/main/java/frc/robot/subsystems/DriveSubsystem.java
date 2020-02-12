/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

private VictorSPX RightBDrive, RightFDrive;
private VictorSPX LeftBDrive, LeftFDrive;

public DriveSubsystem() {
  RightBDrive = new VictorSPX(RobotMap.RightBDrive);
  RightFDrive = new VictorSPX(RobotMap.RightFDrive);
  LeftBDrive = new VictorSPX(RobotMap.LeftBDrive);
  LeftFDrive = new VictorSPX(RobotMap.LeftFDrive);

  RightBDrive.setInverted(true);
  RightFDrive.setInverted(true);
}

public void drive(double forwardPower, double turnPower){
  System.out.println("forward:" + forwardPower + " turn:" + turnPower);
  if (Math.abs(turnPower)<.25){
    turnPower = 0;
  }
  RightBDrive.set(ControlMode.PercentOutput,forwardPower, DemandType.ArbitraryFeedForward, - turnPower);
  RightFDrive.set(ControlMode.PercentOutput,forwardPower, DemandType.ArbitraryFeedForward,  - turnPower);
  LeftBDrive.set(ControlMode.PercentOutput,forwardPower, DemandType.ArbitraryFeedForward, + turnPower);
  LeftFDrive.set(ControlMode.PercentOutput,forwardPower, DemandType.ArbitraryFeedForward, + turnPower);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
   setDefaultCommand(new DriveCommand());
  }
}
