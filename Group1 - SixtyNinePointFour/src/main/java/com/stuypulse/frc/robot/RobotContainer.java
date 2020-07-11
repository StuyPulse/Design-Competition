/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot;

import com.stuypulse.frc.robot.commands.ClimberClimbCommand;
import com.stuypulse.frc.robot.commands.ConveyorConveyCommand;
import com.stuypulse.frc.robot.commands.DrivetrainHighGearCommand;
import com.stuypulse.frc.robot.commands.DrivetrainLowGearCommand;
import com.stuypulse.frc.robot.commands.IndexerRotateCommand;
import com.stuypulse.frc.robot.commands.IntakeAcquireCommand;
import com.stuypulse.frc.robot.commands.IntakeDeacquireCommand;
import com.stuypulse.frc.robot.commands.IntakeExtendCommand;
import com.stuypulse.frc.robot.commands.IntakeRetractCommand;
import com.stuypulse.frc.robot.subsystems.Climber;
import com.stuypulse.frc.robot.subsystems.Conveyor;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Indexer;
import com.stuypulse.frc.robot.subsystems.Intake;

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
  private final Climber climber = new Climber();
  private final Conveyor conveyor = new Conveyor();
  private final Drivetrain drivetrain = new Drivetrain();
  private final Indexer indexer = new Indexer();
  private final Intake intake = new Intake();
  //commands (formated as: private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);)
  private final ClimberClimbCommand climberClimbCommand = new ClimberClimbCommand(climber);
  private final ConveyorConveyCommand ConveyorConveyCommand = new ConveyorConveyCommand(conveyor);
  private final DrivetrainHighGearCommand drivetrainHighGearCommand = new DrivetrainHighGearCommand(drivetrain);
  private final DrivetrainLowGearCommand drivetrainLowGearCommand = new DrivetrainLowGearCommand(drivetrain);
  private final IndexerRotateCommand indexerRotateCommand = new IndexerRotateCommand(indexer);
  private final IntakeAcquireCommand intakeAcquireCommand = new IntakeAcquireCommand(intake);
  private final IntakeDeacquireCommand intakeDeacquireCommand = new IntakeDeacquireCommand(intake);
  private final IntakeExtendCommand intakeExtendCommand = new IntakeExtendCommand(intake);
  private final IntakeRetractCommand intakeRetractCommand = new IntakeRetractCommand(intake);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command DoNothing() {
    // An ExampleCommand will run in autonomous
    return DoNothing();
  }
  public Drivetrain getDrivetrain() {
    return drivetrain;
  }
  public Climber getClimber() {
    return climber;
  }
  public Intake getIntake() {
    return intake;
  }
  public Conveyor getConveyor() {
    return conveyor;
  }
  public Indexer getIndexer() {
    return indexer;
  }
}
