package in.co.mark.webservices.contacts.gateway.dto;

import java.util.Objects;

public record CreateNamePrefixResponse(long id, long ownerUserId, String namePrefix, String desc, long createdOn,
		long lastUpdatedOn) {
	public CreateNamePrefixResponse {
		Objects.requireNonNull(id);
		Objects.requireNonNull(ownerUserId);
		Objects.requireNonNull(namePrefix);
		Objects.requireNonNull(createdOn);
		Objects.requireNonNull(lastUpdatedOn);
	}
}
