package Renderer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	 */
	public characterBuildingDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton continueButton = new JButton("");
		continueButton.setBounds(840, 291, 182, 47);
		contentPane.add(continueButton);
		Image continueIdle = new ImageIcon("E:\\Downloads\\continue_Idle.png").getImage().getScaledInstance(continueButton.getWidth(),continueButton.getHeight(),java.awt.Image.SCALE_SMOOTH);
		continueButton.setIcon(new ImageIcon(continueIdle));
		continueButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Image continueIdle = new ImageIcon("E:\\Downloads\\continue_Idle.png").getImage().getScaledInstance(continueButton.getWidth(),continueButton.getHeight(),java.awt.Image.SCALE_SMOOTH);
				continueButton.setIcon(new ImageIcon(continueIdle));
			}
		});
	}
}
