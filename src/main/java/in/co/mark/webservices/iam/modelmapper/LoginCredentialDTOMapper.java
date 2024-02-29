package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.webservices.iam.domain.model.LoginCredential;
import in.co.mark.webservices.iam.gateway.dto.CreateUserRequest;

@Component
public class LoginCredentialDTOMapper {
	/**
	 * To map the given {@code reqDto} to an equivalent {@link LoginCredential}
	 * model object
	 * 
	 * @param reqDto A request DTO of type {@link CreateUserRequest}
	 * @return A {@link LoginCredential} model object
	 */
	public LoginCredential mapToLoginCredential(CreateUserRequest reqDto) {
		return new LoginCredential(reqDto.username(), reqDto.password());
	}
}
