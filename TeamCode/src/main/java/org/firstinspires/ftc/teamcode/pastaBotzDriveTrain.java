package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class pastaBotzDriveTrain {

    public pastaBotzMotor leftFrontMotor;
    public pastaBotzMotor rightFrontMotor;
    private static final float MAX_SPEED = .5f;
    private static final float MIN_SPEED = -.5f;
    private float P;
    private Telemetry telemetry;
    private boolean lastHeadingButton = false;
    private double lastHeading = 0;
    public pastaBotzGyro gyro;

    public pastaBotzDriveTrain(pastaBotzMotor leftFrontMotor, pastaBotzMotor rightFrontMotor, pastaBotzGyro gyro, Telemetry telemetry){
        this.rightFrontMotor = rightFrontMotor;
        this.leftFrontMotor = leftFrontMotor;
        this.gyro = gyro;
        this.telemetry = telemetry;
        this.P = 0.001f;
    }

    public void drive(float gamePad1LeftY, float gamePad1LeftX, float gamePad1RightX, boolean holdHeading){
        float turn = gamePad1RightX;
        if(!lastHeadingButton && holdHeading){
            lastHeading = gyro.getAngle();
        }

        telemetry.addData("Gyro Angle", gyro.getAngle());

        if(holdHeading){
            turn = (float)(gyro.getAngle() -lastHeading) * P;
            telemetry.addData("Desired Angle" , lastHeading);
        }

        telemetry.addData("Turn Magnitude" , turn);

        driveHelper(gamePad1LeftX, gamePad1LeftY, turn);
        lastHeadingButton = holdHeading;

    }

    private void driveHelper(float gamePad1LeftX, float gamePad1LeftY, float turnMagnitude){
        float lfPow = gamePad1LeftY + gamePad1LeftX - turnMagnitude;
        float lbPow = gamePad1LeftY - gamePad1LeftX - turnMagnitude;
        float rfPow = -gamePad1LeftY + gamePad1LeftX - turnMagnitude;
        float rbPow = -gamePad1LeftY - gamePad1LeftX - turnMagnitude;
        rfPow = Range.clip(rfPow*MAX_SPEED, MIN_SPEED, MAX_SPEED);
        lfPow = Range.clip(lfPow*MAX_SPEED, MIN_SPEED, MAX_SPEED);
        lbPow = Range.clip(lbPow*MAX_SPEED, MIN_SPEED, MAX_SPEED);
        rbPow = Range.clip(rbPow*MAX_SPEED, MIN_SPEED, MAX_SPEED);

        leftFrontMotor.setPower(lfPow);
        //leftBackDrive.setPower(lbPow);
        rightFrontMotor.setPower(rfPow);
       // rightBackDrive.setPower(rbPow);
    }
}
