package renderer;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageChanger {

	public static Image mainMenuContinue(String s, JButton button){
		if(s.equals("click")){
			Image continueClick = new ImageIcon("Assest/Pictures/MainScreen/continue_click.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return continueClick;
		}
		if(s.equals("hover")){
			Image continueHover = new ImageIcon("Assest/Pictures/MainScreen/continue_hover.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return continueHover;
		}
		else {
			Image continueIdle = new ImageIcon("Assest/Pictures/MainScreen/continue_Idle.png").getImage().getScaledInstance(button.getWidth(),button.getHeight(),java.awt.Image.SCALE_SMOOTH);
			return continueIdle;
		}
	}
}
