package org.firstinspires.ftc.teamcode.mechanisms;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
public class TestBoard {
    private DigitalChannel TS1;

    public void init(HardwareMap hwMap) {
        TS1 = hwMap.get(DigitalChannel.class, "TS1");
        TS1.setMode(DigitalChannel.Mode.INPUT);
    }
    public boolean getTouchSensorState()    {
        return TS1.getState();
    }
}
