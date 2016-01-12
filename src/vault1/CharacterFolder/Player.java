package vault1.CharacterFolder;

import java.awt.Color;

import java.awt.Graphics;
import renderer.WorldLayout;

public class Player {

	int x=400;
	int y=300;
	WorldLayout topDwn;

	public Player(WorldLayout topDwn) {
		
		this.topDwn = topDwn;

	}

	public void tick(WorldLayout topDwn) {
		this.topDwn = topDwn;
		
	}
	public void render(Graphics g)
	{
		g.setColor(Color.PINK.darker());
		
		g.fillRect(x, y, 32, 32);
	}
}
