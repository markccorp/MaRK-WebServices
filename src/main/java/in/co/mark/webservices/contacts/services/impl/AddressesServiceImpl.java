package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.contacts.domain.model.Address;
import in.co.mark.webservices.contacts.gateway.dto.CreateAddressRequest;
import in.co.mark.webservices.contacts.gateway.dto.CreateAddressResponse;
import in.co.mark.webservices.contacts.modelmapper.AddressEntityMapper;
import in.co.mark.webservices.contacts.modelmapper.ContactsDTOMapper;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.AddressEObj;
import in.co.mark.webservices.contacts.services.AddressesService;

@Service
public class AddressesServiceImpl implements AddressesService {
	private final ContactsDBAdapter dbAdapter;
	private final ContactsDTOMapper modelDTOMapper;
	private final AddressEntityMapper modelEntityMapper;

	public AddressesServiceImpl(ContactsDBAdapter dbAdapter, ContactsDTOMapper modelDTOMapper,
			AddressEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelDTOMapper = modelDTOMapper;
		this.modelEntityMapper = modelEntityMapper;
	}

	@Override
	public CreateAddressResponse createAddress(CreateAddressRequest reqDto) {
		Address address = modelDTOMapper.mapToAddress(reqDto);
		AddressEObj addressEObj = modelEntityMapper.mapToEntity(address);
		address = modelEntityMapper.mapToModel(dbAdapter.createAddress(addressEObj));
		return modelDTOMapper.mapToCreateAddressResponse(address);
	}

	@Override
	public Address getAddressById(long id) {
		Address address = null;
		AddressEObj addressEObj = dbAdapter.getAddressById(id);
		if (addressEObj != null) {
			address = modelEntityMapper.mapToModel(addressEObj);
		}

		return address;
	}

	@Override
	public RecordsPage<Address> getAddresses(int pageNo, int pageSize) {
		RecordsPage<AddressEObj> entityRecordsPage = dbAdapter.getAddresses(pageNo, pageSize);
		ModelEntityRecordsPageMapper<Address, AddressEObj> merpMapper = new ModelEntityRecordsPageMapper<Address, AddressEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<Address> getAddresses(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		RecordsPage<AddressEObj> entityRecordsPage = dbAdapter.getAddresses(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<Address, AddressEObj> merpMapper = new ModelEntityRecordsPageMapper<Address, AddressEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
