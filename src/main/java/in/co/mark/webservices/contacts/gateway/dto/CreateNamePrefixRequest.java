package in.co.mark.webservices.contacts.gateway.dto;

import java.util.Objects;

public record CreateNamePrefixRequest(long ownerUserId, String namePrefix, String desc) {
	public CreateNamePrefixRequest {
		Objects.requireNonNull(ownerUserId);
		Objects.requireNonNull(namePrefix);
	}
}
