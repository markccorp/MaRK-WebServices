package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.EntityActiveStatus;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.contacts.domain.model.ContactIdentifier;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactIdentifierRequest;
import in.co.mark.webservices.contacts.modelmapper.ContactIdentifierEntityMapper;
import in.co.mark.webservices.contacts.modelmapper.ContactsDTOMapper;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.ContactIdentifierEObj;
import in.co.mark.webservices.contacts.services.ContactIdentifiersService;

@Service
public class ContactIdentifiersServiceImpl implements ContactIdentifiersService {
	private final ContactsDBAdapter dbAdapter;
	private final ContactsDTOMapper modelDTOMapper;
	private final ContactIdentifierEntityMapper modelEntityMapper;

	public ContactIdentifiersServiceImpl(ContactsDBAdapter dbAdapter, ContactsDTOMapper modelDTOMapper,
			ContactIdentifierEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelDTOMapper = modelDTOMapper;
		this.modelEntityMapper = modelEntityMapper;
	}

	@Override
	public ContactIdentifier createContactIdentifier(CreateContactIdentifierRequest reqDto) {
		ContactIdentifier contactIdentifier = modelDTOMapper.mapToContactIdentifier(reqDto);
		if (contactIdentifier.getIdentifierTypeId() == 0L) {
			throw new IllegalArgumentException("Invalid identifier type ID");
		}

		return createContactIdentifier(contactIdentifier);
	}

	@Override
	public ContactIdentifier createContactIdentifier(ContactIdentifier reqObj) {
		ContactIdentifierEObj contactIdentifierEObj = modelEntityMapper.mapToEntity(reqObj);
		contactIdentifierEObj.setStatus(EntityActiveStatus.Active);
		ContactIdentifier contactIdentifier = modelEntityMapper
				.mapToModel(dbAdapter.createContactIdentifier(contactIdentifierEObj));
		return contactIdentifier;
	}

	@Override
	public ContactIdentifier getContactIdentifierById(long id) {
		ContactIdentifier contactIdentifier = null;
		ContactIdentifierEObj contactIdentifierEObj = dbAdapter.getContactIdentifierById(id);
		if (contactIdentifierEObj != null) {
			contactIdentifier = modelEntityMapper.mapToModel(contactIdentifierEObj);
		}

		return contactIdentifier;
	}

	@Override
	public RecordsPage<ContactIdentifier> getContactIdentifiers(int pageNo, int pageSize) {
		RecordsPage<ContactIdentifierEObj> entityRecordsPage = dbAdapter.getContactIdentifiers(pageNo, pageSize);
		ModelEntityRecordsPageMapper<ContactIdentifier, ContactIdentifierEObj> merpMapper = new ModelEntityRecordsPageMapper<ContactIdentifier, ContactIdentifierEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<ContactIdentifier> getContactIdentifiers(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		RecordsPage<ContactIdentifierEObj> entityRecordsPage = dbAdapter.getContactIdentifiers(pageNo, pageSize,
				sortOrder, sortByProperties);
		ModelEntityRecordsPageMapper<ContactIdentifier, ContactIdentifierEObj> merpMapper = new ModelEntityRecordsPageMapper<ContactIdentifier, ContactIdentifierEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
