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
import in.co.mark.webservices.contacts.domain.model.ContactEmail;
import in.co.mark.webservices.contacts.domain.model.EmailType;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactEmailRequest;
import in.co.mark.webservices.contacts.services.ContactEmailsService;
import in.co.mark.webservices.contacts.services.EmailTypesService;

@RestController
@RequestMapping("api/contactemails")
public class ContactEmailsAPIController {
	private static final Logger logger = LoggerFactory.getLogger(ContactEmailsAPIController.class);

	private final ContactEmailsService contactEmailsService;
	private final EmailTypesService emailTypesService;

	public ContactEmailsAPIController(ContactEmailsService contactEmailsService, EmailTypesService emailTypesService) {
		this.contactEmailsService = contactEmailsService;
		this.emailTypesService = emailTypesService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ContactEmail createContactEmail(@RequestBody CreateContactEmailRequest request) {
		ContactEmail contactEmail;

		if (request.emailTypeId() != 0L) {
			contactEmail = contactEmailsService.createContactEmail(request);
		} else {
			logger.info("Creating a new email type first, as no email type ID is provided");
			String emailTypeName = request.emailType().trim(); // Email type must be available here
			EmailType newEmailType = new EmailType(request.ownerUserId(), emailTypeName, emailTypeName);
			newEmailType = emailTypesService.createEmailType(newEmailType);
			contactEmail = new ContactEmail(request.ownerUserId(), newEmailType.getId(), request.emailAddress());
			contactEmail = contactEmailsService.createContactEmail(contactEmail);
		}

		logger.info("Contact email created successfully with ID: {0} for user: {1}", contactEmail.getId(),
				contactEmail.getOwnerId());
		return contactEmail;
	}

	@GetMapping(value = "/{id}")
	public ContactEmail getContactEmailById(@PathVariable long id) {
		ContactEmail contactEmail = contactEmailsService.getContactEmailById(id);
		if (contactEmail == null) {
			logger.info("No name-prefix found with ID: {0}", id);
		}
		return contactEmail;
	}

	@GetMapping()
	public RecordsPage<ContactEmail> getContactEmails(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "contactEmail") String sortBy) {
		return contactEmailsService.getContactEmails(pageNo, pageSize, sortOrder, sortBy);
	}
}
