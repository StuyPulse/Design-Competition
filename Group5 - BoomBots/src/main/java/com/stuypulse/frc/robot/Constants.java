/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.stuypulse.frc.robot;

import edu.wpi.first.wpilibj.SPI.Port;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public interface Constants {

        public interface Shooter {
            int FEEDER_PORT = -1;
            int SHOOTER_TOP_PORT = -1;
            int SHOOTER_BOTTOM_PORT = -1;

            double SHOOTER_TARGET_VELOCITY = -1.0;
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

        public interface Drivetrain {
            int DRIVETRAIN_TOP_LEFT_MOTOR_PORT = -1;
            int DRIVETRAIN_MIDDLE_LEFT_MOTOR_PORT = -1;
            int DRIVETRAIN_BOTTOM_LEFT_MOTOR_PORT = -1;

            int DRIVETRAIN_TOP_RIGHT_MOTOR_PORT = -1;
            int DRIVETRAIN_MIDDLE_RIGHT_MOTOR_PORT = -1;
            int DRIVETRAIN_BOTTOM_RIGHT_MOTOR_PORT = -1;

            int DRIVETRAIN_GYRO_PORT = -1;

            double DRIVETRAIN_P = 0.0;
            double DRIVETRAIN_I = 0.0;
            double DRIVETRAIN_D = 0.0;

            double DRIVETRAIN_TURNING_ERROR_TOLERANCE = 0.01;
        }

        public interface Measurements {
            double SHOOT_FROM_START_TO_GOAL = 10;
            double ANGLE_FROM_START_TO_TRENCH = 37.7;
            double DISTANCE_FROM_BALL_TO_BALL = 36;
            double ANGLE_FROM_TRENCH_TO_RDVS = 125.88;
            double DISTANCE_FROM_TRENCH_TO_RDVS = 109.85;
            double ANGLE_FROM_RDVS_TO_TWO_BALL = 25;
            double DISTANCE_BETWEEN_TWO_BALL = 16.57;
            double DISTANCE_FROM_RDVS_TO_INTERSECTION_BEWTWEEN_TWO_BALL_AND_GOAL = 40;
        }

        public interface Gamepad {
            int DRIVER_PORT = 0;
            int OPERATOR_PORT = 1;
        }

}

