/**
 * 
 * @author Rakesh Kumar
 */
package in.co.mark.webservices.iam.persistence.entities.projections;

import in.co.mark.webservices.iam.domain.model.OrgUserRole;
import in.co.mark.webservices.iam.util.OrgUserStatus;

/**
 * 
 */
public interface OrgUserBasicProjection extends UserBasicProjection {
	long getUserId();

	long getOrgId();

	OrgUserRole getOrgUserRole();

	OrgUserStatus getOrgUserStatus();
}
