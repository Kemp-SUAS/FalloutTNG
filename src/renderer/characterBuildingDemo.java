package renderer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
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

public class characterBuildingDemo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					characterBuildingDemo frame = new characterBuildingDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public characterBuildingDemo() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton continueButton = new JButton("");
		continueButton.setBounds(840, 291, 182, 47);
		contentPane.add(continueButton);
		Image continueIdle = new ImageIcon(AssetLocations.mainMenuContinue("idle")).getImage().getScaledInstance(continueButton.getWidth(),continueButton.getHeight(),java.awt.Image.SCALE_SMOOTH);
		continueButton.setIcon(new ImageIcon(continueIdle));
		continueButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Image continueClick = new ImageIcon(AssetLocations.mainMenuContinue("click")).getImage().getScaledInstance(continueButton.getWidth(),continueButton.getHeight(),java.awt.Image.SCALE_SMOOTH);
				continueButton.setIcon(new ImageIcon(continueClick));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				continueButton.setIcon(new ImageIcon(continueIdle));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Image continueHover = new ImageIcon(AssetLocations.mainMenuContinue("hover")).getImage().getScaledInstance(continueButton.getWidth(),continueButton.getHeight(),java.awt.Image.SCALE_SMOOTH);
				continueButton.setIcon(new ImageIcon(continueHover));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				continueButton.setIcon(new ImageIcon(continueIdle));
			}
		});
	}
}
