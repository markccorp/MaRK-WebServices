package in.co.mark.webservices.iam.util;

import in.co.mark.common.util.IntValuedEnum;
import in.co.mark.common.util.IntValuedEnumCache;

/**
 * Specifies the <i>role</i> of a user in an organization.
 * 
 * @author Rakesh Kumar
 */
public enum OrgUserRole implements IntValuedEnum {
	/** Specifies the <b>Normal User</b> role in an organization. */
	USER(10),
	/** Specifies the <b>Admin</b> role in an organization. */
	ADMIN(20),
	/** Specifies the <b>Super Admin</b> role in an organization. */
	SUPER_ADMIN(99);

	/** Holds the custom <i>enum</i> value. */
	private final int value;

	private OrgUserRole(int value) {
		this.value = value;
	}

	/**
	 * Gets the <i>integer</i> value of this <i>enum</i>.
	 * 
	 * @return the integer {@code value}
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Gets the {@code enum} constant for the given {@code int} value.
	 * 
	 * @param value {@code int} value to get the {@code enum} constant
	 * @return {@code enum} constant for the given {@code int} value
	 */
	public static OrgUserRole fromValue(int value) {
		return IntValuedEnumCache.fromValue(OrgUserRole.class, value);
	}
}
