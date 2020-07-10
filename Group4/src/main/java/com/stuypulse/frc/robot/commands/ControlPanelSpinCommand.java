package com.stuypulse.frc.robot.commands;


import com.stuypulse.frc.robot.subsystems.ControlPanel;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ControlPanelSpinCommand extends CommandBase {

    private ControlPanel controlPanel;

    public ControlPanelSpinCommand(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public void execute() {
        controlPanel.spin();
    }

    public boolean isFinished() {
        // speed
        return false;
    }

}
