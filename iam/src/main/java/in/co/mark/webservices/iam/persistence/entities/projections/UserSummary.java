package in.co.mark.webservices.iam.persistence.entities.projections;

import in.co.mark.webservices.iam.persistence.entities.UserEObj;

/**
 * A projection interface for summary of {@link UserEObj}.
 * 
 * @author Rakesh Kumar
 */
public interface UserSummary {
	long getId();

	String getUsername();

	String getEmail();

	String getFirstName();

	String getLastName();

	String getDisplayName();

	String getAvatarUri();
}
