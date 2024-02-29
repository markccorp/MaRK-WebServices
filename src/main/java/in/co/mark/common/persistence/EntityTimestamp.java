package in.co.mark.common.persistence;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

/**
 * An entity base class with the following properties and their respective
 * getter/setter methods:
 * <ul>
 * <li>{@code createdOn} - DB column name <i>created_on</i></li>
 * <li>{@code lastUpdatedOn} - DB column name <i>last_updated_on</i></li>
 * </ul>
 * Note that this is just a <i>mapped superclass</i>, and not an actual entity.
 * The actual entity classes can extend it to avoid defining the common
 * properties/methods.
 * 
 * @author Rakesh Kumar
 */
@MappedSuperclass
public class EntityTimestamp {
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
	public EntityTimestamp() {

	}

	/**
	 * Initializes all properties of this instance
	 * 
	 * @param createdOn     A timestamp indicating when the respective DB record was
	 *                      created
	 * @param lastUpdatedOn A timestamp indicating when the respective DB record was
	 *                      last updated
	 */
	protected EntityTimestamp(long createdOn, long lastUpdatedOn) {
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
