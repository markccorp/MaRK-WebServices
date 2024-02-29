package in.co.mark.common.domain.model;

/**
 * A model base class with {@code ownerUserId} property and its getter/setter
 * methods. Other model classes, which need user ID to represent user specific
 * instances, can extend it to avoid defining the common property/method.
 * 
 * @author Rakesh Kumar
 */
public class UserSpecificModel extends ModelTimestamp {
	protected long ownerUserId;

	public UserSpecificModel() {

	}

	/**
	 * Initializes {@code ownerUserId} property of this instance
	 * 
	 * @param ownerUserId ID of the owner user
	 */
	protected UserSpecificModel(long ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	/**
	 * Initializes all properties of this instance
	 * 
	 * @param ownerUserId   ID of the owner user
	 * @param createdOn     A timestamp indicating when the respective DB record was
	 *                      created
	 * @param lastUpdatedOn A timestamp indicating when the respective DB record was
	 *                      last updated
	 */
	protected UserSpecificModel(long ownerUserId, long createdOn, long lastUpdatedOn) {
		super(createdOn, lastUpdatedOn);
		this.ownerUserId = ownerUserId;
	}

	/**
	 * To get the ID of the owner user
	 * 
	 * @return {@code ownerUserId} - ID of the owner user
	 */
	public long getOwnerUserId() {
		return ownerUserId;
	}

	/**
	 * To set the ID of the owner user
	 * 
	 * @param ownerUserId ID of the owner user
	 */
	public void setOwnerUserId(long ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
}
