/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.HopperDown;
import frc.robot.commands.HopperIntake;
import frc.robot.commands.HopperOut;
import frc.robot.commands.HopperUp;
import frc.robot.commands.PositionButton;
import frc.robot.commands.PrepClimberCommand;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.HopperPos;
import frc.robot.subsystems.Hoppersubsystem;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  public static DriveSubsystem drivesubsystem = new DriveSubsystem();
  public static Hoppersubsystem hoppersubsystem = new Hoppersubsystem();
  public static HopperPos Hopperpos = new HopperPos();
  public static OI m_oi;

  Command m_autonomousCommand;
  Command m_AutonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    SmartDashboard.putData("Auto mode", m_chooser);
    Robot.m_oi.trigger.whenPressed(new HopperIntake());
    Robot.m_oi.button3.whileHeld(new HopperOut());
    Robot.m_oi.button8.whileHeld(new HopperUp());
    Robot.m_oi.button7.whileHeld(new HopperDown());
   // Robot.m_oi.button11.whenPressed(new PositionButton());

    // Buttons 10 & 12 are used for the climber.  Button 12 can ONLY be used
    // when the climber lock is disengaged.
    Robot.m_oi.button10.whileHeld(new ClimbCommand(climberSubsystem));
    Robot.m_oi.button12.whileHeld(new PrepClimberCommand(climberSubsystem));

    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setDouble(1);
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setDouble(1);
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("stream").setDouble(0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when 
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();
    
      String autoSelected = SmartDashboard.getString("Auto mode",
      "Drive"); switch(autoSelected) { case "My Auto": m_autonomousCommand
      = new AutonomousCommand(); break; case "Default Auto": default:
      m_AutonomousCommand = new AutonomousCommand(); break; }
     

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    HopperPos.encoder.setPosition(0);
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    System.out.println("encoder " + HopperPos.encoder.getPosition());
    Scheduler.getInstance().run();

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
