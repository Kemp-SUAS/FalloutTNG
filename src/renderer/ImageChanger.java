package renderer;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageChanger {
/**
 * Changes the button image for click, hover and idle on the continue button
 * @param s
 * @param button
 * @return Image
 */
	public static Image mainMenuContinue(String s, JButton button){
		if(s.equals("click")){
			Image Click = new ImageIcon("Assest/Pictures/MainScreen/continue_click.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return Click;
		}
		if(s.equals("hover")){
			Image Hover = new ImageIcon("Assest/Pictures/MainScreen/continue_hover.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return Hover;
		}
		else {
			Image continueIdle = new ImageIcon("Assest/Pictures/MainScreen/continue_Idle.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return continueIdle;
		}
	}
	/**
	 * Changes the button image for click, hover and idle on the load button
	 * @param s
	 * @param button
	 * @return Image
	 */
	public static Image mainMenuLoad(String s, JButton button){
		if(s.equals("click")){
			Image Click = new ImageIcon("Assest/Pictures/MainScreen/load_click.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return Click;
		}
		if(s.equals("hover")){
			Image Hover = new ImageIcon("Assest/Pictures/MainScreen/load_hover.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return Hover;
		}
		else {
			Image Idle = new ImageIcon("Assest/Pictures/MainScreen/load_Idle.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
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
		if(s.equals("click")){
			Image Click = new ImageIcon("Assest/Pictures/MainScreen/newGame_click.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return Click;
		}
		if(s.equals("hover")){
			Image Hover = new ImageIcon("Assest/Pictures/MainScreen/newGame_hover.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return Hover;
		}
		else {
			Image Idle = new ImageIcon("Assest/Pictures/MainScreen/newGame_Idle.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
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
		if(s.equals("click")){
			Image Click = new ImageIcon("Assest/Pictures/MainScreen/exit_click.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return Click;
		}
		if(s.equals("hover")){
			Image Hover = new ImageIcon("Assest/Pictures/MainScreen/exit_hover.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return Hover;
		}
		else {
			Image Idle = new ImageIcon("Assest/Pictures/MainScreen/exit_Idle.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return Idle;
		}
	}
	public static Image mainScreenBackground(){
		Image Click = new ImageIcon("Assest/Pictures/MainScreen/mianScreen_Background.png").getImage();
		return Click;
	}
}
