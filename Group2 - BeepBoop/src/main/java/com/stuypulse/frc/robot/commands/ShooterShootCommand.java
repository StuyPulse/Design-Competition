/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;
import com.stuypulse.stuylib.input.Gamepad;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterShootCommand extends CommandBase {
  private Shooter shooter;
  private Gamepad gamepad;
  
  public ShooterShootCommand(Shooter shooter, Gamepad gamepad) {
    this.shooter = shooter;
    this.gamepad = gamepad;
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Separate triggers to allow shooter motors to achieve desired speed before feeding
    shooter.shoot(gamepad.getRightTrigger());
    shooter.feed(gamepad.getLeftTrigger());
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
