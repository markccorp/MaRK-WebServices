package in.co.mark.webservices.iam.domain.model;

/**
 * Enum to specify the role of a user in an organization
 * 
 * @author Rakesh Kumar
 */
public enum OrgUserRole {
	/** Specifies the <b>Normal User</b> role in an organization */
	USER(10),
	/** Specifies the <b>Admin</b> role in an organization */
	ADMIN(20),
	/** Specifies the <b>Super Admin</b> role in an organization */
	SUPER_ADMIN(99);

	/** Holds the custom <i>enum</i> value */
	private final int value;

	private OrgUserRole(int value) {
		this.value = value;
	}

	/**
	 * To get the <i>integer</i> value of this <i>enum</i>
	 * 
	 * @return the {@code value}
	 */
	public int getValue() {
		return value;
	}
}
