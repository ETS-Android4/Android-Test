package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Mecanum_Drive {
    private DcMotor FR,FL,BR,BL;
    double fwdBackPower, strafePower, turnPower, maxPower;
    double FRP, FLP, BRP, BLP;
    private LinearOpMode OpModeReference;
    private HardwareMap hwMap;
    public void Mecanum_Drive(LinearOpMode opModeRef) {
        OpModeReference = opModeRef;
        hwMap = OpModeReference.hardwareMap;
    }

    public void init()  {
        //Init Motors
       FR = LinearOpMode.get(DcMotor.class, "FR");
        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       FL = LinearOpMode.get(DcMotor.class, "FL");
        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       BR = LinearOpMode.get(DcMotor.class, "BR");
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       BL = LinearOpMode.get(DcMotor.class, "BL");
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

       //Reverse motor Direction

        //FR.setDirection(DcMotor.Direction.REVERSE);
        FL.setDirection(DcMotor.Direction.REVERSE);
        //BR.setDirection(DcMotor.Direction.REVERSE);
        BL.setDirection(DcMotor.Direction.REVERSE);
    }
    public void mecanumDrive(){
        double FWD,strafe,turn;
       FWD = -OpModeReference.gamepad1.left_stick_y;
       strafe = OpModeReference.gamepad1.left_stick_x;
       turn = OpModeReference.gamepad1.right_stick_x;
        mecanumDriveWithInputs(FWD,strafe,turn);
    }
    public void mecanumDriveWithInputs(double fwdBack, double strafe, double turn)    {
        //Define Variables
        fwdBackPower = fwdBack;
        strafePower = strafe;
        turnPower = turn;

        FRP = fwdBackPower-turnPower-strafePower;
        FLP = fwdBackPower+turnPower+strafePower;
        BRP = fwdBackPower-turnPower+strafePower;
        BLP = fwdBackPower+turnPower-strafePower;
        maxPower = Math.abs(FLP);
        if(Math.abs(FRP)> maxPower)  {maxPower=Math.abs(FRP);}
        if(Math.abs(BRP)> maxPower)  {maxPower=Math.abs(BRP);}
        if(Math.abs(BLP)> maxPower)  {maxPower=Math.abs(BLP);}
        if (maxPower > 1)   {
            FRP = FRP/maxPower;
            FLP = FLP/maxPower;
            BRP = BRP/maxPower;
            BLP = BLP/maxPower;
            OpModeReference.telemetry.addData("powers", "|%.3f|%.3f|%.3f|%.3f|", FRP,FLP,BRP,BLP);
            OpModeReference.telemetry.update();
            FR.setPower(FRP);
            FL.setPower(FLP);
            BR.setPower(BRP);
            BL.setPower(BLP);
        }
    }
}
