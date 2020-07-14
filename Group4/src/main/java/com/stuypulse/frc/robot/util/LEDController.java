package com.stuypulse.frc.robot.util;

import java.util.Random;

import com.stuypulse.frc.robot.Constants.kLEDController;

import edu.wpi.first.wpilibj.PWMSparkMax;

public class LEDController {

    private static final Random rn = new Random();

    public static final Mode kWhite = new Mode(0.93);
    public static final Mode kBlack = new Mode(0.99);

    public static final Mode kPulse = new Mode(0.93,true);
    public static final Mode kRandom = new Mode();
    public static final Mode kParty = new Mode(true);

    public static class Mode {

        private final double value;

        private final boolean pulse;
        private final boolean isRandom;

        /**
         * Create a mode by explcitily setting each variable.
         *
         * @param value value to set LED controller
         * @param pulse whether or not to pulse before ending
         * @param isRandom should generate random value (ignore given value)
         */
        private Mode(double value, boolean pulse, boolean isRandom) {
            this.value = value;
            this.pulse = pulse;
            this.isRandom = isRandom;
        }

        /**
         * Create non-random mode that sets to a given value.
         *
         * @param value value
         * @param pulse should pulse
         */
        public Mode(double value, boolean pulse) {
            this(value, pulse, false);
        }

        /**
         * Creates a non-random, non-pulsing mode.
         *
         * @param value value
         */
        public Mode(double value) {
            this(value, false);
        }

        /**
         * Creates a random generating mode.
         *
         * @param pulse
         */
        public Mode(boolean pulse) {
            this(0.0, pulse, true);
        }

        /**
         * Creates a random generating, non-pulsing mode.
         */
        public Mode() {
            this(false);
        }

    }

    private final static double getRandomValue() {
        double min = 0.57;
        double max = 0.99;

        int limit = ((int)((max-min)*100));
        int rand = rn.nextInt(limit+1);

        return ( min + (rand/100.0) );
    }

    private final PWMSparkMax pwmController;
    private Mode currentMode;

    public LEDController() {
        pwmController = new PWMSparkMax(kLEDController.CHANNEL);
        currentMode = kBlack;
    }

    public void setMode(Mode newMode) {
        this.currentMode = newMode;
    }

    public Mode getMode() {
        return currentMode;
    }

    public void executeMode() {

        double value = currentMode.isRandom ? getRandomValue() : currentMode.value;

        set(value);

        if (currentMode.pulse) {

            try {
                Thread.sleep(kLEDController.WAIT_TIME);
            } catch (Exception e) { }

            off();

            try {
                Thread.sleep(kLEDController.WAIT_TIME);
            } catch (Exception e) { }

            set(value);

        }

    }

    private void set(double value) {
        pwmController.set(value);
    }

    private double get() {
        return pwmController.get();
    }

    private void off() {
        set(0.99);
    }

    private void on() {
        set(0.93);
    }

}
