package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;

//make instance command
public class IndexerStopCommand extends CommandBase {
    private final Indexer indexer;

    public IndexerStopCommand(Indexer indexer) {
        this.indexer = indexer;
        addRequirements(indexer);
    }

    public void execute() {
        indexer.stop();
    }

    public void end(boolean interrupted) {
    }

    
}