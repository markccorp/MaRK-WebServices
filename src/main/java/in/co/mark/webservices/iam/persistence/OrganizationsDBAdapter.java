package in.co.mark.webservices.iam.persistence;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.iam.persistence.entities.OrganizationEObj;

public interface OrganizationsDBAdapter {
	/**
	 * To create a new organization record in DB
	 * 
	 * @param orgEObj Organization entity to create
	 * @return The newly created organization entity
	 */
	public OrganizationEObj createOrganization(OrganizationEObj orgEObj);

	/**
	 * To get an organization by ID from DB
	 * 
	 * @param id ID of an organization to get its details
	 * @return An {@link OrganizationEObj}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public OrganizationEObj getOrganizationById(long id);

	/**
	 * To get a paginated list of organizations from DB
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of organization entities
	 */
	public RecordsPage<OrganizationEObj> getOrganizations(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of organizations from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of organization entities
	 */
	public RecordsPage<OrganizationEObj> getOrganizations(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
