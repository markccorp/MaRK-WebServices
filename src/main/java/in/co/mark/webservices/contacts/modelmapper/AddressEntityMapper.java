package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.Address;
import in.co.mark.webservices.contacts.persistence.entities.AddressEObj;

@Component
public class AddressEntityMapper implements ModelEntityMapper<Address, AddressEObj> {

	@Override
	public Address mapToModel(AddressEObj addressEObj) {
		return new Address(addressEObj.getId(), addressEObj.getAddressLineOne(), addressEObj.getAddressLineTwo(),
				addressEObj.getLocality(), addressEObj.getCity(), addressEObj.getState(), addressEObj.getCountryCode(),
				addressEObj.getPostalCode(), addressEObj.getCreatedOn(), addressEObj.getLastUpdatedOn());
	}

	@Override
	public AddressEObj mapToEntity(Address address) {
		return new AddressEObj(address.getId(), address.getAddressLineOne(), address.getAddressLineTwo(),
				address.getLocality(), address.getCity(), address.getState(), address.getCountryCode(),
				address.getPostalCode(), address.getCreatedOn(), address.getLastUpdatedOn());
	}
}
