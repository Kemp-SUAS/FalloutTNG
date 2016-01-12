package renderer;

import java.io.IOException;
import java.sql.SQLException;

public class game {

	public static boolean continueButton = false;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {		
		MainMenu menu = new MainMenu();		
	//	menu.run();
		menu.start();
		/*System.out.print(continueButton);
		menu.start();
	
		if(continueButton){
			System.out.print(continueButton);
			menu.stop();
			System.out.print(continueButton);	
			WorldLayout TopDwn = new WorldLayout();
			TopDwn.start();
		}*/

	
		

	}

}
