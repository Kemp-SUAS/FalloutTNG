package renderer;

import java.awt.BorderLayout;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

import vault1.CharacterFolder.Level;
import vault1.CharacterFolder.Player;

public class WorldLayout extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static final WorldLayout world = new WorldLayout();
	public Background background;

	// displays object
	int xOffset = 0;
	int yOffset = 0;

	InputHandler input = new InputHandler();
	Player player = new Player(world);
	BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	Level level1 = new Level(1);
	
	JFrame frame;
	public static Boolean running = false;
	public static String Tittle = "Top Down Scrolling";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final Dimension dimension = new Dimension(WIDTH, HEIGHT);
	long lastTime;
	long timer = 1000 / 60;
	double fps;
	Texture image;

	// Key Controlls

	public static boolean left, right, up, down;

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
		background = new Background(0, 0, world, level1.getIndexInfo(level1.getImageData(), 0));
	}

	private void tick() {
		background.tick(this);
		moveScreen();
		player.tick(this);

	}

	private void moveScreen() {
		if (left) {
			xOffset += 4;
		}
		if (right) {
			xOffset -= 4;
		}
		if (up) {
			yOffset += 4;
		}
		if (down) {
			yOffset -= 4;
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
