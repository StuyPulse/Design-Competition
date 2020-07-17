/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot;

import com.stuypulse.frc.robot.commands.*;
import com.stuypulse.frc.robot.autons.*;
import com.stuypulse.frc.robot.subsystems.*;
import com.stuypulse.frc.robot.util.*;

import com.stuypulse.stuylib.input.Gamepad;
import com.stuypulse.stuylib.input.gamepads.*;

import static com.stuypulse.frc.robot.Constants.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    private final Gamepad driver;
    private final Gamepad operator;

    private final Drivetrain drivetrain;
    private final Intake intake;
    private final Climber climber;
    private final Shooter shooter;
    private final ControlPanel controlPanel;

    private final LEDController ledController;

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        driver = new PS4(DRIVER_PORT);
        operator = new PS4(OPERATOR_PORT);

        drivetrain = new Drivetrain();
        intake = new Intake();
        climber = new Climber();
        shooter = new Shooter();
        controlPanel = new ControlPanel();

        ledController = new LEDController();

        // configure default commands
        configureDefaultCommands();

        // Configure the button bindings
        configureButtonBindings();

        // set up auton chooser
        configureAutons();
    }

    protected LEDController getLEDController() {
        return ledController;
    }

    private void configureDefaultCommands() {
        drivetrain.setDefaultCommand(new DrivetrainDriveCommand(drivetrain, driver));
        shooter.setDefaultCommand(new ShooterTuneCommand(shooter));
        controlPanel.setDefaultCommand(new ControlPanelControlCommand(controlPanel, operator));
        climber.setDefaultCommand(new ClimberDefaultCommand(climber));
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        operator.getLeftButton().whileHeld(new IntakeDeacquireWhileCommand(intake));
        operator.getRightButton().whileHeld(new IntakeAcquireWhileCommand(intake));

        // idk if this works because does it end the command after it's pressed because
        // control panel rotate is not instant
        operator.getBottomButton().whenPressed(new ControlPanelRotateCommand(controlPanel, CONTROL_PANEL_ROTATIONZ));

        operator.getLeftBumper().whenPressed(new IntakeExtendCommand(intake));
        operator.getRightBumper().whenPressed(new IntakeRetractCommand(intake));

        // stop
        operator.getDPadDown().whenPressed(new ShooterStopCommand(shooter));

        // update shooter prm
        operator.getDPadUp().whenPressed(new ShooterUpdateCommand(shooter, FAR_RPM));
        operator.getDPadLeft().whenPressed(new ShooterUpdateCommand(shooter, INITIATION_LINE_RPM));
        operator.getDPadRight().whenPressed(new ShooterUpdateCommand(shooter, TRENCH_RPM));

        // send shooter full forward or full backwards
        operator.getSelectButton().whileHeld(new ShooterControlCommand(shooter, REVERSE_VALUE));
        operator.getStartButton().whileHeld(new ShooterControlCommand(shooter, FORWARD_VALUE));

        operator.getRightAnalogButton().whenPressed(new ClimberLiftUpCommand(climber));
        operator.getLeftAnalogButton().whenPressed(new ClimberLiftDownCommand(climber));

        // "To live is to suffer, to survive is to find some meaning in the suffering."

        driver.getSelectButton().whileHeld(new DrivetrainGoalCommand(drivetrain, INITATION_LINE_DISTANCE))
                .whileHeld(new IntakeAcquireWhileCommand(intake));

        driver.getStartButton().whileHeld(new DrivetrainGoalCommand(drivetrain, TRENCH_DISTANCE))
                .whileHeld(new IntakeAcquireWhileCommand(intake));

        driver.getDPadUp().whenPressed(new LEDSetModeCommand(ledController, LEDController.kGreenPulse));
        driver.getDPadDown().whenPressed(new LEDSetModeCommand(ledController, LEDController.kRedPulse));
    }

    private void configureAutons() {
        AUTON_CHOOSER.addOption("Do Nothing", new DoNothingAutonCommand(ledController));
        AUTON_CHOOSER.addOption("Five Ballz Auton", new FiveBallzAutonCommand(ledController, drivetrain, shooter, intake));

        SmartDashboard.putData("Autons", AUTON_CHOOSER);
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
