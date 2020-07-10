package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ConveyorStopCommand extends CommandBase {
    private final Conveyor conveyor;

    public ConveyorStopCommand (Conveyor conveyor) {
        this.conveyor = conveyor;
        addRequirements(conveyor);
    }

    public void execute() {
        conveyor.stop();
    }
      
    public void end(boolean interrupted) {
    }

}