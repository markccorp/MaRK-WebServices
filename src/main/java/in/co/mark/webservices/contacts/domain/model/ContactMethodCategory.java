package in.co.mark.webservices.contacts.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import in.co.mark.common.domain.model.OwnerSpecificModelBase;

public class ContactMethodCategory extends OwnerSpecificModelBase {
	/**
	 * The <i>primary key</i> of this entity. It will be generated by the DB system
	 * on successful creation of the respective record.
	 */
	private long id;
	private boolean isOwnerOrg;
	private String categoryName;
	private String desc;

	/**
	 * Default constructor
	 */
	public ContactMethodCategory() {

	}

	/**
	 * Initializes {@code ownerId}, {@code categoryName}, and {@code desc}
	 * properties of this instance
	 * 
	 * @param ownerId      ID of the owner - can be a user or an organization
	 * @param categoryName Category name like Phone, Email, URL, etc.
	 * @param desc         Description of this category
	 */
	public ContactMethodCategory(long ownerId, String categoryName, String desc) {
		super(ownerId);
		this.categoryName = categoryName;
		this.desc = desc;
	}

	/**
	 * Initializes {@code ownerId}, {@code isOwnerOrg}, {@code categoryName}, and
	 * {@code desc} properties of this instance
	 * 
	 * @param ownerId      ID of the owner - can be a user or an organization
	 * @param isOwnerOrg   Set to {@code true}, if the owner of this instance
	 *                     represented by {@code ownerId} is an organization;
	 *                     otherwise, {@code false}
	 * @param categoryName Category name like Phone, Email, URL, etc.
	 * @param desc         Description of this category
	 */
	public ContactMethodCategory(long ownerId, boolean isOwnerOrg, String categoryName, String desc) {
		super(ownerId);
		this.isOwnerOrg = isOwnerOrg;
		this.categoryName = categoryName;
		this.desc = desc;
	}

	/**
	 * Initializes all properties of this instance
	 * 
	 * @param id            DB ID of this instance
	 * @param ownerId       ID of the owner - can be a user or an organization
	 * @param isOwnerOrg    Set to {@code true}, if the owner of this instance
	 *                      represented by {@code ownerId} is an organization;
	 *                      otherwise, {@code false}
	 * @param categoryName  Category name like Phone, Email, URL, etc.
	 * @param desc          Description of this category
	 * @param createdOn     A timestamp indicating when the respective DB record was
	 *                      created
	 * @param lastUpdatedOn A timestamp indicating when the respective DB record was
	 *                      last updated
	 */
	public ContactMethodCategory(long id, long ownerId, boolean isOwnerOrg, String categoryName, String desc,
			long createdOn, long lastUpdatedOn) {
		super(ownerId, createdOn, lastUpdatedOn);
		this.id = id;
		this.isOwnerOrg = isOwnerOrg;
		this.categoryName = categoryName;
		this.desc = desc;
	}

	/**
	 * To get the ID of this instance
	 * 
	 * @return {@code id} of this instance
	 */
	public long getId() {
		return id;
	}

	/**
	 * To set the ID of this instance.
	 * <p>
	 * The {@code id} being <i>primary key</i> of entities, it should, ideally, be
	 * set by the DB system on successful creation of the respective record.
	 * </p>
	 * 
	 * @param id ID of this instance
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * To check if the owner of this instance represented by {@code ownerId} is an
	 * organization or not.
	 * 
	 * @return {@code true}, if the owner of this instance represented by
	 *         {@code ownerId} is an organization; otherwise, {@code false}
	 */
	@JsonProperty(value = "isOwnerOrg")
	public boolean isOwnerOrg() {
		return isOwnerOrg;
	}

	/**
	 * To set a {@code boolean} indicating whether the owner of this instance
	 * represented by {@code ownerId} is an organization or not.
	 * 
	 * @param isOwnerOrg Set to {@code true}, if the owner of this instance
	 *                   represented by {@code ownerId} is an organization;
	 *                   otherwise, {@code false}
	 */
	public void setOwnerOrg(boolean isOwnerOrg) {
		this.isOwnerOrg = isOwnerOrg;
	}

	/**
	 * To get the name of this contact method category
	 * 
	 * @return {@code categoryName} value
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * To set an name to this contact method category
	 * 
	 * @param categoryName A contact method category name
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * To get the description of this contact method category
	 * 
	 * @return {@code desc} value
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * To set the description of this contact method category
	 * 
	 * @param desc Description of this contact method category
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
