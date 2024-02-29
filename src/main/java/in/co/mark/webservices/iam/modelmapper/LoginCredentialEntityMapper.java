package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.iam.domain.model.LoginCredential;
import in.co.mark.webservices.iam.persistence.entities.LoginCredentialEObj;

@Component
public class LoginCredentialEntityMapper implements ModelEntityMapper<LoginCredential, LoginCredentialEObj> {

	@Override
	public LoginCredential mapToModel(LoginCredentialEObj entity) {
		return new LoginCredential(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getCreatedOn(),
				entity.getLastUpdatedOn());
	}

	@Override
	public LoginCredentialEObj mapToEntity(LoginCredential model) {
		return new LoginCredentialEObj(model.getId(),

				model.getUsername(), model.getPassword(), model.getCreatedOn(), model.getLastUpdatedOn());
	}
}
