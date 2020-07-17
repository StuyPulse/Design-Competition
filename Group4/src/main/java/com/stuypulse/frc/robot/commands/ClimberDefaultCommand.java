package com.stuypulse.frc.robot.commands;

import static com.stuypulse.frc.robot.Constants.kClimber.*;
import com.stuypulse.frc.robot.subsystems.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * This default command is to ensure that the climber does not pass set limits
 * that might break the climber.
 */
public class ClimberDefaultCommand extends CommandBase {

    private final Climber climber;

    public ClimberDefaultCommand(Climber bruh) {
        this.climber = bruh; // bruh

        addRequirements(bruh); // bruh bruh
    }

    public void execute() {
        if (climber.getDistance() > MAX_DISTANCE || climber.getDistance() < MIN_DISTANCE) {
            climber.stop();
            climber.setBrake();
        } // ... - --- .--. / .-.. --- --- -.- .. -. --. / .- - / -- .

    }

}
