package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class IndexerRotateCommand extends CommandBase {
    private final Indexer indexer;
    
    public IndexerRotateCommand (Indexer indexer) {
        this.indexer = indexer;
        addRequirements(indexer);
    }

    public void execute() {
        indexer.rotate();
    }

    public void end(boolean interrupted) {
        indexer.stop();
    }

    
}