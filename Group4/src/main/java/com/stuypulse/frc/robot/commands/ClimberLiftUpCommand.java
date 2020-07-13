package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Make the climber happy by making it go up (while button is held).
 */
public class ClimberLiftUpCommand extends CommandBase {

    private final Climber climber;

    public ClimberLiftUpCommand(Climber climber) {
        this.climber = climber;

        addRequirements(climber);
    }

    public void execute() {
        climber.liftUp();
    }

    public void end(boolean i) {
        climber.stop();
    }

}
