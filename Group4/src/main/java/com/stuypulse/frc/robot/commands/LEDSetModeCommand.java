package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.util.LEDController;
import com.stuypulse.frc.robot.util.LEDController.Mode;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class LEDSetModeCommand extends InstantCommand {

    private final LEDController ledController;
    private final Mode mode;

    public LEDSetModeCommand(LEDController ledController, Mode newMode) {
        this.ledController = ledController;
        mode = newMode;
    }

    @Override
    public void initialize() {
        ledController.setMode(mode);
    }

}
