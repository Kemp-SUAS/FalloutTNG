package renderer;

public class AssetLocations {

	public static String mainMenuContinue(String s){
		if(s.equals("click")){
			return "Assest/Pictures/MainScreen/continue_click.png";
		}
		if(s.equals("hover")){
			return "Assest/Pictures/MainScreen/continue_hover.png";
		}
		else{
		    return "Assest/Pictures/MainScreen/continue_Idle.png";
		}
	}
}
