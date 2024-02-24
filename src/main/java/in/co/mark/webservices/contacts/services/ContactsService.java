package in.co.mark.webservices.contacts.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.Contact;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactRequest;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactResponse;

public interface ContactsService {
	/**
	 * To create a new contact
	 * 
	 * @param reqDto Request DTO for creating a new contact
	 * @return Response DTO on successful creation of the contact
	 */
	public CreateContactResponse createContact(CreateContactRequest reqDto);

	/**
	 * To get a contact by ID
	 * 
	 * @param id ID of a contact to get its details
	 * @return A {@link Contact}, if found for the given {@code id}; otherwise,
	 *         {@code null}
	 */
	public Contact getContactById(long id);

	public RecordsPage<Contact> getContacts(int pageNo, int pageSize);

	public RecordsPage<Contact> getContacts(int pageNo, int pageSize, int sortOrder, String... sortByProperties);
}
