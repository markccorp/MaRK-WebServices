package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.contacts.domain.model.ContactMethodType;
import in.co.mark.webservices.contacts.modelmapper.ContactMethodTypeEntityMapper;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.ContactMethodTypeEObj;
import in.co.mark.webservices.contacts.services.ContactMethodTypesService;

@Service
public class ContactMethodTypesServiceImpl implements ContactMethodTypesService {
	private final ContactsDBAdapter dbAdapter;
	private final ContactMethodTypeEntityMapper modelEntityMapper;

	public ContactMethodTypesServiceImpl(ContactsDBAdapter dbAdapter, ContactMethodTypeEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelEntityMapper = modelEntityMapper;
	}

	@Override
	public ContactMethodType createContactMethodType(ContactMethodType reqObj) {
		ContactMethodTypeEObj ContactMethodTypeEObj = modelEntityMapper.mapToEntity(reqObj);
		ContactMethodType ContactMethodType = modelEntityMapper
				.mapToModel(dbAdapter.createContactMethodType(ContactMethodTypeEObj));
		return ContactMethodType;
	}

	@Override
	public ContactMethodType getContactMethodTypeById(long id) {
		ContactMethodType ContactMethodType = null;
		ContactMethodTypeEObj ContactMethodTypeEObj = dbAdapter.getContactMethodTypeById(id);
		if (ContactMethodTypeEObj != null) {
			ContactMethodType = modelEntityMapper.mapToModel(ContactMethodTypeEObj);
		}

		return ContactMethodType;
	}

	@Override
	public RecordsPage<ContactMethodType> getContactMethodTypes(int pageNo, int pageSize) {
		RecordsPage<ContactMethodTypeEObj> entityRecordsPage = dbAdapter.getContactMethodTypes(pageNo, pageSize);
		ModelEntityRecordsPageMapper<ContactMethodType, ContactMethodTypeEObj> merpMapper = new ModelEntityRecordsPageMapper<ContactMethodType, ContactMethodTypeEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<ContactMethodType> getContactMethodTypes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		RecordsPage<ContactMethodTypeEObj> entityRecordsPage = dbAdapter.getContactMethodTypes(pageNo, pageSize,
				sortOrder, sortByProperties);
		ModelEntityRecordsPageMapper<ContactMethodType, ContactMethodTypeEObj> merpMapper = new ModelEntityRecordsPageMapper<ContactMethodType, ContactMethodTypeEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
