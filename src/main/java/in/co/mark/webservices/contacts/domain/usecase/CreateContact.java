package in.co.mark.webservices.contacts.domain.usecase;

import in.co.mark.webservices.contacts.domain.model.Contact;

public interface CreateContact {
	Contact createContact(Contact contact);
}
