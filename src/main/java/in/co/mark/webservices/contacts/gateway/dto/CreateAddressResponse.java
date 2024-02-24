package in.co.mark.webservices.contacts.gateway.dto;

import java.util.Objects;

public record CreateAddressResponse(long id, String addressLineOne, String addressLineTwo, String locality, String city,
		String state, long countryCode, String postalCode, long createdOn, long lastUpdatedOn) {
	public CreateAddressResponse {
		Objects.requireNonNull(id);
		Objects.requireNonNull(createdOn);
		Objects.requireNonNull(lastUpdatedOn);
	}
}
