/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands.autons;

import com.stuypulse.frc.robot.subsystems.Conveyor;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Intake;
import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class FiveBallControlPanelAutonCommand extends SequentialCommandGroup {
  private final double DegreesTowardControlPanel = -135;
  private final double DistanceTowardControlPanel = 150;
  private final double DegreesTowardBalls = -45;
  private final double DistanceTowardBalls = 60;
  private final double DegreesTowardGoal = 180;
  public FiveBallControlPanelAutonCommand(Drivetrain drivetrain, Intake intake, Conveyor conveyor, Shooter shooter) {
    addCommands(
      DrivetrainTurnCommand(drivetrain, DegreesTowardControlPanel),
      DrivetrainMovementCommand(drivetrain, DistanceTowardControlPanel),
      DrivetrainTurnCommand(drivetrain, DegreesTowardBalls),
      IntakeExtendCommand(intake),
      IntakeAcquireCommand(intake),
      DrivetrainMovementCommand(drivetrain, DistanceTowardBalls),
      DrivetrainTurnCommand(drivetrain, DegreesTowardGoal),
      ConveyorConveyCommand(conveyor),
      ShooterFeedCommand(shooter),
      ShooterShootCommand(shooter)
    );
  }
}
