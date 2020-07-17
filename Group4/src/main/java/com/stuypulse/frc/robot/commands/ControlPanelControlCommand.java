package com.stuypulse.frc.robot.commands;

import static com.stuypulse.frc.robot.Constants.kControlPanel.ControlCommand.*;

import com.stuypulse.frc.robot.subsystems.ControlPanel;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.stuypulse.stuylib.input.Gamepad;

import com.stuypulse.stuylib.math.SLMath;

/**
 * Command that allows the gamepad to control the ControlPanel by using the
 * gamepad's stick rotation.
 */
public class ControlPanelControlCommand extends CommandBase {

    private ControlPanel controlPanel;

    private Gamepad gamepad;

    public ControlPanelControlCommand(ControlPanel controlPanel, Gamepad gamepad) {
        this.gamepad = gamepad;
        this.controlPanel = controlPanel;

        addRequirements(controlPanel);
    }

    public void execute() {
        double d = SLMath.deadband(gamepad.getRightX(), MIN_FORCE);
        controlPanel.spin(d);
    }

    public void end(boolean interrupted) {
        controlPanel.stop();
        // controlPanel.resetEncoder();
    }

}
