package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.EmailType;
import in.co.mark.webservices.contacts.persistence.entities.EmailTypeEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class EmailTypeEntityMapper implements ModelEntityMapper<EmailType, EmailTypeEObj> {
	@Override
	public EmailType mapToModel(EmailTypeEObj entity) {
		EmailType model = new EmailType(entity.getId(), entity.getOwnerId(), entity.isOwnerOrg(), entity.getEmailType(),
				entity.getDesc(), entity.getCreatedOn(), entity.getLastUpdatedOn());
		return model;
	}

	@Override
	public EmailTypeEObj mapToEntity(EmailType model) {
		EmailTypeEObj entity = new EmailTypeEObj(model.getId(), model.isOwnerOrg(), model.getEmailType(),
				model.getDesc());
		entity.updateUserIdAndTimestamp(model);
		return entity;
	}
}
