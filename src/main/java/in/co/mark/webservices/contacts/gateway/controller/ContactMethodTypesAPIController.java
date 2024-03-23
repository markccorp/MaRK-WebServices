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
import in.co.mark.webservices.contacts.domain.model.ContactMethodType;
import in.co.mark.webservices.contacts.services.ContactMethodTypesService;

@RestController
@RequestMapping("api/contactmethodtypes")
public class ContactMethodTypesAPIController {
	private static final Logger logger = LoggerFactory.getLogger(ContactMethodTypesAPIController.class);

	private ContactMethodTypesService contactMethodTypesService;

	public ContactMethodTypesAPIController(ContactMethodTypesService contactMethodTypesService) {
		this.contactMethodTypesService = contactMethodTypesService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ContactMethodType createContactMethodType(@RequestBody ContactMethodType request) {
		ContactMethodType contactMethodType = contactMethodTypesService.createContactMethodType(request);
		logger.info("Contact method type created successfully with ID: {0} for owner: {1}", contactMethodType.getId(),
				contactMethodType.getOwnerId());
		return contactMethodType;
	}

	@GetMapping(value = "/{id}")
	public ContactMethodType getContactMethodTypeById(@PathVariable long id) {
		ContactMethodType contactMethodType = contactMethodTypesService.getContactMethodTypeById(id);
		if (contactMethodType == null) {
			logger.info("No contact method type found with ID: {0}", id);
		}
		return contactMethodType;
	}

	@GetMapping()
	public RecordsPage<ContactMethodType> getContactMethodTypes(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "contactMethodType") String sortBy) {
		return contactMethodTypesService.getContactMethodTypes(pageNo, pageSize, sortOrder, sortBy);
	}
}
