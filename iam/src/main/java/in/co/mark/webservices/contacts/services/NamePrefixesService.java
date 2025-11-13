package in.co.mark.webservices.contacts.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.NamePrefix;

public interface NamePrefixesService {
	/**
	 * To create a new name prefix
	 * 
	 * @param reqObj Request object for creating a new name prefix
	 * @return Newly created name prefix
	 */
	public NamePrefix createNamePrefix(NamePrefix reqObj);

	/**
	 * To get a name prefix by ID
	 * 
	 * @param id ID of a name prefix to get its details
	 * @return A {@link NamePrefix}, if found for the given {@code id}; otherwise,
	 *         {@code null}
	 */
	public NamePrefix getNamePrefixById(long id);

	/**
	 * To get a paginated list of name prefixes
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of name prefix entities
	 */
	public RecordsPage<NamePrefix> getNamePrefixes(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of name prefixes from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of name prefix entities
	 */
	public RecordsPage<NamePrefix> getNamePrefixes(int pageNo, int pageSize, int sortOrder, String... sortByProperties);
}
