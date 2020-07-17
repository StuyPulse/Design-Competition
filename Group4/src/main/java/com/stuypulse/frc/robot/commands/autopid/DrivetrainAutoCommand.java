package com.stuypulse.frc.robot.commands.autopid;

import com.stuypulse.frc.robot.commands.DrivetrainCommand;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.frc.robot.util.GearController.Gear;
import com.stuypulse.stuylib.network.*;
import com.stuypulse.stuylib.control.*;
import com.stuypulse.stuylib.math.*;

/**
 * <p>
 * <b>Usage:</b>
 * </p>
 *
 * DrivetrainAlignCommand can simply be replaced with DrivetrainAutoCommand in
 * order to use AutoPID.
 */
public abstract class DrivetrainAutoCommand extends DrivetrainCommand {

    private static final SmartNumber SPEED_AUTO_P = new SmartNumber("SPEED_AUTO_P");
    private static final SmartNumber SPEED_AUTO_I = new SmartNumber("SPEED_AUTO_I");
    private static final SmartNumber SPEED_AUTO_D = new SmartNumber("SPEED_AUTO_D");

    private static final SmartNumber ANGLE_AUTO_P = new SmartNumber("ANGLE_AUTO_P");
    private static final SmartNumber ANGLE_AUTO_I = new SmartNumber("ANGLE_AUTO_I");
    private static final SmartNumber ANGLE_AUTO_D = new SmartNumber("ANGLE_AUTO_D");

    private final PIDCalculator speedCalculator;
    private final PIDCalculator angleCalculator;

    private PIDController speedOutput, angleOutput;

    private Angle targetAngle;
    private double targetSpeed;

    public DrivetrainAutoCommand(Drivetrain drivetrain, double speedAmp, double angleAmp) {
        super(drivetrain);

        speedCalculator = new PIDCalculator(speedAmp);
        angleCalculator = new PIDCalculator(angleAmp);

        updateAngleOutput();
        updateSpeedOutput();

    }

    private final void updateAngleOutput() {
        angleOutput = angleCalculator.getPIDController();

        ANGLE_AUTO_P.set(angleOutput.getP());
        ANGLE_AUTO_I.set(angleOutput.getI());
        ANGLE_AUTO_D.set(angleOutput.getD());

    }

    private final void updateSpeedOutput() {
        speedOutput = speedCalculator.getPIDController();

        SPEED_AUTO_P.set(speedOutput.getP());
        SPEED_AUTO_I.set(speedOutput.getI());
        SPEED_AUTO_D.set(speedOutput.getD());
    }

    public DrivetrainAutoCommand(Drivetrain drivetrain) {
        this(drivetrain, 1, 1);
    }

    @Override
    public final void initialize() {
        targetAngle = drivetrain.getAngle().add(getAngleError());
        targetSpeed = drivetrain.getDistance() + getSpeedError();
    }

    public abstract Angle getAngleError();

    public abstract double getSpeedError();

    @Override
    public final double getSpeed() {
        double serror = targetSpeed - drivetrain.getDistance();

        double sOut = speedCalculator.update(serror);

        updateSpeedOutput();

        return sOut;
    }

    public final double getAngle() {
        double aerror = targetAngle.sub(drivetrain.getAngle()).toDegrees();

        double aOut = angleCalculator.update(aerror);

        updateAngleOutput();

        return aOut;
    }

    public boolean isFinished() {
        return false; // isDone()
    }

    public final Gear getGear() {
        return Gear.LOW;
    }

}
