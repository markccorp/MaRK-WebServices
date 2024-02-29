package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;

@Component
public class UserEntityMapper implements ModelEntityMapper<User, UserEObj> {

	@Override
	public User mapToModel(UserEObj userEObj) {
		return new User(userEObj.getId(), userEObj.getEmail(), userEObj.getFirstName(), userEObj.getMiddleName(),
				userEObj.getLastName(), userEObj.getCreatedOn(), userEObj.getLastUpdatedOn());
	}

	@Override
	public UserEObj mapToEntity(User user) {
		return new UserEObj(user.getId(), user.getInitial(), user.getFirstName(), user.getMiddleName(),
				user.getLastName(), user.getDisplayName(), user.getGender(), user.getDobDate(), user.getDobMonth(),
				user.getDobYear(), user.getEmail(), user.getAvatarUri(), user.getCreatedOn(), user.getLastUpdatedOn());
	}
}
