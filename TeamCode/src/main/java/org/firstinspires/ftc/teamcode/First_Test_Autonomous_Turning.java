package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


/**
 * Created by staff on 10/19/2017.
 */
@Autonomous(name ="Rotatef Left")

public class First_Test_Autonomous_Turning extends LinearOpMode {

    org.firstinspires.ftc.teamcode.First_Test robot = new org.firstinspires.ftc.teamcode.First_Test();

    public void runOpMode() throws InterruptedException {
        float hsvValues[] = {0F, 0F, 0F};


        robot.init(hardwareMap);
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello World");    //
        telemetry.update();
        final double SCALE_FACTOR = 255;
        final float values[] = hsvValues;

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        Color.RGBToHSV((int) (robot.colorlooker.red() * SCALE_FACTOR),
                (int) (robot.colorlooker.green() * SCALE_FACTOR),
                (int) (robot.colorlooker.blue() * SCALE_FACTOR),
                hsvValues);


        while (testColorRange() == false) {
            robot.leftFront.setPower(.5);
            robot.rightFront.setPower(.5);
            telemetry.addData("Alpha", robot.colorlooker.alpha());
            telemetry.addData("Red  ", robot.colorlooker.red());
            telemetry.addData("Green", robot.colorlooker.green());
            telemetry.addData("Blue ", robot.colorlooker.blue());
            telemetry.update();

        }


    }

    public boolean testColorRange() {
        if (robot.colorlooker.getDistance(DistanceUnit.CM) < 30) {
            if (robot.colorlooker.red() > robot.colorlooker.blue() + robot.colorlooker.green()) {
                return true;
            }

        }
            return false;
    }
}