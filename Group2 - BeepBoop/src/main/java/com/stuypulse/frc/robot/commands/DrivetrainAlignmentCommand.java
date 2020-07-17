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
import com.stuypulse.stuylib.network.limelight.Limelight;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainAlignmentCommand extends CommandBase {
  private final double TOLERANCE = 2; 

  private Drivetrain drivetrain; 
  private PIDController controller;

  public DrivetrainAlignmentCommand(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    controller = new PIDController(
      Constants.Drivetrain.Turning.kp, 
      Constants.Drivetrain.Turning.ki,
      Constants.Drivetrain.Turning.kd
    );
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double error = Limelight.getTargetXAngle();
    double turn = controller.update(error); 
    drivetrain.arcadeDrive(0, turn);
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
