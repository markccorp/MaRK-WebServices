package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.ContactMethodCategory;
import in.co.mark.webservices.contacts.persistence.entities.ContactMethodCategoryEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class ContactMethodCategoryEntityMapper
		implements ModelEntityMapper<ContactMethodCategory, ContactMethodCategoryEObj> {

	@Override
	public ContactMethodCategory mapToModel(ContactMethodCategoryEObj entity) {
		ContactMethodCategory model = new ContactMethodCategory(entity.getId(), entity.getOwnerId(),
				entity.isOwnerOrg(), entity.getCategoryName(), entity.getDesc(), entity.getCreatedOn(),
				entity.getLastUpdatedOn());
		return model;
	}

	@Override
	public ContactMethodCategoryEObj mapToEntity(ContactMethodCategory model) {
		ContactMethodCategoryEObj entity = new ContactMethodCategoryEObj(model.getId(), model.isOwnerOrg(),
				model.getCategoryName(), model.getDesc());
		entity.updateUserIdAndTimestamp(model);
		return entity;
	}

}
