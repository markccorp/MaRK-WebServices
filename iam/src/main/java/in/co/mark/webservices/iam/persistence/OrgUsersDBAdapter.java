package in.co.mark.webservices.iam.persistence;

import org.springframework.data.domain.Page;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.iam.persistence.entities.OrgUserEObj;
import in.co.mark.webservices.iam.persistence.entities.OrgUserIdentifier;
import jakarta.persistence.EntityExistsException;

/**
 * @author Rakesh Kumar
 */
public interface OrgUsersDBAdapter {
	/**
	 * To check if a mapping exists for the given {@code orgUserId}.
	 * 
	 * @param orgUserId {@link OrgUserIdentifier} to check if a mapping exists
	 * @return {@code true} if a mapping exits; otherwise, {@code false}
	 */
	public boolean existsById(OrgUserIdentifier orgUserId);

	/**
	 * To persist a new mapping for organization and user.
	 * <p>
	 * It assumes that the mapping is new and it does not exist in DB. If the
	 * mapping already exists, it throws {@link EntityExistsException}.
	 * </p>
	 * 
	 * @param orgUserEObj {@link OrgUserEObj} to persist the new mapping
	 */
	public void persist(OrgUserEObj orgUserEObj);

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
	 * To get a paginated and sorted list of Org-user mappings from DB
	 * 
	 * @param orgId            ID of an Org to get its users
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link Page} containing list of Org-user mappings
	 */
	public RecordsPage<OrgUserEObj> getOrgUsers(long orgId, int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);

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
