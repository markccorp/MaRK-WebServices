package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.gateway.dto.UserRequestDTO;
import in.co.mark.webservices.iam.gateway.dto.UserResponseDTO;

@Component
public class UserDTOMapper {
	/**
	 * To map a given {@code reqDto} to an equivalent {@link User} object.
	 * 
	 * @param reqDto A request DTO of type {@link CreateUserRequest}
	 * @return A {@link User} object
	 */
	public User mapToUser(UserRequestDTO reqDto) {
		User user = new User(reqDto.getUsername(), reqDto.getEmail(), reqDto.getInitial(), reqDto.getFirstName(),
				reqDto.getMiddleName(), reqDto.getLastName(), reqDto.getDisplayName(), reqDto.getGender(),
				reqDto.getDobDate(), reqDto.getDobMonth(), reqDto.getDobYear(), null);
		if (reqDto.getUserId() > 0) {
			user.setId(reqDto.getUserId());
		}

		return user;
	}

	/**
	 * To map a given {@code user} to an equivalent {@link UserResponseDTO} object.
	 * 
	 * @param user A model object of type {@link User}
	 * @return A {@link UserResponseDTO} object
	 */
	public UserResponseDTO mapToUserResponseDTO(User user) {
		return new UserResponseDTO(user.getId(), user.getEmail(), user.getUsername(), user.getInitial(),
				user.getFirstName(), user.getMiddleName(), user.getLastName(), user.getDisplayName(), user.getGender(),
				user.getDobDate(), user.getDobMonth(), user.getDobYear(), user.getCreatedOn(), user.getLastUpdatedOn());
	}
}
