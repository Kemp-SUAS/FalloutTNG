package world;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import renderer.Texture;
import renderer.WorldLayout;
import vault1.CharacterFolder.PlayerGameplayStats;
import world.Level;

public class NPC {	


	PlayerGameplayStats npcGameplayStats;
	WorldLayout topDwn;
	Level lvl;
	double rotation;
	Texture playerMode_up = new Texture("Assets/Pictures/Textures/Character/Unsorted/Characters/Shooter2.png");	
	
	int X;
	int Y;
	
	public NPC() {
		
	}
	
	private Object NpcDataInfo(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public NPC(int x, int y) {
		this.X = x + 32;
		this.Y = y + 32;
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

