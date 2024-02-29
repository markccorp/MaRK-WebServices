package in.co.mark.webservices.iam.gateway.dto;

import java.util.Objects;

import org.springframework.util.StringUtils;

public record CreateUserRequest(String username, String password, String firstName, String middleName,
		String lastName) {
	public CreateUserRequest {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		if (!(StringUtils.hasText(firstName) || StringUtils.hasText(lastName))) {
			throw new NullPointerException("Either first name or last name must have a valid value");
		}
	}
}
