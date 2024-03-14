package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.webservices.contacts.domain.model.Address;
import in.co.mark.webservices.contacts.domain.model.Contact;
import in.co.mark.webservices.contacts.domain.model.ContactEmail;
import in.co.mark.webservices.contacts.gateway.controller.ContactsAPIController;
import in.co.mark.webservices.contacts.gateway.dto.CreateAddressRequest;
import in.co.mark.webservices.contacts.gateway.dto.CreateAddressResponse;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactEmailRequest;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactRequest;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactResponse;

/**
 * Converts request/response DTO objects of {@link ContactsAPIController} to
 * domain entities, and vice-versa
 */
@Component
public class ContactsDTOMapper {
	/**
	 * To map the given {@code reqDto} to an equivalent {@link Contact} model object
	 * 
	 * @param reqDto A request DTO of type {@link CreateContactRequest}
	 * @return A {@link Contact} model object
	 */
	public Contact mapToContact(CreateContactRequest reqDto) {
		Contact contact = new Contact();
		contact.setFirstName(reqDto.firstName());
		contact.setMiddleName(reqDto.middleName());
		contact.setLastName(reqDto.lastName());
		return contact;
	}

	/**
	 * To map the given {@code contact} to an equivalent
	 * {@link CreateContactResponse} DTO object
	 * 
	 * @param contact A model object of type {@link Contact}
	 * @return A {@link CreateContactResponse} DTO object
	 */
	public CreateContactResponse mapToCreateContactResponse(Contact contact) {
		return new CreateContactResponse(contact.getId(), contact.getFirstName(), contact.getMiddleName(),
				contact.getLastName(), contact.isFav(), contact.getCreatedOn(), contact.getLastUpdatedOn());
	}

	/**
	 * To map the given {@code reqDto} to an equivalent {@link Address} model object
	 * 
	 * @param reqDto A request DTO of type {@link CreateAddressRequest}
	 * @return A {@link Address} model object
	 */
	public Address mapToAddress(CreateAddressRequest reqDto) {
		Address address = new Address();
		address.setAddressLineOne(reqDto.addressLineOne());
		address.setAddressLineTwo(reqDto.addressLineTwo());
		address.setLocality(reqDto.locality());
		address.setCity(reqDto.city());
		address.setState(reqDto.state());
		address.setCountryCode(reqDto.countryCode());
		address.setPostalCode(reqDto.postalCode());
		return address;
	}

	/**
	 * To map the given {@code address} to an equivalent
	 * {@link CreateAddressResponse} DTO object
	 * 
	 * @param address A model object of type {@link Address}
	 * @return A {@link CreateAddressResponse} DTO object
	 */
	public CreateAddressResponse mapToCreateAddressResponse(Address address) {
		return new CreateAddressResponse(address.getId(), address.getAddressLineOne(), address.getAddressLineTwo(),
				address.getLocality(), address.getCity(), address.getState(), address.getCountryCode(),
				address.getPostalCode(), address.getCreatedOn(), address.getLastUpdatedOn());
	}

	/**
	 * To map the given {@code reqDto} to an equivalent {@link ContactEmail} model
	 * object
	 * 
	 * @param reqDto A request DTO of type {@link CreateContactEmailRequest}
	 * @return A {@link ContactEmail} model object
	 */
	public ContactEmail mapToContactEmail(CreateContactEmailRequest reqDto) {
		return new ContactEmail(reqDto.ownerUserId(), reqDto.emailTypeId(), reqDto.emailAddress());
	}
}
