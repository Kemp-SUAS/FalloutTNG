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

	public Level(int id) {
		this.id = id;

	}

	public Level() {

	}

	public static String getLevelName() {
		return levelName;
	}

	public static String getImageData() {
		return imageData;
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
	public void setImageData(String imageData) throws ClassNotFoundException, SQLException {
		this.imageData = AssetManager.dataBaseGet("Level", id, "imageData");
		String delims = "[\\/\\]+";
		String[] transfer = this.imageData.split(delims);
		ArrayList<String> imageInfo = new ArrayList<String>();
		for (int i = 0; i < transfer.length; i++) {
			imageInfo.add(transfer[i]);
		}
		imageInfo.remove(0);
	}

	public void setWallData(String wallData) throws ClassNotFoundException, SQLException {
		this.wallData = AssetManager.dataBaseGet("Level", id, "wallData");
		String delims = "[\\/\\,]+";
		String[] transfer = this.wallData.split(delims);
		ArrayList<String> wallDimensions = new ArrayList<String>();
		for (int i = 0; i < transfer.length; i++) {
			wallDimensions.add(transfer[i]);
		}
		wallDimensions.remove(0);
	}

	public void setPlayerPosition(String playerPosition) throws ClassNotFoundException, SQLException {
		this.playerPosition = AssetManager.dataBaseGet("Level", id, "playerPos");
		String delims = "[\\/\\]+";
		String[] transfer = this.playerPosition.split(delims);
		ArrayList<String> playerPos = new ArrayList<String>();
		for (int i = 0; i < transfer.length; i++) {
			playerPos.add(transfer[i]);
		}
		playerPos.remove(0);
	}

	public void setPlayerData(String playerData) throws ClassNotFoundException, SQLException {
		this.playerData = AssetManager.dataBaseGet("Level", id, "playerData");
		String delims = "[\\/\\]+";
		String[] transfer = this.playerData.split(delims);
		ArrayList<String> playerDataInfo = new ArrayList<String>();
		for (int i = 0; i < transfer.length; i++) {
			playerDataInfo.add(transfer[i]);
		}
		playerDataInfo.remove(0);
	}

	public void npcData(String npcData) throws ClassNotFoundException, SQLException {
		this.npcData = AssetManager.dataBaseGet("Level", id, "npcData");
		String delims = "[\\/\\]+";
		String[] transfer = this.npcData.split(delims);
		ArrayList<String> npcDataInfo = new ArrayList<String>();
		for (int i = 0; i < transfer.length; i++) {
			npcDataInfo.add(transfer[i]);
		}
		npcDataInfo.remove(0);
	}

	public static void npcDataStringParser(String level) throws ClassNotFoundException, SQLException {
		String table = level;
		String npcDataString = AssetHandling.AssetManager.dataBaseGet(table, id, "npcData");
		String delims = "[\\/\\]+";
		String[] transfer = npcDataString.split(delims);
		ArrayList<String> npcData = new ArrayList<String>();
		for (int i = 0; i < transfer.length; i++) {
			npcData.add(transfer[i]);
		}
		npcData.remove(0);
	}
}
