package in.co.mark.webservices.contacts.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.ContactEmail;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactEmailRequest;

public interface ContactEmailsService {
	/**
	 * To create a new contact email by the given request DTO
	 * 
	 * @param reqDto Request DTO object for creating a new contact email
	 * @return Newly created contact email
	 */
	public ContactEmail createContactEmail(CreateContactEmailRequest reqDto);

	/**
	 * To create a new contact email by the given contact email request
	 * 
	 * @param reqObj Request object for creating a new contact email
	 * @return Newly created contact email
	 */
	public ContactEmail createContactEmail(ContactEmail reqObj);

	/**
	 * To get a contact email by ID
	 * 
	 * @param id ID of a contact email to get its details
	 * @return An {@link ContactEmail}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public ContactEmail getContactEmailById(long id);

	/**
	 * To get a paginated list of contact email
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of contact email entities
	 */
	public RecordsPage<ContactEmail> getContactEmails(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of contact email from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of contact email entities
	 */
	public RecordsPage<ContactEmail> getContactEmails(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
