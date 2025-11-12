package in.co.mark.webservices.iam.gateway.controller;

import java.security.InvalidParameterException;

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
import in.co.mark.webservices.iam.domain.model.Organization;
import in.co.mark.webservices.iam.services.OrganizationsService;

@RestController
@RequestMapping("api/organizations")
public class OrganizationsAPIController {
	private static final Logger logger = LoggerFactory.getLogger(OrganizationsAPIController.class);

	private final OrganizationsService orgService;

	public OrganizationsAPIController(OrganizationsService orgService) {
		this.orgService = orgService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Organization createOrganization(@RequestBody Organization request) {
		// TODO: Set the current user as SuperAdmin of the Org being created.
		// For now, use the one provided in the request object.
		Organization org = null;
		try {
			org = orgService.createOrganization(request);
		} catch (InvalidParameterException e) {
			logger.error("Error occurred while creating organization: {}", e.getMessage());
		}
		return org;
	}

	@GetMapping(value = "/{id}")
	public Organization getOrganizationById(@PathVariable long id) {
		Organization org = orgService.getOrganizationById(id);
		if (org == null) {
			logger.info("No organization found with ID: {}", id);
		}
		return org;
	}

	@GetMapping()
	public RecordsPage<Organization> getOrganizations(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "orgName") String sortBy) {
		return orgService.getOrganizations(pageNo, pageSize, sortOrder, sortBy);
	}
}
