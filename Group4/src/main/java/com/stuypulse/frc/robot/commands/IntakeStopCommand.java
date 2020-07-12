package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * Instant command to stop the intake
 */
public class IntakeStopCommand extends InstantCommand {
    
    private final Intake intake;

    public IntakeStopCommand(Intake intake) {
        this.intake = intake;
    }

    public void initialize() {
        intake.stop();
    }

}