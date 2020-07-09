package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeRetractCommand extends CommandBase {

    private final Intake intake;

    public IntakeRetractCommand(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    public void execute() {
        intake.retract();
    }

}