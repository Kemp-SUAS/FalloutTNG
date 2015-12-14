package renderer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sun.xml.internal.ws.api.server.Container;


@SuppressWarnings("serial")
public class TestJPanel extends JPanel implements Runnable {

	/**
	 * Create the panel.
	 */
	public TestJPanel() {
	}

	
	public static void main(String[] args) {

		// Set up main window (using Swing's Jframe)
		JFrame frame = new JFrame("Dodgeball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 300));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		java.awt.Container c = frame.getContentPane();
		((java.awt.Container) c).add(new TestJPanel());
		frame.pack();


	}


	@Override
	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Wall line= new Wall ();
		
		line.addLine(g);
		}

	}

	
	

