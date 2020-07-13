/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.commands.ClimberClimbDownCommand;
import com.stuypulse.frc.robot.commands.ClimberClimbUpCommand;
import com.stuypulse.frc.robot.commands.DrivetrainDriveCommand;
import com.stuypulse.frc.robot.commands.FeederFeedCommand;
import com.stuypulse.frc.robot.commands.FeederReverseCommand;
import com.stuypulse.frc.robot.commands.IntakeAcquireCommand;
import com.stuypulse.frc.robot.commands.IntakeDeacquireCommand;
import com.stuypulse.frc.robot.commands.IntakeExtendCommand;
import com.stuypulse.frc.robot.commands.IntakeRetractCommand;
import com.stuypulse.frc.robot.commands.ShooterShootCommand;
import com.stuypulse.frc.robot.commands.ShooterStopCommand;
import com.stuypulse.frc.robot.subsystems.Climber;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Intake;
import com.stuypulse.frc.robot.subsystems.Shooter;
import com.stuypulse.stuylib.input.gamepads.PS4;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Climber climber = new Climber();
  private final Drivetrain drivetrain = new Drivetrain();
  private final Intake intake = new Intake();
  private final Shooter shooter = new Shooter();

  private final PS4 driver = new PS4(Constants.Gamepad.DRIVER_PORT);
  private final PS4 operator = new PS4(Constants.Gamepad.OPERATOR_PORT);
  private static SendableChooser<Command> autonChooser = new SendableChooser<>();

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

    // Shooter Controls
    operator.getRightTriggerButton().whileHeld(new ShooterShootCommand(shooter));
    operator.getLeftTriggerButton().whileHeld(new ShooterStopCommand(shooter));
    operator.getDPadRight().whenPressed(new FeederFeedCommand(shooter));
    operator.getDPadLeft().whenPressed(new FeederReverseCommand(shooter));

    // Intake Controls
    operator.getTopButton().toggleWhenPressed(new IntakeExtendCommand(intake));
    operator.getBottomButton().toggleWhenPressed(new IntakeRetractCommand(intake));
    operator.getRightButton().whileHeld(new IntakeAcquireCommand(intake));
    operator.getLeftButton().whileHeld(new IntakeDeacquireCommand(intake));

    // Climber Controls
    operator.getDPadUp().toggleWhenPressed(new ClimberClimbUpCommand(climber));
    operator.getDPadDown().toggleWhenPressed(new ClimberClimbDownCommand(climber));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return autonChooser.getSelected();
  }

}
