package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.contacts.domain.model.EmailType;
import in.co.mark.webservices.contacts.modelmapper.EmailTypeEntityMapper;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.EmailTypeEObj;
import in.co.mark.webservices.contacts.services.EmailTypesService;

@Service
public class EmailTypesServiceImpl implements EmailTypesService {
	private final ContactsDBAdapter dbAdapter;
	private final EmailTypeEntityMapper modelEntityMapper;

	public EmailTypesServiceImpl(ContactsDBAdapter dbAdapter, EmailTypeEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelEntityMapper = modelEntityMapper;
	}

	@Override
	public EmailType createEmailType(EmailType reqObj) {
		EmailTypeEObj emailTypeEObj = modelEntityMapper.mapToEntity(reqObj);
		EmailType emailType = modelEntityMapper.mapToModel(dbAdapter.createEmailType(emailTypeEObj));
		return emailType;
	}

	@Override
	public EmailType getEmailTypeById(long id) {
		EmailType emailType = null;
		EmailTypeEObj emailTypeEObj = dbAdapter.getEmailTypeById(id);
		if (emailTypeEObj != null) {
			emailType = modelEntityMapper.mapToModel(emailTypeEObj);
		}

		return emailType;
	}

	@Override
	public RecordsPage<EmailType> getEmailTypes(int pageNo, int pageSize) {
		RecordsPage<EmailTypeEObj> entityRecordsPage = dbAdapter.getEmailTypes(pageNo, pageSize);
		ModelEntityRecordsPageMapper<EmailType, EmailTypeEObj> merpMapper = new ModelEntityRecordsPageMapper<EmailType, EmailTypeEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<EmailType> getEmailTypes(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		RecordsPage<EmailTypeEObj> entityRecordsPage = dbAdapter.getEmailTypes(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<EmailType, EmailTypeEObj> merpMapper = new ModelEntityRecordsPageMapper<EmailType, EmailTypeEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
