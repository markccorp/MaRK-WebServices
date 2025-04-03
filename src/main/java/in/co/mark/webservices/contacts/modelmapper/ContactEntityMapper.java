package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.Contact;
import in.co.mark.webservices.contacts.persistence.entities.ContactEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class ContactEntityMapper implements ModelEntityMapper<Contact, ContactEObj> {
	@Override
	public Contact mapToModel(ContactEObj entity) {
		Contact model = new Contact(entity.getId(), entity.getOwnerId(), entity.isOwnerOrg(), entity.getNamePrefixId(),
				entity.getInitial(), entity.getFirstName(), entity.getMiddleName(), entity.getLastName(),
				entity.getNickName(), entity.getNameSuffixId(), entity.getGender(), entity.getDobDate(),
				entity.getDobMonth(), entity.getDobYear(), entity.getAvatarUri(), entity.getMaritalStatusId(),
				entity.getMarriageDate(), entity.getMarriageMonth(), entity.getMarriageYear(),
				entity.getSpouseContactId(), entity.getSpouseName(), entity.isFav(), entity.getCreatedOn(),
				entity.getLastUpdatedOn());
		return model;
	}

	@Override
	public ContactEObj mapToEntity(Contact model) {
		ContactEObj entity = new ContactEObj(model.getId(), model.isOwnerOrg(), model.getNamePrefixId(),
				model.getInitial(), model.getFirstName(), model.getMiddleName(), model.getLastName(),
				model.getNickName(), model.getNameSuffixId(), model.getGender(), model.getDobDate(),
				model.getDobMonth(), model.getDobYear(), model.getAvatarUri(), model.getMaritalStatusId(),
				model.getMarriageDate(), model.getMarriageMonth(), model.getMarriageYear(), model.getSpouseContactId(),
				model.getSpouseName(), model.isFav());
		entity.updateUserIdAndTimestamp(model);
		return entity;
	}
}
