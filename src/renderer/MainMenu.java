package renderer;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
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
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	public MainMenu(){
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setPreferredSize(dimension);
		frame = new JFrame(Tittle);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		this.addKeyListener(input);
		init();
		requestFocus();
	}
	
	private void init() {
		
	}
	
	private void render(){
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		java.awt.Graphics g = bs.getDrawGraphics();

		((java.awt.Graphics) g).drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	
	}

	synchronized void start() {
		running = true;
		Thread thread = new Thread(this);
		thread.start();

	}

	synchronized void stop() {

		running = false;
		System.exit(0);

	}
}
