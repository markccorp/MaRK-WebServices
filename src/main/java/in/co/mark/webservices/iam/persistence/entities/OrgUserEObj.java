package in.co.mark.webservices.iam.persistence.entities;

import in.co.mark.common.persistence.EntityBase;
import in.co.mark.webservices.iam.domain.model.OrgUserRole;
import in.co.mark.webservices.iam.util.OrgUserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Organization vs User mapping entity
 * 
 * @author Rakesh Kumar
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "org_users")
public class OrgUserEObj extends EntityBase {
	@Getter
	@Setter
	@EmbeddedId
	private OrgUserIdentifier orgUserId;

	@Getter
	@Setter
	@Column(name = "org_user_role")
	private OrgUserRole orgUserRole;

	@Getter
	@Setter
	@Column(name = "org_user_status")
	private OrgUserStatus orgUserStatus;

	@Getter
	@Setter
	@ManyToOne // (fetch = FetchType.LAZY)
	@MapsId("userId") // maps this part of the composite key
	@JoinColumn(name = "user_id")
	private UserEObj user;

	@Getter
	@Setter
	@ManyToOne // (fetch = FetchType.LAZY)
	@MapsId("orgId") // maps this part of the composite key
	@JoinColumn(name = "org_id")
	private OrganizationEObj organization;

	/**
	 * To get the Org ID of this Org-user mapping
	 * 
	 * @return {@code orgUserId.orgId} of this Org-user mapping
	 */
	public long getOrgId() {
		return orgUserId.getOrgId();
	}

	/**
	 * To set an Org ID for this Org-user mapping
	 * 
	 * @param orgId Org ID for this Org-user mapping
	 */
	public void setOrgId(long orgId) {
		this.orgUserId.setOrgId(orgId);
	}

	/**
	 * To get the user ID of this Org-user mapping
	 * 
	 * @return {@code orgUserId.userId} of this Org-user mapping
	 */
	public long getUserId() {
		return orgUserId.getUserId();
	}

	/**
	 * To set an user ID for this Org-user mapping
	 * 
	 * @param userId User ID for this Org-user mapping
	 */
	public void setUserId(long userId) {
		this.orgUserId.setUserId(userId);
	}
}
