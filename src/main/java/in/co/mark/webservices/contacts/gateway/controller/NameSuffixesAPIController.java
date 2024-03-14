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
import in.co.mark.webservices.contacts.domain.model.NameSuffix;
import in.co.mark.webservices.contacts.services.NameSuffixesService;

@RestController
@RequestMapping("api/namesuffixes")
public class NameSuffixesAPIController {
	private static final Logger logger = LoggerFactory.getLogger(NameSuffixesAPIController.class);

	private NameSuffixesService nameSuffixesService;

	public NameSuffixesAPIController(NameSuffixesService nameSuffixesService) {
		this.nameSuffixesService = nameSuffixesService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public NameSuffix createNameSuffix(@RequestBody NameSuffix request) {
		NameSuffix response = nameSuffixesService.createNameSuffix(request);
		logger.info("Name suffix created successfully with ID: {0} for owner: {1}", response.getId(),
				response.getOwnerId());
		return response;
	}

	@GetMapping(value = "/{id}")
	public NameSuffix getNameSuffixById(@PathVariable long id) {
		NameSuffix nameSuffix = nameSuffixesService.getNameSuffixById(id);
		if (nameSuffix == null) {
			logger.info("No name-suffix found with ID: {0}", id);
		}
		return nameSuffix;
	}

	@GetMapping()
	public RecordsPage<NameSuffix> getNameSuffixes(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "nameSuffix") String sortBy) {
		return nameSuffixesService.getNameSuffixes(pageNo, pageSize, sortOrder, sortBy);
	}
}
