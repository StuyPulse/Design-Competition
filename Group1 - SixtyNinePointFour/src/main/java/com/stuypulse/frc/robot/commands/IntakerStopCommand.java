package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakerStopCommand extends CommandBase {

    private final Intake intake;

    public IntakerStopCommand(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    public void initialize() {
        intake.stop();
    }
}