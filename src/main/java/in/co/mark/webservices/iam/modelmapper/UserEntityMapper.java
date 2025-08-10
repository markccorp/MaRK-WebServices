package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.util.UserUtil;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class UserEntityMapper implements ModelEntityMapper<User, UserEObj> {

	@Override
	public User mapToModel(UserEObj userEObj) {
		return new User(userEObj.getId(), userEObj.getEmail(), null, userEObj.getInitial(), userEObj.getFirstName(),
				userEObj.getMiddleName(), userEObj.getLastName(), userEObj.getDisplayName(),
				UserUtil.SanitizeGenderValue(userEObj.getGender()), userEObj.getDobDate(), userEObj.getDobMonth(),
				userEObj.getDobYear(), userEObj.getAvatarUri(), userEObj.getCreatedOn(), userEObj.getLastUpdatedOn());
	}

	@Override
	public UserEObj mapToEntity(User user) {
		UserEObj entity = new UserEObj(user.getId(), user.getEmail(), user.getInitial(), user.getFirstName(),
				user.getMiddleName(), user.getLastName(), user.getDisplayName(),
				UserUtil.SanitizeGenderValue(user.getGender()), user.getDobDate(), user.getDobMonth(),
				user.getDobYear(), user.getAvatarUri(), null);
		entity.updateTimestamp(user);
		return entity;
	}
}
