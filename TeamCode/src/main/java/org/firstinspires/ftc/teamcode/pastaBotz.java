package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.pastaBotzMotor.MotorType;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class pastaBotz {

    public pastaBotzMotor leftFrontMotor;
    public pastaBotzMotor leftBackMotor;
    public pastaBotzMotor rightFrontMotor;
    public pastaBotzMotor rightBackMotor;
    public pastaBotzDriveTrain driveTrain;

    public pastaBotzGyro gyro;

    public pastaBotz(HardwareMap notPastaBotzMap, Telemetry telemetry) {
        pastaBotzMap hardware = new pastaBotzMap();
        hardware.init(notPastaBotzMap);

        rightFrontMotor = new pastaBotzMotor(hardware.rightFrontMotor, MotorType.RevHDHex);
        rightBackMotor = new pastaBotzMotor(hardware.rightBackMotor, MotorType.RevHDHex);
        leftFrontMotor = new pastaBotzMotor(hardware.leftFrontMotor, MotorType.RevHDHex);
        leftBackMotor = new pastaBotzMotor(hardware.leftBackMotor, MotorType.RevHDHex);

        gyro = new pastaBotzGyro(hardware.gyro);

        driveTrain = new pastaBotzDriveTrain(leftFrontMotor, rightFrontMotor, gyro, telemetry);
    }

}
