package in.co.mark.webservices.contacts.gateway.dto;

import java.util.Objects;

import org.springframework.util.StringUtils;

public record CreateContactEmailRequest(long ownerUserId, long typeId, String typeName, String typeCode,
		String emailAddress) {
	public CreateContactEmailRequest {
		Objects.requireNonNull(ownerUserId);
		if (typeId == 0L && !StringUtils.hasText(typeName)) {
			throw new NullPointerException("Either email type ID or email type name must have a valid value");
		}
	}
}
