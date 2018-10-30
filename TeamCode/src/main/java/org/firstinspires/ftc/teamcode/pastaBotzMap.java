package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class pastaBotzMap {

    DcMotor leftFrontMotor;
    DcMotor leftBackMotor;
    DcMotor rightFrontMotor;
    DcMotor rightBackMotor;
    BNO055IMU gyro;
    HardwareMap pastaBotzMap;

    public pastaBotzMap(){

    }

    void init(HardwareMap notPastaBotzMap){
        this.pastaBotzMap = notPastaBotzMap;
        leftFrontMotor = pastaBotzMap.get(DcMotor.class, "Left F");
        leftBackMotor = pastaBotzMap.get(DcMotor.class, "Left B");
        rightFrontMotor = pastaBotzMap.get(DcMotor.class, "Right F");
        rightBackMotor = pastaBotzMap.get(DcMotor.class, "Right B");
        gyro = pastaBotzMap.get(BNO055IMU.class, "gyro");
    }
}
