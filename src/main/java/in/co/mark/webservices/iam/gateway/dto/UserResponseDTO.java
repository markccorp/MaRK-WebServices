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
public class UserResponseDTO {
	/** System generated ID of this user */
	@Getter
	@Setter
	private long userId;

	/** Primary email address of this user */
	@Getter
	@Setter
	private String email;

	/** Login username of this user */
	@Getter
	@Setter
	private String username;

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

	/** A timestamp indicating when this record was created in DB */
	@Getter
	@Setter
	private long createdOn;

	/** A timestamp indicating when this record was last updated in DB */
	@Getter
	@Setter
	private long lastUpdatedOn;
}
