package in.co.mark.webservices.iam.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.gateway.dto.CreateUserRequest;
import in.co.mark.webservices.iam.gateway.dto.CreateUserResponse;

public interface UsersService {
	/**
	 * To create a new user
	 * 
	 * @param reqDto Request DTO for creating a new user
	 * @return Response DTO on successful creation of the user
	 */
	public CreateUserResponse createUser(CreateUserRequest reqDto);

	/**
	 * To get a user by ID
	 * 
	 * @param id ID of a user to get its details
	 * @return A {@link User}, if found for the given {@code id}; otherwise,
	 *         {@code null}
	 */
	public User getUserById(long id);

	/**
	 * To get a user by email address
	 * 
	 * @param email An email address to get the respective user details
	 * @return A {@link User}, if found for the given {@code email}; otherwise,
	 *         {@code null}
	 */
	public User getUserByEmail(String email);

	public RecordsPage<User> getUsers(int pageNo, int pageSize);

	public RecordsPage<User> getUsers(int pageNo, int pageSize, int sortOrder, String... sortByProperties);

}
