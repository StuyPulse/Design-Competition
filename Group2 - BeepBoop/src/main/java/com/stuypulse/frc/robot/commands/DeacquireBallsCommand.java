/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.subsystems.Chimney;
import com.stuypulse.frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DeacquireBallsCommand extends CommandBase {
  private Intake intake; 
  private Chimney chimney; 

  public DeacquireBallsCommand(Intake intake, Chimney chimney) {
    this.intake = intake; 
    this.chimney = chimney; 
    addRequirements(intake, chimney); 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.deacquire(Constants.Intake.SPEED);
    chimney.liftDown(Constants.Chimney.SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.stop();
    chimney.stop(); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
