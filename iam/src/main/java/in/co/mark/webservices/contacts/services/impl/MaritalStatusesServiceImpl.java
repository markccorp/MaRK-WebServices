package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.contacts.domain.model.MaritalStatus;
import in.co.mark.webservices.contacts.modelmapper.MaritalStatusEntityMapper;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.MaritalStatusEObj;
import in.co.mark.webservices.contacts.services.MaritalStatusesService;

@Service
public class MaritalStatusesServiceImpl implements MaritalStatusesService {
	private final ContactsDBAdapter dbAdapter;
	private final MaritalStatusEntityMapper modelEntityMapper;

	public MaritalStatusesServiceImpl(ContactsDBAdapter dbAdapter, MaritalStatusEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelEntityMapper = modelEntityMapper;
	}

	@Override
	public MaritalStatus createMaritalStatus(MaritalStatus reqObj) {
		MaritalStatusEObj namePrefixEObj = modelEntityMapper.mapToEntity(reqObj);
		MaritalStatus namePrefix = modelEntityMapper.mapToModel(dbAdapter.createMaritalStatus(namePrefixEObj));
		return namePrefix;
	}

	@Override
	public MaritalStatus getMaritalStatusById(long id) {
		MaritalStatus namePrefix = null;
		MaritalStatusEObj namePrefixEObj = dbAdapter.getMaritalStatusById(id);
		if (namePrefixEObj != null) {
			namePrefix = modelEntityMapper.mapToModel(namePrefixEObj);
		}

		return namePrefix;
	}

	@Override
	public RecordsPage<MaritalStatus> getMaritalStatuses(int pageNo, int pageSize) {
		RecordsPage<MaritalStatusEObj> entityRecordsPage = dbAdapter.getMaritalStatuses(pageNo, pageSize);
		ModelEntityRecordsPageMapper<MaritalStatus, MaritalStatusEObj> merpMapper = new ModelEntityRecordsPageMapper<MaritalStatus, MaritalStatusEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<MaritalStatus> getMaritalStatuses(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		RecordsPage<MaritalStatusEObj> entityRecordsPage = dbAdapter.getMaritalStatuses(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<MaritalStatus, MaritalStatusEObj> merpMapper = new ModelEntityRecordsPageMapper<MaritalStatus, MaritalStatusEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
