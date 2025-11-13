package in.co.mark.common.domain.model;

/**
 * A base model class with properties to store {@code typeName},
 * {@code typeCode}, and {@code desc} of a type. It also inherits the properties
 * and the respective getter/setter methods to store <i>owner's ID</i>,
 * <i>created time</i>, and <i>last updated time</i> form
 * {@link OwnerSpecificModelBase} class.
 * 
 * @author Rakesh Kumar
 */
public class OwnerSpecificTypeCodeModelBase extends OwnerSpecificModelBase {
	protected String typeName;
	protected String tyepCode;
	protected String desc;

	/**
	 * The default constructor
	 */
	protected OwnerSpecificTypeCodeModelBase() {

	}

	/**
	 * Initializes {@code ownerId} property of this instance
	 * 
	 * @param ownerId ID of the owner - can be a user or an organization
	 */
	protected OwnerSpecificTypeCodeModelBase(long ownerId) {
		super(ownerId);
	}

	/**
	 * Initializes {@code ownerId}, {@code typeName}, {@code typeCode}, and
	 * {@code desc} properties of this instance
	 * 
	 * @param ownerId  ID of the owner - can be a user or an organization
	 * @param typeName Human readable name of this type
	 * @param typeCode Code of this type which must be unique under an Org
	 * @param desc     Description of this type
	 */
	protected OwnerSpecificTypeCodeModelBase(long ownerId, String typeName, String typeCode, String desc) {
		super(ownerId);
		this.typeName = typeName;
		this.tyepCode = typeCode;
		this.desc = desc;
	}

	/**
	 * Initializes all properties of this instance
	 * 
	 * @param ownerId       ID of the owner - can be a user or an organization
	 * @param typeName      Human readable name of this type
	 * @param typeCode      Code of this type which must be unique under an Org
	 * @param desc          Description of this type
	 * @param createdOn     A timestamp indicating when the respective DB record was
	 *                      created
	 * @param lastUpdatedOn A timestamp indicating when the respective DB record was
	 *                      last updated
	 */
	protected OwnerSpecificTypeCodeModelBase(long ownerId, String typeName, String typeCode, String desc,
			long createdOn, long lastUpdatedOn) {
		super(ownerId, createdOn, lastUpdatedOn);
		this.typeName = typeName;
		this.tyepCode = typeCode;
		this.desc = desc;
	}

	/**
	 * To get the human readable name of this type
	 * 
	 * @return {@code type} value
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * To set a human readable name to this type
	 * 
	 * @param typeName A human readable type name to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * To get the code of this type. The code of a type would be unique under an Org
	 * 
	 * @return {@code typeCode} value
	 */
	public String getTypeCode() {
		return tyepCode;
	}

	/**
	 * To set a code to this type. The code of a type should be unique under an Org
	 * 
	 * @param typeCode A code value for this type
	 */
	public void setTypeCode(String typeCode) {
		this.tyepCode = typeCode;
	}

	/**
	 * To get the description of this type
	 * 
	 * @return {@code desc} value
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * To set a description to this type
	 * 
	 * @param desc Description of this type
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
