package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.ContactIdentifier;
import in.co.mark.webservices.contacts.persistence.entities.ContactIdentifierEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class ContactIdentifierEntityMapper implements ModelEntityMapper<ContactIdentifier, ContactIdentifierEObj> {

	@Override
	public ContactIdentifier mapToModel(ContactIdentifierEObj entity) {
		ContactIdentifier model = new ContactIdentifier(entity.getId(), entity.getContactId(), entity.getOwnerId(),
				entity.getIdentifierTypeId(), entity.getIdentifierValue(), entity.getDesc(), entity.getIssueLocation(),
				entity.getIssueDate(), entity.getExpiryDate(), entity.getStatus(), entity.getCreatedOn(),
				entity.getLastUpdatedOn());
		return model;
	}

	@Override
	public ContactIdentifierEObj mapToEntity(ContactIdentifier model) {
		ContactIdentifierEObj entity = new ContactIdentifierEObj(model.getId(), model.getContactId(),
				model.getIdentifierTypeId(), model.getIdentifierValue(), model.getDesc(), model.getIssueLocation(),
				model.getIssueDate(), model.getExpiryDate(), model.getStatus());
		entity.updateUserIdAndTimestamp(model);
		return entity;
	}

}
