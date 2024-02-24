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
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.gateway.dto.CreateUserRequest;
import in.co.mark.webservices.iam.gateway.dto.CreateUserResponse;
import in.co.mark.webservices.iam.services.UsersService;

@RestController
@RequestMapping("api/users")
public class UsersAPIController {
	private static final Logger logger = LoggerFactory.getLogger(UsersAPIController.class);

	private UsersService usersService;

	public UsersAPIController(UsersService usersService) {
		this.usersService = usersService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public CreateUserResponse createUser(@RequestBody CreateUserRequest request) {
		CreateUserResponse response = usersService.createUser(request);
		logger.info("User created successfully with ID: {0}", response.id());
		return response;
	}

	@GetMapping(value = "/{id}")
	public User getUserById(@PathVariable long id) {
		User user = usersService.getUserById(id);
		if (user == null) {
			logger.info("No user found with ID: {0}", id);
		}
		return user;
	}

	@GetMapping()
	public RecordsPage<User> getUsers(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "displayName") String sortBy) {
		return usersService.getUsers(pageNo, pageSize, sortOrder, sortBy);
	}
}
