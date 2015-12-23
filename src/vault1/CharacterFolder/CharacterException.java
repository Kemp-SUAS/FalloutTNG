
package vault1.CharacterFolder;

/**
 * This class is an exception that gets called when the player dies due to
 * insufficient health point or has low short term gameplay stats resulting in
 * debugs.
 *
 * @author Faduma Ahmed Mohid Aslam Kieran Wilson Simar Pal Kalsi
 *
 */
public class CharacterException extends Exception {

	public CharacterException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public CharacterException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public CharacterException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public CharacterException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public CharacterException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
}
