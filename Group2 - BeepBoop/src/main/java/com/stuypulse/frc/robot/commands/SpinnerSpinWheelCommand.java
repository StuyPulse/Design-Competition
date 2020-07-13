/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Spinner;
import com.stuypulse.stuylib.input.Gamepad;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SpinnerSpinWheelCommand extends CommandBase {
  /**
   * Creates a new SpinnerSpinWheelCommand.
   */

  private Spinner spinner; 
  private Gamepad gamepad; 

  private final double DEADBAND_LIMIT = 0.1;

  public SpinnerSpinWheelCommand(Spinner spinner, Gamepad operatorGamepad) {
    this.spinner = spinner;
    this.gamepad = operatorGamepad;
    addRequirements(spinner);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = gamepad.getLeftX(); 
    if(Math.abs(speed) > DEADBAND_LIMIT) 
      spinner.spin(speed);
    else 
      spinner.stop(); 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    spinner.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
