package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
@Autonomous()
public class Hello_World extends OpMode {
    @Override
    public void init(){
        telemetry.addData("Hello", "Moto");
    }
    public void loop()  {
        //intently left blank
    }
}
