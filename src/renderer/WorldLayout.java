package renderer;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.AttributedString;
import java.util.ArrayList;

import javax.swing.JFrame;

import vault1.CharacterFolder.Controller;
import vault1.CharacterFolder.Player;
import vault1.CharacterFolder.Shooter;
import world.Level;
import world.NPC;

public class WorldLayout extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public Background background;
	int x = 0;

	// displays object
	public static double xOffset = 0;
	public static double yOffset = 0;

	private InputHandler input = new InputHandler();
	private Player player = new Player();
	private NPC npc = new NPC();
	private BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	private double xValue;
	private double yValue;
	 public static boolean space = false;
	private boolean inventoryFrame;
	private JFrame frame;
	private static Boolean running = false;
	private static String Tittle = "Top Down Scrolling";
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final Dimension dimension = new Dimension(WIDTH, HEIGHT);
	private long lastTime;
	private long timer = 1000 / 60;
	private double fps;
	private int backgroundX = 0;
	private int backgroundY = 0;
	private Texture image;
	private Texture inventory;
	private Shooter shoot;
	private Controller c;
	private ArrayList<Shooter> bullets = new ArrayList<Shooter>();
	private ArrayList<Level> levels = new ArrayList<Level>();

	private int currentLevelID = 1;
	private int levelCount = 1;
	// Key Controlls

	public static boolean left, right, up, down, enter, remove;
	public static double rotation;

	private static ArrayList<String> horizontalTransitionInfo = new ArrayList<String>();
	private static ArrayList<String> verticalTransitionInfo = new ArrayList<String>();
	private Level level = new Level(1);
	private Level currentLevel = level;
	private int horizontalNumber;

	@Override
	public void run() {
		long timer = 1000 / 60;

		while (running) {
			lastTime = System.nanoTime();
			try {
				Thread.sleep(timer);
			} catch (InterruptedException e) {

			}
			setFps(1000000000.0 / (System.nanoTime() - lastTime));
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
		setFrame(new JFrame(Tittle));
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setLayout(new BorderLayout());
		getFrame().add(this, BorderLayout.CENTER);
		getFrame().pack();
		getFrame().setResizable(false);
		getFrame().setLocationRelativeTo(null);
		getFrame().setVisible(true);
		this.addKeyListener(input);
		init();
		requestFocus();

		// added coment quite useless really

	}

	private void init() {
		Level level = new Level(1);
		Level currentLevel = level;
		for (int i = 1; i <= levelCount; i++) {
			levels.add(new Level(i));
		}
		backgroundX = Integer.parseInt(currentLevel.getWallData(0));
		backgroundY = Integer.parseInt(currentLevel.getWallData(1));
		background = new Background(0, 0, this, currentLevel.getImageData(0));
		System.out.println(currentLevel.getImageData(0));
		inventory = new Texture("Assets/Pictures/Textures/Inventory_l1.png");
		horizontalNumber = currentLevel.gethorizontalTransitionNumber();
		c = new Controller(this);
	}

	private void tick() {
		background.tick(this);
		moveScreen();
		player.tick(this);
		npc.tick(this);
		c.tick();

	}

	private void moveScreen() {
		for (x = 0; x < 20; x++) {
			if (up) {
				yOffset += 1;
				xValue = xOffset;
				yValue = yOffset;
				WorldLayout.rotation = 0;
			}

			if (right) {
				xOffset -= 1;
				xValue = xOffset;
				yValue = yOffset;
				WorldLayout.rotation = 90;
			}

			if (down) {
				yOffset -= 1;
				xValue = xOffset;
				yValue = yOffset;
				WorldLayout.rotation = 180;
			}

			if (left) {
				xOffset += 1;
				xValue = xOffset;
				yValue = yOffset;
				WorldLayout.rotation = 270;
			}

			if (up && right) {
				yOffset += 0.5;
				xOffset -= 0.5;
				xValue = xOffset;
				yValue = yOffset;
				WorldLayout.rotation = 45;
			}

			if (up && left) {
				yOffset += 0.5;
				xOffset += 0.5;
				xValue = xOffset;
				yValue = yOffset;
				WorldLayout.rotation = 315;
			}
			if (down && left) {
				yOffset += 0.5;
				xOffset -= 0.5;
				xValue = xOffset;
				yValue = yOffset;
				WorldLayout.rotation = 225;
			}

			if (down && right) {
				yOffset -= 0.5;
				xOffset -= 0.5;
				xValue = xOffset;
				yValue = yOffset;
				WorldLayout.rotation = 135;
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
		for (int i = 0; i <= horizontalNumber; i++) {

			if (xOffset < currentLevel.getHorizontalTransitionInfo().get(i).getX1()
					&& xOffset > currentLevel.getHorizontalTransitionInfo().get(i).getX2() && yOffset < currentLevel.getHorizontalTransitionInfo().get(i).getY1()
					&& enter == true) {
				background = new Background(0, 0, this,
						"Assets/Pictures/Textures/levels/Hallway_v2_compressed_interlaced.png");
				yOffset = 0;
				xValue = xOffset;
				yValue = yOffset;
				enter = false;
			}
		}
		for (int i = 0; i <= horizontalTransitionInfo.size(); i++) {
			if (yOffset < -400 && yOffset > -500 && xOffset < -250 && enter == true) {
				background = new Background(0, 0, this,
						"Assets/Pictures/Textures/levels/Hallway_v2_compressed_interlaced.png");
				yOffset = 0;
				xValue = xOffset;
				yValue = yOffset;
				enter = false;
			}
		}

		if (space) {
			// shoot = new Shooter(0, 0, this);
			// shoot.render(g);
			// c.addBullet(new Shooter( xOffset, yOffset, this));
			bullets.add(new Shooter(400 - xOffset, 300 - yOffset, this, rotation));
			c.addBullet(bullets.get(bullets.size() - 1));
		}
		/**if (bullets.size() > 0) {
		for (int i = 0; i < bullets.size(); i++) {
			if (bullets.get(i).getX() < (-1 * backgroundX) + 432) {
				bullets.get(i).setX(-1200 + 32);
				bullets.remove(i);
			}
			if (bullets.get(i).getX() > 400 - 32) {
				bullets.get(i).setX(400 - 32);
				bullets.remove(i);
			}
			if (bullets.get(i).getY() < (-1 * backgroundY) + 332) {
				bullets.get(i).setX(-300 + 32);
				bullets.remove(i);
			}
			if (bullets.get(i).getY() > 300 - 32) {
				bullets.get(i).setX(300 - 32);
				bullets.remove(i);
			}
		}
	}**/

	if (bullets.size() > 0) {
		for (int i = 0; i < bullets.size(); i++) {
			System.out.println("X Value: " + bullets.get(0).getX() + " ");
			System.out.println("Y Value: " + bullets.get(0).getY() + " ");
		}
	}
	if (bullets.size() > 1){
		bullets.remove(0);
	}
		c.render(g);
		player.render(g, rotation);
		npc.render(g, xOffset, yOffset);
		System.out.println(rotation);
		if (xOffset < -400 && xOffset > -500 && yOffset < -250) {
			AttributedString astr = new AttributedString("This is a test string");
			Font font = new Font("Serif", Font.PLAIN, 25);
			astr.addAttribute(TextAttribute.FONT, font, 0, 4);
			astr.addAttribute(TextAttribute.FOREGROUND, Color.RED, 5, 9);
			astr.addAttribute(TextAttribute.BACKGROUND, Color.CYAN, 10, 21);

			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLUE);
			g2.setFont(font);
			g2.drawString("Enter", 380, 260);
			// g.drawString(astr. , 100, 100);
		}
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

	public double getFps() {
		return fps;
	}

	public void setFps(double fps) {
		this.fps = fps;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
