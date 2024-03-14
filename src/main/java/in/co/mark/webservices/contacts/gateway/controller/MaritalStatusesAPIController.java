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
import in.co.mark.webservices.contacts.domain.model.MaritalStatus;
import in.co.mark.webservices.contacts.services.MaritalStatusesService;

@RestController
@RequestMapping("api/maritalstatuses")
public class MaritalStatusesAPIController {
	private static final Logger logger = LoggerFactory.getLogger(MaritalStatusesAPIController.class);

	private MaritalStatusesService maritalStatusesService;

	public MaritalStatusesAPIController(MaritalStatusesService maritalStatusesService) {
		this.maritalStatusesService = maritalStatusesService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public MaritalStatus createMaritalStatus(@RequestBody MaritalStatus request) {
		MaritalStatus maritalStatus = maritalStatusesService.createMaritalStatus(request);
		logger.info("Marital status created successfully with ID: {0} for owner: {1}", maritalStatus.getId(),
				maritalStatus.getOwnerId());
		return maritalStatus;
	}

	@GetMapping(value = "/{id}")
	public MaritalStatus getMaritalStatusById(@PathVariable long id) {
		MaritalStatus maritalStatus = maritalStatusesService.getMaritalStatusById(id);
		if (maritalStatus == null) {
			logger.info("No marital status found with ID: {0}", id);
		}
		return maritalStatus;
	}

	@GetMapping()
	public RecordsPage<MaritalStatus> getMaritalStatuses(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "maritalStatus") String sortBy) {
		return maritalStatusesService.getMaritalStatuses(pageNo, pageSize, sortOrder, sortBy);
	}
}
