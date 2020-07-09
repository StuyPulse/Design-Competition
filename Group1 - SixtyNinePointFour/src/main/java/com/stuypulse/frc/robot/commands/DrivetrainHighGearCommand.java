/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot.commands;

import com.stuypulse.frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * An example command that uses an example subsystem.
 */
public class DrivetrainHighGearCommand extends InstantCommand {
    private final Drivetrain drivetrain;

    public DrivetrainHighGearCommand(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        drivetrain.setHighGear();
    }

}
