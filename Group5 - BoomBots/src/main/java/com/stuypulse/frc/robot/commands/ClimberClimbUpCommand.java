package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimberClimbUpCommand extends CommandBase {
    
    private final Climber climber;

    public ClimberClimbUpCommand(Climber climber) {
        this.climber = climber;
        addRequirements(climber);
    }

    public void execute() {
        climber.climbUp();
    }

    public void end() {
        climber.stop();
    }

}