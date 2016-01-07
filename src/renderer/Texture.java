package renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.sun.javafx.collections.MappingChange.Map;
/**
 * I think we don't want a static entity because then there could be 
 * too many errors so what I am thinking is that if we give the texture to the object then
 * assign it to a specific key.This way when we load the file it will recognize that the file has been used(sprite sheet hold many images
 * so it can be called more than once) then get it from the map instead of loading.
 * Overall it will help with saving and memory management
 * @author Faduma Ahmed Mohid Aslam Simarpal Kalsi Keiran Wilson
 */
public class Texture {
	
	private final static HashMap<String, TextureManager> textureMap= new HashMap<String,TextureManager>();
	
	// store texture in memory so we can use it
	@SuppressWarnings("unused")
	private TextureManager manager;
	
	// if the file is empty
	private String fileName;
	@SuppressWarnings("unused")
	private Texture texture;
	
	
	
	@SuppressWarnings("unchecked")
	public Texture(String fileName)
	{
		this.fileName=fileName;
		
		TextureManager oldTexture = textureMap.get(fileName);
		
		
		
		if(oldTexture != null)
		{
			manager=oldTexture;
			manager.addReference();
		}
		else
		{
			try{
				// it don't support file or input stream, adding that could cause error
				
				manager=  new TextureManager(ImageIO.read(new File("Assets/Pictures/Textures/"+ fileName+ ".png")));
				//((HashMap<String, Texture>) textureMap).put(fileName,this);
				
			
			}
			catch(IOException imageException)
			{
				imageException.printStackTrace();
				
			}}
		
		
		
	}
	/**
	 * Overrrives finalize() in super Object
	 * AutoMatically Called during Garbage Collection(in run time)
	 */
	
	@Override
	protected void finalize() throws Throwable
	{
		// automatically removes texture when no longer needed
		if(manager.removeReference() && !fileName.isEmpty()) textureMap.remove(fileName);
		
		
		super.finalize();
	}
	

	public void render(Graphics g, double x, double y)
	{
		
		
		g.drawImage(manager.getImage(), (int)x, (int) y, null);
	}
}
