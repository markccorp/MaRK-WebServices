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
import in.co.mark.webservices.contacts.domain.model.NamePrefix;
import in.co.mark.webservices.contacts.services.NamePrefixesService;

@RestController
@RequestMapping("api/nameprefixes")
public class NamePrefixesAPIController {
	private static final Logger logger = LoggerFactory.getLogger(NamePrefixesAPIController.class);

	private NamePrefixesService namePrefixesService;

	public NamePrefixesAPIController(NamePrefixesService namePrefixesService) {
		this.namePrefixesService = namePrefixesService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public NamePrefix createNamePrefix(@RequestBody NamePrefix request) {
		NamePrefix namePrefix = namePrefixesService.createNamePrefix(request);
		logger.info("Name prefix created successfully with ID: {0} for owner: {1}", namePrefix.getId(),
				namePrefix.getOwnerId());
		return namePrefix;
	}

	@GetMapping(value = "/{id}")
	public NamePrefix getNamePrefixById(@PathVariable long id) {
		NamePrefix namePrefix = namePrefixesService.getNamePrefixById(id);
		if (namePrefix == null) {
			logger.info("No name prefix found with ID: {0}", id);
		}
		return namePrefix;
	}

	@GetMapping()
	public RecordsPage<NamePrefix> getNamePrefixes(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "namePrefix") String sortBy) {
		return namePrefixesService.getNamePrefixes(pageNo, pageSize, sortOrder, sortBy);
	}
}
