package com.stuypulse.frc.robot.util;


import static com.stuypulse.frc.robot.util.LEDController.*;

public class LEDThread extends Thread {

    private final LEDController controller;

    private boolean isRunning;

    public LEDThread(LEDController controller) {
        super("LEDThread");
        setPriority(Thread.MIN_PRIORITY);

        this.controller = controller;

        isRunning = true;
        start();
    }

    public boolean isRunning() {
        return isRunning();
    }

    public void close() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {

            // do some logic to change mode
            if (2 > 1) {
                controller.setMode(kPartyMode);
            }

            controller.executeMode();

        }
    }

}
