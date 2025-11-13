package in.co.mark.webservices.contacts.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.MaritalStatus;

public interface MaritalStatusesService {
	/**
	 * To create a new marital status
	 * 
	 * @param reqObj Request object for creating a new marital status
	 * @return Newly created marital status
	 */
	public MaritalStatus createMaritalStatus(MaritalStatus reqObj);

	/**
	 * To get a marital status by ID
	 * 
	 * @param id ID of a marital status to get its details
	 * @return A {@link MaritalStatus}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public MaritalStatus getMaritalStatusById(long id);

	/**
	 * To get a paginated list of marital statuses
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of marital status entities
	 */
	public RecordsPage<MaritalStatus> getMaritalStatuses(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of marital statuses from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of marital status entities
	 */
	public RecordsPage<MaritalStatus> getMaritalStatuses(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
