package world;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import renderer.Texture;
import renderer.WorldLayout;
import vault1.CharacterFolder.PlayerGameplayStats;

public class NPC {

	PlayerGameplayStats npcGameplayStats;
	WorldLayout topDwn;
	double rotation;
	Texture playerMode_up = new Texture("Assets/Pictures/Textures/Character/Unsorted/Characters/Shooter2.png");
	int X = 0;
	int Y = 0;
	
	public NPC() {
		
	}
	
	public NPC(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	public void tick(WorldLayout topDwn) {
		this.topDwn = topDwn;
	}

	public void render(Graphics g, double xOffset , double yOffset) {
		BufferedImage manager = null;
		try {
			manager = ImageIO.read(new File("Assets/Pictures/Textures/Character/Unsorted/Characters/Shooter2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		playerMode_up.render(g, X + xOffset, Y + yOffset);
	
	}
}

