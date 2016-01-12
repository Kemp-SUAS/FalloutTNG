package renderer;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import AssetHandling.AssetManager;

@SuppressWarnings("serial")
public class MainMenu extends Canvas implements Runnable{	
	

	private static final long serialVersionUID = 1L;
	
	InputHandler input = new InputHandler();
	BufferedImage bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	JFrame frame;
	public static Boolean running = false;
	public static String Tittle = "Main Menu";
	public static final int WIDTH = 1048;
	public static final int HEIGHT = 600;
	public static final Dimension dimension = new Dimension(WIDTH, HEIGHT);
	long lastTime;
	long timer = 1000/60;
	double fps;
	@Override
	public void run() {
long timer = 1000/60;
		
		
		while (running) {
			lastTime = System.nanoTime();
			try{
				Thread.sleep(timer);
			}
			catch(InterruptedException e){
				
			}
			fps = 1000000000.0 / (System.nanoTime()-lastTime);
			lastTime = System.nanoTime();
			tick();
			render();

		}
		
	}
	public MainMenu() throws ClassNotFoundException, SQLException{
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		setPreferredSize(dimension);
		frame = new JFrame(Tittle);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.pack();
		init();
		requestFocus();
		
	
	}
	
	private void init() throws ClassNotFoundException, SQLException {
		JButton continueButton = new JButton("");
		continueButton.setBounds(840, 191, 182, 47);
		frame.add(continueButton);

		try {
			continueButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 3, continueButton)));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		};
		continueButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					continueButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 1, continueButton))); 
			
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					continueButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 3, continueButton)));
					game.continueButton = true;
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				try {
					continueButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 2, continueButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}

			@Override
			public void mouseExited(MouseEvent e) {
				try {
					continueButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 3, continueButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}
		});
		/**
		 * Create the frame.
		 * 
		 * @throws IOException
		 */
		JButton loadButton = new JButton("");
		loadButton.setBounds(840, 291, 182, 47);
		frame.add(loadButton);

		try {
			loadButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 6, loadButton)));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		};
		loadButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					loadButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 4, loadButton))); 
			
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					loadButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 6, loadButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				try {
					loadButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 5, loadButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}

			@Override
			public void mouseExited(MouseEvent e) {
				try {
					loadButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 6, loadButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}
		});
		/**
		 * Create the frame.
		 * 
		 * @throws IOException
		 */
		JButton newGameButton = new JButton("");
		newGameButton.setBounds(840, 391, 182, 47);
		frame.add(newGameButton);

		try {
			newGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 9, newGameButton)));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		};
		newGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					newGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 7, newGameButton))); 
			
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					newGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 9, newGameButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				try {
					newGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 8, newGameButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}

			@Override
			public void mouseExited(MouseEvent e) {
				try {
					newGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 9, newGameButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}
		});
		/**
		 * Create the frame.
		 * 
		 * @throws IOException
		 */
		JButton exitGameButton = new JButton("");
		exitGameButton.setBounds(840, 491, 182, 47);
		frame.add(exitGameButton);

		try {
			exitGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 12, exitGameButton)));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		};
		exitGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					exitGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 10, exitGameButton))); 
			
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					exitGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 12, exitGameButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				try {
					exitGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 11, exitGameButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}

			@Override
			public void mouseExited(MouseEvent e) {
				try {
					exitGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 12, exitGameButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				};
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AssetManager.dataBaseGet("image_strings", 13, "path" )));
		lblNewLabel.setBounds(10, 11, 1012, 539);
		frame.add(lblNewLabel);
		
		
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
	private void tick() {	
	
	}
	synchronized void stop() {

		running = false;
		System.exit(0);

	}
	private static Image imageMaker(String table, String column, int id, JButton b) throws ClassNotFoundException, SQLException{
		String path = AssetManager.dataBaseGet(table, id, column);

		Image image = new ImageIcon(path).getImage().getScaledInstance(b.getWidth(),b.getHeight(),java.awt.Image.SCALE_SMOOTH);
		return image;
	}
}
