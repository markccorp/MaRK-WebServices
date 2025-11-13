/**
 * 
 * @author Rakesh Kumar
 */
package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.iam.domain.model.OrgUser;
import in.co.mark.webservices.iam.persistence.entities.OrgUserEObj;
import in.co.mark.webservices.iam.persistence.entities.OrgUserIdentifier;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class OrgUserEntityMapper implements ModelEntityMapper<OrgUser, OrgUserEObj> {
	@Override
	public OrgUser mapToModel(OrgUserEObj entity) {
		OrgUser orgUser = null; // Object to return

		UserEObj userEObj = entity.getUserEObj();
		if (userEObj != null) {
			orgUser = new OrgUser(entity.getOrgId(), entity.getUserId(), userEObj.getUsername(), userEObj.getEmail(),
					userEObj.getInitial(), userEObj.getFirstName(), userEObj.getMiddleName(), userEObj.getLastName(),
					userEObj.getDisplayName(), userEObj.getGender(), userEObj.getDobDate(), userEObj.getDobMonth(),
					userEObj.getDobYear(), userEObj.getAvatarUri(), userEObj.getCreatedOn(),
					userEObj.getLastUpdatedOn(), entity.getOrgUserRole(), entity.getOrgUserStatus(),
					entity.getCreatedOn(), entity.getLastUpdatedOn());
		} else {
			orgUser = new OrgUser(entity.getOrgId(), entity.getUserId(), entity.getOrgUserRole(),
					entity.getOrgUserStatus(), entity.getCreatedOn(), entity.getLastUpdatedOn());
		}

		return orgUser;
	}

	@Override
	public OrgUserEObj mapToEntity(OrgUser model) {
		OrgUserEObj entity = new OrgUserEObj(new OrgUserIdentifier(model.getOrgId(), model.getId()),
				model.getOrgUserRole(), model.getOrgUserStatus(), null, null);
		entity.updateTimestamp(model);
		return entity;
	}
}
