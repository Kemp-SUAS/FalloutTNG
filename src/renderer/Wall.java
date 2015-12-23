package renderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.javafx.geom.Rectangle;
/**
  
 * 
 * THis method helps to creates wall on they screen. These walls will essentially be areas in the game map that will prohibit the user from walking through.
 * THe intention of this class is that will be dynamic and easily applicable to other classes
 *  @author Faduma Ahmed, Mohid Aslam, Kieran Wilson Simarpal Kalsi
 */
/**
 * @author fadumaahmed
 *
 */
public class Wall extends JComponent{
	
    /**
     * The x-coordinate of the rectangle
     */
    final int x; 
    /**
     * The y-coordinate of the rectangle
     */
    final int y;
    /**
     * The width of the rectangle
     */
    final int width;
    /**
     * The height of the rectangle
     */
    final int height;   
    /**
     * The color of the rectangle
     */
    final Color color = Color.BLACK;
    /**
     * Creates an ArrayList to store  the rectangle
     */
    
    public ArrayList<Rectangle> lines = new ArrayList<Rectangle>();

    /**
     *  THis constructor sets all the dimensions of the rectangle
     * @param x, The x-coordinate of the rectangle
     * @param y , The y-coordinate of the rectangle
     * @param width The width of the rectangle
     * @param height, The height of the rectangle
     */
    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
    }               


/* (non-Javadoc)
 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
 */
@SuppressWarnings("static-access")
@Override
protected void paintComponent(Graphics g) {
    	// Calls the UI delegate's paint method,	
	 	super.paintComponent(g);
	 	// sets the color of the rectangle
        g.setColor(color.BLACK);
        //draws the rectangle
        g.drawRect(x,width,y,height);
    
}


}