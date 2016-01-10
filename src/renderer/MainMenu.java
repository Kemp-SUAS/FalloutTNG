package renderer;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainMenu extends Canvas implements Runnable {
	
	
	public static final MainMenu menu = new MainMenu();

	private static final long serialVersionUID = 1L;
	
	InputHandler input = new InputHandler();
	BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	JFrame frame;
	public static Boolean running = false;
	public static String Tittle = "Main Menu";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final Dimension dimension = new Dimension(WIDTH, HEIGHT);
	
	private void init() {
		
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


}
