package in.co.mark.webservices.iam.gateway.controller;

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
import in.co.mark.webservices.iam.domain.model.OrgUser;
import in.co.mark.webservices.iam.gateway.dto.OrgUserRequestDTO;
import in.co.mark.webservices.iam.gateway.dto.OrgUserResponseDTO;
import in.co.mark.webservices.iam.services.OrgUsersService;

/**
 * @author Rakesh Kumar
 */
@RestController
@RequestMapping("api/organizations/{id}/users")
public class OrgUsersAPIController {
	private static final Logger logger = LoggerFactory.getLogger(OrgUsersAPIController.class);

	private OrgUsersService orgUserService;

	public OrgUsersAPIController(OrgUsersService orgUserService) {
		this.orgUserService = orgUserService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public OrgUserResponseDTO addUser(@PathVariable("id") long orgId, @RequestBody OrgUserRequestDTO request)
			throws Exception {
		if (orgId <= 0) {
			throw new Exception("Invalid OrgId for adding Org-user");
		}
		if (request.getOrgId() <= 0) {
			request.setOrgId(orgId);
		} else if (request.getOrgId() != orgId) {
			throw new Exception("Invalid OrgId specified for adding user");
		}

		OrgUserResponseDTO response = orgUserService.createOrgUser(request);
		logger.info("Org-user with OrgId: {}, UserId: {} created successfully", response.getOrgId(),
				response.getUserId());
		return response;
	}

	@GetMapping()
	public RecordsPage<OrgUser> getOrgUsers(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "displayName") String sortBy) {
		return orgUserService.getOrgUsers(pageNo, pageSize);
	}
}
