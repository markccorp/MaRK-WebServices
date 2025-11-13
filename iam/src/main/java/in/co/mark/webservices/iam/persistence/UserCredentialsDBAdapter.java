package in.co.mark.webservices.iam.persistence;

import in.co.mark.webservices.iam.persistence.entities.UserCredentialEObj;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;

public interface UserCredentialsDBAdapter {
	/**
	 * To create a new user credential record in DB.
	 * <p>
	 * If {@code userCredEObj.userEObj} is {@code null} then the implementation
	 * should first set it to a reference of {@link UserEObj} and then save the
	 * given {@code userCredEObj}.
	 * </p>
	 * 
	 * @param userId       ID of the owner user of the credential. It will be used
	 *                     to set a reference of {@link UserEObj} to
	 *                     {@code userCredEObj.userEObj}, if it not already set.
	 * @param userCredEObj User credential entity to create
	 * @return The newly created user credential entity
	 */
	public UserCredentialEObj createUserCredential(long userId, UserCredentialEObj userCredEObj);

	/**
	 * To create a new user credential record in DB.
	 * <p>
	 * Note that the given {@code userCredEObj} must have a valid reference set for
	 * its {@code userEObj} property.
	 * </p>
	 * 
	 * @param userCredEObj User credential entity to create
	 * @return The newly created user credential entity
	 */
	public UserCredentialEObj createUserCredential(UserCredentialEObj userCredEObj);

	/**
	 * To get a user credential by ID from DB.
	 * 
	 * @param id ID (user's ID) of a credential to get
	 * @return A {@code UserCredential}, if found for the given {@code id};
	 *         otherwise, {@code null}
	 */
	public UserCredentialEObj getUserCredentialById(long id);

	/**
	 * To update a given user credential entity in DB
	 * 
	 * @param userCredEObj User credential entity to update
	 * @return Updated user credential
	 */
	public UserCredentialEObj updateUserCredential(UserCredentialEObj userCredEObj);
}
