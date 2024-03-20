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
import in.co.mark.webservices.contacts.domain.model.ContactIdentifier;
import in.co.mark.webservices.contacts.domain.model.IdentifierType;
import in.co.mark.webservices.contacts.gateway.dto.CreateContactIdentifierRequest;
import in.co.mark.webservices.contacts.services.ContactIdentifiersService;
import in.co.mark.webservices.contacts.services.IdentifierTypesService;

@RestController
@RequestMapping("api/contactidentifiers")
public class ContactIdentifiersAPIController {
	private static final Logger logger = LoggerFactory.getLogger(ContactIdentifiersAPIController.class);

	private final ContactIdentifiersService contactIdentifiersService;
	private final IdentifierTypesService identifierTypesService;

	public ContactIdentifiersAPIController(ContactIdentifiersService contactIdentifiersService,
			IdentifierTypesService identifierTypesService) {
		this.contactIdentifiersService = contactIdentifiersService;
		this.identifierTypesService = identifierTypesService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ContactIdentifier createContactIdentifier(@RequestBody CreateContactIdentifierRequest request) {
		ContactIdentifier contactIdentifier;

		if (request.identifierTypeId() != 0L) {
			contactIdentifier = contactIdentifiersService.createContactIdentifier(request);
		} else {
			logger.info("Creating a new identifier type first for the user: {0}, as no identifier type ID is provided",
					request.ownerUserId());
			String identifierTypeName = request.identifierType().trim(); // Identifier type must be available here
			IdentifierType newIdentifierType = new IdentifierType(request.ownerUserId(), identifierTypeName,
					identifierTypeName);
			newIdentifierType = identifierTypesService.createIdentifierType(newIdentifierType);
			contactIdentifier = new ContactIdentifier(request.ownerUserId(), request.contactId(),
					newIdentifierType.getId(), request.identifierValue(), request.desc(), request.issueLocation(),
					request.issueDate(), request.expiryDate());
			contactIdentifier = contactIdentifiersService.createContactIdentifier(contactIdentifier);
		}

		logger.info("Contact identifier created successfully with ID: {0} for user: {1}", contactIdentifier.getId(),
				contactIdentifier.getOwnerId());
		return contactIdentifier;
	}

	@GetMapping(value = "/{id}")
	public ContactIdentifier getContactIdentifierById(@PathVariable long id) {
		ContactIdentifier contactIdentifier = contactIdentifiersService.getContactIdentifierById(id);
		if (contactIdentifier == null) {
			logger.info("No contact identifier found with ID: {0}", id);
		}
		return contactIdentifier;
	}

	@GetMapping()
	public RecordsPage<ContactIdentifier> getContactIdentifiers(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "identifierValue") String sortBy) {
		return contactIdentifiersService.getContactIdentifiers(pageNo, pageSize, sortOrder, sortBy);
	}
}
