package in.co.mark.webservices.iam.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.iam.domain.model.Organization;

public interface OrganizationsService {
	/**
	 * To create a new organization
	 * 
	 * @param reqObj Request object for creating a new organization
	 * @return Newly created organization
	 */
	public Organization createOrganization(Organization reqObj);

	/**
	 * To get an organization by ID
	 * 
	 * @param id ID of an organization to get its details
	 * @return An {@link Organization}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public Organization getOrganizationById(long id);

	/**
	 * To get a paginated list of organizations
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of organization entities
	 */
	public RecordsPage<Organization> getOrganizations(int pageNo, int pageSize);

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
	public RecordsPage<Organization> getOrganizations(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
