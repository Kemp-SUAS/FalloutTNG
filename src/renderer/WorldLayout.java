package renderer;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import vault1.CharacterFolder.Controller;
import vault1.CharacterFolder.Level;
import vault1.CharacterFolder.Player;
import vault1.CharacterFolder.Shooter;

public class WorldLayout extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static final WorldLayout world = new WorldLayout();
	public Background background;
	int x = 0;

	// displays object
	int xOffset = 0;
	int yOffset = 0;

	InputHandler input = new InputHandler();
	Player player = new Player(world);
	BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	int xValue;
	int yValue;
	public static boolean space = false;

	JFrame frame;
	public static Boolean running = false;
	public static String Tittle = "Top Down Scrolling";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final Dimension dimension = new Dimension(WIDTH, HEIGHT);
	long lastTime;
	long timer = 1000 / 60;
	double fps;
	int backgroundX = 1600;
	int backgroundY = 600;
	Texture image;
	Texture inventory;
	Shooter shoot;
	private Controller c;
	ArrayList<Shooter> bullets= new ArrayList<Shooter>();
	

	// Key Controlls

	public static boolean left, right, up, down, enter , remove;

	@Override
	public void run() {
		long timer = 1000 / 60;

		while (running) {
			lastTime = System.nanoTime();
			try {
				Thread.sleep(timer);
			} catch (InterruptedException e) {

			}
			fps = 1000000000.0 / (System.nanoTime() - lastTime);
			lastTime = System.nanoTime();
			tick();
			try {
				render();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
		//added coment quite useless really

	}

	private void init() {
		Level level = new Level(1);
		level.setImageData();
		background = new Background(0, 0, world, Level.getImageData().get(0));
		inventory = new Texture("Assets/Pictures/Textures/Inventory_v1.png");

		c = new Controller(this);
	}

	private void tick() {
		background.tick(this);
		moveScreen();
		player.tick(this);
		c.tick();

	}

	private void moveScreen() {
		for (x = 0; x < 20; x++) {
			if (left) {
				xOffset += 1;
				xValue = xOffset;
				yValue = yOffset;
			}
			if (right) {
				xOffset -= 1;
				xValue = xOffset;
				yValue = yOffset;
			}
			if (up) {
				yOffset += 1;
				xValue = xOffset;
				yValue = yOffset;
			}
			if (down) {
				yOffset -= 1;
				xValue = xOffset;
				yValue = yOffset;
			}
		}
	}

	private void render() throws IOException {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		java.awt.Graphics g = bs.getDrawGraphics();

		((java.awt.Graphics) g).drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);

		try {
			background.render(g);
			inventory.render(g, 5, 510);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (xOffset < (-1 * backgroundX) + 432) {
			xOffset = -1200 + 32;
			xValue = xOffset;
			yValue = yOffset;
		}
		if (xOffset > 400 - 32) {
			xOffset = 400 - 32;
			xValue = xOffset;
			yValue = yOffset;
		}
		if (yOffset < (-1 * backgroundY) + 332) {
			yOffset = -300 + 32;
			xValue = xOffset;
			yValue = yOffset;
		}
		if (yOffset > 300 - 32) {
			yOffset = 300 - 32;
			xValue = xOffset;
			yValue = yOffset;
		}
		if (xOffset < -400 && xOffset > -500 && yOffset < 0 && enter == true) {
			background = new Background(0, 0, world, "Assets/Pictures/Textures/Hallway_v1.png");
			yOffset = 0;
			xValue = xOffset;
			yValue = yOffset;
			enter = false;
		}
		
		if (space) {
			//shoot = new Shooter(0, 0, this);
			//shoot.render(g);
			//c.addBullet(new Shooter( xOffset, yOffset, this));
			bullets.add(new Shooter( xOffset +100, yOffset+100, this));
			c.addBullet(bullets.get(bullets.size()-1));
			System.out.println("X offset "+ xOffset );
			System.out.println("Y offset "+ yOffset );
			System.out.println("Shoot");
		}
		c.render(g);
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
