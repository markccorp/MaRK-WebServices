package in.co.mark.webservices.contacts.persistence;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.persistence.entities.AddressEObj;
import in.co.mark.webservices.contacts.persistence.entities.AddressTypeEObj;
import in.co.mark.webservices.contacts.persistence.entities.ContactAddressEObj;
import in.co.mark.webservices.contacts.persistence.entities.ContactEObj;

public interface ContactsDBAdapter {
	/**
	 * To create a new contact record in DB
	 * 
	 * @param contactEObj Contact entity to create
	 * @return The newly created contact entity
	 */
	public ContactEObj createContact(ContactEObj contactEObj);

	/**
	 * To get a contact by ID from DB
	 * 
	 * @param id ID of a contact to get its details
	 * @return A {@link ContactEObj}, if found for the given {@code id}; otherwise,
	 *         {@code null}
	 */
	public ContactEObj getContactById(long id);

	/**
	 * To get a paginated list of contacts from DB
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of contact entities
	 */
	public RecordsPage<ContactEObj> getContacts(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of contacts from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of contact entities
	 */
	public RecordsPage<ContactEObj> getContacts(int pageNo, int pageSize, int sortOrder, String... sortByProperties);

	/**
	 * To create a new address record in DB
	 * 
	 * @param addressEObj Address entity to create
	 * @return The newly created address entity
	 */
	public AddressEObj createAddress(AddressEObj addressEObj);

	/**
	 * To get an address by ID from DB
	 * 
	 * @param id ID of an address to get its details
	 * @return An {@link AddressEObj}, if found for the given {@code id}; otherwise,
	 *         {@code null}
	 */
	public AddressEObj getAddressById(long id);

	/**
	 * To get a paginated list of addresses from DB
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of address entities
	 */
	public RecordsPage<AddressEObj> getAddresses(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of addresses from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of address entities
	 */
	public RecordsPage<AddressEObj> getAddresses(int pageNo, int pageSize, int sortOrder, String... sortByProperties);

	/**
	 * To create a new address-type record in DB
	 * 
	 * @param addressTypeEObj AddressType entity to create
	 * @return The newly created address-type entity
	 */
	public AddressTypeEObj createAddressType(AddressTypeEObj addressTypeEObj);

	/**
	 * To get an address-type by ID from DB
	 * 
	 * @param id ID of an address-type to get its details
	 * @return An {@link AddressTypeEObj}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public AddressTypeEObj getAddressTypeById(long id);

	/**
	 * To get a paginated list of address types from DB
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of address-type entities
	 */
	public RecordsPage<AddressTypeEObj> getAddressTypes(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of address types from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of address-type entities
	 */
	public RecordsPage<AddressTypeEObj> getAddressTypes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);

	/**
	 * To create a new contact-address record in DB
	 * 
	 * @param contactAddressEObj ContactAddress entity to create
	 * @return The newly created contact-address entity
	 */
	public ContactAddressEObj createContactAddress(ContactAddressEObj contactAddressEObj);

	/**
	 * To get a contact-address by ID from DB
	 * 
	 * @param id ID of a contact-address to get its details
	 * @return A {@link ContactAddressEObj}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public ContactAddressEObj getContcatAddressById(long id);

	/**
	 * To get a paginated list of contact addresses from DB
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of contact-address entities
	 */
	public RecordsPage<ContactAddressEObj> getContactAddresses(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of contact addresses from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of contact-address entities
	 */
	public RecordsPage<ContactAddressEObj> getContactAddresses(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
