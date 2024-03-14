package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.contacts.domain.model.NameSuffix;
import in.co.mark.webservices.contacts.modelmapper.NameSuffixEntityMapper;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.NameSuffixEObj;
import in.co.mark.webservices.contacts.services.NameSuffixesService;

@Service
public class NameSuffixesServiceImpl implements NameSuffixesService {
	private final ContactsDBAdapter dbAdapter;
	private final NameSuffixEntityMapper modelEntityMapper;

	public NameSuffixesServiceImpl(ContactsDBAdapter dbAdapter, NameSuffixEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelEntityMapper = modelEntityMapper;
	}

	@Override
	public NameSuffix createNameSuffix(NameSuffix reqObj) {
		NameSuffixEObj nameSuffixEObj = modelEntityMapper.mapToEntity(reqObj);
		NameSuffix nameSuffix = modelEntityMapper.mapToModel(dbAdapter.createNameSuffix(nameSuffixEObj));
		return nameSuffix;
	}

	@Override
	public NameSuffix getNameSuffixById(long id) {
		NameSuffix nameSuffix = null;
		NameSuffixEObj nameSuffixEObj = dbAdapter.getNameSuffixById(id);
		if (nameSuffixEObj != null) {
			nameSuffix = modelEntityMapper.mapToModel(nameSuffixEObj);
		}

		return nameSuffix;
	}

	@Override
	public RecordsPage<NameSuffix> getNameSuffixes(int pageNo, int pageSize) {
		RecordsPage<NameSuffixEObj> entityRecordsPage = dbAdapter.getNameSuffixes(pageNo, pageSize);
		ModelEntityRecordsPageMapper<NameSuffix, NameSuffixEObj> merpMapper = new ModelEntityRecordsPageMapper<NameSuffix, NameSuffixEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<NameSuffix> getNameSuffixes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		RecordsPage<NameSuffixEObj> entityRecordsPage = dbAdapter.getNameSuffixes(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<NameSuffix, NameSuffixEObj> merpMapper = new ModelEntityRecordsPageMapper<NameSuffix, NameSuffixEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
