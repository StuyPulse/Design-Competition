package com.stuypulse.frc.robot.autons;

import com.stuypulse.frc.robot.commands.LEDSetModeCommand;
import com.stuypulse.frc.robot.util.LEDController;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * Classic first auton.
 *
 * This auton does literally nothing.
 */
public class DoNothingAuton extends SequentialCommandGroup {

    // "Sometimes people don’t want to hear the truth because they don’t want their
    // illusions destroyed."

    public DoNothingAuton(LEDController controller) {
        addCommands(
            new LEDSetModeCommand(controller, LEDController.kRed)
        );
    }

}
