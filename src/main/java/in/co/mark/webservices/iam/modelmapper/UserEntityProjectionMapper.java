package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityProjectionMapper;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.persistence.entities.projections.UserProjection;
import lombok.experimental.ExtensionMethod;

/**
 * @author Rakesh Kumar
 */
@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class UserEntityProjectionMapper implements ModelEntityProjectionMapper<User, UserEObj, UserProjection> {

	@Override
	public UserEObj mapModelToEntity(User model) {
		UserEObj entity = new UserEObj(model.getId(), model.getEmail(), model.getInitial(), model.getFirstName(),
				model.getMiddleName(), model.getLastName(), model.getDisplayName(), model.getGender(),
				model.getDobDate(), model.getDobMonth(), model.getDobYear(), model.getAvatarUri(), null);
		entity.updateTimestamp(model);
		return entity;
	}

	public User mapEntityProjectionToModel(UserProjection entityPObj) {
		return new User(entityPObj.getId(), entityPObj.getUsername(), entityPObj.getEmail(), entityPObj.getInitial(),
				entityPObj.getFirstName(), entityPObj.getMiddleName(), entityPObj.getLastName(),
				entityPObj.getDisplayName(), entityPObj.getGender(), entityPObj.getDobDate(), entityPObj.getDobMonth(),
				entityPObj.getDobYear(), entityPObj.getAvatarUri(), entityPObj.getCreatedOn(),
				entityPObj.getLastUpdatedOn());
	}
}
