package renderer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * @author Simar Pal Kalsi
 *Time -- 10:47:33 AM Date Dec 13, 2015
 */
public class Line implements Runnable {

    //X,Y cordinates for the origin
    int startX;
    int startY;
    int endX;
    int endY;
    int width;
    Color colour;
    
    public Line() {
	
    }
    public Line(int startX , int startY, int endX, int endY, int width , Color colour){
	this.startX = startX;
	this.startY = startY;
	this.endX = endX;
	this.endY = endY;
	this.width = width;
	this.colour = colour;
    }
    public void draw(Graphics g){
	Graphics2D g2 = (Graphics2D) g;
	g2.setStroke(new BasicStroke(width));
	g2.drawLine(startX, startY, endX, endY);
	g2.setColor(colour);
	
    }
    @Override
    public void run() {
	
    }
    
    
}
