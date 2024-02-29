package in.co.mark.webservices.iam.persistence;

import org.springframework.data.domain.Page;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;

public interface UsersDBAdapter {
	/**
	 * To create a new user record in DB
	 * 
	 * @param userEObj User entity to create
	 * @return The newly created user entity
	 */
	public UserEObj createUser(UserEObj userEObj);

	/**
	 * To get a user by ID from DB
	 * 
	 * @param id ID of a user to get its details
	 * @return A {code User}, if found for the given {@code id}; otherwise,
	 *         {@code null}
	 */
	public UserEObj getUserById(long id);

	/**
	 * To get a user by email from DB
	 * 
	 * @param id An email of a user to get its details
	 * @return A {@code User}, if found for the given {@code email}; otherwise,
	 *         {@code null}
	 */
	public UserEObj getUserByEmail(String email);

	/**
	 * To get a paginated list of users from DB
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link Page} containing list of contacts
	 */
	public RecordsPage<UserEObj> getUsers(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of users from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link Page} containing list of contacts
	 */
	public RecordsPage<UserEObj> getUsers(int pageNo, int pageSize, int sortOrder, String... sortByProperties);
}
