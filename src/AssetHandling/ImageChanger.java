
package AssetHandling;

import java.awt.Container;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class  will make a Frame, a GUI that will show the main menu of the game. 
 * It has the options of  load new game,continue, Exit. It is the first visual interface the player will interact with.
 * 
 * @author Faduma Ahmed, Kieran Wilson, Mohid Aslam, Simar Pal Kalsi
 *	Time -- 8:11:16 PM Date Dec 8, 2015
 *
 */
public class ImageChanger {

	/*public static Image mainMenuContinue(String s, JButton button){

	}
	*/
	/*public static Image mainMenuContinue(String s, JButton button){
	if(s.equals("click")){
		Image Click = new ImageIcon("Assets/Pictures/MainScreen/continue_click.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
		return Click;
	}
	if(s.equals("hover")){
		Image Hover = new ImageIcon("Assets/Pictures/MainScreen/continue_hover.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
		return Hover;
	}
	else {
		Image continueIdle = new ImageIcon("Assets/Pictures/MainScreen/continue_Idle.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
		return continueIdle;
	}
}
*/
	/**
	 *  THis static method will Change the button for click hover and idle on the load button 
	 * @param s, String
	 * @param button, the button from the JFrame
	 * @return Image, the image when the user clicks the button
	 */
	public static Image   mainMenuLoad(String s, JButton button){
		
		// If the user clicks the button
		if(s.equals("click")){
			// Creates an ImageIcon if the user clicks the buttton. The image will be preloaded by using MediaTracker to monitor the loading state of the image. 
			Image Click =   new ImageIcon("Assets/Pictures/MainScreen/load_click.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			// returns the image 
			return Click;
		}
		
		
		if(s.equals("hover")){
			// Creates an ImageIcon if the user hovers over the button. The image will be preloaded by using MediaTracker to monitor the loading state of the image. 
			
			
			Image Hover =   new ImageIcon("Assets/Pictures/MainScreen/load_hover.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			
			// returns the image
			return Hover;
		}
		else {
			// Creates an ImageIcon if the user is idle over the button. The image will be preloaded by using MediaTracker to monitor the loading state of the image. 
			
			Image Idle =  new ImageIcon("Assets/Pictures/MainScreen/load_Idle.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			// returns the image
			return Idle;
		}
	}
	/**
	 * Changes the button image for click, hover and idle on the newGame button
	 * @param s
	 * @param button
	 * @return Image
	 */
	public static Image mainMenuNewGame(String s, JButton button){
		
		// If the user clicks the button
		if(s.equals("click")){
			
			// Creates an ImageIcon if the user clicks the buttton. The image will be preloaded by using MediaTracker to monitor the loading state of the image. 
			
			Image Click =   new  ImageIcon("Assets/Pictures/MainScreen/newGame_click.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			// returns the image 
			return Click;
		}
		// If the user hovers over the button
		if(s.equals("hover")){
			// Creates an ImageIcon if the user hovers over the button. The image will be preloaded by using MediaTracker to monitor the loading state of the image. 
			
			Image Hover =  new  ImageIcon("Assets/Pictures/MainScreen/newGame_hover.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return Hover; 
			
		}
		// If the user is idle around the button
		else {
			
			// Creates an ImageIcon if the user is idle around the button. The image will be preloaded by using MediaTracker to monitor the loading state of the image. 
			
			Image  Idle = new ImageIcon("Assets/Pictures/MainScreen/newGame_Idle.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			// returns the image 
			
			return Idle;
		}
	}
	/**
	 * Changes the button image for click, hover and idle on the exit button
	 * @param s
	 * @param button
	 * @return Image
	 */
	public static Image mainMenuExitGame(String s, JButton button){
		
		// If the user clicks the button
		if  (s.equals("click") ){
			// Creates an ImageIcon if the user clicks the buttton. The image will be preloaded by using MediaTracker to monitor the loading state of the image. 
			
			Image  Click = new  ImageIcon ("Assets/Pictures/MainScreen/exit_click.png"). getImage().  getScaledInstance(button . getWidth() ,button. getHeight() ,java .awt . Image.SCALE_SMOOTH);
			// returns the image 
			return   Click;
		}
		// If the user hovers over the button
		if(s.equals("hover")){
			// Creates an ImageIcon if the user hovers over the buttton. The image will be preloaded by using MediaTracker to monitor the loading state of the image. 
			
			
			Image Hover = new  ImageIcon("Assets/Pictures/MainScreen/exit_hover.png"). getImage(). getScaledInstance(button .getWidth() ,button. getHeight(),java.awt.Image. SCALE_SMOOTH);
			// returns the image 
			return  Hover;
		}
		// If the user is idle around the button
		else {
			// Creates an ImageIcon if the user is idle around the button. The image will be preloaded by using MediaTracker to monitor the loading state of the image. 
			
			
			Image  Idle = new  ImageIcon("Assets/Pictures/MainScreen/exit_Idle.png") .getImage() .getScaledInstance( button.getWidth(), button.getHeight(),java .awt. Image.SCALE_SMOOTH );
			// returns the image 
			return  Idle;
		}
	}
	
	
	/**
	 * This static method sets the background of the main menu
	 * @return the image of the main menu background method
	 */
	public static ImageIcon mainScreenBackground(){
		// Creates an ImageIcon for the background image. The image will be preloaded by using MediaTracker to monitor the loading state of the image. 
		
		ImageIcon  Click =  new ImageIcon( "Assets/Pictures/MainScreen/mianScreen_Background.png" );
		// returns the image 
		return   Click;
	}
}
