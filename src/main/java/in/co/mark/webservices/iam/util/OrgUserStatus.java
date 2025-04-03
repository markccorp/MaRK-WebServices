/**
 * 
 * @author Rakesh Kumar
 */
package in.co.mark.webservices.iam.util;

/**
 * Enum to specify the status of Org users
 * 
 * @author Rakesh Kumar
 */
public enum OrgUserStatus {
	/**
	 * Specifies that the user is valid and an active user of the Org
	 */
	ACTIVE(0),
	/**
	 * Specifies that the user is invited to join the Org and the invitation is
	 * still valid
	 */
	INVITED(10),
	/**
	 * Specifies that the user was invited to join the Org but the invitation is now
	 * expired
	 */
	INVITATION_EXPIRED(20),
	/**
	 * Specifies that the user is temporarily suspended from the Org
	 */
	SUSPENDED(30),
	/**
	 * Specifies that the user is dissociated from the Org and can be marked for
	 * deletion
	 */
	INACTIVE(99),
	/**
	 * Specifies that the user is no longer part of the Org and can very well be
	 * deleted
	 */
	MARKED_FOR_DELETION(999);

	/** Holds the custom <i>enum</i> value */
	private final int value;

	private OrgUserStatus(int value) {
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
