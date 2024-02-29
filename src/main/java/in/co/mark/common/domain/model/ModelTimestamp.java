package in.co.mark.common.domain.model;

/**
 * A model base class with {@code createdOn} and {@code lastUpdatedOn}
 * properties and their respective getter/setter methods. Other model classes
 * can extend it to avoid re-defining these common properties/methods.
 * 
 * @author Rakesh Kumar
 */
public class ModelTimestamp {
	protected long createdOn;
	protected long lastUpdatedOn;

	/**
	 * Default constructor
	 */
	public ModelTimestamp() {

	}

	/**
	 * Initializes all properties of this instance
	 * 
	 * @param createdOn     A timestamp indicating when the respective DB record was
	 *                      created
	 * @param lastUpdatedOn A timestamp indicating when the respective DB record was
	 *                      last updated
	 */
	protected ModelTimestamp(long createdOn, long lastUpdatedOn) {
		this.createdOn = createdOn;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	/**
	 * To get a timestamp indicating when the respective record was created in DB
	 * 
	 * @return value of {@code createdOn} property
	 */
	public long getCreatedOn() {
		return createdOn;
	}

	/**
	 * To set a timestamp indicating when the respective record being created in DB
	 * 
	 * @param createdOn A timestamp indicating when the respective record being
	 *                  created in DB
	 */
	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * To get a timestamp indicating when the respective record was last updated in
	 * DB
	 * 
	 * @return value of {@code lastUpdatedOn} property
	 */
	public long getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	/**
	 * To set a timestamp indicating when the respective record being last updated
	 * in DB
	 * 
	 * @param lastUpdatedOn A timestamp indicating when the respective record being
	 *                      last updated in DB
	 */
	public void setLastUpdatedOn(long lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
}
