package renderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;



public class playerMovementDemo extends JFrame implements ActionListener, KeyListener{

	Timer tm = new Timer(5, this);
	int x = 0, y = 0, velX = 0, velY = 0;
	
	public void playerMovementDemo(){
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	public void paitComponent(Graphics g){
		super.paintComponents(g);
		g.setColor(Color.black);
		g.fillRect(x, y, 30, 30);
	}
	public void actionPerformed(ActionEvent e){
		x = x+ velX;
		y = y+velY;
		repaint();
	}
	public void keyPressed(KeyEvent e){
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_A){
			velX = -1;
			velY = 0;
		}
		if(c == KeyEvent.VK_W){
			velX = 0;
			velY = 1;
		}
		if(c == KeyEvent.VK_D){
			velX = 1;
			velY = 0;
		}
		if(c == KeyEvent.VK_S){
			velX = 0;
			velY = -1;
		}		
	}
	public void keyTyped(KeyEvent e){		
	}
	public void keyReleased(KeyEvent e){
		velX = 0;
		velY = 0;
	}
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		playerMovementDemo t = new playerMovementDemo();
		JFrame jf = new JFrame();
		jf.setTitle("Tutorial");
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					playerMovementDemo frame = new playerMovementDemo();
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
	public playerMovementDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	

}
