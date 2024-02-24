package in.co.mark.webservices.contacts.gateway.dto;

import java.util.Objects;

public record CreateAddressTypeRequest(String type, String desc) {
	public CreateAddressTypeRequest {
		Objects.requireNonNull(type);
	}
}
