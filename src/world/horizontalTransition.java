package world;

public class horizontalTransition {
int x1,x2,y1,levelId;
	
	public horizontalTransition( int x1 , int x2, int y1 , int levelId)
	
	{
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.levelId = levelId;
	}
	public int[] getDomain(){
		return new int[] {this.x1,this.x2,this.y1};
	}
	public int getLevel(){
		return this.levelId;
	}
}
