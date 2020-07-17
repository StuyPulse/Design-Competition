package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Climber;

import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * Make the climber sad by making it go down (presumably while a button is held).
 */
public class ClimberLiftDownCommand extends InstantCommand {

    private final Climber climber;

    public ClimberLiftDownCommand(Climber climber) {
        this.climber = climber;

        addRequirements(climber);
    }

    public void initialize() {
        climber.retractBrake();
        climber.liftDown();
    }

}
