package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.MaritalStatus;
import in.co.mark.webservices.contacts.persistence.entities.MaritalStatusEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class MaritalStatusEntityMapper implements ModelEntityMapper<MaritalStatus, MaritalStatusEObj> {

	@Override
	public MaritalStatus mapToModel(MaritalStatusEObj entity) {
		MaritalStatus model = new MaritalStatus(entity.getId(), entity.getOwnerId(), entity.isOwnerOrg(),
				entity.getMaritalStatus(), entity.getDesc(), entity.getCreatedOn(), entity.getLastUpdatedOn());
		return model;
	}

	@Override
	public MaritalStatusEObj mapToEntity(MaritalStatus model) {
		MaritalStatusEObj entity = new MaritalStatusEObj(model.getId(), model.isOwnerOrg(), model.getMaritalStatus(),
				model.getDesc());
		entity.updateUserIdAndTimestamp(model);
		return entity;
	}
}
