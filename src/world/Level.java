package world;

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
	private static String horizontalTransition = "";
	private static String verticalTransition = "";
	private static int id;

	static ArrayList<NPC> npcDataInfo = new ArrayList<NPC>();
	static ArrayList<String> playerDataInfo = new ArrayList<String>();
	static ArrayList<String> playerPos = new ArrayList<String>();
	static ArrayList<String> wallDimensions = new ArrayList<String>();
	static ArrayList<String> imageInfo = new ArrayList<String>();
	static ArrayList<horizontalTransition> horizontalTransitionInfo = new ArrayList<horizontalTransition>();
	static ArrayList<verticalTransition> verticalTransitionInfo = new ArrayList<verticalTransition>();
	static ArrayList<Items> itemsOnScreen = new ArrayList<Items>();

	/**
	 * 
	 * @param id
	 */
	public Level(int id) {
		Level.id = id;

	}

	public Level() {

	}

	public String getLevelName() {
		return levelName;
	}

	/*
	 * 
	 */
	public String getImageData(int i) {
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
		for (int i1 = 0; i1 < transfer.length; i1++) {
			imageInfo.add(transfer[i1]);
		}
		return imageInfo.get(i);
	}

	/**
	 * 
	 * @param i
	 * @return wallData
	 */
	public String getWallData(int i) {
		try {
			wallData = AssetManager.dataBaseGet("Level", id, "wallData");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String delims = "[,]";
		String[] transfer = wallData.split(delims);
		for (int i1 = 0; i1 < transfer.length; i1++) {
			wallDimensions.add(transfer[i1]);
		}
		return wallDimensions.get(i);
	}

	/**
	 * 
	 * @param i
	 * @return playerPos
	 */
	public String getPlayerPosition(int i) {
		try {
			playerPosition = AssetManager.dataBaseGet("Level", id, "playerPos");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String delims = "[,]+";
		String[] transfer = playerPosition.split(delims);
		for (int i1 = 0; i1 < transfer.length; i1++) {
			playerPos.add(transfer[i1]);
		}
		return playerPos.get(i);
	}

	/**
	 * 
	 * @param i
	 * @return playerDataInfo
	 */
	public String getPlayerData(int i) {
		try {
			playerData = AssetManager.dataBaseGet("Level", id, "playerData");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String delims = "[,]+";
		String[] transfer = playerData.split(delims);
		for (int i1 = 0; i1 < transfer.length; i1++) {
			playerDataInfo.add(transfer[i1]);
		}
		return playerDataInfo.get(i);
	}

	/**
	 * 
	 * @param i
	 * @return npcDataInfo
	 */
	public ArrayList<NPC> getNpcData(int i) {
		try {
			npcData = AssetManager.dataBaseGet("Level", id, "npcData");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String delims = "[|]+";
		String delims2 = "[,]+";
		String[] transfer = horizontalTransition.split(delims);
		for (int i1 = 0; i1 < transfer.length; i1++) {
			String[] values = transfer[i1].split(delims2);
			npcDataInfo.add(new NPC(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
		}
		return npcDataInfo;
	}

	/**
	 * 
	 * @return horizontalTansistionInfo
	 */
	public ArrayList<horizontalTransition> getHorizontalTransitionInfo() {
		try {
			horizontalTransition = AssetManager.dataBaseGet("Level", id, "horizontal_transitions");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String delims = "[|]+";
		String delims2 = "[,]+";
		String[] transfer = horizontalTransition.split(delims);
		for (int i1 = 0; i1 < transfer.length; i1++) {
			String[] values = transfer[i1].split(delims2);
			horizontalTransitionInfo.add(new horizontalTransition(Integer.parseInt(values[0]),
					Integer.parseInt(values[1]), Integer.parseInt(values[2]), Integer.parseInt(values[3])));
		}
		return horizontalTransitionInfo;
	}

	/**
	 * 
	 * @return verticalTransitionInfo
	 */
	public ArrayList<verticalTransition> getVerticalTransitionInfo() {
		try {
			verticalTransition = AssetManager.dataBaseGet("Level", id, "vertical_transitions");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String delims = "[|]+";
		String delims2 = "[,]+";
		String[] transfer = verticalTransition.split(delims);
		for (int i1 = 0; i1 < transfer.length; i1++) {
			String[] values = transfer[i1].split(delims2);
			verticalTransitionInfo.add(new verticalTransition(Integer.parseInt(values[0]), Integer.parseInt(values[1]),
					Integer.parseInt(values[2]), Integer.parseInt(values[3])));
		}
		return verticalTransitionInfo;
	}
	public ArrayList<Items> getItems() {
		try {
			verticalTransition = AssetManager.dataBaseGet("Level", id, "items");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String delims = "[|]+";
		String delims2 = "[,]+";
		String[] transfer = verticalTransition.split(delims);
		for (int i1 = 0; i1 < transfer.length; i1++) {
			String[] values = transfer[i1].split(delims2);
			itemsOnScreen.add(new Items(Integer.parseInt(values[0]),Integer.parseInt(values[1]),Integer.parseInt(values[2])));
		}
		return itemsOnScreen;
	}

	/**
	 * 
	 * @return horizontalTransitionInfo
	 */
	public int gethorizontalTransitionNumber() {
		return horizontalTransitionInfo.size();
	}

	/**
	 * 
	 * @return verticalTransitionInfo
	 */
	public int getVerticalTransitionNumber() {
		return verticalTransitionInfo.size();
	}

	public void setLevelName(String levelName) throws ClassNotFoundException, SQLException {
		Level.levelName = AssetManager.dataBaseGet("Level", id, "levelName");
	}

}
