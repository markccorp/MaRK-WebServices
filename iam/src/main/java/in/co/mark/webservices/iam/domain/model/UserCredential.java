package in.co.mark.webservices.iam.domain.model;

import in.co.mark.common.persistence.util.EntityActiveStatus;

/**
 * Represents a <i>User Credential</i> which contains user password.
 * 
 * @author Rakesh Kumar
 */
public class UserCredential {
	/** ID of the owner user of this credential. */
	private long id;

	/** Password value of this credential. */
	private String password;

	/** Status of this credential. */
	private EntityActiveStatus status;

	/** Timestamp indicating when the respective record was created. */
	private long createdOn;

	/** Timestamp indicating when the respective record was last updated. */
	private long lastUpdatedOn;

	/** The default constructor of this class. */
	public UserCredential() {
	}

	/**
	 * Initializes {@code password} and {@code status} properties of this class.
	 * 
	 * @param userId   ID of the owner user of this credential
	 * @param password Password to login to the service
	 * @param status   Status of this credential
	 */
	public UserCredential(String password, EntityActiveStatus status) {
		this.password = password;
		this.status = status;
	}

	/**
	 * Initializes all properties of this class.
	 * 
	 * @param id            ID of this login credential
	 * @param password      Password to login to the service
	 * @param status        Status of this credential
	 * @param createdOn     Timestamp indicating when this credential was created
	 * @param lastUpdatedOn Timestamp indicating when this credential was last
	 *                      updated
	 */
	public UserCredential(long id, String password, EntityActiveStatus status, long createdOn, long lastUpdatedOn) {
		this(password, status);
		this.id = id;
		this.createdOn = createdOn;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EntityActiveStatus getStatus() {
		return status;
	}

	public void setStatus(EntityActiveStatus status) {
		this.status = status;
	}

	public long getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}

	public long getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(long lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
}
