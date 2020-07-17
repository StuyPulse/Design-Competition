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

    // All length measurments are in feet

    public interface Gamepads {    
        public static final int DRIVER = 0;
        public static final int OPERATOR = 1;
    } 
        
    public interface Drivetrain {
        public static final int LEFT_FRONT_MOTOR_PORT = -1;
        public static final int LEFT_MID_MOTOR_PORT = -1;
        public static final int LEFT_BACK_MOTOR_PORT = -1;
        public static final int RIGHT_FRONT_MOTOR_PORT = -1;
        public static final int RIGHT_MID_MOTOR_PORT = -1;
        public static final int RIGHT_BACK_MOTOR_PORT = -1;

        public static final int GEAR_SHIFT_SOLENOID_CHANNEL = -1; 

        public static final double WHEEL_DIAMETER = 0.5; 
        public static final double WHEEL_CIRCUMFERENCE = WHEEL_DIAMETER * 2 * Math.PI;
        public static final int ENCODER_TICKS_PER_ROTATION = 4096; 
        public static final double ENCODER_CONVERSION_FACTOR = WHEEL_CIRCUMFERENCE / ENCODER_TICKS_PER_ROTATION;

        // Not tested :P
        public static interface Movement {
            public static final double kp = 0.8; 
            public static final double ki = 0.0; 
            public static final double kd = 0.01;
        }

        // Not tested :P
        public static interface Turning {
            public static final double kp = 0.8; 
            public static final double ki = 0.0; 
            public static final double kd = 0.01;
        }
    }

    public interface Intake {
        public static final int MOTOR_PORT = -1;
        
        public static final double SPEED = 0.5; 
    }

    public interface Chimney {
        public static final int MOTOR_PORT = -1;

        public static final double SPEED = 0.5; 
    }

    public interface Shooter {
        public static final int LEFT_SHOOTER_MOTOR_PORT = -1;
        public static final int MID_SHOOTER_MOTOR_PORT = -1;  
        public static final int RIGHT_SHOOTER_MOTOR_PORT = -1;

        public static final int FEEDER_MOTOR_PORT = -1; 
        
        public static final double TRENCH_RPM = 300;

        public static final double FEED_SPEED = 0.8;

        // Not tested :P
        public static final double kp = 0.8; 
        public static final double ki = 0.0; 
        public static final double kd = 0.01; 
    }

    public interface Spinner {
        public static final int MOTOR_PORT = -1;
    }

    public interface Climber {
        public static final int MOTOR_PORT = -1;
    }
    
    public interface Auton {
        /* 
        naming convention:
        Distance: DISTANCE_FROM_{{start}}_TO_{{finish}}
        Angle:    ANGLE_AT_{{location}}_FROM_{{start}}_TO_{{finish}}
        
        */
        
        public static final double DISTANCE_FROM_INIT_TO_TRENCH = 10;
        public static final double ANGLE_AT_TRENCH_FROM_FORWARD_TO_RDV = 40;
    }
    
}