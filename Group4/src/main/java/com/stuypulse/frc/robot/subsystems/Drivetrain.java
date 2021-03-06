/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import static com.stuypulse.frc.robot.Constants.kDrivetrain.*;
import com.stuypulse.frc.robot.util.GearController.Gear;
import com.stuypulse.stuylib.math.Angle;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Standard drivetrain subsystem.
 */
public class Drivetrain extends SubsystemBase {

    /**
     * Utility function to switch implementation (because idk which is which)
     *
     * @param gear gear enumeration
     * @return state that the gear shifting solenoid should be at.
     */
    private static DoubleSolenoid.Value gearToSolenoid(Gear gear) {
        return gear == Gear.LOW ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse;
    }

    /**
     * Utility function to get a Gear enum from gearShift solenoid
     *
     * (as opposed to storing it)
     *
     * @param state solenoid value
     * @return state that the gear shifting solenoid should be at.
     */
    private static Gear solenoidToGear(DoubleSolenoid.Value state) {
        return state == DoubleSolenoid.Value.kForward ? Gear.LOW : Gear.HIGH;
    }

    /**
     * Speed controllers.
     */
    private CANSparkMax lMotorFront, lMotorBack, lMotorMid, rMotorFront, rMotorMid, rMotorBack;

    /**
     * Encoders (left and right).
     */
    private CANEncoder lEncoder, rEncoder;

    /**
     * Speed controller groups (left and right).
     */
    private SpeedControllerGroup lControllers, rControllers;

    /**
     * Differential drive (takes in SpeedControllerGroup for each side).
     */
    private DifferentialDrive motors;

    /**
     * Gear shift solenoid.
     */
    private DoubleSolenoid gearShift;

    /**
     * Drivetrain gyro.
     */
    private AHRS gyro;

    /**
     * Create a new drivetrain.
     */
    public Drivetrain() {

        lMotorFront = new CANSparkMax(Ports.LEFT_FRONT, MotorType.kBrushless);
        lMotorBack = new CANSparkMax(Ports.LEFT_BACK, MotorType.kBrushless);
        lMotorMid = new CANSparkMax(Ports.LEFT_MID, MotorType.kBrushless);

        rMotorFront = new CANSparkMax(Ports.RIGHT_BACK, MotorType.kBrushless);
        rMotorBack = new CANSparkMax(Ports.RIGHT_FRONT, MotorType.kBrushless);
        rMotorMid = new CANSparkMax(Ports.RIGHT_MID, MotorType.kBrushless);

        lControllers = new SpeedControllerGroup(lMotorFront, lMotorMid, lMotorBack);
        rControllers = new SpeedControllerGroup(rMotorFront, rMotorMid, rMotorBack);

        motors = new DifferentialDrive(lControllers, rControllers);

        rEncoder = rMotorBack.getEncoder();
        lEncoder = lMotorBack.getEncoder();

        gearShift = new DoubleSolenoid(Ports.SOLENOID_A, Ports.SOLENOID_B);

        // DO MOTOR/SOLENOID/GYRO/ENCODER SETUP HERE

        resetGyro();
        resetEncoders();
        setGear(Gear.LOW);

        lMotorFront.setIdleMode(IdleMode.kCoast);
        rMotorFront.setIdleMode(IdleMode.kCoast);

        lMotorBack.setIdleMode(IdleMode.kBrake);
        rMotorBack.setIdleMode(IdleMode.kBrake);

        lMotorMid.setIdleMode(IdleMode.kBrake);
        rMotorMid.setIdleMode(IdleMode.kBrake);

        setEncoderFactor(Encoders.NEO_FACTOR_TO_FEET);

    }

    /**
     * Arcade drive.
     *
     * @param speed robot's x axis speed
     * @param angle robot's z axis rate
     */
    public void arcadeDrive(double speed, double angle) {
        motors.arcadeDrive(speed, angle);
    }

    /**
     * Tank drive.
     *
     * @param lSpeed robot's left side speed
     * @param rSpeed robot's right side speed
     */
    public void tankDrive(double lSpeed, double rSpeed) {
        motors.tankDrive(lSpeed, rSpeed);
    }

    /**
     * Stops the motors.
     */
    public void stop() {
        tankDrive(0, 0);
    }

    /**
     * Gear shifting.
     *
     * @see {@link com.stuypulse.frc.robot.util.GearController.Gear}
     * @param gear gear (HIGH or LOW)
     */
    public void setGear(Gear gear) {
        if (getGear() != gear) {
            gearShift.set(gearToSolenoid(gear));
            // currentGear = gear;
        }
    }

    /**
     * Get gear.
     *
     * @see {@link com.stuypulse.frc.robot.util.GearController.Gear}
     * @return gear / state of gearshift solenoid
     */
    public Gear getGear() {
        return solenoidToGear(gearShift.get());
        // return currentGear;
    }

    /**
     * Sets left & right encoder position to zero.
     */
    public void resetEncoders() {
        lEncoder.setPosition(0);
        rEncoder.setPosition(0);
    }

    /**
     * Sets an encoder conversion factor (from motor rotations &#x2192; human usable
     * unit).
     *
     * @param conversionFactor factor to multiply encoder readings by
     */
    public void setEncoderFactor(double conversionFactor) {
        lEncoder.setPositionConversionFactor(conversionFactor);
        rEncoder.setPositionConversionFactor(conversionFactor);
    }

    /**
     * Returns the absolute max of each side of the robot's encoder values
     * multiplied by a yield constant. Each encoder value is multiplied by a yield
     * constant.
     *
     * @see {@link com.stuypulse.frc.robot.Constants.Encoders}
     * @return approximate distance
     */
    public double getDistance() {
        double lDistance = lEncoder.getPosition() * Encoders.NEO_LEFT_YIELD;
        double rDistance = rEncoder.getPosition() * Encoders.NEO_RIGHT_YIELD;

        return ((lDistance + rDistance)/2) * Encoders.NEO_YIELD;
        // return Math.max(Math.abs(lDistance), Math.abs(rDistance)) * Encoders.NEO_YIELD;
    }

    /**
     * Resets gyro.
     */
    public void resetGyro() {
        gyro.reset();
    }

    /**
     * Gets angle of the gyro in an Angle normalized between [-180, 180]
     *
     * @see {@link com.stuypulse.stuylib.math.Angle}
     * @return angle of the gyroscope
     */
    public Angle getAngle() {
        return Angle.fromDegrees(gyro.getAngle());
    }

}
