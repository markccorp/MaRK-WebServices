package in.co.mark.webservices.iam.gateway.dto;

import in.co.mark.webservices.iam.util.OrgUserRole;
import in.co.mark.webservices.iam.util.OrgUserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Rakesh Kumar
 */
@AllArgsConstructor
@NoArgsConstructor
public class OrgUserResponseDTO extends UserResponseDTO {
	/** ID of an Org to which the specified user is associated to */
	@Getter
	@Setter
	private long orgId;

	/** User's role in the Org specified by the {@code orgId} property */
	@Getter
	@Setter
	private OrgUserRole orgUserRole;

	/** User's status in the Org specified by the {@code orgId} property */
	@Getter
	@Setter
	private OrgUserStatus orgUserStatus;

	/** A timestamp indicating when the org-user record was created in DB */
	@Getter
	@Setter
	private long orgUserCreatedOn;

	/** A timestamp indicating when the org-user record was last updated in DB */
	@Getter
	@Setter
	private long orgUserLastUpdatedOn;
}
