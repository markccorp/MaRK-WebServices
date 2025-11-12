package in.co.mark.common.util;

/**
 * An interface for {@code enum} that is backed by a unique integer value.
 * <p>
 * This is typically used in scenarios where {@code enum} constants need to be
 * mapped to or from integer values — such as database values, API payloads, or
 * configuration files.
 * </p>
 * <p>
 * Implementing this interface allows integration with utility classes like
 * {@code IntValuedEnumCache} for efficient and type-safe reverse lookups.
 * </p>
 * Example:
 * 
 * <pre>{@code
 * public enum OrgUserRole implements IntValuedEnum {
 * 	USER(10), ADMIN(20), SUPER_ADMIN(99);
 *
 * 	private final int value;
 *
 * 	OrgUserRole(int value) {
 * 		this.value = value;
 * 	}
 *
 * 	public int getValue() {
 * 		return value;
 * 	}
 * }
 * }</pre>
 *
 * @author Rakesh Kumar
 */
public interface IntValuedEnum {
	/**
	 * To get the {@code int} value associated with this {@code enum} constant.
	 * 
	 * @return {@code int} value associated with this {@code enum} constant
	 */
	int getValue();
}
