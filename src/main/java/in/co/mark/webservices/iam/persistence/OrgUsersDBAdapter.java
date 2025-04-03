package in.co.mark.webservices.iam.persistence;

import org.springframework.data.domain.Page;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.iam.persistence.entities.OrgUserEObj;

/**
 * @author Rakesh Kumar
 */
public interface OrgUsersDBAdapter {
	/**
	 * To create a new Org user association record in DB
	 * 
	 * @param orgUserEObj Org user entity to create
	 * @return The newly created Org user entity
	 */
	public OrgUserEObj addOrgUser(OrgUserEObj orgUserEObj);

	/**
	 * To get an Org-user mapping by Org ID and User ID
	 * 
	 * @param orgId  ID of an Org to get the respective Org user record
	 * @param userId ID of a user to get the respective Org user record
	 * @return An {@code OrgUserEObj}, if found for the given {@code orgId} and
	 *         {@code userId} otherwise, {@code null}
	 */
	public OrgUserEObj getOrgUser(long orgId, long userId);

	/**
	 * To get a paginated list of Org-user mappings from DB
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link Page} containing list of Org-user mappings
	 */
	public RecordsPage<OrgUserEObj> getOrgUsers(int pageNo, int pageSize);

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
	public RecordsPage<OrgUserEObj> getOrgUsers(int pageNo, int pageSize, int sortOrder, String... sortByProperties);

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
	public RecordsPage<OrgUserEObj> getUserOrgs(long userId, int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
