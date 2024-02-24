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
import in.co.mark.webservices.contacts.domain.model.AddressType;
import in.co.mark.webservices.contacts.gateway.dto.CreateAddressTypeRequest;
import in.co.mark.webservices.contacts.gateway.dto.CreateAddressTypeResponse;
import in.co.mark.webservices.contacts.services.AddressTypesService;

@RestController
@RequestMapping("api/addresstypes")
public class AddressTypesAPIController {
	private static final Logger logger = LoggerFactory.getLogger(AddressTypesAPIController.class);

	private AddressTypesService addressTypesService;

	public AddressTypesAPIController(AddressTypesService addressTypesService) {
		this.addressTypesService = addressTypesService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public CreateAddressTypeResponse createAddressType(@RequestBody CreateAddressTypeRequest request) {
		CreateAddressTypeResponse response = addressTypesService.createAddressType(request);
		logger.info("Address-type created successfully with ID: {0}", response.id());
		return response;
	}

	@GetMapping(value = "/{id}")
	public AddressType getAddressTypeById(@PathVariable long id) {
		AddressType addressType = addressTypesService.getAddressTypeById(id);
		if (addressType == null) {
			logger.info("No address-type found with ID: {0}", id);
		}
		return addressType;
	}

	@GetMapping()
	public RecordsPage<AddressType> getAddressTypes(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "type") String sortBy) {
		return addressTypesService.getAddressTypes(pageNo, pageSize, sortOrder, sortBy);
	}
}
