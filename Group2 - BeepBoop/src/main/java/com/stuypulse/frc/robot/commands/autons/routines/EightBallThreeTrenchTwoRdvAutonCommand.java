/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands.autons.routines;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.commands.AcquireBallsCommand;
import com.stuypulse.frc.robot.commands.DrivetrainAlignmentCommand;
import com.stuypulse.frc.robot.commands.DrivetrainMoveDistanceCommand;
import com.stuypulse.frc.robot.commands.DrivetrainTurnAngleCommand;
import com.stuypulse.frc.robot.commands.ShooterAchieveSpeedCommand;
import com.stuypulse.frc.robot.commands.ShooterFeedCommand;
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
public class EightBallThreeTrenchTwoRdvAutonCommand extends SequentialCommandGroup {
  //Starts with intake facing trench
  
  public EightBallThreeTrenchTwoRdvAutonCommand(Drivetrain drivetrain, Shooter shooter, Intake intake, Chimney chimney) {
    addCommands(
      new ParallelRaceGroup(
        new DrivetrainMoveDistanceCommand(drivetrain, Constants.Auton.DISTANCE_FROM_INIT_TO_TRENCH),
        new AcquireBallsCommand(intake, chimney)
      ),
      new DrivetrainAlignmentCommand(drivetrain),
      new ShooterAchieveSpeedCommand(shooter, Constants.Shooter.TRENCH_RPM), 
      new ShooterFeedCommand(shooter).withTimeout(3),
      new ShooterStopCommand(shooter)


      
    );
  }
}
