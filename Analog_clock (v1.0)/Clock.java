import processing.core.PApplet;

class Clock extends PApplet{

    public void settings(){
		size(800, 800);
	}
	
	public void draw(){
        background(0,100,100);
        
        drawFace();
        drawNumbers();
        drawTime();
    }
    
    public void drawFace(){

        fill(225,100,0);
        circle(width/2, height/2, height*0.9f);

        fill(0, 0, 0);
        circle(width/2, height/2, height*0.05f);
    }

    public void drawNumbers(){

        textSize(38);
        textAlign(CENTER, CENTER);

        for (int number=1; number<=12; number++){
            translate(height/2, width/2);
            rotate(number*PI/6);
            translate(0, -height*0.39f);
            rotate(-number*PI/6);
            text(String.valueOf(number), 0, 0);
            rotate(number*PI/6);
            translate(0, height*0.39f);
            rotate(-number*PI/6);
            translate(-height/2, -width/2);
        }
    }

    public void drawTime(){
        int hours = hour(); hours = hours%12;
        int minutes = minute();
        int seconds = second();
        int milliseconds = millis();

        //seconds hand...........................................
        drawHand(04, height*0.40f, (seconds*0.10471f));

        //minute hand............................................
        drawHand(11, height*0.29f, (minutes*0.10471f) + (seconds*0.00174f));

        //hour hand..............................................
        // hour = (hours*Math.PI/6)+(minutes*Math.PI/(6*60))+(seconds*Math.PI/(360*60));
        drawHand(16, height*0.20f, (hours*PI/6f) + (minutes*PI/360f) + (seconds*PI/21600f));
    }

    public void drawHand(int lineWidth, float length, float angle){
        strokeWeight(lineWidth);
        strokeCap(ROUND);
        translate(height/2,width/2);
        rotate(angle);
        line(0, 0, 0,-length);
        rotate(-angle);
        translate(-height/2, -width/2);

    }
}


