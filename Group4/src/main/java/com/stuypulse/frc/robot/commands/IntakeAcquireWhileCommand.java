package com.stuypulse.frc.robot.commands;


import com.stuypulse.frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Intake command to acquire and then stop (presumably used with a gamepad)
 */
public class IntakeAcquireWhileCommand extends CommandBase {

    private Intake intake;

    public IntakeAcquireWhileCommand(Intake intake) {
        this.intake = intake;

        addRequirements(intake);
    }

    public void execute() {
        intake.acquire();
    }

    public void end() {
        intake.stop();
    }

}
