package renderer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * @author Simar Pal Kalsi, Faduma Ahmed, Kieran Wilson, Mohid Aslam
 *Time -- 10:47:33 AM Date Dec 13, 2015
 */
	public  class Wall   {

		public Image image;
    //X,Y cordinates for the origin
	
		private Graphics g= image.getGraphics() ;
	
	
	/**
	 * Array List to Store Columns 
	 */
	public Rectangle columns;

	/**
	 * start x co-ordinate
	 */
	 private int xValue;
	/**
	 * start y co-ordinate
	 */
	 private int yValue;
	/**
	 * height
	 */
	
	 private int height;
	/**
	 * end x co-ordinate
	 */
    
	/**
	 * width
	 */
	 private int width;
	 /**
	  * width
	  */
     private String colour;
    
    public Wall() {
	
    }
    public Wall( int xValue, int yValue,  int width ,int height, String colour){
	this.xValue = xValue;
	this.yValue = yValue;
	this.height = height;
	this.width = width;
	this.colour = colour;
    }
  
    public void addLine(Graphics g)
	{
    	
    	
    	columns = (new Rectangle(xValue,yValue,width,height));
		paintColumn(g, columns);
			
	}
    public void paintColumn(Graphics g, Rectangle columns)
	{
		
    	
    	g.setColor(Color.RED);
		g.fillRect(columns.x, columns.y, columns.width, columns.height);
	}
    
    
    
    
    
    
    /*public void draw(Graphics g)
    
    {
	Graphics2D g2 = (Graphics2D) g;
	g2.setStroke(new BasicStroke(width));
	g2.drawLine(startX, startY, endX, endY);
	g2.setColor(colour);
	
    }
    
    public void run()
    {
    	Graphics g= new Graphics();
    	
    }*/
    
    
}
