/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.stuylib.input.Gamepad;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainDriveCommand extends CommandBase {
  /**
   * Creates a new DrivetrainTankDriveCommand.
   */

  private Drivetrain drivetrain; 
  private Gamepad gamepad;

  public DrivetrainDriveCommand(Drivetrain drivetrain, Gamepad gamepad) {
    this.drivetrain = drivetrain;
    this.gamepad = gamepad;  
    addRequirements(drivetrain); 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.curvatureDrive(
      gamepad.getLeftTrigger() - gamepad.getRightTrigger(), 
      gamepad.getLeftX()
    ); 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
