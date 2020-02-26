package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.ClimberSubsystem;

/**
 * Run the climber motor to climb.  This actually will unwind the strap initially
 * while springs raise up the hook; once the strap is fully extended it will then
 * start winding in the strap to climb. 
 */
public class ClimbCommand extends Command {

  private ClimberSubsystem subsystem;

  public ClimbCommand(ClimberSubsystem subsystem) {
      this.subsystem = subsystem;
  }

  @Override
  protected void execute() {
    System.out.println("CLIMBING!");
    subsystem.climber.set(.6);
  }

  /**
   * This doesn't matter since this is a whenHeld
   */
  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
    subsystem.climber.set(0);
  }
}
