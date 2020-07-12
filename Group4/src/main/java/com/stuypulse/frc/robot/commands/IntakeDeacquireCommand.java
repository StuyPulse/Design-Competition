package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * Instant command that sets the intake to acquire. (necessary for autons)
 */
public class IntakeDeacquireCommand extends InstantCommand {

    private final Intake intake;

    public IntakeDeacquireCommand(Intake intake) {
        this.intake = intake;

        addRequirements(intake);
    }

    public void initialize() {
        intake.deacquire();
    }

}
