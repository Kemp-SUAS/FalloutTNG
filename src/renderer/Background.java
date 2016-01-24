package renderer;

import java.awt.Color;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {

	public double x;
	public double y;
	public double oX, oY;
	WorldLayout topDwn;
	String fileName;

	public Background(double x, double y, WorldLayout TopDwn, String fileName) {
		this.oX = x;
		this.oY = y;
		this.fileName = fileName;

	}

	public void tick(WorldLayout topDwn)

	{
		this.topDwn = topDwn;
		x = oX + topDwn.xOffset;
		y = oY + topDwn.yOffset;

	}

	public void render(Graphics g) throws IOException {
		
		BufferedImage manager = ImageIO.read(new File(this.fileName));
		g.drawImage(manager, (int) this.x,(int) this.y, null);

	}

}
