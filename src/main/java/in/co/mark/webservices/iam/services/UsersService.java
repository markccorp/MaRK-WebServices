package in.co.mark.webservices.iam.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.EntityActiveStatus;
import in.co.mark.webservices.iam.domain.model.User;

public interface UsersService {
	/**
	 * To check if an entity exists for the given {@code id}.
	 * 
	 * @param id ID to check if a matching entity exists
	 * @return {@code true} if a matching entity exits; otherwise, {@code false}
	 */
	public boolean existsById(long id);

	/**
	 * To check if a user exists for the given {@code email} address.
	 * 
	 * @param email Email address to check if a matching user exists
	 * @return {@code true} if a matching user exits; otherwise, {@code false}
	 */
	public boolean existsByEmail(String email);

	/**
	 * To create a new user. If a {@code password} is also provided then a new user
	 * credential with status {@code Active}, should also be created for the user.
	 * 
	 * @param user     {@link User} to create
	 * @param password Login password of the user (can be {@code null})
	 * @return Newly created user
	 */
	public User createUser(User user, String password);

	/**
	 * To create a new user. If a {@code password} is also provided then a new user
	 * credential should also be created for the user.
	 * 
	 * @param user           {@link User} to create
	 * @param password       Login password of the user (can be {@code null})
	 * @param passwordStatus Status of this credential
	 * @return Newly created user
	 */
	public User createUser(User user, String password, EntityActiveStatus passwordStatus);

	/**
	 * To get the user summary by a given user {@code id}.
	 * 
	 * @param id ID of a user to get summary
	 * @return User summary for the given {@code id}
	 */
	public User getUserSummaryById(long id);

	/**
	 * To get the user summary by a given {@code email} address.
	 * 
	 * @param email Email address of a user to get summary
	 * @return User summary, if found, for the given {@code email} address
	 */
	public User getUserSummaryByEmail(String email);

	/**
	 * To get a paginated and sorted list of users summary.
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for descending; otherwise, ascending
	 * @param sortByProperties Sort-by column names (cannot be {@code null})
	 * @return A {@link RecordsPage} containing list of {@link User}
	 */
	public RecordsPage<User> getUsersSummary(int pageNo, int pageSize, int sortOrder, String... sortByProperties);

	//////////////////////////////
//	public User createUser(UserRequestDTO reqDto, boolean hasCredentials);

//	/**
//	 * To get a user by ID
//	 * 
//	 * @param id ID of a user to get its details
//	 * @return A {@link User}, if found for the given {@code id}; otherwise,
//	 *         {@code null}
//	 */
//	public User findById(long id);
//
//	/**
//	 * To get a user by email address
//	 * 
//	 * @param email An email address to get the respective user details
//	 * @return A {@link User}, if found for the given {@code email}; otherwise,
//	 *         {@code null}
//	 */
//	public User findByEmail(String email);
//
//	public RecordsPage<User> getUsers(int pageNo, int pageSize);
//
//	public List<User> getAllUsers(int pageNo, int pageSize, int sortOrder, String... sortByProperties);
}
