package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.contacts.domain.model.ContactMethodCategory;
import in.co.mark.webservices.contacts.modelmapper.ContactMethodCategoryEntityMapper;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.ContactMethodCategoryEObj;
import in.co.mark.webservices.contacts.services.ContactMethodCategoriesService;

@Service
public class ContactMethodCategoriesServiceImpl implements ContactMethodCategoriesService {
	private final ContactsDBAdapter dbAdapter;
	private final ContactMethodCategoryEntityMapper modelEntityMapper;

	public ContactMethodCategoriesServiceImpl(ContactsDBAdapter dbAdapter,
			ContactMethodCategoryEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelEntityMapper = modelEntityMapper;
	}

	@Override
	public ContactMethodCategory createContactMethodCategory(ContactMethodCategory reqObj) {
		ContactMethodCategoryEObj contactMethodCategoryEObj = modelEntityMapper.mapToEntity(reqObj);
		ContactMethodCategory contactMethodCategory = modelEntityMapper
				.mapToModel(dbAdapter.createContactMethodCategory(contactMethodCategoryEObj));
		return contactMethodCategory;
	}

	@Override
	public ContactMethodCategory getContactMethodCategoryById(long id) {
		ContactMethodCategory contactMethodCategory = null;
		ContactMethodCategoryEObj contactMethodCategoryEObj = dbAdapter.getContactMethodCategoryById(id);
		if (contactMethodCategoryEObj != null) {
			contactMethodCategory = modelEntityMapper.mapToModel(contactMethodCategoryEObj);
		}

		return contactMethodCategory;
	}

	@Override
	public RecordsPage<ContactMethodCategory> getContactMethodCategories(int pageNo, int pageSize) {
		RecordsPage<ContactMethodCategoryEObj> entityRecordsPage = dbAdapter.getContactMethodCategories(pageNo,
				pageSize);
		ModelEntityRecordsPageMapper<ContactMethodCategory, ContactMethodCategoryEObj> merpMapper = new ModelEntityRecordsPageMapper<ContactMethodCategory, ContactMethodCategoryEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<ContactMethodCategory> getContactMethodCategories(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		RecordsPage<ContactMethodCategoryEObj> entityRecordsPage = dbAdapter.getContactMethodCategories(pageNo,
				pageSize, sortOrder, sortByProperties);
		ModelEntityRecordsPageMapper<ContactMethodCategory, ContactMethodCategoryEObj> merpMapper = new ModelEntityRecordsPageMapper<ContactMethodCategory, ContactMethodCategoryEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
