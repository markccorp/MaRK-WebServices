package in.co.mark.webservices.contacts.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.IdentifierType;

public interface IdentifierTypesService {
	/**
	 * To create a new identifier type
	 * 
	 * @param reqObj Request object for creating a new identifier type
	 * @return Newly created identifier type
	 */
	public IdentifierType createIdentifierType(IdentifierType reqObj);

	/**
	 * To get an identifier type by ID
	 * 
	 * @param id ID of an identifier type to get its details
	 * @return An {@link IdentifierType}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public IdentifierType getIdentifierTypeById(long id);

	/**
	 * To get a paginated list of identifier types
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of identifier type entities
	 */
	public RecordsPage<IdentifierType> getIdentifierTypes(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of identifier types from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of identifier type entities
	 */
	public RecordsPage<IdentifierType> getIdentifierTypes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
