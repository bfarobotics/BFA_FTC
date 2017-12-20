package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by staff on 10/4/2017.
 *
 *
 *
 *
 * INIT. FILE.
 */

public class First_Test {

    public DcMotor leftFront = null;
    public DcMotor rightFront = null;
    //public DcMotor leftBack = null;
   //public DcMotor rightBack = null;
    //public DcMotor ballUp = null;
    //public DcMotor shooter = null;
    //public DcMotor lifter = null;
    //public Servo grip = null;
    //public Servo raise = null;
    public LynxI2cColorRangeSensor colorlooker = null;

    /* Local OpMode members. */
    HardwareMap hwMap = null;
    private ElapsedTime period = new ElapsedTime();

    public void init(HardwareMap ahwMap) {
        // save reference to HW Map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftFront = hwMap.get(DcMotor.class, "left_Front");
        rightFront = hwMap.get(DcMotor.class, "right_Front");
        //leftBack = hwMap.get(DcMotor.class, "left_Back");
        //rightBack = hwMap.get(DcMotor.class, "right_Back");
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
      //  ballUp = hwMap.get(DcMotor.class, "Ball_Up");
       // shooter = hwMap.get(DcMotor.class, "Shooter");
        //lifter = hwMap.get(DcMotor.class, "Lifter");
        //grip = hwMap.get(Servo.class, "Gripper");
        //raise = hwMap.get(Servo.class, "Raiser");
        colorlooker = hwMap.get(LynxI2cColorRangeSensor.class, "Color");
        // Set all motors to zero power
        leftFront.setPower(0);
        rightFront.setPower(0);
        //leftBack.setPower(0);
        //rightBack.setPower(0);
        //ballUp.setPower(0);
        //shooter.setPower(0);
        //lifter.setPower(0);
        //grip.setPosition(0);



        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      // leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       // rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //ballUp.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //shooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //lifter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }
}
