package in.co.mark.webservices.contacts.gateway.dto;

import java.util.Objects;

import org.springframework.util.StringUtils;

public record CreateContactIdentifierRequest(long ownerUserId, long contactId, long identifierTypeId,
		String identifierType, String identifierValue, String desc, String issueLocation, long issueDate,
		long expiryDate) {
	public CreateContactIdentifierRequest {
		Objects.requireNonNull(ownerUserId);
		if (identifierTypeId == 0L && !StringUtils.hasText(identifierType)) {
			throw new NullPointerException("Either identifier type ID or identifier type must have a valid value");
		}
	}
}
