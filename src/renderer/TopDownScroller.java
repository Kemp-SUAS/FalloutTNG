package renderer;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class TopDownScroller extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	 BufferedImage bufferedImage = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	
	
	JFrame frame;
	public static Boolean running= false;
	public static String Tittle= "Top Down Scrolling";
	public static final int WIDTH = 700;
	public static final int HEIGHT= WIDTH/4*3;
	public static final Dimension dimension= new Dimension(WIDTH,HEIGHT);
	
	@Override
	public void run() {
		
		while(running)
		{
			tick();
			render();
			
		}
		
	}
	 
	private void render() {
		// TODO Auto-generated method stub
		
	}

	private void tick() {
		// TODO Auto-generated method stub
		
	}

	synchronized void start(){
		running= true;
		Thread thread= new Thread(this);
		thread.start();
		
	}
	 synchronized void stop(){
		
		running=false;
		System.exit(0);
		
	}
	


}
