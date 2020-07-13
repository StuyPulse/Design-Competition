
package main.java.frc.robot.subsystems;

import java.util.Arrays;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.stuypulse.robot.Constants.DrivetrainSettings;
import com.stuypulse.robot.Constants.Ports;
import com.stuypulse.stuylib.math.Angle;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

    //missing everything to do with gears
    //also missing tank and arcade drive
    private CANSparkMax topLeftMotor;
    private CANSparkMax middleLeftMotor;
    private CANSparkMax bottomLeftMotor;

    private CANSparkMax topRightMotor;
    private CANSparkMax middleRightMotor;
    private CANSparkMax bottomRightMotor;

    private CANEncoder leftNeo;
    private CANEncoder rightNeo;

    private SpeedControllerGroup leftMotors;
    private SpeedControllerGroup rightMotors;

    public Drivetrain() {
        topLeftMotor = new CANSparkMax(-1, MotorType.kBrushless);
        middleLeftMotor = new CANSparkMax(-1, MotorType.kBrushless);
        bottomLeftMotor = new CANSparkMax(-1, MotorType.kBrushless);

        topRightMotor = new CANSparkMax(-1, MotorType.kBrushless);
        middleRightMotor = new CANSparkMax(-1, MotorType.kBrushless);
        bottomRightMotor = new CANSparkMax(-1, MotorType.kBrushless);

        leftNeo = new CANEncoder(topLeftMotor);
        rightNeo = new CANEcoder(topRightMotor);

        leftMotors = new SpeedControllerGroup(topLeftMotor, middleLeftMotor, bottomLeftMotor);
        rightMotors = new SpeedControllerGroup(topRightMotor, middleRightMotor, bottomRightMotor);
    }

}