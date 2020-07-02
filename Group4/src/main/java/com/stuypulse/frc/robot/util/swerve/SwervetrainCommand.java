package com.stuypulse.frc.robot.util.swerve;

import com.stuypulse.stuylib.math.Vector2D;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * Abstract swerve command for a swervetrain.
 */
public abstract class SwervetrainCommand extends CommandBase {

    protected final SwervetrainSubsystem swervetrain;

    public SwervetrainCommand(SwervetrainSubsystem swervetrain) {
        this.swervetrain = swervetrain;
    }

    public abstract Vector2D getDirection();

    public abstract double getRotation();

    @Override
    public void execute() {
        swervetrain.swerveDrive(getDirection(), getRotation());
    }

}
