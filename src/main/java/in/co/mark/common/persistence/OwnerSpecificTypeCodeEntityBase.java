package in.co.mark.common.persistence;

import in.co.mark.common.domain.model.OwnerSpecificModelBase;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * A base entity class with properties to store {@code typeName},
 * {@code typeCode}, and {@code desc} of a type. It also inherits the properties
 * and the respective getter/setter methods to store <i>owner's ID</i>,
 * <i>created time</i>, and <i>last updated time</i> form
 * {@link OwnerSpecificModelBase} class.
 * <p>
 * Note that this is just a <i>mapped superclass</i>, and not an actual entity.
 * By extending it one can just avoid redefining the common properties/methods.
 * </p>
 * 
 * @author Rakesh Kumar
 */
@MappedSuperclass
public class OwnerSpecificTypeCodeEntityBase extends OwnerSpecificEntityBase {
	@Getter
	@Setter
	@Column(name = "type_name", nullable = false)
	protected String typeName;

	@Getter
	@Setter
	@Column(name = "type_code", nullable = false)
	protected String typeCode;

	@Getter
	@Setter
	@Column(name = "description")
	private String desc;

	/**
	 * The default constructor
	 */
	protected OwnerSpecificTypeCodeEntityBase() {

	}

	/**
	 * Initializes {@code ownerId} property of this instance
	 * 
	 * @param ownerId ID of the owner - can be a user or an organization
	 */
	protected OwnerSpecificTypeCodeEntityBase(long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * Initializes {@code ownerId}, {@code createdOn}, and {@code lastUpdatedOn}
	 * properties of this instance
	 * 
	 * @param ownerId       ID of the owner - can be a user or an organization
	 * @param createdOn     A timestamp indicating when the respective DB record was
	 *                      created
	 * @param lastUpdatedOn A timestamp indicating when the respective DB record was
	 *                      last updated
	 */
	protected OwnerSpecificTypeCodeEntityBase(long ownerId, long createdOn, long lastUpdatedOn) {
		super(ownerId, createdOn, lastUpdatedOn);
	}

	/**
	 * Initializes all properties of this instance
	 * 
	 * @param ownerId       ID of the owner - can be a user or an organization
	 * @param type          Human readable name of this type
	 * @param code          Code of this type which must be unique under an Org
	 * @param desc          Description of this type
	 * @param createdOn     A timestamp indicating when the respective DB record was
	 *                      created
	 * @param lastUpdatedOn A timestamp indicating when the respective DB record was
	 *                      last updated
	 */
	protected OwnerSpecificTypeCodeEntityBase(long ownerId, String typeName, String typeCode, String desc,
			long createdOn, long lastUpdatedOn) {
		super(ownerId, createdOn, lastUpdatedOn);
		this.typeName = typeName;
		this.typeCode = typeCode;
		this.desc = desc;
	}
}
