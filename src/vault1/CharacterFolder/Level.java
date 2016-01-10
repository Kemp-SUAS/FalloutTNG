package vault1.CharacterFolder;


public class Level {
	
	private String levelName;
	private String imageData;
	private String wallData;
	private String playerPosition;
	private String playerData;
	private String npcData;
	
	
	public Level(String levelName, String imageData, String wallData, String playerPosition, String playerData, String npcData) {
		this.levelName = levelName;
		this.imageData = imageData;
		this.wallData = wallData;
		this.playerPosition = playerPosition;
		this.playerData = playerData;
		this.npcData = npcData;	
	}
	
	public Level(){

	}
	public String getLevelName(){
		return levelName;		
	}
	public String getImageData(){
		return imageData;
	}
	public String getWallData(){
		return wallData;
	}
	public String getPlayerPosition(){
		return playerPosition;
	}
	public String getPlayerData(){
		return playerData;
	}
	public String getNpcData(){
		return npcData;	}
	
	public void setLevelName(String levelName){
		 this.levelName = levelName;
	}
	public void setImageData(String imageData){
		 this.imageData = imageData;
	}
	public void setWallData(String wallData){
		 this.wallData = wallData;
	}
	public void setPlayerPosition(String playerPosition){
		 this.playerPosition = playerPosition;
	}
	public void setPlayerData(String playerData){
		 this.playerData = playerData;
	}
	public void npcData(String npcData){
		 this.npcData = npcData;
	}
	
}

