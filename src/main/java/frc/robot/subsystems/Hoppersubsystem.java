/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
/**
 * Add your docs here.
 */
public class Hoppersubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static VictorSPX HopperIn;

public Hoppersubsystem() {
  HopperIn = new VictorSPX(RobotMap.HopperIn);

  HopperIn.setInverted(true);

}

//public void 
  @Override
  public void initDefaultCommand() {
   /* System.out.println("Trigger: " + Robot.m_oi.trigger.whenPressed());
    {
      if(Robot.m_oi.stick.getTrigger()){
        trigger.whenPressed(());
     } else {
       VictorSPX.set(ControlMode.PercentOutput, 0); 
     }*/

    //HopperIn.set(ControlMode.)
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
