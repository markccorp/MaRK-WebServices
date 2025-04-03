package in.co.mark.webservices.iam.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rakesh Kumar
 */
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
	/** System generated ID. Set it to {@code null} for new user registrations. */
	@Getter
	@Setter
	private long userId;

	/**
	 * Primary email address which can also be used as login username of this user
	 */
	@Getter
	@Setter
	private String email;

	/**
	 * Login usernname of this user. When not specified explicitly, the primary
	 * {@code email} of this user will be used as the login username.
	 */
	@Getter
	@Setter
	private String username;

	/** Login password of this user */
	@Getter
	@Setter
	private String password;

	/** Initial part of the name of this user */
	@Getter
	@Setter
	private String initial;

	/** First name of this user */
	@Getter
	@Setter
	private String firstName;

	/** Middle name of this user */
	@Getter
	@Setter
	private String middleName;

	/** Last name of this user */
	@Getter
	@Setter
	private String lastName;

	/** Display name or nick name of this user */
	@Getter
	@Setter
	private String displayName;

	/**
	 * Gender of this user.<br/>
	 * Possible values: <b>M</b> - Male, <b>F</b> - Female, or <b>O</b> - Other.
	 */
	@Getter
	@Setter
	private char gender;

	/** Date part of the date-of-birth of this user */
	@Getter
	@Setter
	private int dobDate;

	/** Month part of the date-of-birth of this user */
	@Getter
	@Setter
	private int dobMonth;

	/** Year part of the date-of-birth of this user */
	@Getter
	@Setter
	private int dobYear;
}
