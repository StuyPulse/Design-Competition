package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.util.LEDController;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class LEDSetSolidWhiteCommand extends InstantCommand {

    private LEDController ledController;
    
    @Override
    public void initialize() {
        ledController.setSolidWhite();
    }
}