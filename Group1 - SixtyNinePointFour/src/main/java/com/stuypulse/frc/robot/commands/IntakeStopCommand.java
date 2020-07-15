package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class IntakeStopCommand extends InstantCommand {

    private final Intake intake;

    public IntakeStopCommand(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    public void initialize() {
        intake.stop();
    }
}