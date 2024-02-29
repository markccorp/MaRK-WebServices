package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.contacts.domain.model.NamePrefix;
import in.co.mark.webservices.contacts.gateway.dto.CreateNamePrefixRequest;
import in.co.mark.webservices.contacts.modelmapper.ContactsDTOMapper;
import in.co.mark.webservices.contacts.modelmapper.NamePrefixEntityMapper;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.NamePrefixEObj;
import in.co.mark.webservices.contacts.services.NamePrefixesService;

@Service
public class NamePrefixesServiceImpl implements NamePrefixesService {
	private final ContactsDBAdapter dbAdapter;
	private final ContactsDTOMapper modelDTOMapper;
	private final NamePrefixEntityMapper modelEntityMapper;

	public NamePrefixesServiceImpl(ContactsDBAdapter dbAdapter, ContactsDTOMapper modelDTOMapper,
			NamePrefixEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelDTOMapper = modelDTOMapper;
		this.modelEntityMapper = modelEntityMapper;
	}

	@Override
	public NamePrefix createNamePrefix(CreateNamePrefixRequest reqDto) {
		NamePrefix namePrefix = modelDTOMapper.mapToNamePrefix(reqDto);
		NamePrefixEObj namePrefixEObj = modelEntityMapper.mapToEntity(namePrefix);
		namePrefix = modelEntityMapper.mapToModel(dbAdapter.createNamePrefix(namePrefixEObj));
		return namePrefix;
	}

	@Override
	public NamePrefix getNamePrefixById(int id) {
		NamePrefix namePrefix = null;
		NamePrefixEObj namePrefixEObj = dbAdapter.getNamePrefixById(id);
		if (namePrefixEObj != null) {
			namePrefix = modelEntityMapper.mapToModel(namePrefixEObj);
		}

		return namePrefix;
	}

	@Override
	public RecordsPage<NamePrefix> getNamePrefixes(int pageNo, int pageSize) {
		RecordsPage<NamePrefixEObj> entityRecordsPage = dbAdapter.getNamePrefixes(pageNo, pageSize);
		ModelEntityRecordsPageMapper<NamePrefix, NamePrefixEObj> merpMapper = new ModelEntityRecordsPageMapper<NamePrefix, NamePrefixEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<NamePrefix> getNamePrefixes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		RecordsPage<NamePrefixEObj> entityRecordsPage = dbAdapter.getNamePrefixes(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<NamePrefix, NamePrefixEObj> merpMapper = new ModelEntityRecordsPageMapper<NamePrefix, NamePrefixEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
