package renderer;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
 * This class shows the main screen to the user. This will be the the initial interaction the player will have with the game
 *
 */

public class MainScreen extends JFrame {

	public static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//MainScreen frame = new MainScreen();
					//frame.setVisible(true);
	
					//frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public MainScreen() throws IOException, ClassNotFoundException, SQLException {
		/*
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		*/

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton continueButton = new JButton("");
		continueButton.setBounds(840, 191, 182, 47);
		contentPane.add(continueButton);

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
		contentPane.add(newGameButton);

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
		contentPane.add(exitGameButton);

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
		contentPane.add(lblNewLabel);
		

	}
	static Image imageMaker(String table, String column, int id, JButton b) throws ClassNotFoundException, SQLException{
		String path = AssetManager.dataBaseGet(table, id, column);

		Image image = new ImageIcon(path).getImage().getScaledInstance(b.getWidth(),b.getHeight(),java.awt.Image.SCALE_SMOOTH);
		return image;
	}
	
}
