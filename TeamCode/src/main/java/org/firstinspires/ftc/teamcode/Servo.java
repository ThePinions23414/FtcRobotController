package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
#Please add comments when coding
@TeleOp(name = "Servo")
public class Servo extends LinearOpMode {
    private CRServo servo;

    @Override
    public void runOpMode() throws InterruptedException {
        String ColorStatus;
       CRServo servo = hardwareMap.get(CRServo.class,"servo");
        ColorSensor ColorSensor = hardwareMap.get(ColorSensor.class, "ColorSensor");
       waitForStart();
       if (opModeIsActive()) {
           while (opModeIsActive()) {
               servo.setPower(.25);
               while ((ColorSensor.green() > 200)) {
                   servo.setPower(0);
               }
               if (ColorSensor.green() < ColorSensor.blue()) {
                   ColorStatus = "Purple";
               } else {
                   ColorStatus = "Green";
               }
               telemetry.addData("green", ColorSensor.green());
               telemetry.addData("blue", ColorSensor.blue());
               telemetry.addData("ColorStatus", ColorStatus);
               telemetry.update();
           }
       }
    }
}