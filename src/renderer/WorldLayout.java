package renderer;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JFrame;

import AssetHandling.AssetManager;
import vault1.CharacterFolder.Controller;
import vault1.CharacterFolder.Player;
import vault1.CharacterFolder.ReloadTime;
import vault1.CharacterFolder.Shooter;
import world.Items;
import world.Level;
import world.NPC;

/**
 * 
 * @author Faduma Ahmed, Mohid Aslam, Simarpal Kalsi, Kieran Wilson
 *
 */
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
	public static JFrame frame;
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
	boolean medkitPickup = false;
	private Controller c;
	private ArrayList<Shooter> bullets = new ArrayList<Shooter>();
	private ArrayList<Level> levels = new ArrayList<Level>();
	boolean firstInteract = false;
	int levelTwoKill;
	boolean playerDead = false;

	private int currentLevelID = 1;
	private int levelCount = 2;
	// Key Controlls

	public static boolean left, right, up, down, enter, remove, inventoryPanel, one, two, three;
	public static double rotation, fpsStat;

	private static ArrayList<String> horizontalTransitionInfo = new ArrayList<String>();
	private static ArrayList<String> verticalTransitionInfo = new ArrayList<String>();
	private Level level = new Level(1);
	private Level currentLevel = level;
	private int horizontalNumber;
	private int verticalNumber;
	private int levelId = 1;
	Level level2 = new Level(2);
	ArrayList<Items> itemsOnScreen = new ArrayList<Items>();
	int npcOneCounter = 0;
	int convoState = 0;

	@Override
	/**
	 * 
	 */
	public void run() {

		fps = fpsStat;
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

	/**
	 * 
	 */
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

	/**
	 * 
	 */
	private void init() {
		currentLevel = new Level(1);

		backgroundX = Integer.parseInt(currentLevel.getWallData(0));
		backgroundY = Integer.parseInt(currentLevel.getWallData(1));
		background = new Background(0, 0, this, currentLevel.getImageData(0));
		System.out.println(currentLevel.getImageData(0));
		inventory = new Texture("Assets/Pictures/Textures/Inventory_v1.png");
		horizontalNumber = currentLevel.gethorizontalTransitionNumber();
		verticalNumber = currentLevel.getVerticalTransitionNumber();
		itemsOnScreen = currentLevel.getItems();
		c = new Controller(this);
	}

	/**
	 * 
	 */
	private void tick() {
		background.tick(this);
		moveScreen();
		player.tick(this);
		npc.tick(this);
		c.tick();
	}

	/**
	 * 
	 */
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
				yOffset -= 0.5;
				xOffset += 0.5;
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

	/**
	 * 
	 */
	public void shootingBullet() {
		bullets.add(new Shooter(400 - xOffset, 300 - yOffset, this, rotation));
	}

	/**
	 * 
	 * @throws IOException
	 */
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
		if (space) {

			Timer timer = new Timer();
			timer.schedule(new ReloadTime(), 0, 500);

			bullets.add(new Shooter(400 - xOffset, 300 - yOffset, this, rotation));
			c.addBullet(bullets.get(bullets.size() - 1));
		}
		if (!bullets.isEmpty()) {
			for (int i = 0; i < bullets.size(); i++) {
				System.out.println("Bullets Y :" + bullets.get(i).getY());
				System.out.println("Bullets X:" + bullets.get(i).getX());
				if (bullets.get(i).getDirection().equals("0")) {
					if (bullets.get(i).getY() < 0) {
						System.out.println("Bullet removed");
						Controller.b.remove(i);
						bullets.remove(i);
					}
				} else if (bullets.get(i).getDirection().equals("90")) {
					if (bullets.get(i).getX() > backgroundX) {
						System.out.println("Bullet removed");
						Controller.b.remove(i);
						bullets.remove(i);
					}
				} else if (bullets.get(i).getDirection().equals("180")) {
					if (bullets.get(i).getY() > backgroundY) {
						System.out.println("Bullet removed");
						Controller.b.remove(i);
						bullets.remove(i);
					}
				} else if (bullets.get(i).getDirection().equals("270")) {
					if (bullets.get(i).getX() < 0) {
						System.out.println("Bullet removed");
						Controller.b.remove(i);
						bullets.remove(i);
					}
				}
			}
		}
		inventory.render(g, 5, 510);
		if (yOffset > -120 && yOffset < 120 && xOffset < -1110 && levelId == 1) {
			Font font = new Font("Serif", Font.PLAIN, 25);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			g2.setFont(font);
			g2.drawString("Enter Intersection", 500, 560);

			if (enter == true) {
				enter = false;
				try {
					levelId = 2;
					background = new Background(0, 0, this, AssetManager.dataBaseGet("Level", levelId, "imageData"));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				yOffset = 0;
				xOffset = 300;
			}
		}
		if (levelId == 2 && xOffset < -400 && xOffset > -600 && yOffset < -250) {
			Font font = new Font("Serif", Font.PLAIN, 25);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			g2.setFont(font);
			g2.drawString("Enter lowHold", 500, 560);
			if (enter == true) {
				levelId = 3;
				try {
					background = new Background(0, 0, this, AssetManager.dataBaseGet("image_strings", 17, "path"));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				enter = false;
				xOffset = -500;
				yOffset = 250;
			}
		}
		if (levelId == 2 && yOffset > -150 && yOffset < 150 && xOffset < -1000) {
			Font font = new Font("Serif", Font.PLAIN, 25);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			g2.setFont(font);
			g2.drawString("Enter mid-earth", 500, 560);
			if (enter == true) {
				levelId = 5;
				try {
					background = new Background(0, 0, this, AssetManager.dataBaseGet("image_strings", 19, "path"));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				enter = false;
				xOffset = 100;
				yOffset = 0;
			}
		}
		if (levelId == 2 && yOffset > -150 && yOffset < 150 && xOffset > 150) {
			Font font = new Font("Serif", Font.PLAIN, 25);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			g2.setFont(font);
			g2.drawString("Enter street", 500, 560);
			if (enter == true) {
				levelId = 1;
				try {
					background = new Background(0, 0, this, AssetManager.dataBaseGet("image_strings", 14, "path"));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				enter = false;
				xOffset = -1100;
				yOffset = 0;
			}
		}
		if (levelId == 5 && yOffset > -150 && yOffset < 150 && xOffset < 300) {
			Font font = new Font("Serif", Font.PLAIN, 25);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			g2.setFont(font);
			g2.drawString("Enter intersection", 500, 560);
			if (enter == true) {
				levelId = 2;
				try {
					background = new Background(0, 0, this, AssetManager.dataBaseGet("image_strings", 16, "path"));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				enter = false;
				xOffset = -1000;
				yOffset = 0;
			}
		}
		if (levelId == 2 && xOffset < -400 && xOffset > -600 && yOffset > 250) {
			Font font = new Font("Serif", Font.PLAIN, 25);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			g2.setFont(font);
			g2.drawString("Enter uplands", 500, 560);
			if (enter == true) {
				levelId = 4;
				try {
					background = new Background(0, 0, this, AssetManager.dataBaseGet("image_strings", 18, "path"));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				enter = false;
				xOffset = -500;
				yOffset = -250;
			}
		}
		if (levelId == 3 && xOffset < -400 && xOffset > -600 && yOffset > 250) {
			Font font = new Font("Serif", Font.PLAIN, 25);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			g2.setFont(font);
			g2.drawString("Enter Intersection", 500, 560);
			if (enter == true) {
				levelId = 2;
				try {
					background = new Background(0, 0, this, AssetManager.dataBaseGet("image_strings", 16, "path"));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				enter = false;
				xOffset = -500;
				yOffset = 250;
			}
		}

		if (levelId == 4 && xOffset < -400 && xOffset > -600 && yOffset < -250) {
			Font font = new Font("Serif", Font.PLAIN, 25);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.BLACK);
			g2.setFont(font);
			g2.drawString("Enter Intersection", 500, 560);
			if (enter == true) {
				levelId = 2;
				try {
					background = new Background(0, 0, this, AssetManager.dataBaseGet("image_strings", 16, "path"));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				enter = false;
				xOffset = -500;
				yOffset = 250;
			}
		}
		if (levelId == 1) {
			boolean npcDone = false;
			Font font = new Font("Serif", Font.PLAIN, 25);
			Graphics2D g2 = (Graphics2D) g;
			Graphics2D player = (Graphics2D) g;
			player.setColor(Color.RED);
			g2.setColor(Color.BLACK);
			NPC guide = new NPC(100, 200);
			guide.render(g, xOffset, yOffset);
			if (xOffset > 150 && xOffset < 300 && yOffset > -20 && yOffset < 80 && npcDone == false) {
				g2.setColor(Color.BLACK);
				g2.setFont(font);
				g2.drawString("Interact", 500, 560);
				g2.setFont(font);
				if (enter == true) {
					firstInteract = true;
					convoState = 1;
					System.out.println("State changed");

				}
				if (convoState == 1) {
					player.setFont(font);
					g2.setFont(font);
					g2.drawString("Q)So is it your first time in the wasteland?", 200, 180);
					player.drawString("1) yes", 200, 200);
					player.drawString("2) NO", 200, 220);
					player.drawString("3) I come here a lot more than you", 200, 240);
					if (one == true) {
						convoState = 2;
					}
					if (two == true) {
						convoState = 3;
					}
					if (three == true) {
						convoState = 4;
					}

				}
				if (convoState == 2) {
					g2.drawString("Is that so, then a word of advice", 200, 180);
					g2.drawString("Stay away from the loveClaws adn pick up items", 200, 210);
				}
				if (convoState == 3) {
					g2.drawString("ahh okay sir good on ya", 200, 180);
					npcOneCounter++;
					if (npcOneCounter == 240) {
						npcDone = true;
						System.out.println("Done");
					}

				}
				if (convoState == 4) {
					g2.drawString("U WOT M8", 200, 180);
					if (npcOneCounter == 240) {
						npcDone = true;
					}

				}

			} else if (firstInteract == false) {
				g2.setFont(font);
				g2.drawString("Hey Dude come here", 100 + (int) xOffset, 100 + (int) yOffset);
			}
			Items medKit = null;
			try {
				medKit = new Items(800, 200, 4);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (xOffset > -500 && xOffset < -400 && yOffset < 80 && yOffset > 20 && medkitPickup == false) {
				g2.drawString("Interact", 500, 560);
				if (enter == true) {
					medkitPickup = true;
				}
			}
			if (medkitPickup == false) {
				medKit.render(g2, xOffset, yOffset);
			}

		}
		if (levelId == 2) {
			Font font = new Font("Serif", Font.PLAIN, 25);
			NPC stalker = new NPC((int) xOffset, (int) yOffset);
			
			Graphics2D g2 = (Graphics2D) g;
			Graphics2D player = (Graphics2D) g;
			player.setColor(Color.RED);
			g2.setColor(Color.BLACK);
			if (levelTwoKill < 1) {
				player.setFont(font);
				player.drawString("Ohh my a stalker", 300, 100);
				player.drawString("They look just like you to confuse you", 300, 130);
				player.drawString("I need to kill it before it kill me", 300, 160);
				stalker.render(g, xOffset, yOffset);
			}
			if (!bullets.isEmpty()) {
				for (int i = 0; i < bullets.size(); i++) {
					if (bullets.get(i).getY() > stalker.getY()-100 &&bullets.get(i).getY() < stalker.getY()+100&&
							bullets.get(i).getX() > stalker.getX()-100&&bullets.get(i).getX() < stalker.getX()+100) {
						levelTwoKill ++;
					}

				}
			}
			

		}

		System.out.println("X = " + xOffset);
		System.out.println("Y = " + yOffset);

		c.render(g);

		if (playerDead == true) {
			Font font = new Font("Serif", Font.PLAIN, 25);
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.RED);
			g2.setFont(font);
			g2.drawString("Good job your DEAD!!!!!!! ENJOY THIScute dogs picture kieran sure will", 100, 100);
			try {
				background = new Background(0, 0, this, AssetManager.dataBaseGet("image_strings", 20, "path"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		player.render(g, rotation);
		g.dispose();
		bs.show();

	}

	/**
	 * 
	 */
	synchronized void start() {
		running = true;
		Thread thread = new Thread(this);
		thread.start();

	}

	/**
	 * 
	 */
	synchronized void stop() {

		running = false;
		System.exit(0);

	}

	/**
	 * 
	 * @return fps
	 */
	public double getFps() {
		return fps;
	}

	/**
	 * 
	 * @param fps
	 */
	public void setFps(double fps) {
		this.fps = fps;
	}

	/**
	 * 
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * 
	 * @param frame
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
