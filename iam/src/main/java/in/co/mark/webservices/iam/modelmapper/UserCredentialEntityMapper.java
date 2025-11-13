package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.iam.domain.model.UserCredential;
import in.co.mark.webservices.iam.persistence.entities.UserCredentialEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class UserCredentialEntityMapper implements ModelEntityMapper<UserCredential, UserCredentialEObj> {

	@Override
	public UserCredential mapToModel(UserCredentialEObj entity) {
		return new UserCredential(entity.getId(), entity.getPassword(), entity.getStatus(), entity.getCreatedOn(),
				entity.getLastUpdatedOn());
	}

	@Override
	public UserCredentialEObj mapToEntity(UserCredential model) {
		UserCredentialEObj entity = new UserCredentialEObj(model.getId(), model.getPassword(), model.getStatus(), null);
		// Set the created and updated time-stamps explicitly, as UserCredential doesn't
		// extend ModelBase.
		entity.setCreatedOn(model.getCreatedOn());
		entity.setLastUpdatedOn(model.getLastUpdatedOn());
		return entity;
	}
}
