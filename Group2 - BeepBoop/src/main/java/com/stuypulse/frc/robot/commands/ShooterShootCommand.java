/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Chimney;
import com.stuypulse.frc.robot.subsystems.Shooter;
import com.stuypulse.stuylib.input.Gamepad;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterShootCommand extends CommandBase {
  /* 
    Chimney needed to feed. 
    Use to shoot in teleop. 
  */ 
  private Shooter shooter;
  private Chimney chimney;
  private Gamepad gamepad;
  private double startTime;
  
  public ShooterShootCommand(Shooter shooter, Chimney chimney, Gamepad gamepad) {
    this.shooter = shooter;
    this.chimney = chimney;
    this.gamepad = gamepad;
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = gamepad.getRightTrigger() - gamepad.getLeftTrigger(); 
    shooter.shoot(speed);

    // Delay the chimney to allow operator to get shooter to desired speed
    if(Timer.getFPGATimestamp() - startTime >= 1.0)
      chimney.liftUp(speed); 
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
