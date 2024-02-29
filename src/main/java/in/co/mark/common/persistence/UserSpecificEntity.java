package in.co.mark.common.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * An entity base class with {@code ownerUserId} property and its getter/setter
 * methods. Note that this is just a <i>mapped superclass</i>, and not an actual
 * entity. The actual entity classes can extend it to avoid defining the common
 * property/method.
 * 
 * @author Rakesh Kumar
 */
@MappedSuperclass
public abstract class UserSpecificEntity extends EntityTimestamp {
	@Getter
	@Setter
	@Column(name = "owner_user_id", nullable = false)
	protected long ownerUserId;

	protected UserSpecificEntity() {

	}

	/**
	 * Initializes {@code ownerUserId} property of this instance
	 * 
	 * @param ownerUserId ID of the owner user
	 */
	protected UserSpecificEntity(long ownerUserId) {
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
	protected UserSpecificEntity(long ownerUserId, long createdOn, long lastUpdatedOn) {
		super(createdOn, lastUpdatedOn);
		this.ownerUserId = ownerUserId;
	}
}
