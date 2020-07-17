package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ConveyorConveyCommand extends CommandBase {
    private final Conveyor conveyor;

    public ConveyorConveyCommand (Conveyor conveyor) {
        this.conveyor = conveyor;
        addRequirements(conveyor);
    }

    public void execute() {
        conveyor.convey();
    }
      
    public void end(boolean interrupted) {
        conveyor.stop();
    }

}