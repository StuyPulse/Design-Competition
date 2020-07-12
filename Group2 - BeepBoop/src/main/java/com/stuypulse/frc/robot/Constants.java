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
    }

    public interface Intake {
        public static final int MOTOR_PORT = -1;
        
        public static final double SPEED = 0.5; 
    }

    public interface Chimney {
        public static final int MOTOR_PORT = -1;

        public static final double SPEED = 0.5; 
    }

    public interface Spinner {
        public static final int MOTOR_PORT = -1;
    }

    public interface Climber {
        public static final int MOTOR_PORT = -1;
    }
    
}