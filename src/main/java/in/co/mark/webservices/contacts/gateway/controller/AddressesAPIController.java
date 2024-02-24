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
import in.co.mark.webservices.contacts.domain.model.Address;
import in.co.mark.webservices.contacts.gateway.dto.CreateAddressRequest;
import in.co.mark.webservices.contacts.gateway.dto.CreateAddressResponse;
import in.co.mark.webservices.contacts.services.AddressesService;

@RestController
@RequestMapping("api/addresses")
public class AddressesAPIController {
	private static final Logger logger = LoggerFactory.getLogger(AddressesAPIController.class);

	private AddressesService addressesService;

	public AddressesAPIController(AddressesService addressesService) {
		this.addressesService = addressesService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public CreateAddressResponse createAddress(@RequestBody CreateAddressRequest request) {
		CreateAddressResponse response = addressesService.createAddress(request);
		logger.info("Address created successfully with ID: {0}", response.id());
		return response;
	}

	@GetMapping(value = "/{id}")
	public Address getAddressById(@PathVariable long id) {
		Address address = addressesService.getAddressById(id);
		if (address == null) {
			logger.info("No address found with ID: {0}", id);
		}
		return address;
	}

	@GetMapping()
	public RecordsPage<Address> getAddresses(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "city") String sortBy) {
		return addressesService.getAddresses(pageNo, pageSize, sortOrder, sortBy);
	}
}
