package renderer;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JFrame;

import AssetHandling.AssetManager;
import vault1.CharacterFolder.Level;
import vault1.CharacterFolder.Player;

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

	// Key Controlls

	public static boolean left, right, up, down, enter;

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
		background = new Background(0, 0, world, "Assets/Pictures/Textures/Hallway_v2_compressed_interlaced.png");
		inventory = new Texture("Assets/Pictures/Textures/Inventory_v1.png");
	}

	private void tick() {
		background.tick(this);
		moveScreen();
		player.tick(this);

	}

	private void moveScreen() {
		for (x = 0; x < 20; x++) {
			if (left) {
				xOffset += 1;
			}
			if (right) {
				xOffset -= 1;
			}
			if (up) {
				yOffset += 1;
			}
			if (down) {
				yOffset -= 1;
			}
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
			inventory.render(g, 5, 510);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (xOffset < (-1 * backgroundX) + 432) {
			xOffset = -1200 + 32;
		}
		if (xOffset > 400 - 32) {
			xOffset = 400 - 32;
		}
		if (yOffset < (-1 * backgroundY) + 332) {
			yOffset = -300 + 32;
		}
		if (yOffset > 300 - 32) {
			yOffset = 300 - 32;
		}
		if (xOffset < -400 && xOffset > -500 && yOffset < 0 && enter == true) {
			background = new Background(0, 0, world, "Assets/Pictures/Textures/Hallway_v1.png");
			yOffset = 0;
			enter = false;
		}
		System.out.println("Y offset = " + yOffset);
		System.out.println("X offset = " + xOffset);
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
