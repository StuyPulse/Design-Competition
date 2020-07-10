package src.main.java.com.stuypulse.frc.robot.util;

import java.util.function.Consumer;

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
        Consumer<LEDController> controllerMode;

        while (isRunning) {

            // do some logic to change the mode

            /*

            controller.setMode(Consumer<> mode) {

                this.mode = mode;


                this.mode.execute(this) ???
            }

            or do you execute it at the bottom of this loop

            */
            if ((controllerMode = controller.getMode()) != null) {
                controllerMode.accept(controller);
            }
        }
    }

}
