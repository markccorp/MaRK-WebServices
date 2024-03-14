package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.EntityActiveStatus;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.contacts.domain.model.ContactEmail;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactEmailRequest;
import in.co.mark.webservices.contacts.modelmapper.ContactEmailEntityMapper;
import in.co.mark.webservices.contacts.modelmapper.ContactsDTOMapper;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.ContactEmailEObj;
import in.co.mark.webservices.contacts.services.ContactEmailsService;

@Service
public class ContactEmailsServiceImpl implements ContactEmailsService {
	private final ContactsDBAdapter dbAdapter;
	private final ContactsDTOMapper modelDTOMapper;
	private final ContactEmailEntityMapper modelEntityMapper;

	public ContactEmailsServiceImpl(ContactsDBAdapter dbAdapter, ContactsDTOMapper modelDTOMapper,
			ContactEmailEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelDTOMapper = modelDTOMapper;
		this.modelEntityMapper = modelEntityMapper;
	}

	@Override
	public ContactEmail createContactEmail(CreateContactEmailRequest reqDto) {
		ContactEmail contactEmail = modelDTOMapper.mapToContactEmail(reqDto);
		if (contactEmail.getEmailTypeId() == 0L) {
			throw new IllegalArgumentException("Invalid email type ID");
		}

		return createContactEmail(contactEmail);
	}

	@Override
	public ContactEmail createContactEmail(ContactEmail reqObj) {
		ContactEmailEObj contactEmailEObj = modelEntityMapper.mapToEntity(reqObj);
		contactEmailEObj.setStatus(EntityActiveStatus.Active);
		ContactEmail contactEmail = modelEntityMapper.mapToModel(dbAdapter.createContactEmail(contactEmailEObj));
		return contactEmail;
	}

	@Override
	public ContactEmail getContactEmailById(long id) {
		ContactEmail contactEmail = null;
		ContactEmailEObj contactEmailEObj = dbAdapter.getContactEmailById(id);
		if (contactEmailEObj != null) {
			contactEmail = modelEntityMapper.mapToModel(contactEmailEObj);
		}

		return contactEmail;
	}

	@Override
	public RecordsPage<ContactEmail> getContactEmails(int pageNo, int pageSize) {
		RecordsPage<ContactEmailEObj> entityRecordsPage = dbAdapter.getContactEmails(pageNo, pageSize);
		ModelEntityRecordsPageMapper<ContactEmail, ContactEmailEObj> merpMapper = new ModelEntityRecordsPageMapper<ContactEmail, ContactEmailEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<ContactEmail> getContactEmails(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		RecordsPage<ContactEmailEObj> entityRecordsPage = dbAdapter.getContactEmails(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<ContactEmail, ContactEmailEObj> merpMapper = new ModelEntityRecordsPageMapper<ContactEmail, ContactEmailEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
