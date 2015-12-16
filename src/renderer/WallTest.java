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
	    JFrame testFrame = new JFrame();
	    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    final Wall comp = new Wall(50, 50,90, 100);
	    comp.setPreferredSize(new Dimension(320, 200));
	    testFrame.getContentPane().add(comp, BorderLayout.CENTER);
	    @SuppressWarnings("unused")
		JPanel buttonsPanel = new JPanel();
	      
	    testFrame.pack();
	    testFrame.setVisible(true);
	}

}
