package com.stuypulse.frc.robot.autons;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.commands.DrivetrainMovementCommand;
import com.stuypulse.frc.robot.commands.DrivetrainStopCommand;
import com.stuypulse.frc.robot.commands.IntakeAcquireForeverCommand;
import com.stuypulse.frc.robot.commands.IntakeExtendCommand;
import com.stuypulse.frc.robot.commands.IntakeStopCommand;
import com.stuypulse.frc.robot.commands.ShooterShootCommand;
import com.stuypulse.frc.robot.commands.ShooterStopCommand;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Intake;
import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class FiveBallTwoRdvs extends SequentialCommandGroup {
    public FiveBallTwoRdvs(Drivetrain drivetrain, Shooter shooter, Intake intake) {
        addCommands(
            new ShooterShootCommand(shooter),
            new IntakeExtendCommand(intake),
            new DrivetrainMovementCommand(drivetrain, 0.0, Constants.Measurements.DISTANCE_TO_RDVS_IN_FEET),
            new IntakeAcquireForeverCommand(intake),
            new DrivetrainMovementCommand(drivetrain, Constants.Measurements.ANGLE_TO_RDVS, 0.0),
            new DrivetrainMovementCommand(drivetrain, 0.0, Constants.Measurements.DISTANCE_TO_ACQUIRE_RDVS_BALLS_IN_FEET),
            new DrivetrainMovementCommand(drivetrain, 0.0, Constants.Measurements.DISTANCE_TO_BACKUP_AFTER_RDVS),
            new DrivetrainMovementCommand(drivetrain, -Constants.Measurements.ANGLE_TO_RDVS, 0.0),
            new IntakeStopCommand(intake),
            new ShooterShootCommand(shooter),
            new ShooterStopCommand(shooter),
            new DrivetrainStopCommand(drivetrain)
        );
    }
}