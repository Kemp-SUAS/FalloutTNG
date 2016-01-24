package renderer;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import AssetHandling.AssetManager;

public class Main {
	private static final String INTRO = "MainMenu";
	private static final String GAME = "game";
	private CardLayout cardlayout = new CardLayout();
	private JPanel mainPanel = new JPanel(cardlayout);
	private IntroPanel introPanel = new IntroPanel();
	private GamePanel gamePanel = new GamePanel();
	private static final Dimension MAIN_SIZE = new Dimension(1040, 600);
	private JButton back = new JButton("main menu");

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

	private JComponent getMainComponent() {
		return mainPanel;
	}

	private static void createAndShowUI() {
		JFrame frame = new JFrame("FALLOUT TNG");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Main().getMainComponent());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				createAndShowUI();
			}
		});
	}
}

	class IntroPanel {
	private JPanel contentPane = new JPanel();
	private JButton start = new JButton("Start");
	private JButton exit = new JButton("Exit");
	
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
					Window win = SwingUtilities.getWindowAncestor(contentPane);
					win.dispose();
					WorldLayout TopDwn = new WorldLayout();
					TopDwn.start();
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
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window win = SwingUtilities.getWindowAncestor(contentPane);
				win.dispose();
			}
		});
		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window win = SwingUtilities.getWindowAncestor(contentPane);
				win.dispose();
				WorldLayout TopDwn = new WorldLayout();
				TopDwn.start();
			}
		});
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
		try {
			lblNewLabel.setIcon(new ImageIcon(AssetManager.dataBaseGet("image_strings", 13, "path" )));
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		lblNewLabel.setBounds(0, 0, 1048, 600);
		contentPane.add(lblNewLabel);
	}

	public void addActionListener(ActionListener listener) {
		start.addActionListener(listener);
	}

	public JComponent getMainComponent() {
		return contentPane;
	}
	static Image imageMaker(String table, String column, int id, JButton b) throws ClassNotFoundException, SQLException{
		String path = AssetManager.dataBaseGet(table, id, column);

		Image image = new ImageIcon(path).getImage().getScaledInstance(b.getWidth(),b.getHeight(),java.awt.Image.SCALE_SMOOTH);
		return image;
	}

}

	class GamePanel {

	private JPanel mainPanel = new JPanel();

	private JButton back;

	public GamePanel() {

		back = new JButton("return to main menu");

		mainPanel.add(back);

	}

	public JComponent getMainComponent() {
		return mainPanel;
	}

	public void addBackActionListener(ActionListener listener) {
		back.addActionListener(listener);

	}

}
