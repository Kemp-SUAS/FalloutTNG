package renderer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	@Override
	public void keyPressed(KeyEvent event) {
	
		int keyCode= event.getKeyCode();
		if(keyCode== event.VK_LEFT)
		{
			TopDownScroller.left=true;
			
			
		}
		if(keyCode== event.VK_RIGHT)
		{
			TopDownScroller.right=true;
			
		}
		
		if(keyCode== event.VK_UP)
		{
			TopDownScroller.up=true;
			
		}
		if(keyCode== event.VK_DOWN)
		{
			TopDownScroller.down=true;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		int keyCode= event.getKeyCode();
		if(keyCode== event.VK_LEFT)
		{
			TopDownScroller.left=false;
			
		}
		if(keyCode== event.VK_RIGHT)
		{
			TopDownScroller.right=false;
			
		}
		
		if(keyCode== event.VK_UP)
		{
			TopDownScroller.up=false;
			
		}
		if(keyCode== event.VK_DOWN)
		{
			TopDownScroller.down=false;
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		
		
	}

}
