package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.mechanisms.Mecanum_Drive;

import java.sql.Driver;

@TeleOp()
public class mecanumTest extends OpMode{
    Mecanum_Drive Drive = new Mecanum_Drive();
    @Override
    public void init()  {
        Drive.init();
    }
    public void loop()  {
        Drive.mecanumDrive();
    }
}

