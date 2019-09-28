import processing.core.PApplet;

class Main{

	public static void main(String[] args){

        String[] processingArgs = {"Clock"};
		Clock analogClock = new Clock();
		PApplet.runSketch(processingArgs, analogClock);
		
	}
}