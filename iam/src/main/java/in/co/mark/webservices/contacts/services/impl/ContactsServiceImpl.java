package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.contacts.domain.model.Contact;
import in.co.mark.webservices.contacts.domain.usecase.CreateContact;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactRequest;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactResponse;
import in.co.mark.webservices.contacts.modelmapper.ContactEntityMapper;
import in.co.mark.webservices.contacts.modelmapper.ContactsDTOMapper;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.ContactEObj;
import in.co.mark.webservices.contacts.services.ContactsService;

@Service
public class ContactsServiceImpl implements ContactsService, CreateContact {
	private final ContactsDBAdapter dbAdapter;
	private final ContactsDTOMapper modelDTOMapper;
	private final ContactEntityMapper modelEntityMapper;

	public ContactsServiceImpl(ContactsDBAdapter dbAdapter, ContactsDTOMapper modelDTOMapper,
			ContactEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelDTOMapper = modelDTOMapper;
		this.modelEntityMapper = modelEntityMapper;
	}

	public CreateContactResponse createContact(CreateContactRequest reqDto) {
		Contact contact = createContact(modelDTOMapper.mapToContact(reqDto));
		return modelDTOMapper.mapToCreateContactResponse(contact);
	}

	public Contact createContact(Contact contact) {
		ContactEObj contactEObj = modelEntityMapper.mapToEntity(contact);
		return modelEntityMapper.mapToModel(dbAdapter.createContact(contactEObj));
	}

	public Contact getContactById(long id) {
		Contact contact = null;
		ContactEObj contactEObj = dbAdapter.getContactById(id);
		if (contactEObj != null) {
			contact = modelEntityMapper.mapToModel(contactEObj);
		}

		return contact;
	}

	public RecordsPage<Contact> getContacts(int pageNo, int pageSize) {
		RecordsPage<ContactEObj> entityRecordsPage = dbAdapter.getContacts(pageNo, pageSize);
		ModelEntityRecordsPageMapper<Contact, ContactEObj> merpMapper = new ModelEntityRecordsPageMapper<Contact, ContactEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	public RecordsPage<Contact> getContacts(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		RecordsPage<ContactEObj> entityRecordsPage = dbAdapter.getContacts(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<Contact, ContactEObj> merpMapper = new ModelEntityRecordsPageMapper<Contact, ContactEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

}
