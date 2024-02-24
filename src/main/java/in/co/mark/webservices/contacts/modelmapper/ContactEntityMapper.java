package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.Contact;
import in.co.mark.webservices.contacts.persistence.entities.ContactEObj;

@Component
public class ContactEntityMapper implements ModelEntityMapper<Contact, ContactEObj> {
	@Override
	public Contact mapToModel(ContactEObj contactEObj) {
		return new Contact(contactEObj.getId(), contactEObj.getFirstName(), contactEObj.getMiddleName(),
				contactEObj.getLastName(), contactEObj.getAvatarUri(), contactEObj.isFav(), contactEObj.getCreatedOn(),
				contactEObj.getLastUpdatedOn());
	}

	@Override
	public ContactEObj mapToEntity(Contact contact) {
		return new ContactEObj(contact.getId(), contact.getFirstName(), contact.getMiddleName(), contact.getLastName(),
				contact.getAvatarUri(), contact.isFav(), contact.getCreatedOn(), contact.getLastUpdatedOn());
	}
}
