/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

public class DrivetrainDriveFiveCommand extends Command {
  private final Drivetrain drivetrain;
  public DrivetrainDriveFiveCommand() {
    drivetrain = new Drivetrain();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (getDistance() < 5.0) {
      arcadeDrive(1);
    } else {
      stop();
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
