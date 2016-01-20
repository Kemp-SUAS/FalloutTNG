package renderer;

import java.io.IOException;
import java.sql.SQLException;

public class game {

	public static boolean continueButton = false;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		WorldLayout TopDwn = new WorldLayout();
		TopDwn.start();

	}

}
