package com.stuypulse.frc.robot.autons;

import edu.wpi.first.wpilibj2.command.*;

public class WithTimeout extends ParallelRaceGroup {
    public WithTimeout(double secondsToTimeout, Command command) {
        addCommands(new WaitCommand(secondsToTimeout), command);
    }
}
