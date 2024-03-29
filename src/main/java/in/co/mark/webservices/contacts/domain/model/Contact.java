package in.co.mark.webservices.contacts.domain.model;

public class Contact {
	/**
	 * The <i>primary key</i> of this entity. It will be generated by the DB system
	 * on successful creation of the respective record.
	 */
	private long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String avatarUri;
	private boolean isFav;
	private long createdOn;
	private long lastUpdatedOn;

	/**
	 * Default constructor
	 */
	public Contact() {
	}

	/**
	 * Constructor with all fields
	 * 
	 * @param id            ID of this contact
	 * @param firstName     First name of this contact
	 * @param middleName    Middle name of this contact
	 * @param lastName      Last name of this contact
	 * @param avatarUri     URI of the avatar of this contact
	 * @param isFav         A boolean indicating if this contact is marked as
	 *                      favorite or not
	 * @param createdOn     A timestamp indicating when this contact was created
	 * @param lastUpdatedOn A timestamp indicating when this contact was last
	 *                      updated
	 */
	public Contact(long id, String firstName, String middleName, String lastName, String avatarUri, boolean isFav,
			long createdOn, long lastUpdatedOn) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.avatarUri = avatarUri;
		this.isFav = isFav;
		this.createdOn = createdOn;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	/**
	 * To get the ID of this contact
	 * 
	 * @return {@code id} of this contact
	 */
	public long getId() {
		return id;
	}

	/**
	 * To set the ID of this contact.
	 * <p>
	 * The {@code id} being <i>primary key</i> of this entity, it should, ideally,
	 * be set by the DB system on successful creation of the respective record.
	 * </p>
	 * 
	 * @param id ID of this contact
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * To get the first name of this contact
	 * 
	 * @return {@code firstName} of this contact
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * To set the first name of this contact
	 * 
	 * @param firstName First name of this contact
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * To get the middle name of this contact
	 * 
	 * @return {@code middleName} of this contact
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * To set the middle name of this contact
	 * 
	 * @param middleName Middle name of this contact
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * To get the last name of this contact
	 * 
	 * @return {@code lastName} of this contact
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * To set the last name of this contact
	 * 
	 * @param lastName Last name of this contact
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * To get the URI of the avatar of this contact
	 * 
	 * @return {@code avatarUri} of this contact
	 */
	public String getAvatarUri() {
		return avatarUri;
	}

	/**
	 * To set the URI of the avatar of this contact
	 * 
	 * @param avatarUri URI of the avatar of this contact
	 */
	public void setAvatarUri(String avatarUri) {
		this.avatarUri = avatarUri;
	}

	/**
	 * To check if this contact is marked as a favorite contact ({@code true}) or
	 * not ({@code false})
	 * 
	 * @return value of {@code isFav} property of this contact
	 */
	public boolean isFav() {
		return isFav;
	}

	/**
	 * To mark or unmark this contact as favorite by setting {@code isFav} value
	 * 
	 * @param isFav Set to {@code true} to mark this contact as favorite; otherwise,
	 *              set to {@code false}
	 */
	public void setFav(boolean isFav) {
		this.isFav = isFav;
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
