package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * The Climber only consists of a Neo motor / SparkMax motor controller.
 */
public class ClimberSubsystem extends Subsystem {

  public CANSparkMax climber;

  public ClimberSubsystem() {
    climber = new CANSparkMax(RobotMap.CLIMBER, MotorType.kBrushless);
    climber.setInverted(true);
  }

  @Override
  protected void initDefaultCommand() {
    // noop
  }
}
