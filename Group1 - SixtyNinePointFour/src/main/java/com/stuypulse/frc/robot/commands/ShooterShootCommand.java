package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.Constants.ShooterShoot;
import com.stuypulse.frc.robot.subsystems.Shooter;
import com.stuypulse.stuylib.control.Controller;
import com.stuypulse.stuylib.control.PIDController;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterShootCommand extends CommandBase {
    private final Shooter shooter;
    private final double targetRPM;
    private Controller controller = new PIDController(ShooterShoot.P, ShooterShoot.I, ShooterShoot.D);

    public ShooterShootCommand (Shooter shooter, double targetRPM) {
        this.shooter = shooter;
        this.targetRPM = targetRPM;
        addRequirements(shooter);
    }

    public void initialize() {
    }

    public void execute() {
        shooter.setSpeed(controller.update(shooter.getRPM(), targetRPM));
    }

    public boolean isFinished() {
        return controller.isDone(ShooterShoot.SHOOTING_ERROR);
    }
}