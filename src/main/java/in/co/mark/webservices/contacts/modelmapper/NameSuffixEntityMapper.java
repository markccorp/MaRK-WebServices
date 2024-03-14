package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.NameSuffix;
import in.co.mark.webservices.contacts.persistence.entities.NameSuffixEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class NameSuffixEntityMapper implements ModelEntityMapper<NameSuffix, NameSuffixEObj> {

	@Override
	public NameSuffix mapToModel(NameSuffixEObj entity) {
		NameSuffix model = new NameSuffix(entity.getId(), entity.getOwnerId(), entity.isOwnerOrg(),
				entity.getNameSuffix(), entity.getDesc(), entity.getCreatedOn(), entity.getLastUpdatedOn());
		return model;
	}

	@Override
	public NameSuffixEObj mapToEntity(NameSuffix model) {
		NameSuffixEObj entity = new NameSuffixEObj(model.getId(), model.isOwnerOrg(), model.getNameSuffix(),
				model.getDesc());
		entity.updateUserIdAndTimestamp(model);
		return entity;
	}
}
