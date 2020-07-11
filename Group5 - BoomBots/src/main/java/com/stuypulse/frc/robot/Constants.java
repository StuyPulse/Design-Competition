/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public interface Constants {

    public interface Ports {

        public interface Shooter {
            int FEEDER_PORT = -1;
            int SHOOTER_TOP_PORT = -1;
            int SHOOTER_BOTTOM_PORT = -1;

            int SHOOTER_TARGET_VELOCITY = -1;
            double FEEDER_FEED_CONSTANT = 1.0;
        }

        public interface Intake {
            int INTAKE_MOTOR_PORT = -1;
            int INTAKE_SOLENOID_CHANNEL_A = -1;
            int INTAKE_SOLENOID_CHANNEL_B = -1;
            int INTAKE_SENSOR_PORT = -1;

            double INTAKE_MOTOR_ACQUIRE_SPEED = 1.0;
        }

        public interface Climber {
            int CLIMBER_LEFT_MOTOR_PORT = -1;
            int CLIMBER_RIGHT_MOTOR_PORT = -1;

            double CLIMBER_LIFT_UP_SPEED = 1.0;
            double CLIMBER_LIFT_DOWN_SPEED = -1.0;
        }

        public interface Gamepad {
            int DRIVER_PORT = 0;
            int OPERATOR_PORT = 1;
        }
        
    }

}

