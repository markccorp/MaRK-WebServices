package in.co.mark.webservices.contacts.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.ContactMethodType;

public interface ContactMethodTypesService {
	/**
	 * To create a new contact method type
	 * 
	 * @param reqObj Request object for creating a new contact method type
	 * @return Newly created contact method type
	 */
	public ContactMethodType createContactMethodType(ContactMethodType reqObj);

	/**
	 * To get an contact method type by ID
	 * 
	 * @param id ID of an contact method type to get its details
	 * @return An {@link ContactMethodType}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public ContactMethodType getContactMethodTypeById(long id);

	/**
	 * To get a paginated list of contact method types
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of contact method type entities
	 */
	public RecordsPage<ContactMethodType> getContactMethodTypes(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of contact method types from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of contact method type entities
	 */
	public RecordsPage<ContactMethodType> getContactMethodTypes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
