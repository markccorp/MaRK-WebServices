package in.co.mark.webservices.contacts.gateway.dto;

import java.util.Objects;

public record CreateContactResponse(long id, String firstName, String middleName, String lastName, boolean isFav,
		long createdOn, long lastUpdatedOn) {
	/**
	 * Initializes the properties of this class with the given parameter values.
	 * Following parameters must have valid values:
	 * <ul>
	 * <li>{@code id}</li>
	 * <li>Either {@code firstName} or {@code lastName}
	 * <li>{@code createdOn}</li>
	 * </ul>
	 * 
	 * @param id            System assigned ID for the newly created contact
	 * @param firstName     First name of the contact
	 * @param middleName    Middle name of the contact
	 * @param lastName      Last name of the contact
	 * @param avatartUri    URI of the avatar of the contact
	 * @param isFav         A {@code boolean} indicating if the contact is marked as
	 *                      favorite or not
	 * @param createdOn     A timestamp indicating when the contact was created
	 * @param lastUpdatedOn A timestamp indicating when the contact was last updated
	 */
	public CreateContactResponse {
		Objects.requireNonNull(id);
		Objects.requireNonNull(createdOn);
		if (firstName == null && lastName == null) {
			throw new NullPointerException("Either first name or last name must have a valid value");
		}
	}
}
