package com.stuypulse.frc.robot.util;

import java.util.function.Consumer;
import java.util.Random;

import com.stuypulse.frc.robot.Constants.kLEDController;

import edu.wpi.first.wpilibj.PWMSparkMax;

public class LEDController {

    private static class Wait implements Consumer<LEDController> {

        private final long time;
        public Wait(long time) {
            this.time = time;
        }

        @Override
        public void accept(LEDController in) {
            try {
                Thread.sleep(time);
            } catch (Exception e) {}
        }
    }

    public static final Consumer<LEDController> kOn = x->x.on();
    public static final Consumer<LEDController> kOff = x->x.off();

    public static final Consumer<LEDController> kWait(long waitTime) {
        return new Wait(waitTime);
    }
    public static final Consumer<LEDController> kWait = kWait(500);

    public static final Consumer<LEDController> kHotPink = x->x.set(0.57);
    public static final Consumer<LEDController> kDarkRed = x->x.set(0.59);
    public static final Consumer<LEDController> kRed = x->x.set(0.61);
    public static final Consumer<LEDController> kRedOrange = x->x.set(0.63);
    public static final Consumer<LEDController> kOrange = x->x.set(0.65);
    public static final Consumer<LEDController> kGold = x->x.set(0.67);
    public static final Consumer<LEDController> kYellow = x->x.set(0.69);
    public static final Consumer<LEDController> kLawnGreen = x->x.set(0.71);
    public static final Consumer<LEDController> kLime = x->x.set(0.73);
    public static final Consumer<LEDController> kDarkGreen = x->x.set(0.75);
    public static final Consumer<LEDController> kGreen = x->x.set(0.77);
    public static final Consumer<LEDController> kBlueGreen = x->x.set(0.79);
    public static final Consumer<LEDController> kAqua = x->x.set(0.81);
    public static final Consumer<LEDController> kSkyBlue = x->x.set(0.83);
    public static final Consumer<LEDController> kDarkBlue = x->x.set(0.85);
    public static final Consumer<LEDController> kBlue = x->x.set(0.87);
    public static final Consumer<LEDController> kBlueViolet = x->x.set(0.89);
    public static final Consumer<LEDController> kViolet = x->x.set(0.91);
    public static final Consumer<LEDController> kWhite = x->x.set(0.93);
    public static final Consumer<LEDController> kGray = x->x.set(0.95);
    public static final Consumer<LEDController> kDarkGray = x->x.set(0.97);
    public static final Consumer<LEDController> kBlack = x->x.set(0.99);

    private static final Random rn = new Random();

    public static final Consumer<LEDController> kRandom = x -> {
        double min = 0.57;
        double max = 0.99;

        int limit = ((int)((max-min)*100));
        int rand = rn.nextInt(limit+1);

        x.set( min + (rand/100.0) );
    };

    public static final Consumer<LEDController> kPartyMode = kPulse(kRandom, kRandom);

    public static final Consumer<LEDController> kPulse(Consumer<LEDController> a, Consumer<LEDController> b) {
        return a.andThen(kWait).andThen(b).andThen(kWait);
    }

    public static final Consumer<LEDController> kPulse(Consumer<LEDController> a) {
        return kPulse(a, kOff);
    }

    public static final Consumer<LEDController> kPulse = kPulse(kOn, kOff);

    private final PWMSparkMax pwmController;

    private Consumer<LEDController> mode;

    public LEDController() {
        pwmController = new PWMSparkMax(kLEDController.CHANNEL);
        mode = kOff;
    }

    public Consumer<LEDController> getMode() {
        return mode;
    }

    public void setMode(Consumer<LEDController> mode) {
        if (mode == null) {
            this.mode = x -> {};
        }

        this.mode.accept(this);
    }

    public void set(double value) {
        pwmController.set(value);
    }

    public double get() {
        return pwmController.get();
    }

    public void off() {
        set(kLEDController.BLACK);
    }

    public void on() {
        set(kLEDController.WHITE);
    }

}
