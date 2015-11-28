package Renderer.ScenesFloder;

import javax.swing.JPanel;
import java.awt.Button;

public class MainMenuScene extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainMenuScene() {
		setLayout(null);
		
		Button ContinueButtoon = new Button("Continue");
		ContinueButtoon.setBounds(329, 99, 70, 22);
		add(ContinueButtoon);
		
		Button loadButton = new Button("Load");
		loadButton.setBounds(329, 127, 70, 22);
		add(loadButton);
		
		Button newGameButton = new Button("New Game");
		newGameButton.setBounds(329, 157, 70, 22);
		add(newGameButton);
		
		Button exitButton = new Button("Exit");
		exitButton.setBounds(329, 185, 70, 22);
		add(exitButton);

	}
}
