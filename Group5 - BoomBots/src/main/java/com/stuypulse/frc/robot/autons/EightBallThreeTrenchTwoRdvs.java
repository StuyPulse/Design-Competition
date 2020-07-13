package com.stuypulse.frc.robot.autons;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.commands.DrivetrainManualTurnCommand;
import com.stuypulse.frc.robot.commands.DrivetrainDriveStraightCommand;
import com.stuypulse.frc.robot.commands.DrivetrainStopCommand;
import com.stuypulse.frc.robot.commands.ShooterShootCommand;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// Based off of EightBallThreeTrenchTwoRdvsAutonCommand from Edwin
public class EightBallThreeTrenchTwoRdvs extends SequentialCommandGroup {
    public EightBallThreeTrenchTwoRdvs(Drivetrain drivetrain, Shooter shooter) {
        addCommands(
            new ShooterShootCommand(shooter),
            new DrivetrainManualTurnCommand(drivetrain, Constants.Measurements.ANGLE_FROM_START_TO_TRENCH),
            new DrivetrainManualTurnCommand(drivetrain, -Constants.Measurements.ANGLE_FROM_START_TO_TRENCH),
            new DrivetrainDriveStraightCommand(drivetrain, Constants.Measurements.DISTANCE_FROM_BALL_TO_BALL),

            new DrivetrainManualTurnCommand(drivetrain, Constants.Measurements.ANGLE_FROM_TRENCH_TO_RDVS),
            new DrivetrainDriveStraightCommand(drivetrain, Constants.Measurements.DISTANCE_FROM_TRENCH_TO_RDVS),
            new DrivetrainManualTurnCommand(drivetrain, Constants.Measurements.ANGLE_FROM_RDVS_TO_TWO_BALL),
            new DrivetrainDriveStraightCommand(drivetrain, Constants.Measurements.DISTANCE_BETWEEN_TWO_BALL),
            new DrivetrainManualTurnCommand(drivetrain, 90),
            new DrivetrainDriveStraightCommand(drivetrain, Constants.Measurements.DISTANCE_FROM_RDVS_TO_INTERSECTION_BEWTWEEN_TWO_BALL_AND_GOAL),
            new DrivetrainManualTurnCommand(drivetrain, 80),
            new ShooterShootCommand(shooter),
            new DrivetrainStopCommand(drivetrain)
        );
    }
}