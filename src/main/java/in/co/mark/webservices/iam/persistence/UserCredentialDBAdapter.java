package in.co.mark.webservices.iam.persistence;

import in.co.mark.webservices.iam.persistence.entities.UserCredentialEObj;

public interface UserCredentialDBAdapter {
	/**
	 * To create a new user credential record in DB
	 * 
	 * @param userCredEObj User login credential entity to create
	 * @return The newly created user login credential entity
	 */
	public UserCredentialEObj CreateUserCredential(UserCredentialEObj userCredEObj);

	/**
	 * To get a user credential by ID from DB
	 * 
	 * @param id ID of a user login credential to get its details
	 * @return A {@code UserCredential}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public UserCredentialEObj getUserCredentialById(long id);

	/**
	 * To get a user credential by {@code username} from DB
	 * 
	 * @param username Username of a user login credential to get its details
	 * @return A {@code UserCredential}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public UserCredentialEObj getUserCredentialByUsername(String username);

	/**
	 * To update the password of a user credential by its ID
	 * 
	 * @param id          ID of a user login credential to update its password
	 * @param newPassword New password to update
	 */
	public void UpdateUserPassword(long id, String newPassword);

	/**
	 * To update a given user credential entity in DB
	 * 
	 * @param userCredEObj User login credential entity to update
	 * @return {@code true}, if the password is updated successfully; otherwise,
	 *         {@code false}
	 */
	public UserCredentialEObj UpdateUserCredential(UserCredentialEObj userCredEObj);
}
