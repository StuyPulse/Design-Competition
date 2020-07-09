/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot;

import com.stuypulse.frc.robot.commands.ClimberClimbCommand;
import com.stuypulse.frc.robot.commands.DrivetrainDriveCommand;
import com.stuypulse.frc.robot.commands.DrivetrainSetHighGearCommand;
import com.stuypulse.frc.robot.commands.DrivetrainSetLowGearCommand;
import com.stuypulse.frc.robot.commands.IntakeAcquireCommand;
import com.stuypulse.frc.robot.commands.IntakeDequireCommand;
import com.stuypulse.frc.robot.commands.SpinnerSpinWheelCommand;
import com.stuypulse.frc.robot.subsystems.Climber;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Intake;
import com.stuypulse.frc.robot.subsystems.Spinner;
import com.stuypulse.stuylib.input.gamepads.Logitech;
import com.stuypulse.stuylib.input.gamepads.PS4;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private PS4 driverGamepad;
  private Logitech.XMode operatorGamepad; 

  private Drivetrain drivetrain;
  private Intake intake;  
  private Spinner spinner; 
  private Climber climber;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    driverGamepad = new PS4(Constants.Ports.Gamepads.DRIVER);
    operatorGamepad = new Logitech.XMode(Constants.Ports.Gamepads.OPERATOR);
  
    drivetrain = new Drivetrain();
    intake = new Intake(); 
    spinner = new Spinner(); 
    climber = new Climber();
    
    drivetrain.setDefaultCommand(
      new DrivetrainDriveCommand(drivetrain, driverGamepad)
    ); 
    spinner.setDefaultCommand(
      new SpinnerSpinWheelCommand(spinner, operatorGamepad)
    );
    climber.setDefaultCommand(
      new ClimberClimbCommand(climber, operatorGamepad)
    );

    configureButtonBindings();
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
      new IntakeDequireCommand(intake)
    ); 
    operatorGamepad.getRightBumper().whileHeld(
      new IntakeAcquireCommand(intake)
    ); 
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return m_autoCommand;
    return null; 
  }
}