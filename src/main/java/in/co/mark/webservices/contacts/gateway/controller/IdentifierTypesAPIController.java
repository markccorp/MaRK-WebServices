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
import in.co.mark.webservices.contacts.domain.model.IdentifierType;
import in.co.mark.webservices.contacts.services.IdentifierTypesService;

@RestController
@RequestMapping("api/identifiertypes")
public class IdentifierTypesAPIController {
	private static final Logger logger = LoggerFactory.getLogger(IdentifierTypesAPIController.class);

	private IdentifierTypesService identifierTypesService;

	public IdentifierTypesAPIController(IdentifierTypesService identifierTypesService) {
		this.identifierTypesService = identifierTypesService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public IdentifierType createIdentifierType(@RequestBody IdentifierType request) {
		IdentifierType identifierType = identifierTypesService.createIdentifierType(request);
		logger.info("Identifier type created successfully with ID: {0} for owner: {1}", identifierType.getId(),
				identifierType.getOwnerId());
		return identifierType;
	}

	@GetMapping(value = "/{id}")
	public IdentifierType getIdentifierTypeById(@PathVariable long id) {
		IdentifierType identifierType = identifierTypesService.getIdentifierTypeById(id);
		if (identifierType == null) {
			logger.info("No identifier type found with ID: {0}", id);
		}
		return identifierType;
	}

	@GetMapping()
	public RecordsPage<IdentifierType> getIdentifierTypes(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "identifierType") String sortBy) {
		return identifierTypesService.getIdentifierTypes(pageNo, pageSize, sortOrder, sortBy);
	}
}
