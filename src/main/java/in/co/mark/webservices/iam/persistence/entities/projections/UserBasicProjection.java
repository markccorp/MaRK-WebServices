package in.co.mark.webservices.iam.persistence.entities.projections;

import in.co.mark.webservices.iam.persistence.entities.UserEObj;

/**
 * A projection interface covering the basic properties of {@link UserEObj}
 * class
 * 
 * @author Rakesh Kumar
 */
public interface UserBasicProjection {
	long getId();

	String getUsername();

	String getEmail();

	String getInitial();

	String getFirstName();

	String getMiddleName();

	String getLastName();

	String getDisplayName();

	long getCreatedOn();

	long getLastUpdatedOn();
}
