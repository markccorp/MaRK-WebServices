package in.co.mark.webservices.iam.gateway.adapter;

import org.springframework.stereotype.Component;

import in.co.mark.webservices.contacts.domain.model.Contact;
import in.co.mark.webservices.contacts.services.ContactsService;
import in.co.mark.webservices.iam.domain.model.User;

@Component
public class ContactsServiceAdapter {
	private final ContactsService contactsService;

	public ContactsServiceAdapter(ContactsService contactsService) {
		this.contactsService = contactsService;
	}

	public Contact addUserAsOrgContact(long orgId, User user) {
		Contact contact = new Contact();
		contact.setOwnerId(orgId);
		contact.setOwnerOrg(true);
		contact.setInitial(user.getInitial());
		contact.setFirstName(user.getFirstName());
		contact.setMiddleName(user.getMiddleName());
		contact.setLastName(user.getLastName());
		contact.setNickName(user.getDisplayName());
		contact.setGender(user.getGender() + ""); // TODO: Change the contact's gender to char
		contact.setDobDate(user.getDobDate());
		contact.setDobMonth(user.getDobMonth());
		contact.setDobYear(user.getDobYear());
		Contact newContact = contactsService.createContact(contact);
		// TODO: Update email of this contact
		return newContact;
	}
}
