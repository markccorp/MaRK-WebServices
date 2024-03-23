package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.ContactMethodType;
import in.co.mark.webservices.contacts.persistence.entities.ContactMethodTypeEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class ContactMethodTypeEntityMapper implements ModelEntityMapper<ContactMethodType, ContactMethodTypeEObj> {

	@Override
	public ContactMethodType mapToModel(ContactMethodTypeEObj entity) {
		ContactMethodType model = new ContactMethodType(entity.getId(), entity.getOwnerId(), entity.isOwnerOrg(),
				entity.getContactMethothCategoryId(), entity.getContactMethodType(), entity.getDesc(),
				entity.getCreatedOn(), entity.getLastUpdatedOn());
		return model;
	}

	@Override
	public ContactMethodTypeEObj mapToEntity(ContactMethodType model) {
		ContactMethodTypeEObj entity = new ContactMethodTypeEObj(model.getId(), model.isOwnerOrg(),
				model.getContactMethothCategoryId(), model.getContactMethodType(), model.getDesc());
		entity.updateUserIdAndTimestamp(model);
		return entity;
	}

}
