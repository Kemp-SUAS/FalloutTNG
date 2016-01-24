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
	private static String horizontalTransition;
	private static String verticalTransition;
	private static int id;

	static ArrayList<String> npcDataInfo = new ArrayList<String>();
	static ArrayList<String> playerDataInfo = new ArrayList<String>();
	static ArrayList<String> playerPos = new ArrayList<String>();
	static ArrayList<String> wallDimensions = new ArrayList<String>();
	static ArrayList<String> imageInfo = new ArrayList<String>();
	static ArrayList<horizontalTransition> horizontalTransitionInfo = new ArrayList<horizontalTransition>();
	static ArrayList<String> verticalTransitionInfo = new ArrayList<String>();

	public Level(int id) {
		Level.id = id;

	}

	public Level() {

	}

	public static String getLevelName() {
		return levelName;
	}

	public static String getImageData(int i) {
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

	public static String getWallData(int i) {
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

	public static String getPlayerPosition(int i) {
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

	public static String getPlayerData(int i) {
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

	public static String getNpcData(int i) {
		try {
			npcData = AssetManager.dataBaseGet("Level", id, "npcData");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String delims = "[,]+";
		String[] transfer = npcData.split(delims);
		for (int i1 = 0; i1 < transfer.length; i1++) {
			npcDataInfo.add(transfer[i1]);
		}
		return npcDataInfo.get(i);
	}

	public static ArrayList<horizontalTransition> getHorizontalTransitionInfo(int i) {
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
			horizontalTransitionInfo.add(new horizontalTransition(Integer.parseInt(values[0]),Integer.parseInt(values[1]),Integer.parseInt(values[2]),Integer.parseInt(values[3])));
		}
		return horizontalTransitionInfo;
	}

	public static String getVerticalTransitionInfo(int i) {
		try {
			verticalTransition = AssetManager.dataBaseGet("Level", id, "vertical_transitions");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String delims = "[,]+";
		String[] transfer = verticalTransition.split(delims);
		for (int i1 = 0; i1 < transfer.length; i1++) {
			verticalTransitionInfo.add(transfer[i1]);
		}
		return verticalTransitionInfo.get(i);
	}

	public void setLevelName(String levelName) throws ClassNotFoundException, SQLException {
		Level.levelName = AssetManager.dataBaseGet("Level", id, "levelName");
	}

	public static String getIndexInfo(ArrayList<String> arrayList, int id) {
		return arrayList.get(id);
	}

}
