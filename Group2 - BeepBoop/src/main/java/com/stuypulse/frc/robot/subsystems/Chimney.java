package com.stuypulse.frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Chimney extends SubsystemBase {
  private CANSparkMax motor; 
  private CANEncoder neoEncoder; 
  
  public Chimney() {
    motor = new CANSparkMax(Constants.Chimney.MOTOR_PORT, MotorType.kBrushless); 
    neoEncoder = motor.getEncoder(); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void liftUp(double speed) {
    motor.set(speed);
  }
  
  public void liftDown(double speed) {
    liftUp(-speed); 
  }

  public void stop() {
    motor.set(0); 
  }

  public double getNeoEncoder() {
    return neoEncoder.getPosition(); 
  }

  public void resetNeoEncoder() {
    neoEncoder.setPosition(0); 
  }
}

