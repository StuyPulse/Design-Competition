/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot;

import com.stuypulse.frc.robot.Constants.Ports;
import com.stuypulse.frc.robot.commands.ClimberClimbCommand;
import com.stuypulse.frc.robot.commands.ConveyorConveyCommand;
import com.stuypulse.frc.robot.commands.DrivetrainDriveCommand;
import com.stuypulse.frc.robot.commands.DrivetrainHighGearCommand;
import com.stuypulse.frc.robot.commands.DrivetrainLowGearCommand;
import com.stuypulse.frc.robot.commands.IndexerRotateCommand;
import com.stuypulse.frc.robot.commands.IntakeAcquireCommand;
import com.stuypulse.frc.robot.commands.IntakeDeacquireCommand;
import com.stuypulse.frc.robot.commands.IntakeExtendCommand;
import com.stuypulse.frc.robot.commands.IntakeRetractCommand;
import com.stuypulse.frc.robot.commands.ShooterFeedCommand;
import com.stuypulse.frc.robot.commands.ShooterShootCommand;
import com.stuypulse.frc.robot.commands.autons.DoNothingAutonCommand;
import com.stuypulse.frc.robot.subsystems.Climber;
import com.stuypulse.frc.robot.subsystems.Conveyor;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Indexer;
import com.stuypulse.frc.robot.subsystems.Intake;
import com.stuypulse.frc.robot.subsystems.Shooter;
import com.stuypulse.stuylib.input.WPIGamepad;
import com.stuypulse.stuylib.input.gamepads.Logitech;
import com.stuypulse.stuylib.input.gamepads.PS4;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Climber climber = new Climber();
  private final Conveyor conveyor = new Conveyor();
  private final Drivetrain drivetrain = new Drivetrain();
  private final Indexer indexer = new Indexer();
  private final Intake intake = new Intake();
  private final Shooter shooter = new Shooter();

  private final Command doNothingAutonCommand = new DoNothingAutonCommand();

  private final PS4 driver = new PS4(Ports.Gamepad.DRIVER);
  private final Logitech.XMode operator = new Logitech.XMode(Ports.Gamepad.OPERATOR);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    drivetrain.setDefaultCommand(new DrivetrainDriveCommand(drivetrain, driver));

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driver.getTopButton().whenPressed(new DrivetrainHighGearCommand(drivetrain));
    driver.getBottomButton().whenPressed(new DrivetrainLowGearCommand(drivetrain));

    operator.getTopButton().whenPressed(new ClimberClimbCommand(climber));
    operator.getLeftButton().toggleWhenPressed(new ConveyorConveyCommand(conveyor));
    operator.getRightButton().whileHeld(new IntakeAcquireCommand(intake));
    operator.getBottomButton().whileHeld(new IntakeDeacquireCommand(intake));
    operator.getOptionButton().toggleWhenPressed(new IndexerRotateCommand(indexer));
    operator.getRightTriggerButton().whileHeld(new ShooterShootCommand(shooter));
    operator.getLeftTriggerButton().whileHeld(new ShooterFeedCommand(shooter));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return doNothingAutonCommand;
  }

  public Drivetrain getDrivetrain() {
    return drivetrain;
  }

  public Climber getClimber() {
    return climber;
  }

  public Conveyor getConveyor() {
    return conveyor;
  }

  public Indexer getIndexer() {
    return indexer;
  }

  public Intake getIntake() {
    return intake;
  }

  public Shooter getShooter() {
    return shooter;
  }
}
