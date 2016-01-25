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

	private Collision collision ;
	
	private PlayerGameplayStats npcGameplayStats;
	private WorldLayout topDwn;
	private Level lvl;
	double rotation;
	Texture playerMode_up = new Texture("Assets/Pictures/Textures/Character/Unsorted/Characters/Shooter2.png");	
	
	int X;
	int Y;
	
	public NPC() {
		
		
		
	}
	/**
	 * 
	 * @param i
	 */
	private Object NpcDataInfo(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public NPC(int x, int y) {
		

		this.X = x + 32;
		this.Y = y + 32;
		
		collision = new Collision(X, X+40,Y,Y+40);
		
		
	}
	public boolean collide(double xOffset, double yOffset){
		if(xOffset>(this.X + xOffset)-50 && xOffset<(this.X + xOffset)+50&& yOffset>(this.Y + yOffset)-50
				&& yOffset>(this.Y + yOffset)+50){
			return true;
		}
		return false;
	}
	public double getX(){
		return this.X;
	}
	public double getY(){
		return this.Y;
	}
	/**
	 * 
	 * @param topDwn
	 */
	public void tick(WorldLayout topDwn) {
		this.topDwn = topDwn;
	}
	/**
	 * 
	 * @param g
	 * @param xOffset
	 * @param yOffset
	 */
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

