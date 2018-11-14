package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Basic: Iterative OpMode", group="Iterative Opmode")
@Disabled
public class teleOp extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runTime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;



    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");


        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runTime.reset();
    }


    @Override
    public void loop() {
        double leftPower;
        double rightPower;


        double drive = -gamepad1.left_stick_y;
        double turn  =  gamepad1.right_stick_x;
        leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

  
        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);

        telemetry.addData("Status", "Run Time: " + runTime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
    }


    @Override
    public void stop() {
    }

}