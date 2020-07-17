/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands.autons.routines;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.commands.ChimneyFeedCommand;
import com.stuypulse.frc.robot.commands.DrivetrainAlignmentCommand;
import com.stuypulse.frc.robot.commands.DrivetrainMoveDistanceCommand;
import com.stuypulse.frc.robot.commands.DrivetrainTurnAngleCommand;
import com.stuypulse.frc.robot.commands.IntakeAcquireBallsCommand;
import com.stuypulse.frc.robot.commands.ShooterAchieveSpeedCommand;
import com.stuypulse.frc.robot.commands.ShooterStopCommand;
import com.stuypulse.frc.robot.subsystems.Chimney;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.subsystems.Intake;
import com.stuypulse.frc.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class SixBallThreeTrenchAutonCommand extends SequentialCommandGroup {
  /*
    Robot starts on target side (in front) of the initiation line 
    Turns and shoots 
    Turns back 
    Goes into trench while intaking
    Turns and shoots again 
  */
  private final double TIME_TO_SHOOT_THREE_BALLS = 1.5; // sec 
  private final double DISTANCE_TO_END_OF_TRENCH = 16.22; // feet
  
  public SixBallThreeTrenchAutonCommand(Drivetrain drivetrain, Intake intake, Chimney chimney, Shooter shooter) {
    addCommands(
      new DrivetrainAlignmentCommand(drivetrain),
      new ShooterAchieveSpeedCommand(shooter, Constants.Shooter.INIT_RPM),
      new ChimneyFeedCommand(chimney).withTimeout(TIME_TO_SHOOT_THREE_BALLS),
      new ShooterStopCommand(shooter),
      new DrivetrainTurnAngleCommand(drivetrain, -drivetrain.getAngle()),
      new ParallelRaceGroup(
        new DrivetrainMoveDistanceCommand(drivetrain, DISTANCE_TO_END_OF_TRENCH),
        new IntakeAcquireBallsCommand(intake)
      ),
      new DrivetrainAlignmentCommand(drivetrain),
      new ShooterAchieveSpeedCommand(shooter, Constants.Shooter.TRENCH_RPM),
      new ChimneyFeedCommand(chimney).withTimeout(TIME_TO_SHOOT_THREE_BALLS),
      new ShooterStopCommand(shooter)
    );
  }
}
