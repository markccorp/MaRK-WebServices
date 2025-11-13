package in.co.mark.common.util;

import jakarta.persistence.AttributeConverter;

/**
 * A generic JPA {@link AttributeConverter} for {@code enum} implementing the
 * {@link IntValuedEnum} interface.
 * <p>
 * This converter enables automatic persistence and retrieval of {@code enum}
 * constants based on their associated {@code int} values, typically stored in a
 * database column. It delegates the conversion logic to
 * {@code IntValuedEnumCache} for efficient and thread-safe lookups.
 * </p>
 * <p>
 * To use this converter, create a concrete subclass for each {@code enum} type:
 * 
 * <pre>{@code
 * @Converter(autoApply = true)
 * public class OrgUserRoleConverter extends IntValuedEnumConverter&lt;OrgUserRole&gt; {
 * 	public OrgUserRoleConverter() {
 * 		super(OrgUserRole.class);
 * 	}
 * }
 * }</pre>
 * </p>
 * 
 * @param <E> the {@code enum} type implementing {@code IntValuedEnum}
 * @author Rakesh Kumar
 */
public class IntValuedEnumConverter<E extends Enum<E> & IntValuedEnum> implements AttributeConverter<E, Integer> {

	private final Class<E> enumClass;

	/**
	 * Constructs a new converter for the specified {@code enum} class.
	 *
	 * @param enumClass the {@code enum} class to be converted
	 */
	public IntValuedEnumConverter(Class<E> enumClass) {
		this.enumClass = enumClass;
	}

	/**
	 * Converts the {@code enum} constant to its corresponding integer value for
	 * database storage.
	 *
	 * @param attribute the {@code enum} constant
	 * @return the integer value to store in the database, or {@code null} if the
	 *         attribute is {@code null}
	 */
	@Override
	public Integer convertToDatabaseColumn(E attribute) {
		return attribute != null ? attribute.getValue() : null;
	}

	/**
	 * Converts the stored integer value from the database back to the corresponding
	 * {@code enum} constant.
	 *
	 * @param dbData the integer value from the database
	 * @return the matching {@code enum} constant, or {@code null} if the database
	 *         value is {@code null}
	 * @throws IllegalArgumentException if the value does not map to any
	 *                                  {@code enum} constant
	 */
	@Override
	public E convertToEntityAttribute(Integer dbData) {
		return dbData != null ? IntValuedEnumCache.fromValue(enumClass, dbData) : null;
	}
}
