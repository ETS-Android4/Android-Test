package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBoard;

@TeleOp
public class Touch_Sensor_OpMode extends OpMode {
    TestBoard board = new TestBoard();
    @Override
    public void init()  {
        board.init(hardwareMap);
    }
    public  void loop() {
        telemetry.addData("Touch Sensor",board.getTouchSensorState());
    }
}
