/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot;

import com.stuypulse.frc.robot.commands.DrivetrainDriveCommand;
import com.stuypulse.frc.robot.autons.DoNothingAuton;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.stuylib.input.Gamepad;
import com.stuypulse.stuylib.input.gamepads.PS4;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // auton chooser
    private static final SendableChooser<Command> AUTON_CHOOSER = new SendableChooser<>();

    // The robot's subsystems and commands are defined here...
    private final Gamepad gamepad;
    private final Drivetrain drivetrain;

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        gamepad = new PS4(Constants.GAMEPAD_PORT);
        drivetrain = new Drivetrain();

        // configure default commands
        configureDefaultCommands();

        // Configure the button bindings
        configureButtonBindings();

        // set up auton chooser
        configureAutons();
    }

    private void configureDefaultCommands() {
        drivetrain.setDefaultCommand(new DrivetrainDriveCommand(drivetrain, gamepad));
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {

    }

    private void configureAutons() {
        AUTON_CHOOSER.addOption("Do Nothing", new DoNothingAuton());
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return AUTON_CHOOSER.getSelected();
    }
}
