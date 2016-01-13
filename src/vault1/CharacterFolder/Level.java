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

	public void setImageData(String imageData) throws ClassNotFoundException, SQLException {
		this.imageData = AssetManager.dataBaseGet("Level", id, "imageData");
	}

	public void setWallData(String wallData) throws ClassNotFoundException, SQLException {
		this.wallData = AssetManager.dataBaseGet("Level", id, "wallData");
	}

	public void setPlayerPosition(String playerPosition) throws ClassNotFoundException, SQLException {
		this.playerPosition = AssetManager.dataBaseGet("Level", id, "playerPos");
	}

	public void setPlayerData(String playerData) throws ClassNotFoundException, SQLException {
		this.playerData = AssetManager.dataBaseGet("Level", id, "playerData");
	}

	public void npcData(String npcData) throws ClassNotFoundException, SQLException {
		this.npcData = AssetManager.dataBaseGet("Level", id, "npcData");
	}

	public static void imageDataStringParser(String level) throws ClassNotFoundException, SQLException {
		String table = "level_" + level;
		String imageDataString = AssetHandling.AssetManager.dataBaseGet(table, id, "imageData");
		String delims = "[\\/\\]+";
		String[] transfer = imageDataString.split(delims);
		ArrayList<String> imageData = new ArrayList<String>();
		for (int i = 0; i < transfer.length; i++) {
			imageData.add(transfer[i]);
		}
		imageData.remove(0);
	}

	public static void wallDataStringParser(String level) throws SQLException, ClassNotFoundException {
		String table = "level_" + level;
		String wallString = AssetHandling.AssetManager.dataBaseGet(table, id, "wall");
		String delims = "[\\/\\,]+";
		String[] transfer = wallString.split(delims);
		ArrayList<String> wallDimensions = new ArrayList<String>();
		for (int i = 0; i < transfer.length; i++) {
			wallDimensions.add(transfer[i]);
		}
		wallDimensions.remove(0);
	}

	public static void playerPositionStringParser(String level) throws ClassNotFoundException, SQLException {
		String table = "level_" + level;
		String playerPositionString = AssetHandling.AssetManager.dataBaseGet(table, id, "playerPos");
		String delims = "[\\/\\]+";
		String[] transfer = playerPositionString.split(delims);
		ArrayList<String> playerPosition = new ArrayList<String>();
		for (int i = 0; i < transfer.length; i++) {
			playerPosition.add(transfer[i]);
		}
		playerPosition.remove(0);
	}

	public static void playerDataStringParser(String level) throws ClassNotFoundException, SQLException {
		String table = "level_" + level;
		String playerDataString = AssetHandling.AssetManager.dataBaseGet(table, id, "playerData");
		String delims = "[\\/\\]+";
		String[] transfer = playerDataString.split(delims);
		ArrayList<String> playerData = new ArrayList<String>();
		for (int i = 0; i < transfer.length; i++) {
			playerData.add(transfer[i]);
		}
		playerData.remove(0);
	}

	public static void npcDataStringParser(String level) throws ClassNotFoundException, SQLException {
		String table = "level_" + level;
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
