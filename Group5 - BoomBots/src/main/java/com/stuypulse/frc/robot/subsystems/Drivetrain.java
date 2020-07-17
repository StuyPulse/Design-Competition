package com.stuypulse.frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants;
import com.stuypulse.stuylib.math.Angle;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

    public static enum Gear {
        HIGH, LOW
    };

    private CANSparkMax topLeftMotor;
    private CANSparkMax middleLeftMotor;
    private CANSparkMax bottomLeftMotor;

    private CANSparkMax topRightMotor;
    private CANSparkMax middleRightMotor;
    private CANSparkMax bottomRightMotor;

    private CANEncoder leftNEO;
    private CANEncoder rightNEO;

    private SpeedControllerGroup leftMotors;
    private SpeedControllerGroup rightMotors;

    private Gear gear;
    private Solenoid gearShift;

    // only have one
    private DifferentialDrive highGearDrive;
    private DifferentialDrive lowGearDrive;

    private AHRS navx;

    public Drivetrain() {
        topLeftMotor = new CANSparkMax(Constants.Drivetrain.DRIVETRAIN_TOP_LEFT_MOTOR_PORT, MotorType.kBrushless);
        middleLeftMotor = new CANSparkMax(Constants.Drivetrain.DRIVETRAIN_MIDDLE_LEFT_MOTOR_PORT, MotorType.kBrushless);
        bottomLeftMotor = new CANSparkMax(Constants.Drivetrain.DRIVETRAIN_BOTTOM_LEFT_MOTOR_PORT, MotorType.kBrushless);

        topRightMotor = new CANSparkMax(Constants.Drivetrain.DRIVETRAIN_TOP_RIGHT_MOTOR_PORT, MotorType.kBrushless);
        middleRightMotor = new CANSparkMax(Constants.Drivetrain.DRIVETRAIN_MIDDLE_RIGHT_MOTOR_PORT, MotorType.kBrushless);
        bottomRightMotor = new CANSparkMax(Constants.Drivetrain.DRIVETRAIN_BOTTOM_RIGHT_MOTOR_PORT, MotorType.kBrushless);

        leftNEO = new CANEncoder(topLeftMotor);
        rightNEO = new CANEncoder(topRightMotor);

        leftMotors = new SpeedControllerGroup(topLeftMotor, middleLeftMotor, bottomLeftMotor);
        rightMotors = new SpeedControllerGroup(topRightMotor, middleRightMotor, bottomRightMotor);

        navx = new AHRS(Port.kMXP);
    }

    public Gear getGear(Gear gear) {
        return gear;
    }

    public void setGear(Gear gear) {
        if (this.gear != gear) {
            this.gear = gear;
            gearShift.set(this.gear == Gear.HIGH);
        }
    }

    public DifferentialDrive getCurrentDrive() {
        if (gear == Gear.HIGH) {
            return highGearDrive;
        } else {
            return lowGearDrive;
        }
    }
    
    public double getLeftEncoderDistance() {
        return leftNEO.getPosition();
    }
    
    public double getRightEncoderDistance() {
        return rightNEO.getPosition();
    }
    
    public double getDistance() {
        return Math.abs(Math.max(getLeftEncoderDistance(), getRightEncoderDistance()));
    }

    public AHRS getNavX() {
        return navx;
    }
      
    public Angle getGyroAngle() {
        return Angle.degrees(navx.getAngle());
    }

    public void drive() {
        leftMotors.set(1.0);
        rightMotors.set(1.0);
    }

    public void turn(double angle) {
        arcadeDrive(0, angle);
    }

    public void stop() {
        getCurrentDrive().tankDrive(0,0);
    }

    public void tankDrive(double left, double right) {
        getCurrentDrive().tankDrive(left, right);
    }

    public void arcadeDrive(double speed, double rotation) {
        getCurrentDrive().arcadeDrive(speed, rotation);
    }

}