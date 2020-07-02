package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants.Ports;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    
    public static enum Gear {
        HIGH, LOW
    }

    private CANSparkMax topLeft;
    private CANSparkMax middleLeft;
    private CANSparkMax bottomLeft;
    private CANSparkMax topRight;
    private CANSparkMax middleRight;
    private CANSparkMax bottomRight;

    private SpeedControllerGroup leftMotors;
    private SpeedControllerGroup rightMotors;

    private Gear gear;
    private Solenoid gearShift;

    private DifferentialDrive highGear;
    private DifferentialDrive lowGear;

    public Drivetrain() {

        topLeft = new CANSparkMax(Ports.Drivetrain.TOP_LEFT_MOTOR_PORT, MotorType.kBrushless);
        middleLeft = new CANSparkMax(Ports.Drivetrain.MIDDLE_LEFT_MOTOR_PORT, MotorType.kBrushless);
        bottomLeft = new CANSparkMax(Ports.Drivetrain.BOTTOM_LEFT_MOTOR_PORT, MotorType.kBrushless);
        topRight = new CANSparkMax(Ports.Drivetrain.TOP_RIGHT_MOTOR_PORT, MotorType.kBrushless);
        middleRight = new CANSparkMax(Ports.Drivetrain.MIDDLE_RIGHT_MOTOR_PORT, MotorType.kBrushless);
        bottomRight = new CANSparkMax(Ports.Drivetrain.BOTTOM_RIGHT_MOTOR_PORT, MotorType.kBrushless);
         
        gearShift = new Solenoid(Ports.Drivetrain.GEAR_SHIFT_PORT);
         
        topLeft.setIdleMode(IdleMode.kCoast);
        middleLeft.setIdleMode(IdleMode.kCoast);
        bottomLeft.setIdleMode(IdleMode.kCoast);
        topRight.setIdleMode(IdleMode.kCoast);
        middleRight.setIdleMode(IdleMode.kCoast);
        bottomRight.setIdleMode(IdleMode.kCoast);
        
        leftMotors = new SpeedControllerGroup(topLeft, middleLeft, bottomLeft);
        rightMotors = new SpeedControllerGroup(topRight, middleRight, bottomRight);
         
        highGear = new DifferentialDrive(leftMotors, rightMotors);
        lowGear = highGear;

     }

    public DifferentialDrive getCurrentDrive() {
        if (gear == Gear.HIGH)
            return highGear; 
        return lowGear;
    }

    public void tankDrive(double left, double right) {
        getCurrentDrive().tankDrive(left, right);
    }

    public void stop() {
        tankDrive(0, 0);
    }

    public void setGear(Gear gear) {
        if (this.gear != gear) {
            this.gear = gear;
            gearShift.set(this.gear == Gear.HIGH);
        } 
    }

    public void setHighGear() {
        setGear(Gear.HIGH);
    }

    public void setLowGear() {
        setGear(Gear.LOW);
    }
}