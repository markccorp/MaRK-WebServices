package in.co.mark.webservices.iam.persistence.entities.projections;

import in.co.mark.webservices.iam.persistence.entities.UserEObj;

/**
 * A projection interface for the {@link UserEObj} class
 * 
 * @author Rakesh Kumar
 */
public interface UserProjection {
	long getId();

	String getUsername();

	String getEmail();

	String getInitial();

	String getFirstName();

	String getMiddleName();

	String getLastName();

	String getDisplayName();

	char getGender();

	int getDobDate();

	int getDobMonth();

	int getDobYear();

	String getAvatarUri();

	long getCreatedOn();

	long getLastUpdatedOn();
}
