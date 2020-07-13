package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Make the climber sad by making it go down (presumably while a button is held).
 */
public class ClimberLiftDownCommand extends CommandBase {

    private final Climber climber;

    public ClimberLiftDownCommand(Climber climber) {
        this.climber = climber;

        addRequirements(climber);
    }

    public void execute() {
        climber.liftDown();
    }

    public void end(boolean i) {
        climber.stop();
    }

}
