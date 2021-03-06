package renderer;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import AssetHandling.AssetManager;

/**
 * 
 * This class is to hold the main screen and all the panels/ frames in the game.
 * it uses card layout to change perspective
 * 
 * @author faduma ahmed, Keiran Wilson, Mohid Aslam, Simar Pal Kalsi
 *
 */
public class Main {

	/**
	 * the name of the menu
	 * 
	 */
	private static final String INTRO = "MainMenu";
	/**
	 * the name of the game
	 * 
	 */
	private static final String GAME = "game";
	/**
	 * the card layout to be used
	 * 
	 */
	private CardLayout cardlayout = new CardLayout();
	/**
	 * the main screen panel
	 * 
	 */
	private JPanel mainPanel = new JPanel(cardlayout);
	/**
	 * the into game panel
	 * 
	 */
	private IntroPanel introPanel = new IntroPanel();
	/**
	 * the game panel
	 * 
	 */
	private GamePanel gamePanel = new GamePanel();
	/**
	 * the dimensions of the screen
	 * 
	 */
	private static final Dimension MAIN_SIZE = new Dimension(1040, 600);
	/**
	 * the button to return to main menu
	 * 
	 */
	private JButton back = new JButton("main menu");

	/**
	 * sets the main menu and all the layouts used
	 */
	public Main() {
		mainPanel.add(introPanel.getMainComponent(), INTRO);
		mainPanel.add(gamePanel.getMainComponent(), GAME);
		mainPanel.setPreferredSize(MAIN_SIZE);
		introPanel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, GAME);

			}
		});

		gamePanel.addBackActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardlayout.show(mainPanel, INTRO);

			}
		});
	}

	/**
	 * 
	 * @return mainPanel
	 */
	private JComponent getMainComponent() {
		return mainPanel;
	}

	/**
	 * 
	 */
	private static void createAndShowUI() {
		JFrame frame = new JFrame("FALLOUT TNG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Main().getMainComponent());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				createAndShowUI();
			}
		});
	}
}

class IntroPanel {

	/**
	 * the panel for this layout
	 */
	private JPanel contentPane = new JPanel();
	/**
	 * button to start the game
	 * 
	 */
	private JButton start = new JButton("Start");
	/**
	 * button to exit the game
	 * 
	 */
	private JButton exit = new JButton("Exit");
	/**
	 * 
	 */

	/**
	 * 
	 */
	/**
	 * 
	 */
	public IntroPanel() {
		contentPane.setLayout(null);
		start = new JButton("Start");
		start.setBounds(840, 191, 182, 47);
		exit = new JButton("exit");
		exit.setBounds(840, 191, 182, 47);
		JButton continueButton = new JButton("");
		continueButton.setBounds(840, 191, 182, 47);
		contentPane.add(continueButton);
		contentPane.add(start);

		contentPane.add(exit);
		try {
			continueButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 3, continueButton)));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		;
		continueButton.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.
			 * MouseEvent)
			 */
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

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mouseReleased(MouseEvent e) {
				try {
					continueButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 3, continueButton)));
					Window win = SwingUtilities.getWindowAncestor(contentPane);
					win.dispose();
					WorldLayout TopDwn = new WorldLayout();
					TopDwn.start();
					InventoryScreen inventory = new InventoryScreen();
					inventory.start();

				} catch (ClassNotFoundException e1) {

					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseEntered(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mouseEntered(MouseEvent e) {
				try {
					continueButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 2, continueButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseExited(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mouseExited(MouseEvent e) {
				try {
					continueButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 3, continueButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}
		});
		exit.addActionListener(new ActionListener() {
			@Override
			/**
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				Window win = SwingUtilities.getWindowAncestor(contentPane);
				win.dispose();
			}
		});
		start.addActionListener(new ActionListener() {
			@Override
			/**
			 * 
			 */
			public void actionPerformed(ActionEvent e) {
				Window win = SwingUtilities.getWindowAncestor(contentPane);
				win.dispose();
				WorldLayout TopDwn = new WorldLayout();
				TopDwn.start();
			}
		});
		JButton loadButton = new JButton("");
		loadButton.setBounds(840, 291, 182, 47);

		try {
			loadButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 6, loadButton)));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		;
		loadButton.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.
			 * MouseEvent)
			 */
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

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mouseReleased(MouseEvent e) {
				try {
					loadButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 6, loadButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseEntered(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mouseEntered(MouseEvent e) {
				try {
					loadButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 5, loadButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseExited(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mouseExited(MouseEvent e) {
				try {
					loadButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 6, loadButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}
		});
		/**
		 * Creates the button.
		 * 
		 * 
		 */
		JButton newGameButton = new JButton("");

		newGameButton.setBounds(840, 391, 182, 47);

		try {
			newGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 9, newGameButton)));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		;
		newGameButton.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.
			 * MouseEvent)
			 */
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

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mouseReleased(MouseEvent e) {
				try {
					newGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 9, newGameButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseEntered(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mouseEntered(MouseEvent e) {
				try {
					newGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 8, newGameButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseExited(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mouseExited(MouseEvent e) {
				try {
					newGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 9, newGameButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}
		});

		JButton exitGameButton = new JButton("");
		exitGameButton.setBounds(840, 491, 182, 47);
		contentPane.add(exitGameButton);
		try {
			exitGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 12, exitGameButton)));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		;
		exitGameButton.addMouseListener(new MouseAdapter() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mousePressed(MouseEvent e) {
				try {
					exitGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 10, exitGameButton)));
					JFrame frameClose = new JFrame();
					frameClose.dispatchEvent(new WindowEvent(frameClose, WindowEvent.WINDOW_CLOSING));
					frameClose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					System.exit(0);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseReleased(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mouseReleased(MouseEvent e) {
				try {
					exitGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 12, exitGameButton)));
					

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseEntered(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mouseEntered(MouseEvent e) {
				try {
					exitGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 11, exitGameButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.awt.event.MouseAdapter#mouseExited(java.awt.event.
			 * MouseEvent)
			 */
			@Override

			public void mouseExited(MouseEvent e) {
				try {
					exitGameButton.setIcon(new ImageIcon(imageMaker("image_strings", "path", 12, exitGameButton)));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				;
			}
		});
		JLabel lblNewLabel = new JLabel("New label");
		try {
			lblNewLabel.setIcon(new ImageIcon(AssetManager.dataBaseGet("image_strings", 13, "path")));
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblNewLabel.setBounds(0, 0, 1048, 600);
		contentPane.add(lblNewLabel);
	}

	/**
	 * 
	 * @param listener,
	 *            add actions listeners to the buttons
	 */
	public void addActionListener(ActionListener listener) {
		start.addActionListener(listener);
	}

	/**
	 * 
	 * @return contentPane, get the contentPane from main
	 */
	public JComponent getMainComponent() {
		return contentPane;
	}

	/**
	 * This static method allows data to be stored in the SQLite database
	 * 
	 * @param tableName
	 *            Name of the table.
	 * @param column
	 *            The column being placed into.
	 * @param id
	 *            The value of the stored string.
	 * @param b
	 *            The button the image will appear on
	 * @throws SQLException
	 *             exception that provides information on a database access
	 *             error or other errors.
	 * @throws ClassNotFoundException
	 *             An exception that provides information on a database access
	 *             error or other errors.
	 */
	static Image imageMaker(String table, String column, int id, JButton b)
			throws ClassNotFoundException, SQLException {
		String path = AssetManager.dataBaseGet(table, id, column);

		Image image = new ImageIcon(path).getImage().getScaledInstance(b.getWidth(), b.getHeight(),
				java.awt.Image.SCALE_SMOOTH);
		return image;
	}

}

/**
 * 
 * This class was a test just to see if the panels can switch on the same frame
 * 
 * @author faduma ahmed, Keiran Wilson, Mohid Aslam, Simar Pal Kalsi
 *
 */
class GamePanel {

	/**
	 * the panel for this class to use
	 */
	private JPanel mainPanel = new JPanel();

	/**
	 * button to return back to the screen
	 */
	private JButton back;

	public GamePanel() {

		back = new JButton("return to main menu");

		mainPanel.add(back);

	}

	/**
	 * 
	 * @return mainPanel, returns to the main panel
	 */
	public JComponent getMainComponent() {
		return mainPanel;
	}

	/**
	 * 
	 * @param listener
	 *            , returns back to the ancestor panel
	 */
	public void addBackActionListener(ActionListener listener) {
		back.addActionListener(listener);

	}

}
