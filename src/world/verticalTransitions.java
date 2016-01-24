package world;

public class verticalTransitions {

	int y1,y2,x1,levelId;
	
	public verticalTransitions( int y1 , int y2, int x1 , int levelId)
	
	{
		this.y1 = y1;
		this.y2 = y2;
		this.x1 = x1;
		this.levelId = levelId;
	}
	public int[] getDomain(){
		return new int[] {this.y1,this.y2,this.x1};
	}
	public int getLevel(){
		return this.levelId;
	}
}
