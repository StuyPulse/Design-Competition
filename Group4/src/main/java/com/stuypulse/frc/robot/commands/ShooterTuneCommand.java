package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Shooter;
import static com.stuypulse.frc.robot.Constants.kShooter.TuneCommand.*;

import com.stuypulse.stuylib.control.*;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Uses PID tuning to set the motors of the shooter (and feeder) to a target
 * RPM.
 */
public class ShooterTuneCommand extends CommandBase {

    private final Shooter shooter;

    private Controller shooterController;
    private Controller feederController;

    public ShooterTuneCommand(Shooter shooter, double rpm) {
        this.shooter = shooter;

        shooterController = new PIDController(SHOOTER_P, SHOOTER_I, SHOOTER_D);
        feederController = new PIDController(FEEDER_P, FEEDER_I, FEEDER_D);

        addRequirements(shooter);
    }

    @Override
    public void execute() {
        double shooterError = shooter.getTargetRPM() - shooter.getShooterRPM();

        shooter.setShooter(shooterController.update(shooterError));

        double feederError = shooter.getTargetRPM() - shooter.getFeederRPM();

        shooter.setFeeder(feederController.update(feederError));

    } // "God is dead"

    public boolean isFinished() {
        return false;
    }

}
