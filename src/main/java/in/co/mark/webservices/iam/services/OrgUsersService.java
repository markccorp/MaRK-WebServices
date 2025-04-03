package in.co.mark.webservices.iam.services;

import org.springframework.data.domain.Page;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.iam.domain.model.OrgUser;
import in.co.mark.webservices.iam.gateway.dto.OrgUserRequestDTO;
import in.co.mark.webservices.iam.gateway.dto.OrgUserResponseDTO;

/**
 * @author Rakesh Kumar
 */
public interface OrgUsersService {
	/**
	 * To create or add a new user to the organization specified by an {@code orgId}
	 * in the request. If a user with the specified email address already exists in
	 * the system then it just creates a new mapping for the Org and user; otherwise
	 * it first creates a new user in the system and then creates the mapping.
	 * 
	 * @param reqObj Request DTO to create or add a new user to the specified Org
	 * @return Response DTO on successful creation of the user
	 */
	public OrgUserResponseDTO createOrgUser(OrgUserRequestDTO reqObj);

	/**
	 * To get an Org-user mapping by Org ID and User ID
	 * 
	 * @param orgId  ID of an Org to get the respective Org user record
	 * @param userId ID of a user to get the respective Org user record
	 * @return An {@code OrgUser}, if found for the given {@code orgId} and
	 *         {@code userId} otherwise, {@code null}
	 */
	public OrgUser getOrgUser(long orgId, long userId);

	/**
	 * To get a paginated list of Org-user mappings from DB
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link Page} containing list of Org-user mappings
	 */
	public RecordsPage<OrgUser> getOrgUsers(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of Org-user mappings from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link Page} containing list of Org-user mappings
	 */

	public RecordsPage<OrgUser> getOrgUsers(int pageNo, int pageSize, int sortOrder, String... sortByProperties);

	/**
	 * To get a paginated and sorted list of Organizations to which the user
	 * specified by the parameter {@code userId}, is associated to
	 * 
	 * @param userId           ID of a user get the associated organizations list
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link Page} containing list of Org-user mappings
	 */
	public RecordsPage<OrgUser> getUserOrgs(long userId, int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
