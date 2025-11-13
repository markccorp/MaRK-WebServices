package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.IdentifierType;
import in.co.mark.webservices.contacts.persistence.entities.IdentifierTypeEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class IdentifierTypeEntityMapper implements ModelEntityMapper<IdentifierType, IdentifierTypeEObj> {
	@Override
	public IdentifierType mapToModel(IdentifierTypeEObj entity) {
		IdentifierType model = new IdentifierType(entity.getId(), entity.getOwnerId(), entity.getIdentifierType(),
				entity.getDesc(), entity.getCreatedOn(), entity.getLastUpdatedOn());
		return model;
	}

	@Override
	public IdentifierTypeEObj mapToEntity(IdentifierType model) {
		IdentifierTypeEObj entity = new IdentifierTypeEObj(model.getId(), model.getIdentifierType(), model.getDesc());
		entity.updateUserIdAndTimestamp(model);
		return entity;
	}
}
