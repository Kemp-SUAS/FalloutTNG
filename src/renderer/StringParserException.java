/**
 * 
 */
package renderer;

/**
 *  This is an exxception class to help with any errors when parsing info from SQLite
 * @author Faduma Ahmed Mohid Aslam Keiran Wilson Simar Pal Kalsi
 *
 */
public class StringParserException extends Exception {

	/**
	 * the serial version of this class
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public StringParserException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public StringParserException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public StringParserException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public StringParserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
