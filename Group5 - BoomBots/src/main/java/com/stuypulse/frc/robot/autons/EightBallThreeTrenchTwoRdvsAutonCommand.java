package com.stuypulse.frc.robot.autons;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.commands.DrivetrainMovementCommand;
import com.stuypulse.frc.robot.commands.DrivetrainStopCommand;
import com.stuypulse.frc.robot.commands.LEDSetSolidWhiteCommand;
import com.stuypulse.frc.robot.commands.LEDTurnOffCommand;
import com.stuypulse.frc.robot.commands.ShooterShootCommand;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class EightBallThreeTrenchTwoRdvsAutonCommand extends SequentialCommandGroup {
    public EightBallThreeTrenchTwoRdvsAutonCommand(Drivetrain drivetrain, Shooter shooter) {
        addCommands(
            new LEDSetSolidWhiteCommand(),
            new ShooterShootCommand(shooter).withTimeout(1.0),
            new DrivetrainMovementCommand(drivetrain, Constants.Measurements.ANGLE_FROM_START_TO_TRENCH, 0.0),
            new DrivetrainMovementCommand(drivetrain, -Constants.Measurements.ANGLE_FROM_START_TO_TRENCH, 0.0),
            new DrivetrainMovementCommand(drivetrain, 0.0, Constants.Measurements.DISTANCE_FROM_BALL_TO_BALL),
            new DrivetrainMovementCommand(drivetrain, Constants.Measurements.ANGLE_FROM_TRENCH_TO_RDVS, 0.0),
            new DrivetrainMovementCommand(drivetrain, 0.0, Constants.Measurements.DISTANCE_FROM_TRENCH_TO_RDVS),
            new DrivetrainMovementCommand(drivetrain, Constants.Measurements.ANGLE_FROM_RDVS_TO_TWO_BALL, 0.0),
            new DrivetrainMovementCommand(drivetrain, 0.0, Constants.Measurements.DISTANCE_BETWEEN_TWO_BALL),
            new DrivetrainMovementCommand(drivetrain, 90, 0.0),
            new DrivetrainMovementCommand(drivetrain, 0.0, Constants.Measurements.DISTANCE_FROM_RDVS_TO_INTERSECTION_BEWTWEEN_TWO_BALL_AND_GOAL),
            new DrivetrainMovementCommand(drivetrain, 80, 0.0),
            new LEDTurnOffCommand(),
            new ShooterShootCommand(shooter).withTimeout(1.0),
            new DrivetrainStopCommand(drivetrain)
        );
    }
}