package vault1.CharacterFolder;

import java.sql.SQLException;
import java.util.ArrayList;

import AssetHandling.AssetManager;

public class Level {

	private static String levelName;
	private static String imageData;
	private static String wallData;
	private static String playerPosition;
	private static String playerData;
	private static String npcData;
	private static int id;

	static ArrayList<String> npcDataInfo = new ArrayList<String>();
	static ArrayList<String> playerDataInfo = new ArrayList<String>();
	static ArrayList<String> playerPos = new ArrayList<String>();
	static ArrayList<String> wallDimensions = new ArrayList<String>();
	static ArrayList<String> imageInfo = new ArrayList<String>();
	
	public Level(int id) {
		Level.id = id;
		
	}

	public Level() {

	}

	public static  String getLevelName() {
		return levelName;
	}

	public static ArrayList<String> getImageData() {
		return imageInfo;
	}

	public static String getWallData() {
		return wallData;
	}

	public static String getPlayerPosition() {
		return playerPosition;
	}

	public static String getPlayerData() {
		return playerData;
	}

	public static String getNpcData() {
		return npcData;
	}

	public void setLevelName(String levelName) throws ClassNotFoundException, SQLException {
		Level.levelName = AssetManager.dataBaseGet("Level", id, "levelName");
	}

	// setters consist of string parsers each with their unique delims if
	// necessary.
	public void setImageData() {
		try {
			Level.imageData = AssetManager.dataBaseGet("Level", id, "imageData");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String delims = "[,]+";
		String[] transfer = Level.imageData.split(delims);
		for (int i = 0; i < transfer.length; i++) {
			imageInfo.add(transfer[i]);
		}
	}

	public void setWallData(String wallData) throws ClassNotFoundException, SQLException {
		this.wallData = AssetManager.dataBaseGet("Level", id, "wallData");
		String delims = "[\\/\\,]+";
		String[] transfer = this.wallData.split(delims);
		for (int i = 0; i < transfer.length; i++) {
			wallDimensions.add(transfer[i]);
		}
	}

	public void setPlayerPosition(String playerPosition) throws ClassNotFoundException, SQLException {
		this.playerPosition = AssetManager.dataBaseGet("Level", id, "playerPos");
		String delims = "[\\/\\]+";
		String[] transfer = this.playerPosition.split(delims);
		for (int i = 0; i < transfer.length; i++) {
			playerPos.add(transfer[i]);
		}
	}

	public void setPlayerData(String playerData) throws ClassNotFoundException, SQLException {
		this.playerData = AssetManager.dataBaseGet("Level", id, "playerData");
		String delims = "[\\/\\]+";
		String[] transfer = this.playerData.split(delims);
		for (int i = 0; i < transfer.length; i++) {
			playerDataInfo.add(transfer[i]);
		}
	}

	public void npcData(String npcData) throws ClassNotFoundException, SQLException {
		this.npcData = AssetManager.dataBaseGet("Level", id, "npcData");
		String delims = "[\\/\\]+";
		String[] transfer = this.npcData.split(delims);
		for (int i = 0; i < transfer.length; i++) {
			npcDataInfo.add(transfer[i]);
		}
	}
	public static String getIndexInfo(ArrayList<String> arrayList, int id) {
		return arrayList.get(id);
	}

}
