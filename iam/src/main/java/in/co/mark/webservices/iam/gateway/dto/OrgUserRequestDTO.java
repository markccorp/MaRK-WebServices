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
public class OrgUserRequestDTO extends UserRequestDTO {
	/** Role of this user in the Org specified by the {@code orgId} property */
	@Getter
	@Setter
	private OrgUserRole orgUserRole;

	/**
	 * Status of this user in the Org specified by the {@code orgId} property. For a
	 * new user addition to the Org, it should be {@code OrgUserStatus.INVITED}.
	 */
	@Getter
	@Setter
	private OrgUserStatus orgUserStatus;
}
