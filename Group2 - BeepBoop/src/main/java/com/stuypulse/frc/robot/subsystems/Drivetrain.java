package com.stuypulse.frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Drivetrain extends SubsystemBase {
    private static final boolean HIGH_GEAR = false; 
    private static final boolean LOW_GEAR = true;

    private CANSparkMax leftFrontMotor;
    private CANSparkMax leftMidMotor;
    private CANSparkMax leftBackMotor;
    
    private CANSparkMax rightFrontMotor;
    private CANSparkMax rightMidMotor;
    private CANSparkMax rightBackMotor;

    private SpeedControllerGroup leftMotors;
    private SpeedControllerGroup rightMotors;

    private DifferentialDrive differentialDrive;

    private CANEncoder leftNEOEncoder;
    private CANEncoder rightNEOEncoder;

    private AHRS gyro;

    private Solenoid gearShift;
 
    public Drivetrain() {
        leftFrontMotor = new CANSparkMax(Constants.Ports.Drivetrain.LEFT_FRONT, MotorType.kBrushless);
        leftMidMotor = new CANSparkMax(Constants.Ports.Drivetrain.LEFT_MID, MotorType.kBrushless);
        leftBackMotor = new CANSparkMax(Constants.Ports.Drivetrain.LEFT_BACK, MotorType.kBrushless);

        rightFrontMotor = new CANSparkMax(Constants.Ports.Drivetrain.RIGHT_FRONT, MotorType.kBrushless);
        rightMidMotor = new CANSparkMax(Constants.Ports.Drivetrain.RIGHT_MID, MotorType.kBrushless);
        rightBackMotor = new CANSparkMax(Constants.Ports.Drivetrain.RIGHT_BACK, MotorType.kBrushless);

        leftMotors = new SpeedControllerGroup(leftFrontMotor, leftMidMotor, leftBackMotor);
        rightMotors = new SpeedControllerGroup(rightFrontMotor, rightMidMotor, rightBackMotor); 

        differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

        leftNEOEncoder = leftFrontMotor.getEncoder(); 
        rightNEOEncoder = rightFrontMotor.getEncoder();
        
        gyro = new AHRS(SPI.Port.kMXP);

        gearShift = new Solenoid(Constants.Ports.Drivetrain.GEAR_SHIFT);
    }

    public void tankDrive(double left, double right) {
        differentialDrive.tankDrive(left, right);
    }

    public void stop() {
        tankDrive(0, 0);
    }
    
    public void arcadeDrive(double speed, double rotation) {
        differentialDrive.arcadeDrive(speed, rotation);
    }

    public void curvatureDrive(double speed, double rotation) {
        differentialDrive.curvatureDrive(speed, rotation, false);
    }

    public double getAngle() { 
        // TODO: wait on engineering
        return gyro.getAngle(); 
    }

    public void resetGyro() {
        gyro.reset();
    }

    public double getRawLeftNEOEncoderPosition() {
        return leftNEOEncoder.getPosition();
    }

    public double getRawRightNEOEncoderPosition() {
        return rightNEOEncoder.getPosition();
    }

    public void resetNEOEncoders() {
        leftNEOEncoder.setPosition(0);
        rightNEOEncoder.setPosition(0);
    }

    public void setHighGear() {
        gearShift.set(HIGH_GEAR); 
    }

    public void setLowGear() {
        gearShift.set(LOW_GEAR);
    }
}