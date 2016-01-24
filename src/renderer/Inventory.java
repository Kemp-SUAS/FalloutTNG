package renderer;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vault1.CharacterFolder.PlayerSkillPoints;

public class Inventory {

	public PlayerSkillPoints skill = new PlayerSkillPoints();

	private JPanel inventory = new JPanel();
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

	public Inventory() {
		Image background = Toolkit.getDefaultToolkit().createImage("Assets/Pictures/MainScreen/Inventory.png");

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

		inventory.add(strength);

		inventory.add(endurance);

		inventory.add(luck);

		inventory.add(wit);

		inventory.add(dexterity);

		inventory.add(intelligence);

		inventory.add(weightCarryMultiplier);

		inventory.add(backToMain);

		inventory.add(backToGame);

		inventory.add(exit);

		awareness.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

				awarenessLabel.setText(String.valueOf(skill.getAwarenessStat()));

			}

		});

		strength.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

				strengthLabel.setText(String.valueOf(skill.getStrengthStat()));

			}

		});

		endurance.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

				enduranceLabel.setText(String.valueOf(skill.getEnduranceStat()));

			}

		});

		luck.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

				luckLabel.setText(String.valueOf(skill.getLuckStat()));

			}

		});
		wit.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

				witLabel.setText(String.valueOf(skill.getWitStat()));

			}

		});

		dexterity.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

				dexterityLabel.setText(String.valueOf(skill.getDexterityStat()));

			}

		});

		intelligence.addMouseListener(new MouseAdapter()

		{
			public void mousePressed(MouseEvent e) {

				intelligenceLabel.setText(String.valueOf(skill.getIntelligenceStat()));

			}

		});

	}

}
