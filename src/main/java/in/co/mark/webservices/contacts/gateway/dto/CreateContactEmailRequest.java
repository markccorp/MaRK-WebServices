package in.co.mark.webservices.contacts.gateway.dto;

import java.util.Objects;

import org.springframework.util.StringUtils;

public record CreateContactEmailRequest(long ownerUserId, long emailTypeId, String emailType, String emailAddress) {
	public CreateContactEmailRequest {
		Objects.requireNonNull(ownerUserId);
		if (emailTypeId == 0L && !StringUtils.hasText(emailType)) {
			throw new NullPointerException("Either email type ID or email type must have a valid value");
		}
	}
}
