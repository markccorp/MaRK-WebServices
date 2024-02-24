package in.co.mark.webservices.iam.gateway.dto;

import java.util.Objects;

public record CreateUserRequest(String email, String displayName) {
	public CreateUserRequest {
		Objects.requireNonNull(email);
	}
}
