package in.co.mark.webservices.iam.gateway.dto;

import java.util.Objects;

public record CreateUserResponse(long id, String email, String displayName, String avatarUri, long createdOn,
		long lastUpdatedOn) {
	public CreateUserResponse {
		Objects.requireNonNull(id);
		Objects.requireNonNull(email);
		Objects.requireNonNull(createdOn);
	}
}
