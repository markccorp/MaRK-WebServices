package in.co.mark.webservices.contacts.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.ContactIdentifier;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactIdentifierRequest;

public interface ContactIdentifiersService {
	/**
	 * To create a new contact identifier by the given request DTO
	 * 
	 * @param reqDto Request DTO object for creating a new contact identifier
	 * @return Newly created contact identifier
	 */
	public ContactIdentifier createContactIdentifier(CreateContactIdentifierRequest reqDto);

	/**
	 * To create a new contact identifier by the given contact identifier request
	 * 
	 * @param reqObj Request object for creating a new contact identifier
	 * @return Newly created contact identifier
	 */
	public ContactIdentifier createContactIdentifier(ContactIdentifier reqObj);

	/**
	 * To get a contact identifier by ID
	 * 
	 * @param id ID of a contact identifier to get its details
	 * @return An {@link ContactIdentifier}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public ContactIdentifier getContactIdentifierById(long id);

	/**
	 * To get a paginated list of contact identifier
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of contact identifier entities
	 */
	public RecordsPage<ContactIdentifier> getContactIdentifiers(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of contact identifier from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of contact identifier entities
	 */
	public RecordsPage<ContactIdentifier> getContactIdentifiers(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
