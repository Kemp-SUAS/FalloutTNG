package world;

public class verticalTransition {

	int y1,y2,x1,levelId;
	
	public verticalTransition( int y1 , int y2, int x1 , int levelId)
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
	public int getY1(){
		return this.y1;
	}
	public int getY2(){
		return this.y2;
	}
	public int getX1(){
		return this.x1;
	}
}
