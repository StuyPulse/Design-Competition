package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeDeacquireCommand extends CommandBase {

    private final Intake intake;

    public IntakeDeacquireCommand(Intake intake) {
        this.intake = intake;
        addRequirements(intake);
    }

    public void execute() {
        intake.deacquire();
    }

    public void end() {
        intake.stop();
    }
    
}