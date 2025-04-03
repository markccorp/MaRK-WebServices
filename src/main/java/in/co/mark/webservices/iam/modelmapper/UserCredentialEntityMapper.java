package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.iam.domain.model.UserCredential;
import in.co.mark.webservices.iam.persistence.entities.UserCredentialEObj;

@Component
public class UserCredentialEntityMapper implements ModelEntityMapper<UserCredential, UserCredentialEObj> {

	@Override
	public UserCredential mapToModel(UserCredentialEObj entity) {
		return new UserCredential(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getCreatedOn(),
				entity.getLastUpdatedOn());
	}

	@Override
	public UserCredentialEObj mapToEntity(UserCredential model) {
		return new UserCredentialEObj(model.getId(), model.getUsername(), model.getPassword(), model.getCreatedOn(),
				model.getLastUpdatedOn(), null);
	}
}
