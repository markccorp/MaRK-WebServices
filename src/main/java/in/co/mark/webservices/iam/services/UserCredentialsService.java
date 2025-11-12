package in.co.mark.webservices.iam.services;

import in.co.mark.common.persistence.util.EntityActiveStatus;
import in.co.mark.webservices.iam.domain.model.UserCredential;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;

public interface UserCredentialsService {
	/**
	 * To create a new credentials with given {@code password} for a user specified
	 * by given {@code userId}. The credential status should be set to
	 * {@code Active}.
	 * 
	 * @param userId   ID of the user to create a new credential for
	 * @param password Password to be added as credential
	 * @return Newly created user credential
	 */
	public UserCredential createUserCredential(long userId, String password);

	/**
	 * To create a new credentials with given {@code password} and {@code status}
	 * for a user specified by given {@code userId}.
	 * 
	 * @param userId   ID of the user to create a new credential for
	 * @param password Password to be added as credential
	 * @param status   Status of this credential
	 * @return Newly created user credential
	 */
	public UserCredential createUserCredential(long userId, String password, EntityActiveStatus status);

	/**
	 * To create a new credentials with given {@code password} and {@code status}
	 * for given {@code userEObj}.
	 * 
	 * @param userEObj {@link UserEObj} to create a new credential for
	 * @param password Password to be added as credential
	 * @param status   Status of this credential
	 * @return Newly created user credential
	 */
	public UserCredential createUserCredential(UserEObj userEObj, String password, EntityActiveStatus status);

	/**
	 * To get a user credential by {@code id}.
	 * 
	 * @param id ID (user's ID) to get user credential
	 * @return User credential for the given {@code id}
	 */
	public UserCredential getUserCredentialById(long id);

	/**
	 * To update the user credential with given {@code password} and {@code status}
	 * for a user specified by {@code userId} .
	 * 
	 * @param id       ID (user's ID) of a credential to update
	 * @param password New password to update with
	 * @param status   New status of this credential
	 * @return Updated user credential
	 * @throws Exception
	 */
	public UserCredential updateUserCredential(long id, String password, EntityActiveStatus status);
}
