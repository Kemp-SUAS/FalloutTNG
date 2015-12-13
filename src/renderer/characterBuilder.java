package renderer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AssetHandling.ImageChanger;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.event.ActionEvent;

public class characterBuilder extends JFrame {

	private static final Graphics g = null;

	ArrayList<Image> images = new ArrayList<Image>();

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					characterBuilder frame = new characterBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame which has all the labels and buttons to customize the user.
	 */
	public characterBuilder() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Makes a label that says hair
		JLabel lblHair = new JLabel("Hair");
		lblHair.setBounds(624, 64, 58, 88);
		contentPane.add(lblHair);
		// Makes a label that says Body
		JLabel lblBody = new JLabel("Body");
		lblBody.setBounds(624, 291, 58, 88);
		contentPane.add(lblBody);
		// Makes a label that says Face
		JLabel lblFace = new JLabel("Face");
		lblFace.setBounds(624, 181, 65, 70);
		contentPane.add(lblFace);
		// Makes a button that says Change Body
		JButton btnChangeBody = new JButton("Change Body");
		btnChangeBody.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBody.setIcon(ImageChanger.mainScreenBackground());
			}
		});
		btnChangeBody.setBounds(24, 356, 145, 53);
		contentPane.add(btnChangeBody);
		// Makes a button that says Change Hair
		JButton btnChangeHair = new JButton("Change Hair");
		btnChangeHair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHair.setIcon(ImageChanger.mainScreenBackground());
			}
		});
		btnChangeHair.setBounds(24, 83, 139, 58);
		contentPane.add(btnChangeHair);
		// Makes a button that says Change Face
		JButton btnChangeFace = new JButton("Change Face");
		btnChangeFace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFace.setIcon(ImageChanger.mainScreenBackground());
			}
		});
		btnChangeFace.setBounds(24, 205, 145, 58);
		contentPane.add(btnChangeFace);
		
		// THis is a test to add a line on to the screen
		Line line;
		
		line= new Line (2,3,7,100,"BLACK");
		
		line.addLine(g);
		
	}
}
