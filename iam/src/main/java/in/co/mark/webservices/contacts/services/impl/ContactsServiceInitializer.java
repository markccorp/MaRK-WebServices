package in.co.mark.webservices.contacts.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.services.ServiceInitializer;
import in.co.mark.webservices.contacts.persistence.ContactsDBAdapter;
import in.co.mark.webservices.contacts.persistence.entities.EmailTypeEObj;
import in.co.mark.webservices.contacts.persistence.util.ContactsDefaultTypeCodeNames;

@Service
public class ContactsServiceInitializer implements ServiceInitializer {
	private final ContactsDBAdapter dbAdapter;

	public ContactsServiceInitializer(ContactsDBAdapter dbAdapter) {
		this.dbAdapter = dbAdapter;
	}

	@Override
	public boolean Init(long ownerId) {
		checkAndAddDefaultEmailTypes(ownerId);
		return true;
	}

	private void checkAndAddDefaultEmailTypes(long ownerId) {
		EmailTypeEObj primaryEmailType = this.dbAdapter
				.getEmailTypeByCode(ContactsDefaultTypeCodeNames.PrimaryEmailTypeCode);
		if (primaryEmailType == null) {
			primaryEmailType = new EmailTypeEObj();
			primaryEmailType.setOwnerId(ownerId);
			primaryEmailType.setOwnerOrg(true);
			primaryEmailType.setTypeCode(ContactsDefaultTypeCodeNames.PrimaryEmailTypeCode);
			// TODO: Set the email type name and description values as per the locale
			primaryEmailType.setTypeName(ContactsDefaultTypeCodeNames.PrimaryEmailTypeCode);
			primaryEmailType.setDesc("Primary email address");
			dbAdapter.createEmailType(primaryEmailType);
		}
	}
}
