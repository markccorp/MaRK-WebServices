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
import in.co.mark.webservices.contacts.domain.model.EmailType;
import in.co.mark.webservices.contacts.services.EmailTypesService;

@RestController
@RequestMapping("api/emailtypes")
public class EmailTypesAPIController {
	private static final Logger logger = LoggerFactory.getLogger(EmailTypesAPIController.class);

	private EmailTypesService emailTypesService;

	public EmailTypesAPIController(EmailTypesService emailTypesService) {
		this.emailTypesService = emailTypesService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public EmailType createEmailType(@RequestBody EmailType request) {
		EmailType emailType = emailTypesService.createEmailType(request);
		logger.info("Email type created successfully with ID: {0} for owner: {1}", emailType.getId(),
				emailType.getOwnerId());
		return emailType;
	}

	@GetMapping(value = "/{id}")
	public EmailType getEmailTypeById(@PathVariable long id) {
		EmailType emailType = emailTypesService.getEmailTypeById(id);
		if (emailType == null) {
			logger.info("No email type found with ID: {0}", id);
		}
		return emailType;
	}

	@GetMapping()
	public RecordsPage<EmailType> getEmailTypes(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "emailType") String sortBy) {
		return emailTypesService.getEmailTypes(pageNo, pageSize, sortOrder, sortBy);
	}
}
