package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.AddressType;
import in.co.mark.webservices.contacts.persistence.entities.AddressTypeEObj;

@Component
public class AddressTypeEntityMapper implements ModelEntityMapper<AddressType, AddressTypeEObj> {

	@Override
	public AddressType mapToModel(AddressTypeEObj addressTypeEObj) {
		return new AddressType(addressTypeEObj.getId(), addressTypeEObj.getType(), addressTypeEObj.getDesc(),
				addressTypeEObj.getCreatedOn(), addressTypeEObj.getLastUpdatedOn());
	}

	@Override
	public AddressTypeEObj mapToEntity(AddressType addressType) {
		return new AddressTypeEObj(addressType.getId(), addressType.getType(), addressType.getDesc(),
				addressType.getCreatedOn(), addressType.getLastUpdatedOn());
	}
}
