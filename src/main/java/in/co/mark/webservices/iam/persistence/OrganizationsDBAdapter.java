package in.co.mark.webservices.iam.persistence;

import org.springframework.data.domain.Page;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.iam.persistence.entities.OrganizationEObj;

public interface OrganizationsDBAdapter {
	/**
	 * To check if an entity exists for the given {@code id}.
	 * 
	 * @param id ID to check if a matching entity exists
	 * @return {@code true} if a matching entity exits; otherwise, {@code false}
	 */
	public boolean existsById(long id);

	/**
	 * To create a new organization record in DB.
	 * 
	 * @param orgEObj Organization entity to create
	 * @return The newly created organization entity
	 */
	public OrganizationEObj createOrganization(OrganizationEObj orgEObj);

	/**
	 * To get an organization by ID from DB.
	 * 
	 * @param id ID of an organization to get
	 * @return An {@link OrganizationEObj}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public OrganizationEObj getOrganizationById(long id);

	/**
	 * To get a paginated and sorted list of organizations from DB.
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for descending; otherwise, ascending
	 * @param sortByProperties Sort-by column names (cannot be {@code null})
	 * @return A {@link Page} containing list of {@link OrganizationEObj}
	 */
	public RecordsPage<OrganizationEObj> getOrganizations(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
