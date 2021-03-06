package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeAcquireCommand extends CommandBase {
    private final Intake intake;

    public IntakeAcquireCommand(Intake intake) {
      this.intake = intake;
      addRequirements(intake);
    }

    public void execute() {
        intake.acquire();
    }

    public boolean isFinished() {
        return intake.isBallDetected();
    }

    public void end(boolean interrupted) {
        intake.stop();
    }

}