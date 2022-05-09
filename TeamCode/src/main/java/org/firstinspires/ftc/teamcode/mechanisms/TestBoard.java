package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class TestBoard {
    private DigitalChannel Touch_Sensor1;

    public void init( HardwareMap hwMap) {
        Touch_Sensor1 = hwMap.get(DigitalChannel.class, "touch_sensor");
        Touch_Sensor1.setMode(DigitalChannel.Mode.INPUT);
    }
    public boolean getTouchSensorState()    {
        return Touch_Sensor1.getState();
    }
}
