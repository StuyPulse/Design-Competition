/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot; //ah i have found my prioblem

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public interface Constants {

    //
    public interface Ports {
    //Drivetrain Subsystem
    int DRIVETRAIN_TOP_LEFT_MOTOR = -1;
    int DRIVETRAIN_TOP_RIGHT_MOTOR = -1;
    int DRIVETRAIN_MIDDLE_LEFT_MOTOR = -1;
    int DRIVETRAIN_MIDDLE_RIGHT_MOTOR = -1;
    int DRIVETRAIN_BOTTOM_LEFT_MOTOR = -1;
    int DRIVETRAIN_BOTTOM_RIGHT_MOTOR = -1;
    //intake subsystem
    int INTAKE_SOLENOID_FIRST_CHANNEL = -1;
    int INTAKE_SOLENOID_SECOND_CHANNEL = -1;

    int INTAKE_MOTOR = -1;

    int INTAKE_BUTTON = -1;
    //Climber subsystem
    int CLIMBER_LEFT_MOTOR = -1;
    int CLIMBER_RIGHT_MOTOR = -1;
    //Conveyor subsystem
    int CONVEYOR_MOTOR = -1;
    //Indexer Subsystem
    int INDEXER_MOTOR = -1;
    }
    
//what in the world are interface
}
