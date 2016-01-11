package renderer;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import vault1.CharacterFolder.Player;


public class WorldLayout extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;

	private static final WorldLayout world = new WorldLayout();
	public Background background;
	
	
	//displays object
	int xOffset=0;
	int yOffset=0;
	
	InputHandler input = new InputHandler();
	Player player = new Player(world);
	BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	JFrame frame;
	public static Boolean running = false;
	public static String Tittle = "Top Down Scrolling";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final Dimension dimension = new Dimension(WIDTH, HEIGHT);


	// Key Controlls
	
	public static boolean left, right,up,down; 
	@Override
	public void run() {

		while (running) {
			tick();
			render();

		}

	}

	
	public WorldLayout() {

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
		background = new Background(0,0,world,"Assets/Pictures/Textures/Grass Texture.png");
	}

	private void tick() {	
		background.tick(this);
		moveScreen();
		player.tick(this);
	
	}
	private void moveScreen()
	{
		if(left)
		{
			xOffset++;
		}
		if(right)
		{
			xOffset--;
		}
		if(up)
		{
			yOffset++;
		}
		if(down)
		{
			yOffset--;
		}
	}
	private void render() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		java.awt.Graphics g = bs.getDrawGraphics();

		((java.awt.Graphics) g).drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
		
		try {
			background.render(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player.render(g);
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