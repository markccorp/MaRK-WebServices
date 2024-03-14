package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.NamePrefix;
import in.co.mark.webservices.contacts.persistence.entities.NamePrefixEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class NamePrefixEntityMapper implements ModelEntityMapper<NamePrefix, NamePrefixEObj> {

	@Override
	public NamePrefix mapToModel(NamePrefixEObj entity) {
		NamePrefix model = new NamePrefix(entity.getId(), entity.getOwnerId(), entity.isOwnerOrg(),
				entity.getNamePrefix(), entity.getDesc(), entity.getCreatedOn(), entity.getLastUpdatedOn());
		return model;
	}

	@Override
	public NamePrefixEObj mapToEntity(NamePrefix model) {
		NamePrefixEObj entity = new NamePrefixEObj(model.getId(), model.isOwnerOrg(), model.getNamePrefix(),
				model.getDesc());
		entity.updateUserIdAndTimestamp(model);
		return entity;
	}
}
