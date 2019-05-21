import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

/**
 * 
 */

/**
 * @author msjom
 *
 */
public class Mindstorm {

	/**
	 * @param args
	 */
	public static EV3LargeRegulatedMotor mLinks = new EV3LargeRegulatedMotor(MotorPort.B);
	public static EV3LargeRegulatedMotor mRechts = new EV3LargeRegulatedMotor(MotorPort.C);
	
	public static Port p4 = LocalEV3.get().getPort("S4");
	
	public static SensorModes sensor = new EV3UltrasonicSensor(p4);
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		MoveForward(1000);
		TurnLeft();
		MoveForward(1000);
		TurnRight();
		
		
		
	}
	
	public static void TurnLeft() throws InterruptedException {
		mLinks.synchronizeWith(new EV3LargeRegulatedMotor[] {mRechts});
		mLinks.startSynchronization();
		mLinks.setSpeed(360);
		mRechts.setSpeed(360);
		mLinks.rotate(-90);
		mRechts.rotate(90);
		mLinks.endSynchronization();
		mLinks.waitComplete();
		mRechts.waitComplete();
		
	}
	
	public static void TurnRight() throws InterruptedException {
		mLinks.synchronizeWith(new EV3LargeRegulatedMotor[] {mRechts});
		mLinks.startSynchronization();
		mLinks.setSpeed(360);
		mRechts.setSpeed(360);
		mLinks.rotate(90);
		mRechts.rotate(-90);
		mLinks.endSynchronization();
		mLinks.waitComplete();
		mRechts.waitComplete();
		
		
	}
	
	public static void DrawLCD(String s) {
		LCD.drawString(s, 0, 0);
	}
	
	public static void MoveForward(int delay) {
		mLinks.synchronizeWith(new EV3LargeRegulatedMotor[] {mRechts});
		mLinks.startSynchronization();
		mLinks.forward();
		mRechts.forward();
		Delay.msDelay(delay);
		mRechts.stop();
		mLinks.stop();
		mLinks.endSynchronization();
		mLinks.waitComplete();
		mRechts.waitComplete();
		
	}
	public static float GetDistance() {
		SampleProvider distance= sensor.getMode("Distance");
		float[] sample = new float[distance.sampleSize()];
		
		distance.fetchSample(sample, 0);
		return sample[sample.length-1];
	}

}
