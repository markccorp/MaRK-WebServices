package in.co.mark.webservices.contacts.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.EmailType;

public interface EmailTypesService {
	/**
	 * To create a new email type
	 * 
	 * @param reqObj Request object for creating a new email type
	 * @return Newly created email type
	 */
	public EmailType createEmailType(EmailType reqObj);

	/**
	 * To get an email type by ID
	 * 
	 * @param id ID of an email type to get its details
	 * @return An {@link EmailType}, if found for the given {@code id}; otherwise,
	 *         {@code null}
	 */
	public EmailType getEmailTypeById(long id);

	/**
	 * To get a paginated list of email types
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of email type entities
	 */
	public RecordsPage<EmailType> getEmailTypes(int pageNo, int pageSize);

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
	public RecordsPage<EmailType> getEmailTypes(int pageNo, int pageSize, int sortOrder, String... sortByProperties);
}
