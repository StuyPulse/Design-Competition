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
        public interface Gamepads {    
            public static final int DRIVER = 0;
            public static final int OPERATOR = 1;
        } 
        
        public interface Drivetrain {
            public static final int LEFT_FRONT = -1;
            public static final int LEFT_MID = -1;
            public static final int LEFT_BACK = -1;
            public static final int RIGHT_FRONT = -1;
            public static final int RIGHT_MID = -1;
            public static final int RIGHT_BACK = -1;

            public static final int GEAR_SHIFT = -1; 
        }
    }

}
