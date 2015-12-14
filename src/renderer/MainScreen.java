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

public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
	
					frame.setResizable(false);
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
	 */
	public MainScreen() throws IOException {
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

		loadButton.setIcon(new ImageIcon(ImageChanger.mainMenuLoad("idle", loadButton)));
		loadButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				loadButton.setIcon(new ImageIcon(ImageChanger.mainMenuLoad("click", loadButton)));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				loadButton.setIcon(new ImageIcon(ImageChanger.mainMenuLoad("idle", loadButton)));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				loadButton.setIcon(new ImageIcon(ImageChanger.mainMenuLoad("hover", loadButton)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				loadButton.setIcon(new ImageIcon(ImageChanger.mainMenuLoad("idle", loadButton)));
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

		newGameButton.setIcon(new ImageIcon(ImageChanger.mainMenuNewGame("idle", newGameButton)));
		newGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				newGameButton.setIcon(new ImageIcon(ImageChanger.mainMenuNewGame("click", newGameButton)));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				newGameButton.setIcon(new ImageIcon(ImageChanger.mainMenuNewGame("idle", newGameButton)));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				newGameButton.setIcon(new ImageIcon(ImageChanger.mainMenuNewGame("hover", newGameButton)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				newGameButton.setIcon(new ImageIcon(ImageChanger.mainMenuNewGame("idle", newGameButton)));
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

		exitGameButton.setIcon(new ImageIcon(ImageChanger.mainMenuExitGame("idle", exitGameButton)));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(ImageChanger.mainScreenBackground());
		lblNewLabel.setBounds(10, 11, 1012, 539);
		contentPane.add(lblNewLabel);
		
		exitGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				exitGameButton.setIcon(new ImageIcon(ImageChanger.mainMenuExitGame("click", exitGameButton)));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				exitGameButton.setIcon(new ImageIcon(ImageChanger.mainMenuExitGame("idle", exitGameButton)));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				exitGameButton.setIcon(new ImageIcon(ImageChanger.mainMenuExitGame("hover", exitGameButton)));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitGameButton.setIcon(new ImageIcon(ImageChanger.mainMenuExitGame("idle", exitGameButton)));
			}
		});
		
		

	}
	private static Image imageMaker(String table, String column, int id, JButton b) throws ClassNotFoundException, SQLException{
		String path = AssetManager.dataBaseGet(table, id, column);
		Image image = new ImageIcon(path).getImage().getScaledInstance(b.getWidth(),b.getHeight(),java.awt.Image.SCALE_SMOOTH);
		return image;
	}
	
}
