package in.co.mark.webservices.iam.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.iam.domain.model.Organization;

public interface OrganizationsService {
	/**
	 * To check if an entity exists for the given {@code id}.
	 * 
	 * @param id ID to check if a matching entity exists
	 * @return {@code true} if a matching entity exits; otherwise, {@code false}
	 */
	public boolean existsById(long id);

	/**
	 * To create a new organization.
	 * 
	 * @param reqObj {@link Organization} to create
	 * @return Newly created organization
	 */
	public Organization createOrganization(Organization reqObj);

	/**
	 * To get an organization by ID.
	 * 
	 * @param id ID of an organization to get
	 * @return An {@link Organization}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public Organization getOrganizationById(long id);

	/**
	 * To get a paginated and sorted list of organizations from DB.
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for descending; otherwise, ascending
	 * @param sortByProperties Sort-by column names (cannot be {@code null})
	 * @return A {@link RecordsPage} containing list of {@link Organization}
	 */
	public RecordsPage<Organization> getOrganizations(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
