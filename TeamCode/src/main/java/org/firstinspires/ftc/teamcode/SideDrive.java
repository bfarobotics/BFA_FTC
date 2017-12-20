package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcontroller.external.samples.*;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * Created by staff on 11/29/2017.
 */
@TeleOp(name="Side Drive", group="R2D2")
public class SideDrive extends LinearOpMode {


    org.firstinspires.ftc.teamcode.First_Test_2 robot = new org.firstinspires.ftc.teamcode.First_Test_2();

    public void runOpMode() {
        double left;
        double right;
        double up;
        double away;

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello World");    //
        /*telemetry.addData("Target Power", tgtPower());
        telemetry.addData("Motor Power", motorTest.getPower());
        telemetry.addData("Distance(cm)", sensorColorRange.getDistance(DistanceUnit.CM));*/
        telemetry.addData("Status", "Running");
        telemetry.update();


        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {


            // Run wheels in tank mode (note: The joystick goes negative when pushed forwards, so negate it)
            away = gamepad2.right_stick_y;
            up = gamepad2.left_stick_y;
            left = gamepad1.left_stick_y;
            right = -gamepad1.right_stick_y;


            robot.leftFront.setPower(left);
            //  robot.leftBack.setPower(left * 0.875);
            robot.rightFront.setPower(right);
            //robot.rightBack.setPower(right * 0.875);

            if(gamepad1.a == true){
                robot.launcher.setPower(1);
            }else
            {
                robot.launcher.setPower(0);
            }


            //if (gamepad2.left_trigger == true)  {
            // robot.raise.setPosition(1);
            // }
            //else if (gamepad2.right_trigger == true)  {
            //robot.raise.setPosition(-1);
            //}
            // Move both servos to new position.

            // Send telemetry message to signify robot running;


            // Pause for 40 mS each cycle = update 25 times a second.
            sleep(40);
        }
    }
}


