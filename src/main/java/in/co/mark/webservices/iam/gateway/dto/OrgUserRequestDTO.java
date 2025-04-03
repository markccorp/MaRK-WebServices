package in.co.mark.webservices.iam.gateway.dto;

import in.co.mark.webservices.iam.domain.model.OrgUserRole;
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
public class OrgUserRequestDTO extends UserRequestDTO {
	/** ID of an Org to which the specified user will be associate to */
	@Getter
	@Setter
	private long orgId;

	/** User's role in the Org specified by the {@code orgId} property */
	@Getter
	@Setter
	private OrgUserRole orgUserRole;

	/**
	 * User's status in the Org specified by the {@code orgId} property. For a new
	 * mapping, it should be {@code OrgUserStatus.INVITED}.
	 */
	@Getter
	@Setter
	private OrgUserStatus orgUserStatus;
}
