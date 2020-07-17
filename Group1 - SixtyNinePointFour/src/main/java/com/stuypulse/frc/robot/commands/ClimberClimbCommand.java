package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimberClimbCommand extends CommandBase {
    private final Climber climber;
    
    public ClimberClimbCommand(Climber climber) {
        this.climber = climber;
        addRequirements(climber);
    }

    public void execute() {
        climber.climb();
    }

    public void end(boolean interrupted) {
        climber.stopClimb();
    }
}