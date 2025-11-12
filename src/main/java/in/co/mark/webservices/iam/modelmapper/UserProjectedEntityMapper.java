package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.exceptions.NotImplementedException;
import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.persistence.entities.projections.UserSummary;
import lombok.experimental.ExtensionMethod;

/**
 * @author Rakesh Kumar
 */
@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class UserProjectedEntityMapper implements ModelEntityMapper<User, UserSummary> {
	@Override
	public User mapToModel(UserSummary entity) {
		User user = new User();
		user.setId(entity.getId());
		user.setUsername(entity.getUsername());
		user.setEmail(entity.getEmail());
		user.setFirstName(entity.getFirstName());
		user.setLastName(entity.getLastName());
		user.setDisplayName(entity.getDisplayName());
		user.setAvatarUri(entity.getAvatarUri());
		return user;
	}

	@Override
	public UserSummary mapToEntity(User model) {
		throw new NotImplementedException();
	}
}
