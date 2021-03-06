package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Climber;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ClimberClimbDownCommand extends CommandBase {
    
    private final Climber climber;

    public ClimberClimbDownCommand(Climber climber) {
        this.climber = climber;
        addRequirements(climber);
    }

    @Override
    public void execute() {
        climber.climbDown();
    }

    @Override
    public void end(boolean interrupted) {
        climber.stop();
    }

}