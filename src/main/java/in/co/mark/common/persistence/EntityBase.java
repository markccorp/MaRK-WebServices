package in.co.mark.common.persistence;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

/**
 * A base entity class with properties and the respective getter/setter methods
 * to store <i>created</i> and <i>last updated</i> time of the entity.
 * <p>
 * Note that this is just a <i>mapped superclass</i>, and not an actual entity.
 * By extending it one can just avoid redefining the common properties/methods.
 * </P>
 * 
 * @author Rakesh Kumar
 */
@MappedSuperclass
public abstract class EntityBase {
	@Getter
	@Setter
	@Column(name = "created_on", nullable = false)
	protected long createdOn;

	@Getter
	@Setter
	@Column(name = "last_updated_on", nullable = false)
	protected long lastUpdatedOn;

	/**
	 * Default constructor
	 */
	public EntityBase() {

	}

	/**
	 * Initializes all properties of this instance
	 * 
	 * @param createdOn     A timestamp indicating when the respective DB record was
	 *                      created
	 * @param lastUpdatedOn A timestamp indicating when the respective DB record was
	 *                      last updated
	 */
	protected EntityBase(long createdOn, long lastUpdatedOn) {
		this.createdOn = createdOn;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	@PrePersist
	public void prePersist() {
		long currTimeMilli = Instant.now().toEpochMilli();
		createdOn = currTimeMilli;
		lastUpdatedOn = currTimeMilli;
	}

	@PreUpdate
	public void preUpdate() {
		lastUpdatedOn = Instant.now().toEpochMilli();
	}
}
