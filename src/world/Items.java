package world;

import java.awt.Graphics;
import java.sql.SQLException;

import AssetHandling.AssetManager;
import renderer.Texture;

public class Items {
	int x,y;
	Texture item;
	Collision collision;
	public Items(int x, int y, int id) {
		this.x = x;
		this.y = y;
		if(id>20){
			id = 5;
		}
        try {
			AssetManager.dataBaseGet("items", id, "image");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        collision = new Collision(x,x+50,y,y+75);
	}
	public Collision getCollide(){
		return this.collision;
	}
	public void render(Graphics g, int xOffset, int yOffset){
		item.render(g, this.x + xOffset, this.y +yOffset);
	}
}
