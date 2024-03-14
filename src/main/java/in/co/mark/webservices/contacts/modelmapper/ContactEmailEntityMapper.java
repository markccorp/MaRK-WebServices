package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.ContactEmail;
import in.co.mark.webservices.contacts.persistence.entities.ContactEmailEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class ContactEmailEntityMapper implements ModelEntityMapper<ContactEmail, ContactEmailEObj> {

	@Override
	public ContactEmail mapToModel(ContactEmailEObj entity) {
		ContactEmail model = new ContactEmail(entity.getId(), entity.getOwnerId(), entity.getEmailTypeId(),
				entity.getEmailAddress(), entity.getStatus(), entity.getCreatedOn(), entity.getLastUpdatedOn());
		return model;
	}

	@Override
	public ContactEmailEObj mapToEntity(ContactEmail model) {
		ContactEmailEObj entity = new ContactEmailEObj(model.getId(), model.getEmailTypeId(), model.getEmailAddress(),
				model.getStatus());
		entity.updateUserIdAndTimestamp(model);
		return entity;
	}

}
