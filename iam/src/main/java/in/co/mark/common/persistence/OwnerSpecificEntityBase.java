package in.co.mark.common.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * A base entity class with a property and its getter/setter methods to store
 * the owner's ID ({@code ownerId}) of the entity. It also inherits the
 * properties and getter/setter methods to store <i>created</i> and <i>last
 * updated</i> time form {@link EntityBase} class.
 * <p>
 * An extending class with possibilities of having both <i>Organization</i> and
 * <i>User</i> specific instances can define an additional property, say
 * {@code isOwnerOrg} to specify whether the owner ({@code ownerId}) is an
 * organization or not.
 * </p>
 * Note that this is just a <i>mapped superclass</i>, and not an actual entity.
 * By extending it one can just avoid redefining the common properties/methods.
 * 
 * @author Rakesh Kumar
 */
@MappedSuperclass
public abstract class OwnerSpecificEntityBase extends EntityBase {
	@Getter
	@Setter
	@Column(name = "owner_id", nullable = false)
	protected long ownerId;

	protected OwnerSpecificEntityBase() {

	}

	/**
	 * Initializes {@code ownerId} property of this instance
	 * 
	 * @param ownerId ID of the owner - can be a user or an organization
	 */
	protected OwnerSpecificEntityBase(long ownerId) {
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
	protected OwnerSpecificEntityBase(long ownerId, long createdOn, long lastUpdatedOn) {
		super(createdOn, lastUpdatedOn);
		this.ownerId = ownerId;
	}
}
