package com.stuypulse.frc.robot.util.swerve;

import com.stuypulse.stuylib.math.Vector2D;
import com.stuypulse.stuylib.math.Angle;
import edu.wpi.first.wpilibj2.command.CommandBase;

import com.stuypulse.frc.robot.util.FilteredVStream;
import com.stuypulse.frc.robot.util.VStream;
import com.stuypulse.stuylib.input.Gamepad;

public abstract class SwervetrainCommand extends CommandBase {

    protected final SwervetrainSubsystem swervetrain;

    public SwervetrainCommand(SwervetrainSubsystem swervetrain) {
        this.swervetrain = swervetrain;
    }

    public abstract Vector2D getDirection();

    public abstract Angle getRotation();

    @Override
    public void execute() {
        swervetrain.swerveDrive(getDirection(), getRotation());
    }

}