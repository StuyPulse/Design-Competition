/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands.autons;

import com.stuypulse.frc.robot.Constants.Ports.Shooter;
import com.stuypulse.frc.robot.commands.DrivetrainDriveCommand;
import com.stuypulse.frc.robot.commands.DrivetrainMovementCommand;
import com.stuypulse.frc.robot.commands.DrivetrainTurnCommand;
import com.stuypulse.frc.robot.commands.ShooterShootCommand;
import com.stuypulse.frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ThreeBallDriveTowardTrenchAutonCommand extends SequentialCommandGroup {
  private final double DegreesTowardTrench = 135;
  private final double DistanceTowardsTrench = 110;
  private final double DegreesTowardBalls = 45;
  public ThreeBallDriveTowardTrenchAutonCommand(Shooter shooter, Drivetrain drivetrain) {
    addCommands(
      ShooterShootCommand(shooter),
      DrivetrainTurnCommand(drivetrain, DegreesTowardTrench),
      DrivetrainMovementCommand(drivetrain, DistanceTowardsTrench),
      DrivetrainTurnCommand(drivetrain, DegreesTowardBalls)
    );
  }
}
