package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.contacts.domain.model.AddressType;
import in.co.mark.webservices.contacts.modelmapper.AddressTypeEntityMapper;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.AddressTypeEObj;
import in.co.mark.webservices.contacts.services.AddressTypesService;

@Service
public class AddressTypesServiceImpl implements AddressTypesService {
	private final ContactsDBAdapter dbAdapter;
	private final AddressTypeEntityMapper modelEntityMapper;

	public AddressTypesServiceImpl(ContactsDBAdapter dbAdapter, AddressTypeEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelEntityMapper = modelEntityMapper;
	}

	@Override
	public AddressType createAddressType(AddressType reqObj) {
		AddressTypeEObj addressTypeEObj = modelEntityMapper.mapToEntity(reqObj);
		AddressType addressType = modelEntityMapper.mapToModel(dbAdapter.createAddressType(addressTypeEObj));
		return addressType;
	}

	@Override
	public AddressType getAddressTypeById(long id) {
		AddressType addressType = null;
		AddressTypeEObj addressTypeEObj = dbAdapter.getAddressTypeById(id);
		if (addressTypeEObj != null) {
			addressType = modelEntityMapper.mapToModel(addressTypeEObj);
		}

		return addressType;
	}

	@Override
	public RecordsPage<AddressType> getAddressTypes(int pageNo, int pageSize) {
		RecordsPage<AddressTypeEObj> entityRecordsPage = dbAdapter.getAddressTypes(pageNo, pageSize);
		ModelEntityRecordsPageMapper<AddressType, AddressTypeEObj> merpMapper = new ModelEntityRecordsPageMapper<AddressType, AddressTypeEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<AddressType> getAddressTypes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		RecordsPage<AddressTypeEObj> entityRecordsPage = dbAdapter.getAddressTypes(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<AddressType, AddressTypeEObj> merpMapper = new ModelEntityRecordsPageMapper<AddressType, AddressTypeEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

}
