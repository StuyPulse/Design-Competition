/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.Constants;
import com.stuypulse.frc.robot.subsystems.Drivetrain;
import com.stuypulse.stuylib.control.PIDController;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainMoveDistanceCommand extends CommandBase {
  private final double TOLERANCE = 0.1; 
  
  private Drivetrain drivetrain;
  private PIDController controller;
  private double initialDistance; 
  private double targetDistance;
  
  public DrivetrainMoveDistanceCommand(Drivetrain drivetrain, double targetDistance) {
    this.drivetrain = drivetrain;
    this.targetDistance = targetDistance;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    controller = new PIDController(
      Constants.Drivetrain.Movement.kp,
      Constants.Drivetrain.Movement.ki,
      Constants.Drivetrain.Movement.kd
    );
    initialDistance = drivetrain.getEncoderPosition(); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double distance = drivetrain.getEncoderPosition() - initialDistance; 
    double error = targetDistance - distance;
    double speed = controller.update(error);
    drivetrain.arcadeDrive(speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop(); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return controller.isDone(TOLERANCE);
  }
}
