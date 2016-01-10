package renderer;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.sun.glass.events.WindowEvent;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable {

	public static final String NAME= "Fallout TNG";
	public static final int WIDTH= 700;
	public static final int HEIGHT= WIDTH/4*3;
	private boolean running;
	private Texture texture;
	private Texture texture2;
	private Texture texture3;
	private GameStates gsm;
	
	public Game()
	{
		texture= new Texture("Test.png");
		texture2= new Texture("Test.png");
		texture3= new Texture("Test.png");
	}
	
	
	private void tick()
	{
		
	}
	private void render()
	{
		BufferStrategy bS= getBufferStrategy();
		if(bS==null)
		{
			createBufferStrategy(3);
			return;
			
		}
		
		Graphics g= bS.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		texture.render(g, 100,100);
		texture2.render(g, 200,150);
		texture3.render(g, 300,150);
		
		g.dispose();
		bS.show();
		
		
	}
	
	private void start()
	{
		if (running)return;
		running=true;
		
		new Thread(this,"GameMain-thread").start();
	}
	private void stop()
	{
		if (!running)return;
		running=false;
		
		System.exit(0);
		
			}
	
	
	
	@Override
	public void run() {
		gsm = new GameStates();
		double target = 60.0;
		double secondsPerTarget=1000000000.0/target;
		long last= System.nanoTime();
		long time= System.currentTimeMillis();
		double notUsing= 0;
		int fps=0;
		int tps=0;
		boolean canRender= false;
		
		
				
		while(running)
		{
			long now = System.nanoTime();
			notUsing+=(now-last)/secondsPerTarget;
			last=now;
			
			if(notUsing>=1.0)
			{
				tick();
				notUsing--;
				tps++;
				canRender =true;
				
			}else canRender= false;
			try
			{
			Thread.sleep(1);
			}catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			if(canRender)
			{
				render();
				fps++;
				
			}
			if(System.currentTimeMillis()-1000>time)
			{
				time+=1000;
				
				fps=0;
				tps=0;
				
						
			}
		}
		

	}
	
	public static void main(String[] args)
	{
		Game game = new Game();
		
		JFrame frame= new JFrame(NAME);
		
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setFocusable(true);
		
		//inner anonymous method in class
		frame.addWindowListener(new WindowListener()
				{
			public void windowClosing(WindowEvent e){
				
			System.err.println("Exsiting Game");
			
				game.stop();
			
			}

			@Override
			/**
			 * NOT USED!
			 * @param arg0
			 */
			public void windowActivated(java.awt.event.WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			/**
			 * NOT USED!
			 * @param arg0
			 */
			public void windowClosed(java.awt.event.WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			/**
			 * NOT USED!
			 * @param arg0
			 */
			public void windowClosing(java.awt.event.WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			/**
			 * NOT USED!
			 * @param arg0
			 */
			public void windowDeactivated(java.awt.event.WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			/**
			 * NOT USED!
			 * @param arg0
			 */
			public void windowDeiconified(java.awt.event.WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			/**
			 * NOT USED!
			 * @param arg0
			 */
			public void windowIconified(java.awt.event.WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			
			/**
			 * NOT USED!
			 * @param arg0
			 */
			public void windowOpened(java.awt.event.WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
				}
				
				);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.requestFocus();
		game.start();
		
	}
	
	

}
