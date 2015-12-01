package renderer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.awt.event.ActionEvent;

public class characterBuilder extends JFrame {

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
	 * Create the frame.
	 */
	public characterBuilder() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 666);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHair = new JLabel("Hair");
		lblHair.setBounds(624, 64, 58, 88);
		contentPane.add(lblHair);

		JLabel lblBody = new JLabel("Body");
		lblBody.setBounds(624, 291, 58, 88);
		contentPane.add(lblBody);

		JLabel lblFace = new JLabel("Face");
		lblFace.setBounds(624, 181, 65, 70);
		contentPane.add(lblFace);

		JButton btnChangeBody = new JButton("Change Body");
		btnChangeBody.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblBody.setIcon(ImageChanger.mainScreenBackground());
			}
		});
		btnChangeBody.setBounds(24, 356, 145, 53);
		contentPane.add(btnChangeBody);

		JButton btnChangeHair = new JButton("Change Hair");
		btnChangeHair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblHair.setIcon(ImageChanger.mainScreenBackground());
			}
		});
		btnChangeHair.setBounds(24, 83, 139, 58);
		contentPane.add(btnChangeHair);

		JButton btnChangeFace = new JButton("Change Face");
		btnChangeFace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFace.setIcon(ImageChanger.mainScreenBackground());
			}
		});
		btnChangeFace.setBounds(24, 205, 145, 58);
		contentPane.add(btnChangeFace);
	}
}
