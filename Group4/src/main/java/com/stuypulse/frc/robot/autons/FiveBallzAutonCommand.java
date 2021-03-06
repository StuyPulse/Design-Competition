package com.stuypulse.frc.robot.autons;

import edu.wpi.first.wpilibj2.command.*;
import com.stuypulse.frc.robot.commands.*;
import com.stuypulse.frc.robot.subsystems.*;
import com.stuypulse.frc.robot.util.LEDController;

import static com.stuypulse.frc.robot.Constants.*;

import com.stuypulse.stuylib.math.*;

/**
 * Five ball<b>z</b> auton.
 *
 * <ol>
 * <li>Assume shooter is on the front and intake is on the back of the robot.</li>
 * <li>Start nearest the other team's trench.</li>
 * <li>Face the shooter away from the other team's trench</li>
 * <li>Drive backwards trench distance and distance from trench. </li>
 * <li>Turn intake on to take in other team's balls</li>
 * <li>Align and shoot from trench distance</li>
 * </ol>
 */
public class FiveBallzAutonCommand extends SequentialCommandGroup {

    public FiveBallzAutonCommand(LEDController controller, Drivetrain drivetrain, Shooter shooter, Intake intake) {
        final double DISTANCE = 3 + 1;

        final double MAX_TIMEOUT = 0.5;

        addCommands(
            new LEDSetModeCommand(controller, LEDController.kDarkBlue),
            new IntakeAcquireCommand(intake),
            new IntakeExtendCommand(intake),
            new DrivetrainMoveCommand(drivetrain, -DISTANCE, Angle.fromDegrees(0)),

            new LEDSetModeCommand(controller, LEDController.kBlue),
            new DrivetrainGoalCommand(drivetrain, DISTANCE).withTimeout(MAX_TIMEOUT),
            new LEDSetModeCommand(controller, LEDController.kGreen),

            new ShooterUpdateCommand(shooter, TRENCH_RPM)

        );
    }

}
