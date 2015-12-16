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

public class Wall extends JComponent{
	
    final int x1; 
    final int y1;
    final int x2;
    final int y2;   
    final Color color = Color.BLACK;
    public ArrayList<Rectangle> lines = new ArrayList<Rectangle>();

    public Wall(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        
    }               


@SuppressWarnings("static-access")
@Override
protected void paintComponent(Graphics g) {
    		
	 	super.paintComponent(g);
   
        g.setColor(color.BLACK);
        g.drawRect(x1,x2,y1,y2);
    
}

public static void main(String[] args) {
    JFrame testFrame = new JFrame();
    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    final Wall comp = new Wall(50, 50,90, 100, Color.BLACK);
    comp.setPreferredSize(new Dimension(320, 200));
    testFrame.getContentPane().add(comp, BorderLayout.CENTER);
    JPanel buttonsPanel = new JPanel();
      
    testFrame.pack();
    testFrame.setVisible(true);
}

}