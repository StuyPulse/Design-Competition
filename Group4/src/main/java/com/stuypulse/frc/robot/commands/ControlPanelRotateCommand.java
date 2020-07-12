package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.ControlPanel;
import static com.stuypulse.frc.robot.Constants.kControlPanel.RotateCommand.*;

import com.stuypulse.stuylib.control.*;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Command that allows the ControlPanel to rotate a certain number of times
 * (assuming the encoder is set to return rotations) by tuning error.
 */
public class ControlPanelRotateCommand extends CommandBase {

    private final ControlPanel controlPanel;

    private final double targetRotations;

    private Controller rotController;

    private double currentGoal;

    public ControlPanelRotateCommand(ControlPanel controlPanel, double targetRotations) {
        this.controlPanel = controlPanel;

        this.targetRotations = targetRotations;

        currentGoal = 0.0;

        rotController = new PIDController(ROT_P, ROT_I, ROT_D);

        addRequirements(controlPanel);
    }

    @Override
    public void initialize() {
        currentGoal = targetRotations + controlPanel.getRotations();
    }

    public void execute() {
        double error = currentGoal - controlPanel.getRotations();

        rotController.update(error);
    }

    public boolean isFinished() {
        return rotController.isDone(ROT_MAX_ERROR, ROT_MAX_VELOCITY);
    }

    public void end(boolean i) {
        controlPanel.stop();
    }

}
