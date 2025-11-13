package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.contacts.domain.model.IdentifierType;
import in.co.mark.webservices.contacts.modelmapper.IdentifierTypeEntityMapper;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.IdentifierTypeEObj;
import in.co.mark.webservices.contacts.services.IdentifierTypesService;

@Service
public class IdentifierTypesServiceImpl implements IdentifierTypesService {
	private final ContactsDBAdapter dbAdapter;
	private final IdentifierTypeEntityMapper modelEntityMapper;

	public IdentifierTypesServiceImpl(ContactsDBAdapter dbAdapter, IdentifierTypeEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelEntityMapper = modelEntityMapper;
	}

	@Override
	public IdentifierType createIdentifierType(IdentifierType reqObj) {
		IdentifierTypeEObj identifierTypeEObj = modelEntityMapper.mapToEntity(reqObj);
		IdentifierType identifierType = modelEntityMapper
				.mapToModel(dbAdapter.createIdentifierType(identifierTypeEObj));
		return identifierType;
	}

	@Override
	public IdentifierType getIdentifierTypeById(long id) {
		IdentifierType identifierType = null;
		IdentifierTypeEObj identifierTypeEObj = dbAdapter.getIdentifierTypeById(id);
		if (identifierTypeEObj != null) {
			identifierType = modelEntityMapper.mapToModel(identifierTypeEObj);
		}

		return identifierType;
	}

	@Override
	public RecordsPage<IdentifierType> getIdentifierTypes(int pageNo, int pageSize) {
		RecordsPage<IdentifierTypeEObj> entityRecordsPage = dbAdapter.getIdentifierTypes(pageNo, pageSize);
		ModelEntityRecordsPageMapper<IdentifierType, IdentifierTypeEObj> merpMapper = new ModelEntityRecordsPageMapper<IdentifierType, IdentifierTypeEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<IdentifierType> getIdentifierTypes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		RecordsPage<IdentifierTypeEObj> entityRecordsPage = dbAdapter.getIdentifierTypes(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<IdentifierType, IdentifierTypeEObj> merpMapper = new ModelEntityRecordsPageMapper<IdentifierType, IdentifierTypeEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
