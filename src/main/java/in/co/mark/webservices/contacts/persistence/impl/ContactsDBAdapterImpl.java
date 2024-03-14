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
import in.co.mark.webservices.contacts.persistence.entities.ContactEmailEObj;
import in.co.mark.webservices.contacts.persistence.entities.EmailTypeEObj;
import in.co.mark.webservices.contacts.persistence.entities.MaritalStatusEObj;
import in.co.mark.webservices.contacts.persistence.entities.NamePrefixEObj;
import in.co.mark.webservices.contacts.persistence.entities.NameSuffixEObj;
import in.co.mark.webservices.contacts.persistence.repositories.AddressTypesRepository;
import in.co.mark.webservices.contacts.persistence.repositories.AddressesRepository;
import in.co.mark.webservices.contacts.persistence.repositories.ContactAddressesRepository;
import in.co.mark.webservices.contacts.persistence.repositories.ContactEmailsRepository;
import in.co.mark.webservices.contacts.persistence.repositories.ContactsRepository;
import in.co.mark.webservices.contacts.persistence.repositories.EmailTypesRepository;
import in.co.mark.webservices.contacts.persistence.repositories.MaritalStatusesRepository;
import in.co.mark.webservices.contacts.persistence.repositories.NamePrefixesRepository;
import in.co.mark.webservices.contacts.persistence.repositories.NameSuffixesRepository;

@Component
public class ContactsDBAdapterImpl implements ContactsDBAdapter {
	private final ContactsRepository contactsRepo;
	private final AddressesRepository addressesRepo;
	private final AddressTypesRepository addressTypesRepo;
	private final ContactAddressesRepository contactAddressesRepo;
	private final NamePrefixesRepository namePrefixesRepo;
	private final NameSuffixesRepository nameSuffixesRepo;
	private final EmailTypesRepository emailTypesRepo;
	private final ContactEmailsRepository contactEmailsRepo;
	private final MaritalStatusesRepository maritalStatusesRepo;

	public ContactsDBAdapterImpl(ContactsRepository contactsRepo, AddressesRepository addressesRepo,
			AddressTypesRepository addressTypesRepo, ContactAddressesRepository contactAddressesRepo,
			NamePrefixesRepository namePrefixesRepo, NameSuffixesRepository nameSuffixesRepo,
			EmailTypesRepository emailTypesRepo, ContactEmailsRepository contactEmailsRepo,
			MaritalStatusesRepository maritalStatusesRepo) {
		this.contactsRepo = contactsRepo;
		this.addressesRepo = addressesRepo;
		this.addressTypesRepo = addressTypesRepo;
		this.contactAddressesRepo = contactAddressesRepo;
		this.namePrefixesRepo = namePrefixesRepo;
		this.nameSuffixesRepo = nameSuffixesRepo;
		this.emailTypesRepo = emailTypesRepo;
		this.contactEmailsRepo = contactEmailsRepo;
		this.maritalStatusesRepo = maritalStatusesRepo;
	}

	@Override
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

	@Override
	public NamePrefixEObj createNamePrefix(NamePrefixEObj namePrefixEObj) {
		return namePrefixesRepo.save(namePrefixEObj);
	}

	@Override
	public NamePrefixEObj getNamePrefixById(long id) {
		Optional<NamePrefixEObj> optionalNamePrefixEObj = namePrefixesRepo.findById(id);
		return optionalNamePrefixEObj.orElse(null);
	}

	@Override
	public RecordsPage<NamePrefixEObj> getNamePrefixes(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Slice<NamePrefixEObj> slicedResult = namePrefixesRepo.findAll(paging);
		return new RecordsPageImpl<NamePrefixEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<NamePrefixEObj> getNamePrefixes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<NamePrefixEObj> slicedResult = namePrefixesRepo.findAll(paging);
		return new RecordsPageImpl<NamePrefixEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public NameSuffixEObj createNameSuffix(NameSuffixEObj nameSuffixEObj) {
		return nameSuffixesRepo.save(nameSuffixEObj);
	}

	@Override
	public NameSuffixEObj getNameSuffixById(long id) {
		Optional<NameSuffixEObj> optionalNameSuffixEObj = nameSuffixesRepo.findById(id);
		return optionalNameSuffixEObj.orElse(null);
	}

	@Override
	public RecordsPage<NameSuffixEObj> getNameSuffixes(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Slice<NameSuffixEObj> slicedResult = nameSuffixesRepo.findAll(paging);
		return new RecordsPageImpl<NameSuffixEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<NameSuffixEObj> getNameSuffixes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<NameSuffixEObj> slicedResult = nameSuffixesRepo.findAll(paging);
		return new RecordsPageImpl<NameSuffixEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public EmailTypeEObj createEmailType(EmailTypeEObj emailTypeEObj) {
		return emailTypesRepo.save(emailTypeEObj);
	}

	@Override
	public EmailTypeEObj getEmailTypeById(long id) {
		Optional<EmailTypeEObj> optionalEmailTypeEObj = emailTypesRepo.findById(id);
		return optionalEmailTypeEObj.orElse(null);
	}

	@Override
	public RecordsPage<EmailTypeEObj> getEmailTypes(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Slice<EmailTypeEObj> slicedResult = emailTypesRepo.findAll(paging);
		return new RecordsPageImpl<EmailTypeEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<EmailTypeEObj> getEmailTypes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<EmailTypeEObj> slicedResult = emailTypesRepo.findAll(paging);
		return new RecordsPageImpl<EmailTypeEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public ContactEmailEObj createContactEmail(ContactEmailEObj contactEmailEObj) {
		return contactEmailsRepo.save(contactEmailEObj);
	}

	@Override
	public ContactEmailEObj getContactEmailById(long id) {
		Optional<ContactEmailEObj> optionalContactEmailEObj = contactEmailsRepo.findById(id);
		return optionalContactEmailEObj.orElse(null);
	}

	@Override
	public RecordsPage<ContactEmailEObj> getContactEmails(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Slice<ContactEmailEObj> slicedResult = contactEmailsRepo.findAll(paging);
		return new RecordsPageImpl<ContactEmailEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<ContactEmailEObj> getContactEmails(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<ContactEmailEObj> slicedResult = contactEmailsRepo.findAll(paging);
		return new RecordsPageImpl<ContactEmailEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public MaritalStatusEObj createMaritalStatus(MaritalStatusEObj maritalStatusEObj) {
		return maritalStatusesRepo.save(maritalStatusEObj);
	}

	@Override
	public MaritalStatusEObj getMaritalStatusById(long id) {
		Optional<MaritalStatusEObj> optionalMaritalStatusEObj = maritalStatusesRepo.findById(id);
		return optionalMaritalStatusEObj.orElse(null);
	}

	@Override
	public RecordsPage<MaritalStatusEObj> getMaritalStatuses(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Slice<MaritalStatusEObj> slicedResult = maritalStatusesRepo.findAll(paging);
		return new RecordsPageImpl<MaritalStatusEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<MaritalStatusEObj> getMaritalStatuses(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<MaritalStatusEObj> slicedResult = maritalStatusesRepo.findAll(paging);
		return new RecordsPageImpl<MaritalStatusEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}
}
