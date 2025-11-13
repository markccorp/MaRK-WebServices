package in.co.mark.webservices.iam.domain.model;

import in.co.mark.webservices.iam.util.OrgUserRole;
import in.co.mark.webservices.iam.util.OrgUserStatus;

/**
 * Represents a <i>mapping</i> between {@link User} and {@link Organization}.
 * 
 * @author Rakesh Kumar
 */
public class OrgUser extends User {
	protected long orgId;
	protected OrgUserRole orgUserRole;
	protected OrgUserStatus orgUserStatus;
	protected long orgUserCreatedOn;
	protected long orgUserLastUpdatedOn;

	/** The default constructor of this class. */
	public OrgUser() {

	}

	/**
	 * Initializes user ID - the {@code id} property of the parent class
	 * {@link User} and {@code orgId}, {@code orgUserRole}, and
	 * {@code orgUserStatus} properties of this class.
	 * 
	 * @param orgId         ID of the Org this user is associated to
	 * @param userId        ID of this user
	 * @param orgUserRole   Role of this user in the Org
	 * @param orgUserStatus Status of this user in the Org
	 */
	public OrgUser(long orgId, long userId, OrgUserRole orgUserRole, OrgUserStatus orgUserStatus) {
		this.orgId = orgId;
		this.id = userId;
		this.orgUserRole = orgUserRole;
		this.orgUserStatus = orgUserStatus;
	}

	/**
	 * Initializes user ID - the {@code id} property of the parent class
	 * {@link User} and all properties of this class.
	 * 
	 * @param orgId                ID of the Org this user is associated to
	 * @param userId               ID of this user
	 * @param orgUserRole          Role of this user in the Org
	 * @param orgUserStatus        Status of this user in the Org
	 * @param orgUserCreatedOn     A timestamp indicating when this user got added
	 *                             to this Org
	 * @param orgUserLastUpdatedOn A timestamp indicating when this org-user
	 *                             association was last updated
	 */
	public OrgUser(long orgId, long userId, OrgUserRole orgUserRole, OrgUserStatus orgUserStatus, long orgUserCreatedOn,
			long orgUserLastUpdatedOn) {
		this.orgId = orgId;
		this.id = userId;
		this.orgUserRole = orgUserRole;
		this.orgUserStatus = orgUserStatus;
		this.orgUserCreatedOn = orgUserCreatedOn;
		this.orgUserLastUpdatedOn = orgUserLastUpdatedOn;
	}

	/**
	 * Initializes {@code orgId} property of this class and {@code email},
	 * {@code firstName}, and {@code lastName} properties of the parent class
	 * {@link User}.
	 * 
	 * @param orgId     ID of the Org this user is associated to
	 * @param email     The primary email address of this user
	 * @param firstName First name of this user
	 * @param lastName  Last name of this user
	 */
	public OrgUser(long orgId, String email, String firstName, String lastName) {
		super(email, firstName, lastName);
		this.orgId = orgId;
	}

	/**
	 * Initializes {@code orgId}, userId ({@code userId}), {@code username},
	 * {@code email}, {@code initial} , {@code firstName}, {@code middleName},
	 * {@code lastName}, {@code displayName}, {@code gender}, {@code dobDate},
	 * {@code dobMonth}, {@code dobYear}, {@code avatarUri}, {@code orgUserRole},
	 * and {@code orgUserStatus} properties of this instance.
	 * 
	 * @param orgId                ID of the Org this user is associated to
	 * @param userId               ID of this user
	 * 
	 * 
	 * @param username             Login username of this user. When {@code null},
	 *                             the {@code email} value will be used.
	 * @param email                The primary email address of this user
	 * @param initial              Initial of this user
	 * @param firstName            First name of this user
	 * @param middleName           Middle name of this user
	 * @param lastName             Last name of this user
	 * @param displayName          Display name or nick name of this user
	 * @param gender               Gender of this user (<b>M</b> - Male, <b>F</b> -
	 *                             Female, <b>O</b> - Other, or <b>U</b> - Unknown)
	 * @param dobDate              <i>Date</i> part of the date-of-birth of this
	 *                             user
	 * @param dobMonth             <i>Month</i> part of the date-of-birth of this
	 *                             user
	 * @param dobYear              <i>Year</i> part of the date-of-birth of this
	 *                             user
	 * @param avatarUri            URI of avatar image of this user
	 * @param userCreatedOn        A timestamp indicating when the user was created
	 * @param userLastUpdatedOn    A timestamp indicating when the user was last
	 *                             updated
	 * @param orgUserRole          Role of this user in the Org
	 * @param orgUserStatus        Status of this user in the Org
	 * @param orgUserCreatedOn     A timestamp indicating when this user got added
	 *                             to this Org
	 * @param orgUserLastUpdatedOn A timestamp indicating when this org-user
	 *                             association was last updated
	 */
	public OrgUser(long orgId, long userId, String username, String email, String initial, String firstName,
			String middleName, String lastName, String displayName, char gender, int dobDate, int dobMonth, int dobYear,
			String avatarUri, OrgUserRole orgUserRole, OrgUserStatus orgUserStatus) {
		super(username, email, initial, firstName, middleName, lastName, displayName, gender, dobDate, dobMonth,
				dobYear, avatarUri);
		this.orgId = orgId;
		this.id = userId;
		this.orgUserRole = orgUserRole;
		this.orgUserStatus = orgUserStatus;
	}

	/**
	 * Initializes all properties, including the inherited ones, of this class.
	 * 
	 * @param orgId                ID of the Org this user is associated to
	 * @param userId               ID of this user
	 * 
	 * 
	 * @param username             Login username of this user. When {@code null},
	 *                             the {@code email} value will be used.
	 * @param email                The primary email address of this user
	 * @param initial              Initial of this user
	 * @param firstName            First name of this user
	 * @param middleName           Middle name of this user
	 * @param lastName             Last name of this user
	 * @param displayName          Display name or nick name of this user
	 * @param gender               Gender of this user (<b>M</b> - Male, <b>F</b> -
	 *                             Female, <b>O</b> - Other, or <b>U</b> - Unknown)
	 * @param dobDate              <i>Date</i> part of the date-of-birth of this
	 *                             user
	 * @param dobMonth             <i>Month</i> part of the date-of-birth of this
	 *                             user
	 * @param dobYear              <i>Year</i> part of the date-of-birth of this
	 *                             user
	 * @param avatarUri            URI of avatar image of this user
	 * @param userCreatedOn        A timestamp indicating when the user was created
	 * @param userLastUpdatedOn    A timestamp indicating when the user was last
	 *                             updated
	 * @param orgUserRole          Role of this user in the Org
	 * @param orgUserStatus        Status of this user in the Org
	 * @param orgUserCreatedOn     A timestamp indicating when this user got added
	 *                             to this Org
	 * @param orgUserLastUpdatedOn A timestamp indicating when this org-user
	 *                             association was last updated
	 */
	public OrgUser(long orgId, long userId, String username, String email, String initial, String firstName,
			String middleName, String lastName, String displayName, char gender, int dobDate, int dobMonth, int dobYear,
			String avatarUri, long userCreatedOn, long userLastUpdatedOn, OrgUserRole orgUserRole,
			OrgUserStatus orgUserStatus, long orgUserCreatedOn, long orgUserLastUpdatedOn) {
		super(userId, email, username, initial, firstName, middleName, lastName, displayName, gender, dobDate, dobMonth,
				dobYear, avatarUri, userCreatedOn, userLastUpdatedOn);
		this.orgId = orgId;
		this.orgUserRole = orgUserRole;
		this.orgUserStatus = orgUserStatus;
		this.orgUserCreatedOn = orgUserCreatedOn;
		this.orgUserLastUpdatedOn = orgUserLastUpdatedOn;
	}

	public long getOrgId() {
		return orgId;
	}

	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}

	public long getUserId() {
		return id;
	}

	public void setUserId(long userId) {
		this.id = userId;
	}

	public OrgUserRole getOrgUserRole() {
		return orgUserRole;
	}

	public void setOrgUserRole(OrgUserRole orgUserRole) {
		this.orgUserRole = orgUserRole;
	}

	public OrgUserStatus getOrgUserStatus() {
		return orgUserStatus;
	}

	public void setOrgUserStatus(OrgUserStatus orgUserStatus) {
		this.orgUserStatus = orgUserStatus;
	}

	public long getOrgUserCreatedOn() {
		return orgUserCreatedOn;
	}

	public void setOrgUserCreatedOn(long orgUserCreatedOn) {
		this.orgUserCreatedOn = orgUserCreatedOn;
	}

	public long getOrgUserLastUpdatedOn() {
		return orgUserLastUpdatedOn;
	}

	public void setOrgUserLastUpdatedOn(long orgUserLastUpdatedOn) {
		this.orgUserLastUpdatedOn = orgUserLastUpdatedOn;
	}
}
