package com.stuypulse.frc.robot.util;

import java.util.Random;

import com.stuypulse.frc.robot.Constants.kLEDController;

import edu.wpi.first.wpilibj.PWMSparkMax;

public class LEDController {

    private static final Random rn = new Random();

    // "To live is to suffer, to survive is to find some meaning in the suffering."
    public static final Mode kHotPink = new Mode(0.57);
    public static final Mode kDarkRed = new Mode(0.59);
    public static final Mode kRed = new Mode(0.61);
    public static final Mode kRedOrange = new Mode(0.63);
    public static final Mode kOrange = new Mode(0.65);
    public static final Mode kGold = new Mode(0.67);
    public static final Mode kYellow = new Mode(0.69);
    public static final Mode kLawnGreen = new Mode(0.71);
    public static final Mode kLime = new Mode(0.73);
    public static final Mode kDarkGreen = new Mode(0.75);
    public static final Mode kGreen = new Mode(0.77);
    public static final Mode kBlueGreen = new Mode(0.79);
    public static final Mode kAqua = new Mode(0.81);
    public static final Mode kSkyBlue = new Mode(0.83);
    public static final Mode kDarkBlue = new Mode(0.85);
    public static final Mode kBlue = new Mode(0.87);
    public static final Mode kBlueViolet = new Mode(0.89);
    public static final Mode kViolet = new Mode(0.91);
    public static final Mode kWhite = new Mode(0.93);
    public static final Mode kGray = new Mode(0.95);
    public static final Mode kDarkGray = new Mode(0.97);
    public static final Mode kBlack = new Mode(0.99);

    public static final Mode kHotPinkPulse = new Mode(0.57,true);
    public static final Mode kDarkRedPulse = new Mode(0.59,true);
    public static final Mode kRedPulse = new Mode(0.61,true);
    public static final Mode kRedOrangePulse = new Mode(0.63,true);
    public static final Mode kOrangePulse = new Mode(0.65,true);
    public static final Mode kGoldPulse = new Mode(0.67,true);
    public static final Mode kYellowPulse = new Mode(0.69,true);
    public static final Mode kLawnGreenPulse = new Mode(0.71,true);
    public static final Mode kLimePulse = new Mode(0.73,true);
    public static final Mode kDarkGreenPulse = new Mode(0.75,true);
    public static final Mode kGreenPulse = new Mode(0.77,true);
    public static final Mode kBlueGreenPulse = new Mode(0.79,true);
    public static final Mode kAquaPulse = new Mode(0.81,true);
    public static final Mode kSkyBluePulse = new Mode(0.83,true);
    public static final Mode kDarkBluePulse = new Mode(0.85,true);
    public static final Mode kBluePulse = new Mode(0.87,true);
    public static final Mode kBlueVioletPulse = new Mode(0.89,true);
    public static final Mode kVioletPulse = new Mode(0.91,true);
    public static final Mode kWhitePulse = new Mode(0.93,true);
    public static final Mode kGrayPulse = new Mode(0.95,true);
    public static final Mode kDarkGrayPulse = new Mode(0.97,true);
    public static final Mode kBlackPulse = new Mode(0.99,true);

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
