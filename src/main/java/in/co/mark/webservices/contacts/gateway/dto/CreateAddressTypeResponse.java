package in.co.mark.webservices.contacts.gateway.dto;

import java.util.Objects;

public record CreateAddressTypeResponse(long id, String type, String desc, long createdOn, long lastUpdatedOn) {
	public CreateAddressTypeResponse {
		Objects.requireNonNull(id);
		Objects.requireNonNull(type);
		Objects.requireNonNull(createdOn);
		Objects.requireNonNull(lastUpdatedOn);
	}
}
