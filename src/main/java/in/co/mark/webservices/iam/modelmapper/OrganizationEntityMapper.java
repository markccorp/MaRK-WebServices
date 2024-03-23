package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.iam.domain.model.Organization;
import in.co.mark.webservices.iam.persistence.entities.OrganizationEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class OrganizationEntityMapper implements ModelEntityMapper<Organization, OrganizationEObj> {

	@Override
	public Organization mapToModel(OrganizationEObj entity) {
		Organization model = new Organization(entity.getId(), entity.getSuperAdminId(), entity.getOrgName(),
				entity.getDesc(), entity.getParentOrgId(), entity.getStatus(), entity.getCreatedOn(),
				entity.getLastUpdatedOn());
		return model;
	}

	@Override
	public OrganizationEObj mapToEntity(Organization model) {
		OrganizationEObj entity = new OrganizationEObj(model.getId(), model.getSuperAdminId(), model.getOrgName(),
				model.getDesc(), model.getParentOrgId(), model.getStatus());
		entity.updateTimestamp(model);
		return entity;
	}
}
