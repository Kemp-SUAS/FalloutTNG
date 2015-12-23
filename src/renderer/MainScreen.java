package renderer;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AssetHandling.ImageChanger;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import AssetHandling.AssetManager;
/**
 * 
 * @author Faduma Ahmed, Mohid Aslam, Kieran Wilson Simarpal Kalsi
 * 
 * This class shows the main screen to the user. This will be the the initial interaction the player will have with the game. This class sets the frame an all mouse related actions
 *
 */

public class MainScreen extends JFrame {

	// create a generic lightweight container.
	private JPanel contentPane;

	/**
	 * Launch the application.It sets the screen and the frame size settings
	 * 
	 * 
	 */
	public static void main(String[] args) {
		//that queues events, an implements the runnable interface
		EventQueue.invokeLater(new Runnable() {
			
			/**
			 * inherited method from Runnable interface
			 * @see java.lang.Runnable#run()
			 */
			public void run() {
				
				try {
					// creates a new object from this class
					MainScreen  frame =  new MainScreen ();
					// sets the visibility of the frame
					frame . setVisible  (true );
					// Prohibts the user from changing the size of the frame
					frame . setResizable (false );
				} 
				// indicates conditions that a reasonable application might want to catch.
				catch ( Exception  e ) {
					e. printStackTrace( );
				}
			}
		});
	} 

	/**
	 * THis constructors creates the frame and sets all required settings
	 * 
	 * 
	 * @throws IOException
	 */
	public MainScreen() throws IOException {
		/*
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		*/
		// Sets the operation that will happen by default when the user initiates a "close" on this frame
		setDefaultCloseOperation( JFrame . EXIT_ON_CLOSE );
		// Moves and resizes this component.
		setBounds ( 100 , 100 , 1048 , 600);
		// Creates a new JPanel with a double buffer and a flow layout.
		contentPane  =  new  JPanel( );
		// Sets the borders, object is responsible for defining the insets for the component 
		contentPane. setBorder ( new  EmptyBorder (5, 5, 5, 5));
		
		setContentPane(contentPane);
		// Sets the layout manager for the container.
		contentPane.setLayout(null);
		// Creates a new button
		JButton continueButton = new JButton("");
		// Moves and resizes this the button.
		continueButton.setBounds(840, 191, 182, 47);
		// Appends the specified component to contentPane
		contentPane.add(continueButton);

		try {
			//
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
		contentPane.add(loadButton);

		try {
			loadButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 6, loadButton)));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		};
		continueButton.addMouseListener(new MouseAdapter() {
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
		contentPane.add(newGameButton);

		try {
			newGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 9, newGameButton)));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		};
		continueButton.addMouseListener(new MouseAdapter() {
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
		contentPane.add(exitGameButton);

		try {
			exitGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 12, exitGameButton)));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		};
		continueButton.addMouseListener(new MouseAdapter() {
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
		lblNewLabel.setIcon(ImageChanger.mainScreenBackground());
		lblNewLabel.setBounds(10, 11, 1012, 539);
		contentPane.add(lblNewLabel);
		

	}
	private static Image imageMaker(String table, String column, int id, JButton b) throws ClassNotFoundException, SQLException{
		String path = AssetManager.dataBaseGet(table, id, column);
		System.out.println(path);
		Image image = new ImageIcon(path).getImage().getScaledInstance(b.getWidth(),b.getHeight(),java.awt.Image.SCALE_SMOOTH);
		return image;
	}
	
}
