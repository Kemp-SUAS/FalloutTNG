package renderer;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import vault1.CharacterFolder.PlayerSkillPoints;
/**
 * This screen is displayed while the user plays the game so they are able to see the contents on them.
 * @author Kieran Wilson, Faduma Ahmed, Simar Kalsi, Mohid Aslam 
 *
 */

public class InventoryScreen extends JPanel implements Runnable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4092094527771064840L;

	public PlayerSkillPoints skill = new PlayerSkillPoints();

	public static JPanel inventory = new JPanel(new BorderLayout());
	private JButton strength = new JButton("Strength");
	private JLabel strengthLabel;
	private JButton awareness = new JButton("Awareness");
	private JLabel awarenessLabel;
	private JButton endurance = new JButton("Endurance");
	private JLabel enduranceLabel;
	private JButton luck = new JButton("Luck");
	private JLabel luckLabel;
	private JButton intelligence = new JButton("Intelligence");
	private JLabel intelligenceLabel;
	private JButton wit = new JButton("wit");
	private JLabel witLabel;
	private JButton dexterity = new JButton("Dexterity");
	private JLabel dexterityLabel;
	private JButton weightCarryMultiplier = new JButton("Weight Carry Multiplier");
	private JLabel weightCarryMultiplierLabel;
	private JButton backToMain = new JButton("Return to Main Menu");
	private JButton backToGame = new JButton("Return To The Game");
	private JButton exit = new JButton("Exit");
	private long lastTime;
	private long timer = 1000 / 60;
	private double fps;
	private static Boolean running = false;

	
	/**
	 * The inventory screen displayed on the screen and shows the stats of the player in game.
	 */
	public InventoryScreen() {
		
		super();
		inventory.setLayout(null);

		strength.setBounds(150, 200, 182, 47);
		strengthLabel.setBounds(250, 200, 182, 47);

		awareness.setBounds(150, 250, 182, 47);
		awarenessLabel.setBounds(250, 250, 182, 47);

		endurance.setBounds(150, 300, 182, 47);
		enduranceLabel.setBounds(250, 300, 182, 47);

		luck.setBounds(150, 350, 182, 47);
		luckLabel.setBounds(250, 350, 182, 47);

		wit.setBounds(150, 400, 182, 47);
		witLabel.setBounds(250, 400, 182, 47);

		intelligence.setBounds(150, 450, 182, 47);
		intelligenceLabel.setBounds(250, 450, 182, 47);

		dexterity.setBounds(150, 500, 182, 47);
		dexterityLabel.setBounds(250, 500, 182, 47);

		weightCarryMultiplier.setBounds(150, 550, 182, 47);
		weightCarryMultiplierLabel.setBounds(250, 550, 182, 47);

		backToMain.setBounds(150, 600, 182, 47);

		backToGame.setBounds(150, 650, 182, 47);

		exit.setBounds(150, 700, 182, 47);

		inventory.add(awareness);
		inventory.add(awarenessLabel);

		inventory.add(strength);
		inventory.add(strengthLabel);

		inventory.add(endurance);
		inventory.add(enduranceLabel);

		inventory.add(luck);
		inventory.add(luckLabel);
		inventory.add(witLabel);

		inventory.add(wit);

		inventory.add(dexterity);
		inventory.add(dexterityLabel);

		inventory.add(intelligence);
		inventory.add(intelligenceLabel);

		inventory.add(weightCarryMultiplier);
		inventory.add(weightCarryMultiplierLabel);

		inventory.add(backToMain);

		inventory.add(backToGame);

		inventory.add(exit);

		awareness.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {
					if(skill.getAwarenessStat() != 0)
				
				awarenessLabel.setText(String.valueOf(skill.getAwarenessStat()));
					
					else
			   awarenessLabel.setText(String.valueOf(0));
						

			}

		});

		strength.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

				if(skill.getStrengthStat() != 0)
					
					strengthLabel.setText(String.valueOf(skill.getAwarenessStat()));
						
						else
					strengthLabel.setText(String.valueOf(0));
				
				

			}

		});

		endurance.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

					if(skill.getEnduranceStat() != 0)
					
						enduranceLabel.setText(String.valueOf(skill.getEnduranceStat()));
						
						else
						enduranceLabel.setText(String.valueOf(0));
				

			}

		});

		luck.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

				if(skill.getLuckStat() != 0)
					
					luckLabel.setText(String.valueOf(skill.getLuckStat()));
					
					else
					luckLabel.setText(String.valueOf(0));
				
				

			}

		});
		wit.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

					if(skill.getWitStat() != 0)
					
					witLabel.setText(String.valueOf(skill.getWitStat()));
					
					else
					witLabel.setText(String.valueOf(0));

			}

		});

		dexterity.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

					if(skill.getDexterityStat() != 0)
					
						dexterityLabel.setText(String.valueOf(skill.getDexterityStat()));
					
					else
						dexterityLabel.setText(String.valueOf(0));

			}

		});

		intelligence.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

				if(skill.getIntelligenceStat() ==0)
					
					intelligenceLabel.setText(String.valueOf(skill.getIntelligenceStat()));
				
				else
					intelligenceLabel.setText(String.valueOf(0));

			}

		});
		
		backToGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window win = SwingUtilities.getWindowAncestor(inventory);
				win.dispose();
				WorldLayout TopDwn = new WorldLayout();
				TopDwn.start();
			}
		});
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window win = SwingUtilities.getWindowAncestor(inventory);
				win.dispose();
			}
		});
		backToMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window win = SwingUtilities.getWindowAncestor(inventory);
				win.dispose();
				Main main= new Main();
				
				
				
				
				
			}
		});
		
	}
	
		@Override
		public void paintComponent(Graphics g)
		{
		  super.paintComponent(g);
		   ImageIcon i = new ImageIcon("Assets/Pictures/MainScreen/Inventory.png");
		  i.paintIcon(this, g, 0, 0);
		  
		}
		
		
		synchronized void start() {
			running = true;
			Thread thread = new Thread(this);
			thread.start();

		}

		@Override
		public void run() {
			long timer = 1000 / 60;

			while (running) {
				lastTime = System.nanoTime();
				try {
					Thread.sleep(timer);
				} catch (InterruptedException e) {

				}
				setFps(1000000000.0 / (System.nanoTime() - lastTime));
				lastTime = System.nanoTime();
				
				
				}

			}

		public double getFps() {
			return fps;
		}

		public void setFps(double fps) {
			this.fps = fps;
		}

		}



