package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.ControlPanel;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class ControlPanelStopCommand extends InstantCommand {

    private ControlPanel controlPanel;

    public ControlPanelStopCommand(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public void initialize() {
        controlPanel.stop();
    }

}
