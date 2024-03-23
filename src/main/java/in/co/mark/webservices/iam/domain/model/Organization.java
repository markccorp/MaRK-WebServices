package in.co.mark.webservices.iam.domain.model;

import in.co.mark.common.domain.model.ModelBase;
import in.co.mark.common.persistence.util.EntityActiveStatus;

public class Organization extends ModelBase {
	/**
	 * This ID will be generated by the system on successful registration of a user,
	 * and it can be used to uniquely identify the user in the system.
	 */
	private long id;
	/**
	 * ID of the <i>Super Admin</i> user. An organization can have only one <i>Super
	 * Admin</i>, and (s)he will have all the privileges in the organization.
	 */
	private long superAdminId;
	private String orgName;
	private String desc;
	/**
	 * ID of the parent organization, if any.
	 * <p>
	 * It can be used to, say deactivate all organization just by deactivating the
	 * parent organization. However, activating organization should be done
	 * individually.
	 * </p>
	 */
	private long parentOrgId;
	private EntityActiveStatus status;

	/**
	 * Default constructor
	 */
	public Organization() {
	}

	/**
	 * Initializes {@code id}, {@code superAdminId}, {@code orgName}, {@code desc},
	 * {@code parentOrgId}, and {@code status} properties of this instance
	 * 
	 * @param id           DB ID of this instance
	 * @param superAdminId ID of the <i>Super Admin</i> of this organization
	 * @param orgName      Name of this organization
	 * @param desc         A short description
	 * @param parentOrgId  ID of the parent organization, if any
	 * @param status       Status of this record
	 */
	public Organization(long id, long superAdminId, String orgName, String desc, long parentOrgId,
			EntityActiveStatus status) {
		this.id = id;
		this.superAdminId = superAdminId;
		this.orgName = orgName;
		this.desc = desc;
		this.parentOrgId = parentOrgId;
		this.status = status;
	}

	/**
	 * Initializes all properties of this instance
	 * 
	 * @param id            DB ID of this instance
	 * @param superAdminId  ID of the <i>Super Admin</i> of this organization
	 * @param orgName       Name of this organization
	 * @param desc          A short description
	 * @param parentOrgId   ID of the parent organization, if any
	 * @param status        Status of this record
	 * @param createdOn     A timestamp indicating when this user was created
	 * @param lastUpdatedOn A timestamp indicating when this user was last updated
	 */
	public Organization(long id, long superAdminId, String orgName, String desc, long parentOrgId,
			EntityActiveStatus status, long createdOn, long lastUpdatedOn) {
		super(createdOn, lastUpdatedOn);
		this.id = id;
		this.superAdminId = superAdminId;
		this.orgName = orgName;
		this.desc = desc;
		this.parentOrgId = parentOrgId;
		this.status = status;
	}

	/**
	 * To get the ID of this instance
	 * 
	 * @return {@code id} of this instance
	 */
	public long getId() {
		return id;
	}

	/**
	 * To set the ID of this instance.
	 * <p>
	 * The {@code id} being <i>primary key</i> of entities, it should, ideally, be
	 * set by the DB system on successful creation of the respective record.
	 * </p>
	 * 
	 * @param id ID of this instance
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * To get the ID of the user who created this organization
	 * 
	 * @return {@code createdById} value
	 */
	public long getSuperAdminId() {
		return superAdminId;
	}

	/**
	 * To set the ID of the <i>Super Admin</i> this organization
	 * 
	 * @param superAdminId ID of the <i>Super Admin</i> of this organization
	 */
	public void setSuperAdminId(long superAdminId) {
		this.superAdminId = superAdminId;
	}

	/**
	 * To get the name of this organization
	 * 
	 * @return {@code orgName} value
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * To set the name of this organization
	 * 
	 * @param orgName Name of this organization. It must be unique.
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * To get the description of this identifier type
	 * 
	 * @return {@code desc} value
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * To set the description of this identifier type
	 * 
	 * @param desc Description of this identifier type
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * To get the ID of the parent organization, if any. It can be {@code null} when
	 * there is no parent organization is registered.
	 * 
	 * @return {@code parentOrgId} value
	 */
	public long getParentOrgId() {
		return parentOrgId;
	}

	/**
	 * To set the ID of the parent organization, if any. Setting it {@code null}
	 * will indicate that no parent organization is registered.
	 * 
	 * @param parentOrgId ID of the parent organization, if any
	 */
	public void setParentOrgId(long parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	/**
	 * To get the status of this record
	 * 
	 * @return {@code status} value
	 */
	public EntityActiveStatus getStatus() {
		return status;
	}

	/**
	 * To set the status of this record
	 * 
	 * @param status {@link EntityActiveStatus} indicating the status of this record
	 */
	public void setStatus(EntityActiveStatus status) {
		this.status = status;
	}
}
