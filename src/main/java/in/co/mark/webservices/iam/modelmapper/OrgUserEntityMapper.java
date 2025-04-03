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
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class OrgUserEntityMapper implements ModelEntityMapper<OrgUser, OrgUserEObj> {
	@Override
	public OrgUser mapToModel(OrgUserEObj entity) {
		return new OrgUser(entity.getOrgId(), entity.getUserId(), entity.getOrgUserRole(), entity.getOrgUserStatus(),
				entity.getCreatedOn(), entity.getLastUpdatedOn());
	}

	@Override
	public OrgUserEObj mapToEntity(OrgUser model) {
		OrgUserEObj entity = new OrgUserEObj(new OrgUserIdentifier(model.getOrgId(), model.getUserId()), model.getOrgUserRole(),
				model.getOrgUserStatus());
		entity.updateTimestamp(model);
		return entity;
	}
}
