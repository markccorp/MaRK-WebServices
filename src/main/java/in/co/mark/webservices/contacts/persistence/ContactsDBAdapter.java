package in.co.mark.webservices.contacts.persistence;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.persistence.entities.AddressEObj;
import in.co.mark.webservices.contacts.persistence.entities.AddressTypeEObj;
import in.co.mark.webservices.contacts.persistence.entities.ContactAddressEObj;
import in.co.mark.webservices.contacts.persistence.entities.ContactEObj;
import in.co.mark.webservices.contacts.persistence.entities.ContactEmailEObj;
import in.co.mark.webservices.contacts.persistence.entities.EmailTypeEObj;
import in.co.mark.webservices.contacts.persistence.entities.NamePrefixEObj;
import in.co.mark.webservices.contacts.persistence.entities.NameSuffixEObj;

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

	/**
	 * To create a new name prefix record in DB
	 * 
	 * @param namePrefixEObj NamePrefix entity to create
	 * @return The newly created name prefix entity
	 */
	public NamePrefixEObj createNamePrefix(NamePrefixEObj namePrefixEObj);

	/**
	 * To get a name prefix by ID from DB
	 * 
	 * @param id ID of a name prefix to get its details
	 * @return A {@link NamePrefixEObj}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public NamePrefixEObj getNamePrefixById(long id);

	/**
	 * To get a paginated list of name prefixes from DB
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of name prefix entities
	 */
	public RecordsPage<NamePrefixEObj> getNamePrefixes(int pageNo, int pageSize);

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
	public RecordsPage<NamePrefixEObj> getNamePrefixes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);

	/**
	 * To create a new name suffix record in DB
	 * 
	 * @param nameSuffixEObj NameSuffix entity to create
	 * @return The newly created name suffix entity
	 */
	public NameSuffixEObj createNameSuffix(NameSuffixEObj nameSuffixEObj);

	/**
	 * To get a name suffix by ID from DB
	 * 
	 * @param id ID of a name suffix to get its details
	 * @return A {@link NameSuffixEObj}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public NameSuffixEObj getNameSuffixById(long id);

	/**
	 * To get a paginated list of name suffixes from DB
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of name suffix entities
	 */
	public RecordsPage<NameSuffixEObj> getNameSuffixes(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of name suffixes from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of name suffix entities
	 */
	public RecordsPage<NameSuffixEObj> getNameSuffixes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);

	/**
	 * To create a new email type record in DB
	 * 
	 * @param emailTypeEObj EmailType entity to create
	 * @return The newly created email type entity
	 */
	public EmailTypeEObj createEmailType(EmailTypeEObj emailTypeEObj);

	/**
	 * To get an email type by ID from DB
	 * 
	 * @param id ID of an email type to get its details
	 * @return A {@link EmailTypeEObj}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public EmailTypeEObj getEmailTypeById(long id);

	/**
	 * To get a paginated list of email types from DB
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of email type entities
	 */
	public RecordsPage<EmailTypeEObj> getEmailTypes(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of email types from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of email type entities
	 */
	public RecordsPage<EmailTypeEObj> getEmailTypes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);

	/**
	 * To create a new contact email record in DB
	 * 
	 * @param contactEmailEObj ContactEmail entity to create
	 * @return The newly created contact email entity
	 */
	public ContactEmailEObj createContactEmail(ContactEmailEObj contactEmailEObj);

	/**
	 * To get a contact email by ID from DB
	 * 
	 * @param id ID of a contact email to get its details
	 * @return A {@link ContactEmailEObj}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public ContactEmailEObj getContactEmailById(long id);

	/**
	 * To get a paginated list of contact email from DB
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of contact email entities
	 */
	public RecordsPage<ContactEmailEObj> getContactEmails(int pageNo, int pageSize);

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
	public RecordsPage<ContactEmailEObj> getContactEmails(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
