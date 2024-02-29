package in.co.mark.webservices.contacts.domain.model;

import in.co.mark.common.domain.model.UserSpecificModel;

public class NameSuffix extends UserSpecificModel {
	/**
	 * The <i>primary key</i> of this entity. It will be generated by the DB system
	 * on successful creation of the respective record.
	 */
	private int id;
	private String nameSuffix;
	private String desc;

	/**
	 * Initializes {@code ownerUserId}, {@code nameSuffix}, and {@code desc}
	 * properties of this instance
	 * 
	 * @param ownerUserId ID of the owner user
	 * @param nameSuffix  Name suffix value of this instance
	 * @param desc        Description of this name suffix
	 */
	public NameSuffix(long ownerUserId, String nameSuffix, String desc) {
		super(ownerUserId);
		this.nameSuffix = nameSuffix;
		this.desc = desc;
	}

	/**
	 * Initializes all properties of this instance
	 * 
	 * @param id            DB ID of this instance
	 * @param ownerUserId   ID of the owner user
	 * @param nameSuffix    Name suffix value of this instance
	 * @param desc          Description of this name suffix
	 * @param createdOn     A timestamp indicating when the respective DB record was
	 *                      created
	 * @param lastUpdatedOn A timestamp indicating when the respective DB record was
	 *                      last updated
	 */
	public NameSuffix(int id, long ownerUserId, String nameSuffix, String desc, long createdOn, long lastUpdatedOn) {
		super(ownerUserId, createdOn, lastUpdatedOn);
		this.id = id;
		this.nameSuffix = nameSuffix;
		this.desc = desc;
	}

	/**
	 * To get the ID of this instance
	 * 
	 * @return {@code id} of this instance
	 */
	public int getId() {
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
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * To get the name suffix value
	 * 
	 * @return {@code nameSuffix} value
	 */
	public String getNameSuffix() {
		return nameSuffix;
	}

	/**
	 * To set a name suffix value
	 * 
	 * @param nameSuffix A name suffix value
	 */
	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	/**
	 * To get the description of this name suffix
	 * 
	 * @return {@code desc} value
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * To set the description of this name suffix
	 * 
	 * @param desc Description of this name suffix
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
