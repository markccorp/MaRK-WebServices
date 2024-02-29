package in.co.mark.webservices.contacts.gateway.dto;

import java.util.Objects;

public record CreateNameSuffixRequest(long ownerUserId, String nameSuffix, String desc) {
	public CreateNameSuffixRequest {
		Objects.requireNonNull(ownerUserId);
		Objects.requireNonNull(nameSuffix);
	}
}
