package in.co.mark.webservices.iam.gateway.dto;

import java.util.Objects;

import org.springframework.util.StringUtils;

public record CreateUserResponse(long id, String username, String firstName, String middleName, String lastName,
		long createdOn, long lastUpdatedOn) {
	public CreateUserResponse {
		Objects.requireNonNull(id);
		Objects.requireNonNull(username);
		if (!(StringUtils.hasText(firstName) || StringUtils.hasText(lastName))) {
			throw new NullPointerException("Either first name or last name must have a valid value");
		}
		Objects.requireNonNull(createdOn);
	}
}
