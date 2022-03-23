package org.firstinspires.ftc.teamcode.inspiratie_si_teste;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Basic: Linear OpMode", group="Linear Opmode")
@Disabled
    public class Encoderrevmotor extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    //Variabile motoare:
    private DcMotor motor= null;

    static final int MOTOR_TICK_COUNT=1120;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        motor= hardwareMap.get(DcMotor.class,"motor");

        motor.setDirection(DcMotor.Direction.FORWARD);

        //Reset the incoders:
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        double circumferinta=3.14*3.7;
        double rotatiaNecesara=12/circumferinta;
        int encouderDrivingTarget= (int) (rotatiaNecesara*1120);

        motor.setTargetPosition(encouderDrivingTarget);
        runtime.reset();
        while (opModeIsActive()) {
            if(gamepad1.dpad_down) {
                motor.setPower(1);
            }
            if(gamepad1.dpad_up) {
                motor.setPower(1);
            }

            if(gamepad1.x){

                motor.setPower(.5);

                motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                while(motor.isBusy()){

                    telemetry.addData("Path","Driving 18 inch");
                    telemetry.update();
                    idle();
                }
                motor.setPower(0);

            }
            telemetry.addData(">>", "Press start to continue");
            telemetry.update();

            telemetry.addData("Status", "Run Time: " + runtime.toString());

            telemetry.update();
        }
        }
    }
