package renderer;

import java.sql.SQLException;

public class game {

	public static boolean continueButton = false;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {		
		
		MainMenu menu = new MainMenu();		

		System.out.print(continueButton);
		menu.start();
	
		if(continueButton){
			System.out.print(continueButton);
			menu.stop();
			System.out.print(continueButton);	
			WorldLayout TopDwn = new WorldLayout();
			TopDwn.start();
		}

	
		

	}

}
