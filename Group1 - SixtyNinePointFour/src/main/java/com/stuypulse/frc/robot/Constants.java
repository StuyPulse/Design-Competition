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
    
        public interface Drivetrain {
            int DRIVETRAIN_TOP_LEFT_MOTOR = -1;
            int DRIVETRAIN_TOP_RIGHT_MOTOR = -1;
            int DRIVETRAIN_MIDDLE_LEFT_MOTOR = -1;
            int DRIVETRAIN_MIDDLE_RIGHT_MOTOR = -1;
            int DRIVETRAIN_BOTTOM_LEFT_MOTOR = -1;
            int DRIVETRAIN_BOTTOM_RIGHT_MOTOR = -1;

            int LEFT_GEAR_SHIFT = -1;
            int RIGHT_GEAR_SHIFT = -1;
        }

        public interface Intake {
            int LEFT_INTAKE_SOLENOID_A = -1;
            int LEFT_INTAKE_SOLENOID_B = -1;

            int RIGHT_INTAKE_SOLENOID_A = -1;
            int RIGHT_INTAKE_SOLENOID_B = -1;

            int INTAKE_MOTOR = -1;

            int INTAKE_BUTTON = -1;
        }
    
        public interface Climber {
            int CLIMBER_LEFT_MOTOR = -1;
            int CLIMBER_RIGHT_MOTOR = -1;
        }

        public interface Conveyor {
            int CONVEYOR_MOTOR = -1;
        }

        public interface Indexer {
            int INDEXER_MOTOR = -1;
        }

        public interface Shooter {
            int LEFT_FEEDER = -1;
            int RIGHT_FEEDER = -1;
            int LEFT_SHOOTER = -1;
            int RIGHT_SHOOTER = -1;
        }

        public interface Gamepad{
            int DRIVER = -1;
            int OPERATOR = -1;
        }
    
    }

    public interface DrivetrainMovement{
        double P = -1;
        double I = 0;
        double D = -1;
        double MOVEMENT_ERROR = 0.01;
    }

    public interface DrivetrainTurn{
        double P = -1;
        double I = 0;
        double D = -1;
        double TURNING_ERROR = 0.01;
    }
}
