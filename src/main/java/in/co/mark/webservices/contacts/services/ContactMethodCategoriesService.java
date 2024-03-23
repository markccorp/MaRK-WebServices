package in.co.mark.webservices.contacts.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.ContactMethodCategory;

public interface ContactMethodCategoriesService {
	/**
	 * To create a new contact method category
	 * 
	 * @param reqObj Request object for creating a new contact method category
	 * @return Newly created contact method category
	 */
	public ContactMethodCategory createContactMethodCategory(ContactMethodCategory reqObj);

	/**
	 * To get an contact method category by ID
	 * 
	 * @param id ID of an contact method category to get its details
	 * @return An {@link ContactMethodCategory}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public ContactMethodCategory getContactMethodCategoryById(long id);

	/**
	 * To get a paginated list of contact method categories
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of contact method category
	 *         entities
	 */
	public RecordsPage<ContactMethodCategory> getContactMethodCategories(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of contact method categories from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of contact method category
	 *         entities
	 */
	public RecordsPage<ContactMethodCategory> getContactMethodCategories(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
