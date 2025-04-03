package in.co.mark.webservices.iam.domain.model;

import in.co.mark.common.domain.model.ModelBase;
import in.co.mark.webservices.iam.util.OrgUserStatus;

/**
 * @author Rakesh Kumar
 */
public class OrgUser extends ModelBase {
	private long orgId;
	private long userId;
	private OrgUserRole orgUserRole;
	private OrgUserStatus orgUserStatus;

	/**
	 * Initializes {@code orgId}, {@code userId}, and {@code orgUserRole} properties
	 * of this instance
	 * 
	 * @param orgId       ID of an Org to which the user specified by the
	 *                    {@code userId}, is/will be associate with
	 * @param userId      ID of a user who is/will be associated with the Org
	 *                    specified by the {@code orgId}
	 * @param orgUserRole Role of a user specified by the {@code userId} in the Org
	 *                    specified by the {@code orgId}
	 */
	public OrgUser(long orgId, long userId, OrgUserRole orgUserRole) {
		this(orgId, userId, orgUserRole, OrgUserStatus.INVITED);
	}

	/**
	 * Initializes {@code orgId}, {@code userId}, {@code orgUserRole} , and
	 * {@code orgUserStatus} properties of this instance
	 * 
	 * @param orgId         ID of an Org to which the user specified by the
	 *                      {@code userId}, is/will be associate with
	 * @param userId        ID of a user who is/will be associated with the Org
	 *                      specified by the {@code orgId}
	 * @param orgUserRole   Role of the user specified by the {@code userId} in the
	 *                      Org specified by the {@code orgId}
	 * @param orgUserStatus Status of the user specified by the {@code userId} in
	 *                      the Org specified by the {@code orgId}
	 */
	public OrgUser(long orgId, long userId, OrgUserRole orgUserRole, OrgUserStatus orgUserStatus) {
		this.orgId = orgId;
		this.userId = userId;
		this.orgUserRole = orgUserRole;
		this.orgUserStatus = orgUserStatus;
	}

	/**
	 * Initializes all properties of this instance
	 * 
	 * @param orgId         ID of an Org to which the user specified by the
	 *                      {@code userId}, is/will be associate with
	 * @param userId        ID of a user who is/will be associated with the Org
	 *                      specified by the {@code orgId}
	 * @param orgUserRole   Role of the user specified by the {@code userId} in the
	 *                      Org specified by the {@code orgId}
	 * @param orgUserStatus Status of the user specified by the {@code userId} in
	 *                      the Org specified by the {@code orgId}
	 * @param createdOn     A timestamp indicating when this Org-user mapping was
	 *                      created
	 * @param lastUpdatedOn A timestamp indicating when this Org-user mapping was
	 *                      last updated
	 */
	public OrgUser(long orgId, long userId, OrgUserRole orgUserRole, OrgUserStatus orgUserStatus, long createdOn,
			long lastUpdatedOn) {
		super(createdOn, lastUpdatedOn);
		this.orgId = orgId;
		this.userId = userId;
		this.orgUserRole = orgUserRole;
		this.orgUserStatus = orgUserStatus;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public OrgUserRole getOrgUserRole() {
		return orgUserRole;
	}

	public void setOrgUserRole(OrgUserRole orgUserRole) {
		this.orgUserRole = orgUserRole;
	}

	public OrgUserStatus getOrgUserStatus() {
		return orgUserStatus;
	}

	public void setOrgUserStatus(OrgUserStatus orgUserStatus) {
		this.orgUserStatus = orgUserStatus;
	}
}
