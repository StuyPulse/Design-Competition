/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands.autons;

import com.stuypulse.frc.robot.commands.ConveyorConveyCommand;
import com.stuypulse.frc.robot.commands.DrivetrainMovementCommand;
import com.stuypulse.frc.robot.commands.DrivetrainTurnCommand;
import com.stuypulse.frc.robot.commands.IntakeAcquireCommand;
import com.stuypulse.frc.robot.commands.IntakeExtendCommand;
import com.stuypulse.frc.robot.commands.ShooterFeedCommand;
import com.stuypulse.frc.robot.commands.ShooterShootCommand;
import com.stuypulse.frc.robot.subsystems.Conveyor;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Intake;
import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class SixBallTrenchAutonCommand extends SequentialCommandGroup {
  private final double DegreesTowardTrench = 135;
  private final double DistanceTowardTrench = 110;
  private final double DegreesTowardBalls = 45;
  private final double DistanceTowardBalls = 30 + 36.5*2;
  private final double DistanceTowardGoal = 180;
  public SixBallTrenchAutonCommand(Drivetrain drivetrain, Shooter shooter, Intake intake, Conveyor conveyor) {
    addCommands(
      DrivetrainTurnCommand(drivetrain, DegreesTowardTrench),
      DrivetrainMovementCommand(drivetrain, DistanceTowardTrench),
      DrivetrainTurnCommand(drivetrain, DegreesTowardBalls),
      IntakeExtendCommand(intake),
      IntakeAcquireCommand(intake),
      DrivetrainMovementCommand(drivetrain, DistanceTowardBalls),
      DrivetrainTurnCommand(drivetrain,DistanceTowardGoal),
      ConveyorConveyCommand(conveyor),
      ShooterFeedCommand(shooter),
      ShooterShootCommand(shooter)
    );

  }
}
