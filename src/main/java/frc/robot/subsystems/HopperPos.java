/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;

/**
 * Add your docs here.
 */
public class HopperPos extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

public static CANSparkMax HopperPost;
public static CANEncoder encoder;



public HopperPos() {
  HopperPost = new CANSparkMax(RobotMap.HopperPost, MotorType.kBrushless);
   encoder = HopperPost.getEncoder();
encoder.setPosition(0);


  HopperPost.setInverted(true);
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
