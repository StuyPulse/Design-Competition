/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands.autons;

import com.stuypulse.frc.robot.commands.DrivetrainMovementCommand;
import com.stuypulse.frc.robot.commands.DrivetrainTurnCommand;
import com.stuypulse.frc.robot.commands.ShooterShootCommand;
import com.stuypulse.frc.robot.commands.ShooterStopFeedCommand;
import com.stuypulse.frc.robot.commands.ShooterStopShootCommand;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Shooter;
import com.stuypulse.frc.robot.Constants.AutonConstants;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class ThreeBallDriveTowardTrenchAutonCommand extends SequentialCommandGroup {
  public ThreeBallDriveTowardTrenchAutonCommand(Shooter shooter, Drivetrain drivetrain) {
    addCommands(
      new ShooterShootCommand(shooter, AutonConstants.SHOOTING_RPM).withTimeout(1.0),
      new DrivetrainTurnCommand(drivetrain, AutonConstants.DEGREES_TOWARDS_TRENCH),
      new DrivetrainMovementCommand(drivetrain, AutonConstants.DISTANCE_TOWARDS_TRENCH),
      new DrivetrainTurnCommand(drivetrain, AutonConstants.DEGREES_TOWARDS_BALL),
      new WaitCommand(1.0),
      new ShooterStopFeedCommand(shooter),
      new ShooterStopShootCommand(shooter)
    );
  }
}
