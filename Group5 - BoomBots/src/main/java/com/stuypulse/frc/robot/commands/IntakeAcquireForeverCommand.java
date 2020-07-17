package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class IntakeAcquireForeverCommand extends InstantCommand {
  
  private Intake intake;

  public IntakeAcquireForeverCommand(Intake intake) {
      this.intake = intake;
      addRequirements(intake);
  }

  @Override
  public void initialize() {
      intake.acquire();
  }
  
}