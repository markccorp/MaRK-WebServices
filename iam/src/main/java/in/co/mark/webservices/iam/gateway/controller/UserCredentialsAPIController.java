package in.co.mark.webservices.iam.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.co.mark.common.exceptions.ResourceNotFoundException;
import in.co.mark.common.persistence.util.EntityActiveStatus;
import in.co.mark.webservices.iam.domain.model.UserCredential;
import in.co.mark.webservices.iam.services.UserCredentialsService;

@RestController
@RequestMapping("api/users/{id}/credentials")
public class UserCredentialsAPIController {
	private static final Logger logger = LoggerFactory.getLogger(UserCredentialsAPIController.class);

	private final UserCredentialsService userCredService;

	public UserCredentialsAPIController(UserCredentialsService userCredService) {
		this.userCredService = userCredService;
	}

	@PatchMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> updateUserCredential(@PathVariable("id") long credId,
			@RequestBody UserCredential request) {
		try {
			userCredService.updateUserCredential(credId, request.getPassword(), EntityActiveStatus.Active);
			return ResponseEntity.ok("Success");
		} catch (ResourceNotFoundException e) {
			logger.error("No credential found for ID: {}.", credId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Credential not found");
		}
	}
}
