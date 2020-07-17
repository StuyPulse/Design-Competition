/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot;

import com.stuypulse.frc.robot.commands.AcquireBallsCommand;
import com.stuypulse.frc.robot.commands.ClimberClimbCommand;
import com.stuypulse.frc.robot.commands.DeacquireBallsCommand;
import com.stuypulse.frc.robot.commands.DrivetrainAlignmentCommand;
import com.stuypulse.frc.robot.commands.DrivetrainDriveCommand;
import com.stuypulse.frc.robot.commands.DrivetrainSetHighGearCommand;
import com.stuypulse.frc.robot.commands.DrivetrainSetLowGearCommand;
import com.stuypulse.frc.robot.commands.ShooterShootCommand;
import com.stuypulse.frc.robot.commands.SpinnerSpinWheelCommand;
import com.stuypulse.frc.robot.commands.autons.routines.DoNothingAutonCommand;
import com.stuypulse.frc.robot.commands.autons.routines.SixBallThreeTrenchAutonCommand;
import com.stuypulse.frc.robot.subsystems.Chimney;
import com.stuypulse.frc.robot.subsystems.Climber;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Intake;
import com.stuypulse.frc.robot.subsystems.Shooter;
import com.stuypulse.frc.robot.subsystems.Spinner;
import com.stuypulse.stuylib.input.gamepads.Logitech;
import com.stuypulse.stuylib.input.gamepads.PS4;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private SendableChooser<Command> chooser;

  private PS4 driverGamepad;
  private Logitech.XMode operatorGamepad; 

  private Drivetrain drivetrain;
  private Intake intake;  
  private Chimney chimney;
  private Shooter shooter; 
  private Spinner spinner; 
  private Climber climber;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    driverGamepad = new PS4(Constants.Gamepads.DRIVER);
    operatorGamepad = new Logitech.XMode(Constants.Gamepads.OPERATOR);
  
    drivetrain = new Drivetrain();
    intake = new Intake(); 
    chimney = new Chimney();
    shooter = new Shooter();
    spinner = new Spinner(); 
    climber = new Climber();
    
    drivetrain.setDefaultCommand(
      new DrivetrainDriveCommand(drivetrain, driverGamepad)
    ); 
    shooter.setDefaultCommand(
      new ShooterShootCommand(shooter, chimney, operatorGamepad)
    );
    spinner.setDefaultCommand(
      new SpinnerSpinWheelCommand(spinner, operatorGamepad)
    );
    climber.setDefaultCommand(
      new ClimberClimbCommand(climber, operatorGamepad)
    );

    configureButtonBindings();
    addAutons(); 
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driverGamepad.getRightButton().whenPressed(
      new DrivetrainSetHighGearCommand(drivetrain)
    ); 
    driverGamepad.getBottomButton().whenPressed(
      new DrivetrainSetLowGearCommand(drivetrain)
    );

    operatorGamepad.getLeftBumper().whileHeld(
      new DeacquireBallsCommand(intake, chimney)
    ); 
    operatorGamepad.getRightBumper().whileHeld(
      new AcquireBallsCommand(intake, chimney)
    ); 
    operatorGamepad.getRightButton().whileHeld(
      new DrivetrainAlignmentCommand(drivetrain)
    ); 
  }

  private void addAutons() {
    chooser = new SendableChooser<>(); 
    chooser.setDefaultOption("Do Nothing", new DoNothingAutonCommand());
    chooser.addOption(
      "Six Ball Three Trench", 
      new SixBallThreeTrenchAutonCommand(drivetrain, intake, chimney, shooter)
    );

    SmartDashboard.putData("Autonomous", chooser);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return chooser.getSelected(); 
  }
}
