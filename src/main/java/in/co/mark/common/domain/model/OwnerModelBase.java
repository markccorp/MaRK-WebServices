package in.co.mark.common.domain.model;

/**
 * A base model class with a property and its getter/setter methods to store the
 * owner's ID ({@code ownerId}). It also inherits the properties and
 * getter/setter methods to store <i>created</i> and <i>last updated</i> time
 * form {@link ModelBase} class. Other model classes can extend it to avoid
 * redefining these common properties/methods.
 * <p>
 * An extending class with possibilities of having both <i>Organization</i> and
 * <i>User</i> specific instances can define an additional property, say
 * {@code isOwnerOrg} to specify whether the owner ({@code ownerId}) is an
 * organization or not.
 * </p>
 * 
 * @author Rakesh Kumar
 */
public class OwnerModelBase extends ModelBase {
	protected long ownerId;

	public OwnerModelBase() {

	}

	/**
	 * Initializes {@code ownerUserId} property of this instance
	 * 
	 * @param ownerId ID of the owner - can be a user or an organization
	 */
	protected OwnerModelBase(long ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * Initializes all properties of this instance
	 * 
	 * @param ownerId       ID of the owner - can be a user or an organization
	 * @param createdOn     A timestamp indicating when the respective DB record was
	 *                      created
	 * @param lastUpdatedOn A timestamp indicating when the respective DB record was
	 *                      last updated
	 */
	protected OwnerModelBase(long ownerId, long createdOn, long lastUpdatedOn) {
		super(createdOn, lastUpdatedOn);
		this.ownerId = ownerId;
	}

	/**
	 * To get the ID of the owner which can either be a user or an organization
	 * 
	 * @return {@code ownerUserId} - ID of the owner
	 */
	public long getOwnerId() {
		return ownerId;
	}

	/**
	 * To set the ID of the owner which can either be a user or an organization
	 * 
	 * @param ownerId ID of the owner
	 */
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
}
