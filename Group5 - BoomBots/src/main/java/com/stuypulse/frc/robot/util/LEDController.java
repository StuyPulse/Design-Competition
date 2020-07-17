package com.stuypulse.frc.robot.util;

import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.Timer;

public class LEDController {

    private PWMSparkMax controller;

    public LEDController(int port) {
        controller = new PWMSparkMax(port);
    }

    public void setValue(double value) {
        controller.set(value);
    }

    public void setSolidWhite() {
        setValue(0.93);
    }

    public void setSolidPink() {
        setValue(0.57);
    }

    public void setSolidRed() {
        setValue(0.61);
    }

    public void setWhitePulse() {
        setValue(0.61);
        Timer.delay(0.5);
        setValue(0.99);
        Timer.delay(0.1);
    }

    public void setPinkPulse() {
        setValue(0.57);
        Timer.delay(0.5);
        setValue(0.99);
        Timer.delay(0.1);
    }

    public void setRedPulse() {
        setValue(0.61);
        Timer.delay(0.5);
        setValue(0.99);
        Timer.delay(0.1);
    }

    public void setSolidYellow() {
        setValue(0.69);
    }

    public void setLimeFlash() {
        setValue(0.73);
        Timer.delay(0.5);
        setValue(0.99);
    }

    public void setBlueFlash() {
        setValue(0.87);
        Timer.delay(0.5);
        setValue(0.99);
    }

    public void turnOff() {
        setValue(0.99);
    }
    
}