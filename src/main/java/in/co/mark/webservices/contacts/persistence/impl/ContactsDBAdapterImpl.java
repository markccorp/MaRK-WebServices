package in.co.mark.webservices.contacts.persistence.impl;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.impl.RecordsPageImpl;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.AddressEObj;
import in.co.mark.webservices.contacts.persistence.entities.AddressTypeEObj;
import in.co.mark.webservices.contacts.persistence.entities.ContactAddressEObj;
import in.co.mark.webservices.contacts.persistence.entities.ContactEObj;
import in.co.mark.webservices.contacts.persistence.repositories.AddressTypesRepository;
import in.co.mark.webservices.contacts.persistence.repositories.AddressesRepository;
import in.co.mark.webservices.contacts.persistence.repositories.ContactAddressesRepository;
import in.co.mark.webservices.contacts.persistence.repositories.ContactsRepository;

@Component
public class ContactsDBAdapterImpl implements ContactsDBAdapter {
	private final ContactsRepository contactsRepo;
	private final AddressesRepository addressesRepo;
	private final AddressTypesRepository addressTypesRepo;
	private final ContactAddressesRepository contactAddressesRepo;

	public ContactsDBAdapterImpl(ContactsRepository contactsRepo, AddressesRepository addressesRepo,
			AddressTypesRepository addressTypesRepo, ContactAddressesRepository contactAddressesRepo) {
		this.contactsRepo = contactsRepo;
		this.addressesRepo = addressesRepo;
		this.addressTypesRepo = addressTypesRepo;
		this.contactAddressesRepo = contactAddressesRepo;
	}

	public ContactEObj createContact(ContactEObj contactEObj) {
		return contactsRepo.save(contactEObj);
	}

	@Override
	public ContactEObj getContactById(long id) {
		Optional<ContactEObj> optionalContactEObj = contactsRepo.findById(id);
		return optionalContactEObj.orElse(null);
	}

	@Override
	public RecordsPage<ContactEObj> getContacts(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Slice<ContactEObj> slicedResult = contactsRepo.findAll(paging);
		return new RecordsPageImpl<ContactEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<ContactEObj> getContacts(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<ContactEObj> slicedResult = contactsRepo.findAll(paging);
		return new RecordsPageImpl<ContactEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public AddressEObj createAddress(AddressEObj addressEObj) {
		return addressesRepo.save(addressEObj);
	}

	@Override
	public AddressEObj getAddressById(long id) {
		Optional<AddressEObj> optionalContactEObj = addressesRepo.findById(id);
		return optionalContactEObj.orElse(null);
	}

	@Override
	public RecordsPage<AddressEObj> getAddresses(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Slice<AddressEObj> slicedResult = addressesRepo.findAll(paging);
		return new RecordsPageImpl<AddressEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<AddressEObj> getAddresses(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<AddressEObj> slicedResult = addressesRepo.findAll(paging);
		return new RecordsPageImpl<AddressEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public AddressTypeEObj createAddressType(AddressTypeEObj addressTypeEObj) {
		return addressTypesRepo.save(addressTypeEObj);
	}

	@Override
	public AddressTypeEObj getAddressTypeById(long id) {
		Optional<AddressTypeEObj> optionalContactEObj = addressTypesRepo.findById(id);
		return optionalContactEObj.orElse(null);
	}

	@Override
	public RecordsPage<AddressTypeEObj> getAddressTypes(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Slice<AddressTypeEObj> slicedResult = addressTypesRepo.findAll(paging);
		return new RecordsPageImpl<AddressTypeEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<AddressTypeEObj> getAddressTypes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<AddressTypeEObj> slicedResult = addressTypesRepo.findAll(paging);
		return new RecordsPageImpl<AddressTypeEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public ContactAddressEObj createContactAddress(ContactAddressEObj contactAddressEObj) {
		return contactAddressesRepo.save(contactAddressEObj);
	}

	@Override
	public ContactAddressEObj getContcatAddressById(long id) {
		Optional<ContactAddressEObj> optionalContactEObj = contactAddressesRepo.findById(id);
		return optionalContactEObj.orElse(null);
	}

	@Override
	public RecordsPage<ContactAddressEObj> getContactAddresses(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Slice<ContactAddressEObj> slicedResult = contactAddressesRepo.findAll(paging);
		return new RecordsPageImpl<ContactAddressEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<ContactAddressEObj> getContactAddresses(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<ContactAddressEObj> slicedResult = contactAddressesRepo.findAll(paging);
		return new RecordsPageImpl<ContactAddressEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}
}
