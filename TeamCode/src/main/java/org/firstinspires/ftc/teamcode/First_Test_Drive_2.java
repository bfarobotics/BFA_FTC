package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcontroller.external.samples.*;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Locale;

/**
 * BFA ROBOTICS
 * JOE WILLS BUT MOSTLY DAVID WEINSTEIN
 * NOV. 1 2017
 *
 * This program contains a basic non-continuous servo scheme.
 *
 * For continuous servo control, set positions to 1 and 0 for different directions,
 * and .5 for no movement.
 *
 *
 * USER CONTROL.
 */
@TeleOp(name="BB9: 2 WHEELS", group="R2D2")

public class First_Test_Drive_2 extends LinearOpMode {

    ColorSensor sensorColor;
    DistanceSensor sensorDistance;

    org.firstinspires.ftc.teamcode.First_Test robot = new org.firstinspires.ftc.teamcode.First_Test();

    public void runOpMode() {
        double left;
        double right;
        double up;
        double away;


        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F, 0F, 0F};

        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;

        // sometimes it helps to multiply the raw RGB values with a scale factor
        // to amplify/attentuate the measured values.
        final double SCALE_FACTOR = 255;

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello World");    //
        /*telemetry.addData("Target Power", tgtPower());
        telemetry.addData("Motor Power", motorTest.getPower());
        telemetry.addData("Distance(cm)", sensorColorRange.getDistance(DistanceUnit.CM));*/
        telemetry.addData("Distance (cm)",
                String.format(Locale.US, "%.02f", sensorDistance.getDistance(DistanceUnit.CM)));
        telemetry.addData("Alpha", sensorColor.alpha());
        telemetry.addData("Red  ", sensorColor.red());
        telemetry.addData("Green", sensorColor.green());
        telemetry.addData("Blue ", sensorColor.blue());
        telemetry.addData("Hue", hsvValues[0]);
        telemetry.addData("Status", "Running");

        telemetry.update();



        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            robot.colorlooker.enableLed(true);
            Color.RGBToHSV((int) (sensorColor.red() * SCALE_FACTOR),
                    (int) (sensorColor.green() * SCALE_FACTOR),
                    (int) (sensorColor.blue() * SCALE_FACTOR),
                    hsvValues);

            // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
            away = gamepad2.right_stick_y;
            up = gamepad2.left_stick_y;
            left = gamepad1.left_stick_y;
            right = -gamepad1.right_stick_y;

            // leftFront and rightFront are the two wheels.  the Back wheels are not used.
            robot.leftFront.setPower(left);
            robot.rightFront.setPower(right);
            /*robot.ballUp.setPower(up);
            robot.shooter.setPower(away);
            if (gamepad2.a == true) {
                robot.lifter.setPower(up);
                robot.ballUp.setPower(0);
            }

            if (gamepad2.left_bumper == true) {
                robot.grip.setPosition(1);
            } else if (gamepad2.right_bumper == true) {
                robot.grip.setPosition(-1);
            }
*/
            // Move both servos to new position.

            // Send telemetry message to signify robot running;


            // Pause for 40 mS each cycle = update 25 times a second.
            sleep(40);
        }
    }
}


