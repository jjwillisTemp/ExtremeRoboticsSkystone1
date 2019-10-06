package org.firstinspires.ftc.teamcode;
//package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Extreme Robotics 2019
 */

public class Robot
{
    // Hardware map & op mode
    HardwareMap hwMap;
    LinearOpMode opMode;
    double drivePower = 0.9;
    // Variables for Encoder driving
    static final double COUNTS_PER_MOTOR_REV = 1120;    // eg: Andy Mark Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 2.0;     // This is < 1.0 if geared UP
    static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    private ElapsedTime runtime = new ElapsedTime();

    //Robot wheels
    DcMotor rightFrontMotor;
    DcMotor leftFrontMotor;
    DcMotor rightBackMotor;
    DcMotor leftBackMotor;

    Servo testRightServo;
    Servo testLeftServo;




    double[] paramA = {0, 1, -1};

    public void init(HardwareMap ProtohwMap, LinearOpMode linearOpMode)
    {
        hwMap = ProtohwMap;
        opMode = linearOpMode;

        // Wheels
        leftFrontMotor = hwMap.dcMotor.get("leftFrontMotor");
        leftBackMotor = hwMap.dcMotor.get("leftBackMotor");
        rightFrontMotor = hwMap.dcMotor.get("rightFrontMotor");
        rightBackMotor = hwMap.dcMotor.get("rightBackMotor");
        testRightServo = hwMap.servo.get("testRightServo");
        testLeftServo = hwMap.servo.get("testLeftServo");
        leftFrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBackMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Arm
      /*  actuatorMotor = hwMap.dcMotor.get("actuatorMotor");
        omniMotor = hwMap.dcMotor.get("omniMotor");
        cascadingMotor = hwMap.dcMotor.get("cascadingMotor");
        bootMotor = hwMap.dcMotor.get("bootMotor");
        sideServo = hwMap.servo.get("sideServo");
        sweepServo = hwMap.servo.get("sweepServo");
        lockBackServo = hwMap.servo.get("lockBackServo");
        lockFrontServo = hwMap.servo.get("lockFrontServo");
        */
        // Lift
        //liftMotor = hwMap.dcMotor.get("liftMotor");
    }

    public void WaitMillis(long millis)
    {
        try
        {
            Thread.sleep(millis);
        } catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    // drive without encoder. drive based on time.
    public void drive(double leftFront, double rightFront, double leftBack, double rightBack, long millis)
    {
        leftFrontMotor.setPower(leftFront);
        rightFrontMotor.setPower(rightFront);
        leftBackMotor.setPower(leftBack);
        rightBackMotor.setPower(rightBack);
        WaitMillis(millis);
    }

    //OMNI METHODS

    // Drive forward without encoder. drive based on time.
    //CORRECTTTTTTT
    public void OdriveForward(double power, long millis)
    {
        leftFrontMotor.setPower(paramA[1] * power);
        rightFrontMotor.setPower(paramA[1] * power);
        leftBackMotor.setPower(paramA[1] * power);
        rightBackMotor.setPower(paramA[1] * power);
        WaitMillis(millis);
    }

    // Drive backward without encoder. drive based on time.
    //CORRECTTTTT
    public void OdriveBackwards(double power, long millis)
    {
        leftFrontMotor.setPower(paramA[2] * power);
        rightFrontMotor.setPower(paramA[2] * power);
        leftBackMotor.setPower(paramA[2] * power);
        rightBackMotor.setPower(paramA[2] * power);
        WaitMillis(millis);
    }

    // Crab left without encoder. drive based on time.
    //EDITED
    public void OdriveLeft(double power, long millis)
    {
        leftFrontMotor.setPower(paramA[2] * power);
        leftBackMotor.setPower(paramA[1] * power);
        rightFrontMotor.setPower(paramA[1] * power);
        rightBackMotor.setPower(paramA[2] * power);
        WaitMillis(millis);
    }

    // Crab right without encoder. drive based on time.
    //EDITED
    public void OdriveRight(double power, long millis)
    {
        leftFrontMotor.setPower(paramA[1] * power);
        leftBackMotor.setPower(paramA[2] * power);
        rightFrontMotor.setPower(paramA[2] * power);
        rightBackMotor.setPower(paramA[1] * power);
        WaitMillis(millis);
    }

    // Tank Turn right without encoder. drive based on time.
    //EDITED
    public void OturnRight(double power, long millis)
    {
        leftFrontMotor.setPower(paramA[1] * power);
        leftBackMotor.setPower(paramA[1] * power);
        rightFrontMotor.setPower(paramA[2] * power);
        rightBackMotor.setPower(paramA[2] * power);
        WaitMillis(millis);
    }

    // Tank Turn left without encoder. drive based on time.
    //EDITED
    public void OturnLeft(double power, long millis)
    {
        leftFrontMotor.setPower(paramA[2] * power);
        leftBackMotor.setPower(paramA[2] * power);
        rightFrontMotor.setPower(paramA[1] * power);
        rightBackMotor.setPower(paramA[1] * power);
        WaitMillis(millis);
    }

    //MECANUM METHODS

    public void MdriveForward(double power, long millis)
    {
        leftFrontMotor.setPower(paramA[1] * power);
        rightFrontMotor.setPower(paramA[1] * power);
        leftBackMotor.setPower(paramA[1] * power);
        rightBackMotor.setPower(paramA[1] * power);
        WaitMillis(millis);
    }

    public void MdriveBackward(double power, long millis)
    {
        leftFrontMotor.setPower(paramA[2] * power);
        rightFrontMotor.setPower(paramA[2] * power);
        leftBackMotor.setPower(paramA[2] * power);
        rightBackMotor.setPower(paramA[2] * power);
        WaitMillis(millis);
    }

    public void MdriveLeft(double power, long millis)
    {
        leftFrontMotor.setPower(paramA[2] * power);
        rightFrontMotor.setPower(paramA[1] * power);
        leftBackMotor.setPower(paramA[1] * power);
        rightBackMotor.setPower(paramA[2] * power);
        WaitMillis(millis);
    }

    public void MdriveRight(double power, long millis)
    {
        leftFrontMotor.setPower(paramA[1] * power);
        rightFrontMotor.setPower(paramA[2] * power);
        leftBackMotor.setPower(paramA[2] * power);
        rightBackMotor.setPower(paramA[1] * power);
        WaitMillis(millis);
    }

    public void MturnLeft(double power, long millis)
    {
        leftFrontMotor.setPower(paramA[2] * power);
        rightFrontMotor.setPower(paramA[1] * power);
        leftBackMotor.setPower(paramA[2] * power);
        rightBackMotor.setPower(paramA[1] * power);
        WaitMillis(millis);
    }

    public void MturnRight(double power, long millis)
    {
        leftFrontMotor.setPower(paramA[1] * power);
        rightFrontMotor.setPower(paramA[2] * power);
        leftBackMotor.setPower(paramA[1] * power);
        rightBackMotor.setPower(paramA[2] * power);
        WaitMillis(millis);
    }

    //ENCODER METHODS

    public void encoderDriveBack(double ticks) {
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        opMode.telemetry.addData("current rightFrontMotor encoder position: ", rightFrontMotor.getCurrentPosition());
        opMode.telemetry.update();

        while (rightFrontMotor.getCurrentPosition() <= ticks) {
            rightBackMotor.setPower(-drivePower);
            rightFrontMotor.setPower(-drivePower);
            leftBackMotor.setPower(-drivePower);
            leftFrontMotor.setPower(-drivePower);
        }

        opMode.telemetry.addData("current rightFrontMotor encoder position: ", rightFrontMotor.getCurrentPosition());
        opMode.telemetry.update();

        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void encoderDriveForward(double ticks) {
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        while (rightFrontMotor.getCurrentPosition() <= ticks) {
            rightBackMotor.setPower(drivePower);
            rightFrontMotor.setPower(drivePower);
            leftBackMotor.setPower(drivePower);
            leftFrontMotor.setPower(drivePower);
        }

        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void encoderDriveRight(double ticks) {
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        while (rightFrontMotor.getCurrentPosition() <= ticks) {
            rightBackMotor.setPower(drivePower);
            rightFrontMotor.setPower(-drivePower);
            leftBackMotor.setPower(-drivePower);
            leftFrontMotor.setPower(drivePower);
        }
    }

    public void encoderDriveLeft(double ticks) {
        while (rightFrontMotor.getCurrentPosition() <= ticks) {
            rightBackMotor.setPower(-drivePower);
            rightFrontMotor.setPower(drivePower);
            leftBackMotor.setPower(drivePower);
            leftFrontMotor.setPower(-drivePower);
        }

        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void encoderTurnRight(double ticks) {
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        while (rightFrontMotor.getCurrentPosition() <= ticks) {
            rightBackMotor.setPower(-drivePower);
            rightFrontMotor.setPower(-drivePower);
            leftBackMotor.setPower(drivePower);
            leftFrontMotor.setPower(drivePower);
        }

        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void encoderTurnLeft(double ticks) {
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        while (rightFrontMotor.getCurrentPosition() <= ticks) {
            rightBackMotor.setPower(drivePower);
            rightFrontMotor.setPower(drivePower);
            leftBackMotor.setPower(-drivePower);
            leftFrontMotor.setPower(-drivePower);
        }

        rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

}
