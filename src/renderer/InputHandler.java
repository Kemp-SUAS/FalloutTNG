package renderer;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;


public class InputHandler implements KeyListener {
	@Override
	public void keyPressed(KeyEvent event) {
	
		int keyCode= event.getKeyCode();
		if(keyCode== event.VK_LEFT)
		{
			WorldLayout.left=true;
		}

		if(keyCode== event.VK_RIGHT)
		{
			WorldLayout.right=true;
			
		}
		if(keyCode== event.VK_UP)
		{
			WorldLayout.up=true;
		}
		if(keyCode== event.VK_DOWN)
		{
			WorldLayout.down=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		int keyCode= event.getKeyCode();
		if(keyCode== event.VK_LEFT)
		{
			WorldLayout.left=false;
			
		}
		if(keyCode== event.VK_RIGHT)
		{
			WorldLayout.right=false;
			
		}
		
		if(keyCode== event.VK_UP)
		{
			WorldLayout.up=false;
			
		}
		if(keyCode== event.VK_DOWN)
		{
			WorldLayout.down=false;
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		
		
	}

}
