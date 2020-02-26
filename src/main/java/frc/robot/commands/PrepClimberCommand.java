package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.ClimberSubsystem;

/**
 * Run the climber BACKWARDS to prepare for a match.  This is necessary to get the
 * strap wound correctly and springs extended.
 */
public class PrepClimberCommand extends Command {

  private ClimberSubsystem subsystem;

  public PrepClimberCommand(ClimberSubsystem subsystem) {
      this.subsystem = subsystem;
  }

  @Override
  protected void execute() {
    System.out.println("PREP'ING to CLIMB!");
    subsystem.climber.set(-.4);
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
