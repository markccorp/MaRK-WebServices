package in.co.mark.webservices.iam.util;

import in.co.mark.common.util.IntValuedEnumConverter;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * JPA {@link AttributeConverter} for the {@link OrgUserRole} {@code enum}.
 * <p>
 * This converter enables automatic persistence and retrieval of
 * {@code OrgUserRole} {@code enum} constants based on their associated
 * {@code int} values, using the generic {@link IntValuedEnumConverter}.
 * </p>
 * <p>
 * It is typically used to map {@code enum} values to integer columns in the
 * database and vice versa.
 * </p>
 *
 * <p>
 * Example:
 * 
 * <pre>{@code
 * @Convert(converter = OrgUserRoleConverter.class)
 * private OrgUserRole role;
 * }</pre>
 * </p>
 * <p>
 * To apply this converter automatically across all entities, annotate with
 * {@code @Converter(autoApply = true)}.
 * </p>
 *
 * @author Rakesh Kumar
 */
@Converter
public class OrgUserRoleConverter extends IntValuedEnumConverter<OrgUserRole> {

	/**
	 * Constructs a converter for the {@link OrgUserRole} {@code enum}.
	 */
	public OrgUserRoleConverter() {
		super(OrgUserRole.class);
	}
}
