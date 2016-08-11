package com.hfrobots.tnt.season1516;

import com.qualcomm.ftccommon.DbgLog;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

public abstract class TestBenchHardware extends OpMode {
	//	Be sure to compare the hardware map in testbench.xml to the physical hardware layout.
	//  The sensors will not work if they are plugged into the wrong ports.


	DcMotor motor1, motor2;
	Servo servo1, servo2, servo3, servo4, servo5, servo6;
	I2cDevice range1;
	GyroSensor gyro1;
	ModernRoboticsI2cGyro mrGyro1;
	I2cDevice compass1;
	ColorSensor color1;
	OpticalDistanceSensor optDist1;
	TouchSensor touch1;
	DeviceInterfaceModule deviceInterfaceModule1;
	private String warningMessage;
	private boolean warningGenerated = false;

	@Override
	public void init() {

		warningMessage = "Can't map; ";

		try {
			motor1 = hardwareMap.dcMotor.get("motor1");
		} catch (Exception p_exception) {
			appendWarningMessage("motor1");
			DbgLog.msg(p_exception.getLocalizedMessage());
			motor1 = null;
		}

		try {
			motor2 = hardwareMap.dcMotor.get("motor2");
		} catch (Exception p_exception) {
			appendWarningMessage("motor2");
			DbgLog.msg(p_exception.getLocalizedMessage());
			motor2 = null;
		}

		try {
			servo1 = hardwareMap.servo.get("servo1");
		} catch (Exception p_exception) {
			appendWarningMessage("servo1");
			DbgLog.msg(p_exception.getLocalizedMessage());
			servo1 = null;
		}


		try {
			servo2 = hardwareMap.servo.get("servo2");
		} catch (Exception p_exception) {
			appendWarningMessage("servo2");
			DbgLog.msg(p_exception.getLocalizedMessage());
			servo2 = null;
		}


		try {
			servo1 = hardwareMap.servo.get("servo3");
		} catch (Exception p_exception) {
			appendWarningMessage("servo3");
			DbgLog.msg(p_exception.getLocalizedMessage());
			servo3 = null;
		}


		try {
			servo4 = hardwareMap.servo.get("servo4");
		} catch (Exception p_exception) {
			appendWarningMessage("servo4");
			DbgLog.msg(p_exception.getLocalizedMessage());
			servo4 = null;
		}


		try {
			servo5 = hardwareMap.servo.get("servo5");
		} catch (Exception p_exception) {
			appendWarningMessage("servo5");
			DbgLog.msg(p_exception.getLocalizedMessage());
			servo5 = null;
		}


		try {
			servo6 = hardwareMap.servo.get("servo6");
		} catch (Exception p_exception) {
			appendWarningMessage("servo6");
			DbgLog.msg(p_exception.getLocalizedMessage());
			servo6 = null;
		}

		try {
			range1 = hardwareMap.i2cDevice.get("range1");
		} catch (Exception p_exception) {
			appendWarningMessage("range1");
			DbgLog.msg(p_exception.getLocalizedMessage());
			range1 = null;
		}

		try {
			gyro1 = hardwareMap.gyroSensor.get("gyro1");
			mrGyro1 = (ModernRoboticsI2cGyro) gyro1; //From MR sample code.  Why?
			gyro1.calibrate();
		} catch (Exception p_exception) {
			appendWarningMessage("gyro1");
			DbgLog.msg(p_exception.getLocalizedMessage());
			gyro1 = null;
		}

		try {
			compass1 = hardwareMap.i2cDevice.get("compass1");
		} catch (Exception p_exception) {
			appendWarningMessage("compass1");
			DbgLog.msg(p_exception.getLocalizedMessage());
			compass1 = null;
		}

		try {
			color1 = hardwareMap.colorSensor.get("color1");
		} catch (Exception p_exception) {
			appendWarningMessage("color1");
			DbgLog.msg(p_exception.getLocalizedMessage());
			color1 = null;
		}

		try {
			optDist1 = hardwareMap.opticalDistanceSensor.get("opdist1");
		} catch (Exception p_exception) {
			appendWarningMessage("opdist1");
			DbgLog.msg(p_exception.getLocalizedMessage());
			optDist1 = null;
		}

		try {
			touch1 = hardwareMap.touchSensor.get("touch1");
		} catch (Exception p_exception) {
			appendWarningMessage("touch1");
			DbgLog.msg(p_exception.getLocalizedMessage());
			touch1 = null;
		}

		try {
			deviceInterfaceModule1 = hardwareMap.deviceInterfaceModule.get("Device Interface Module 1");
		} catch (Exception p_exception) {
			appendWarningMessage("deviceInterfaceModule1");
			DbgLog.msg(p_exception.getLocalizedMessage());
			deviceInterfaceModule1 = null;
		}
	}

	void appendWarningMessage(String exceptionMessage) {
		if (warningGenerated) {
			warningMessage += ", ";
		}
		warningGenerated = true;
		warningMessage += exceptionMessage;
	}

}
