package in.co.mark.webservices.iam.persistence;

import in.co.mark.webservices.iam.persistence.entities.LoginCredentialEObj;

public interface LoginCredentialDBAdapter {
	/**
	 * To create a new login credential record in DB
	 * 
	 * @param loginCredEObj Login credential entity to create
	 * @return The newly created login credential entity
	 */
	public LoginCredentialEObj CreateLoginCredential(LoginCredentialEObj loginCredEObj);

	/**
	 * To get a login credential by ID from DB
	 * 
	 * @param id ID of a login credential to get its details
	 * @return A {@code LoginCredential}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public LoginCredentialEObj getLoginCredentialById(long id);

	/**
	 * To get a login credential by {@code username} from DB
	 * 
	 * @param username Username of a login credential to get its details
	 * @return A {@code LoginCredential}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public LoginCredentialEObj getLoginCredentialByUsername(String username);

	/**
	 * To update the password of a login credential by its ID
	 * 
	 * @param id          ID of a login credential to update its password
	 * @param newPassword New password to update
	 */
	public void UpdateLoginPassword(long id, String newPassword);

	/**
	 * To update a given login credential entity in DB
	 * 
	 * @param loginCredEObj Login credential entity to update
	 * @return {@code true}, if the password is updated successfully; otherwise,
	 *         {@code false}
	 */
	public LoginCredentialEObj UpdateLoginCredential(LoginCredentialEObj loginCredEObj);
}
