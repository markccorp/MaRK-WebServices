package in.co.mark.webservices.contacts.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.Contact;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactRequest;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactResponse;
import in.co.mark.webservices.contacts.services.ContactsService;

@RestController
@RequestMapping("api/contacts")
public class ContactsAPIController {
	private static final Logger logger = LoggerFactory.getLogger(ContactsAPIController.class);

	private ContactsService contactsService;

	public ContactsAPIController(ContactsService contactsService) {
		this.contactsService = contactsService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public CreateContactResponse createContact(@RequestBody CreateContactRequest request) {
		CreateContactResponse response = contactsService.createContact(request);
		logger.info("Contact created successfully with ID: {0}", response.id());
		return response;
	}

	@GetMapping(value = "/{id}")
	public Contact getContactById(@PathVariable long id) {
		Contact contact = contactsService.getContactById(id);
		if (contact == null) {
			logger.info("No contact found with ID: {0}", id);
		}
		return contact;
	}

	@GetMapping()
	public RecordsPage<Contact> getContacts(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "firstName") String sortBy) {
		return contactsService.getContacts(pageNo, pageSize, sortOrder, sortBy);
	}
}
