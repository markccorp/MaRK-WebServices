package in.co.mark.webservices.iam.util;

public class UserUtil {
	/**
	 * To sanitize the given value for {@code gender}.
	 * <p>
	 * Valid possible values for gender could be: <b>M</b> - Male, <b>F</b> -
	 * Female, <b>O</b> - Other, or <b>U</b> - Unknown.<br>
	 * For a different/invalid value of the {@code gender}, it returns <b>U</b>.
	 * </p>
	 * 
	 * @param gender A value to sanitize for a valid <i>gender</i> value
	 * @return A valid possible values for gender
	 */
	public static char SanitizeGenderValue(char gender) {
		switch (gender) {
		case 'M':
		case 'm':
			return 'M';
		case 'F':
		case 'f':
			return 'F';
		case 'O':
		case 'o':
			return 'O';
		default:
			return 'U';
		}
	}
}
