/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Climber;
import com.stuypulse.stuylib.input.Gamepad;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimberClimbCommand extends CommandBase {
  private Climber climber;
  private Gamepad operatorGamepad;

  private final double DEADBAND_LIMIT = 0.1;

  /**
   * Creates a new ClimberClimbCommand.
   */
  public ClimberClimbCommand(Climber climber, Gamepad operatorGamepad) {
    this.climber = climber;
    this.operatorGamepad = operatorGamepad;
    addRequirements(climber);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = operatorGamepad.getLeftY();
    if(Math.abs(speed) > DEADBAND_LIMIT)
      climber.climb(speed);
    else
      climber.stop();
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
