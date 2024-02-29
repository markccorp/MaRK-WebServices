package in.co.mark.webservices.contacts.gateway.dto;

import java.util.Objects;

public record CreateNameSuffixResponse(long id, long ownerUserId, String nameSuffix, String desc, long createdOn,
		long lastUpdatedOn) {
	public CreateNameSuffixResponse {
		Objects.requireNonNull(id);
		Objects.requireNonNull(ownerUserId);
		Objects.requireNonNull(nameSuffix);
		Objects.requireNonNull(createdOn);
		Objects.requireNonNull(lastUpdatedOn);
	}
}
