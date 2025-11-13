package in.co.mark.webservices.iam.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.iam.domain.model.OrgUser;

/**
 * @author Rakesh Kumar
 */
public interface OrgUsersService {
	/**
	 * To add a user to an organization specified by the {@code orgId}.
	 * <p>
	 * If a valid {@code userId} is provided in the given {@code orgUser} then the
	 * implementation should just add a mapping for the organization and the user.
	 * Otherwise, it should first try to create a new user with the given details
	 * and then add the mapping.
	 * </p>
	 * 
	 * @param orgId   Organization ID to the add the user to
	 * @param orgUser {@link OrgUser} to add to the given organization
	 * @return {@link OrgUser} containing the {@code orgId} and {@code userId} of
	 *         the mapping
	 */
	public OrgUser addOrgUser(long orgId, OrgUser orgUser);

	/**
	 * To get an organization-user mapping by {@code orgId} and {@code userId}.
	 * 
	 * @param orgId  ID of an organization to get the mapping
	 * @param userId ID of a user to get the mapping
	 * @return An {@link OrgUser}, if found for the given {@code orgId} and
	 *         {@code userId} otherwise, {@code null}
	 */
	public OrgUser getOrgUser(long orgId, long userId);

	/**
	 * To get a paginated and sorted list of organization-user mappings for an
	 * organization specified by the given {@code orgId}.
	 * 
	 * @param orgId            ID of an organization to get the list of mappings
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of organization-user mappings
	 */

	public RecordsPage<OrgUser> getOrgUsers(long orgId, int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);

	/**
	 * To get a paginated and sorted list of organization-user mappings for a user
	 * specified by the given {@code userId}.
	 * 
	 * @param userId           ID of a user get the list of associated
	 *                         organization-user mappings
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of organization-user mappings
	 */
	public RecordsPage<OrgUser> getUserOrgs(long userId, int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
