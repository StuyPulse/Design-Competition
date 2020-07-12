package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Intake command to deacquire and then stop (presumably used with a gamepad)
 */
public class IntakeDeacquireWhileCommand extends CommandBase {

    private Intake intake;

    public IntakeDeacquireWhileCommand(Intake intake) {
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
