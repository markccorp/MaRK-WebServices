package in.co.mark.webservices.iam.persistence.entities;

import in.co.mark.common.persistence.EntityBase;
import in.co.mark.webservices.iam.util.OrgUserRole;
import in.co.mark.webservices.iam.util.OrgUserRoleConverter;
import in.co.mark.webservices.iam.util.OrgUserStatus;
import in.co.mark.webservices.iam.util.OrgUserStatusConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a <i>mapping</i> between {@link UserEObj} and
 * {@link OrganizationEObj}.
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
	@Convert(converter = OrgUserRoleConverter.class)
	private OrgUserRole orgUserRole;

	@Getter
	@Setter
	@Column(name = "org_user_status")
	@Convert(converter = OrgUserStatusConverter.class)
	private OrgUserStatus orgUserStatus;

	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId") // maps this part of the composite key
	@JoinColumn(name = "user_id")
	private UserEObj userEObj;

	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("orgId") // maps this part of the composite key
	@JoinColumn(name = "org_id")
	private OrganizationEObj organizationEObj;

	/**
	 * Gets the Org ID of this Org-user mapping.
	 * 
	 * @return {@code orgUserId.orgId} of this Org-user mapping
	 */
	public long getOrgId() {
		return orgUserId.getOrgId();
	}

	/**
	 * Sets an Org ID for this Org-user mapping.
	 * 
	 * @param orgId Org ID for this Org-user mapping
	 */
	public void setOrgId(long orgId) {
		this.orgUserId.setOrgId(orgId);
	}

	/**
	 * Gets the user ID of this Org-user mapping.
	 * 
	 * @return {@code orgUserId.userId} of this Org-user mapping
	 */
	public long getUserId() {
		return orgUserId.getUserId();
	}

	/**
	 * Sets an user ID for this Org-user mapping.
	 * 
	 * @param userId User ID for this Org-user mapping
	 */
	public void setUserId(long userId) {
		this.orgUserId.setUserId(userId);
	}
}
