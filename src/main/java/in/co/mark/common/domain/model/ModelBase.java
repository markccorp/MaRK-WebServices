package in.co.mark.common.domain.model;

/**
 * A base model class with properties and the respective getter/setter methods
 * to store <i>created</i> and <i>last updated</i> time. Other model classes can
 * extend it to avoid redefining these common properties/methods.
 * 
 * @author Rakesh Kumar
 */
public abstract class ModelBase {
	protected long createdOn;
	protected long lastUpdatedOn;

	/**
	 * Default constructor
	 */
	public ModelBase() {

	}

	/**
	 * Initializes all properties of this instance
	 * 
	 * @param createdOn     A timestamp indicating when the respective DB record was
	 *                      created
	 * @param lastUpdatedOn A timestamp indicating when the respective DB record was
	 *                      last updated
	 */
	protected ModelBase(long createdOn, long lastUpdatedOn) {
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
