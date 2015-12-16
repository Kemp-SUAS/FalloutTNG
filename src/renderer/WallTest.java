package renderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class uses the Wall.java class to draw lines
 * @author Faduma Ahmed, Simarpal Kalsi Kieran Wilson, Mohid Aslam
 *
 */

@SuppressWarnings("serial")
public class WallTest  extends JComponent {

	public WallTest() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
	  // Creates a new JFrame
	JFrame testFrame = new JFrame();
	  // the programs stops running when the panel is exited
	testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   
	// CREATES A NEW WALL OBJECT
	final Wall comp = new Wall(50, 50,90, 100);
	
	// sets the dimension of the screen
	    comp.setPreferredSize(new Dimension(320, 200));
	    // sets the layout of the screen
	    testFrame.getContentPane().add(comp, BorderLayout.CENTER);
	    @SuppressWarnings("unused")
	    // creates a new JPanel
		JPanel buttonsPanel = new JPanel();
	      // resizes the frame to the determined presets
	    testFrame.pack();
	    // sets the visibility of the frame
	    testFrame.setVisible(true);
	}

}
