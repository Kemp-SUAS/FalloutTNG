package vault1.CharacterFolder;

import java.awt.Color;
import renderer.Texture;

import java.awt.Graphics;
import renderer.WorldLayout;
import renderer.InputHandler;

public class Player {

	int x = 368;
	int y = 268;
	WorldLayout topDwn;
	Texture playerMode_up = new Texture("Assets/Pictures/Textures/Character/Unsorted/Characters/Shooter2.png");
	
	public Player(WorldLayout topDwn) {

		this.topDwn = topDwn;

	}

	public void tick(WorldLayout topDwn) {
		this.topDwn = topDwn;

	}

	public void render(Graphics g) {
			playerMode_up.render(g, x, y);
	}
}
