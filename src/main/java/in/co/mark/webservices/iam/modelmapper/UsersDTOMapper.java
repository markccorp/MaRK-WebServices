package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.gateway.dto.CreateUserRequest;
import in.co.mark.webservices.iam.gateway.dto.CreateUserResponse;

@Component
public class UsersDTOMapper {
	/**
	 * To map the given {@code reqDto} to an equivalent {@link User} model object
	 * 
	 * @param reqDto A request DTO of type {@link CreateUserRequest}
	 * @return A {@link User} model object
	 */
	public User mapToUser(CreateUserRequest reqDto) {
		return new User(reqDto.username(), reqDto.firstName(), reqDto.middleName(), reqDto.lastName());
	}

	/**
	 * To map the given {@code user} to an equivalent {@link CreateUserResponse} DTO
	 * object
	 * 
	 * @param user A model object of type {@link User}
	 * @return A {@link CreateUserResponse} DTO object
	 */
	public CreateUserResponse mapToCreateUserResponse(User user) {
		return new CreateUserResponse(user.getId(), user.getEmail(), user.getFirstName(), user.getMiddleName(),
				user.getLastName(), user.getCreatedOn(), user.getLastUpdatedOn());
	}
}
