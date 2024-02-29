package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.Contact;
import in.co.mark.webservices.contacts.persistence.entities.ContactEObj;

@Component
public class ContactEntityMapper implements ModelEntityMapper<Contact, ContactEObj> {
	@Override
	public Contact mapToModel(ContactEObj contactEObj) {
		return new Contact(contactEObj.getId(), contactEObj.getNamePrefixId(), contactEObj.getInitial(),
				contactEObj.getFirstName(), contactEObj.getMiddleName(), contactEObj.getLastName(),
				contactEObj.getNickName(), contactEObj.getNameSuffixId(), contactEObj.getGender(),
				contactEObj.getDobDate(), contactEObj.getDobMonth(), contactEObj.getDobYear(),
				contactEObj.getAvatarUri(), contactEObj.getMaritalStatusId(), contactEObj.getMarriageDate(),
				contactEObj.getMarriageMonth(), contactEObj.getMarriageYear(), contactEObj.getSpouseContactId(),
				contactEObj.getSpouseName(), contactEObj.isFav(), contactEObj.getCreatedOn(),
				contactEObj.getLastUpdatedOn());
	}

	@Override
	public ContactEObj mapToEntity(Contact contact) {
		return new ContactEObj(contact.getId(), contact.getNamePrefixId(), contact.getInitial(), contact.getFirstName(),
				contact.getMiddleName(), contact.getLastName(), contact.getNickName(), contact.getNameSuffixId(),
				contact.getGender(), contact.getDobDate(), contact.getDobMonth(), contact.getDobYear(),
				contact.getAvatarUri(), contact.getMaritalStatusId(), contact.getMarriageDate(),
				contact.getMarriageMonth(), contact.getMarriageYear(), contact.getSpouseContactId(),
				contact.getSpouseName(), contact.isFav(), contact.getCreatedOn(), contact.getLastUpdatedOn());
	}
}
