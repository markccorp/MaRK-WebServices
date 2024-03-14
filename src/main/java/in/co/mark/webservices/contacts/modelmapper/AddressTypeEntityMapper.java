package in.co.mark.webservices.contacts.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.common.extensions.ModelEntityMapperExtn;
import in.co.mark.common.persistence.util.ModelEntityMapper;
import in.co.mark.webservices.contacts.domain.model.AddressType;
import in.co.mark.webservices.contacts.persistence.entities.AddressTypeEObj;
import lombok.experimental.ExtensionMethod;

@Component
@ExtensionMethod({ ModelEntityMapperExtn.class })
public class AddressTypeEntityMapper implements ModelEntityMapper<AddressType, AddressTypeEObj> {

	@Override
	public AddressType mapToModel(AddressTypeEObj addressTypeEObj) {
		return new AddressType(addressTypeEObj.getId(), addressTypeEObj.getOwnerId(), addressTypeEObj.isOwnerOrg(),
				addressTypeEObj.getAddressType(), addressTypeEObj.getDesc(), addressTypeEObj.getCreatedOn(),
				addressTypeEObj.getLastUpdatedOn());
	}

	@Override
	public AddressTypeEObj mapToEntity(AddressType model) {
		AddressTypeEObj entity = new AddressTypeEObj(model.getId(), model.isOwnerOrg(), model.getAddressType(),
				model.getDesc());
		entity.updateUserIdAndTimestamp(model);
		return entity;
	}
}
