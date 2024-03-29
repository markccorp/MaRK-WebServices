package in.co.mark.webservices.contacts.domain.model;

public class Address {
	/**
	 * The <i>primary key</i> of this entity. It will be generated by the DB system
	 * on successful creation of the respective record.
	 */
	private long id;
	private String addressLineOne;
	private String addressLineTwo;
	private String locality;
	private String city;
	private String state;
	private long countryCode;
	private String postalCode;
	private long createdOn;
	private long lastUpdatedOn;

	/**
	 * Default constructor
	 */
	public Address() {
	}

	/**
	 * Constructor with all fields
	 * 
	 * @param id             ID of this address
	 * @param addressLineOne First line of this address
	 * @param addressLineTwo Second line of this address
	 * @param locality       Locality of this address
	 * @param city           City of this address
	 * @param state          State of this address
	 * @param countryCode    Country code of this address
	 * @param postalCode     Postal code of this address
	 * @param createdOn      A timestamp indicating when this address was created
	 * @param lastUpdatedOn  A timestamp indicating when this address was last
	 *                       updated
	 */
	public Address(long id, String addressLineOne, String addressLineTwo, String locality, String city, String state,
			long countryCode, String postalCode, long createdOn, long lastUpdatedOn) {
		super();
		this.id = id;
		this.addressLineOne = addressLineOne;
		this.addressLineTwo = addressLineTwo;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.countryCode = countryCode;
		this.postalCode = postalCode;
		this.createdOn = createdOn;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(long countryCode) {
		this.countryCode = countryCode;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
