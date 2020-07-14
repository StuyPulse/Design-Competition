/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.subsystems.Shooter;
import com.stuypulse.stuylib.control.PIDController;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterAchieveSpeedCommand extends CommandBase {
  private final double TOLERANCE = 5; 

  private Shooter shooter;
  private double targetRPM;
  private PIDController controller;  
   
  public ShooterAchieveSpeedCommand(Shooter shooter, double targetRPM) {
    this.shooter = shooter; 
    this.targetRPM = targetRPM;
    addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    controller = new PIDController(
      Constants.Shooter.kp,
      Constants.Shooter.ki, 
      Constants.Shooter.kd
    );
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double error = targetRPM - shooter.getMedianShooterRPM();
    double out = controller.update(error); 
    double volts = shooter.getShooterVoltage() + out; 
    shooter.setShooterVoltage(volts);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return controller.isDone(TOLERANCE); 
  }
}
