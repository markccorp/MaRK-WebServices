package in.co.mark.webservices.iam.persistence;

import org.springframework.data.domain.Page;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.persistence.entities.projections.UserSummary;

public interface UsersDBAdapter {
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
	 * To create a new user record in DB.
	 * 
	 * @param userEObj User entity to create
	 * @return The newly created user entity
	 */
	public UserEObj createUser(UserEObj userEObj);

	/**
	 * To get user summary by a given user {@code id}.
	 * 
	 * @param id ID of a user to get summary
	 * @return User summary for the given {@code id}
	 */
	public UserSummary getUserSummaryById(long id);

	/**
	 * To get the user summary by a given {@code email} address.
	 * 
	 * @param email Email address of a user to get summary
	 * @return User summary, if found, for the given {@code email} address
	 */
	public UserSummary getUserSummaryByEmail(String email);

	/**
	 * To get a paginated and sorted list of users summary.
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for descending; otherwise, ascending
	 * @param sortByProperties Sort-by column names (cannot be {@code null})
	 * @return A {@link Page} containing list of {@link UserSummary}
	 */
	public RecordsPage<UserSummary> getUsersSummary(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
