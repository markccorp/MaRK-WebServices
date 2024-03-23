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
import in.co.mark.webservices.contacts.domain.model.ContactMethodCategory;
import in.co.mark.webservices.contacts.services.ContactMethodCategoriesService;

@RestController
@RequestMapping("api/contactmethodcategories")
public class ContactMethodCategoriesAPIController {
	private static final Logger logger = LoggerFactory.getLogger(ContactMethodCategoriesAPIController.class);

	private ContactMethodCategoriesService contactMethodCategoriesService;

	public ContactMethodCategoriesAPIController(ContactMethodCategoriesService contactMethodCategoriesService) {
		this.contactMethodCategoriesService = contactMethodCategoriesService;
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ContactMethodCategory createContactMethodCategory(@RequestBody ContactMethodCategory request) {
		ContactMethodCategory contactMethodCategory = contactMethodCategoriesService
				.createContactMethodCategory(request);
		logger.info("Contact method category created successfully with ID: {0} for owner: {1}",
				contactMethodCategory.getId(), contactMethodCategory.getOwnerId());
		return contactMethodCategory;
	}

	@GetMapping(value = "/{id}")
	public ContactMethodCategory getContactMethodCategoryById(@PathVariable long id) {
		ContactMethodCategory contactMethodCategory = contactMethodCategoriesService.getContactMethodCategoryById(id);
		if (contactMethodCategory == null) {
			logger.info("No contact method category found with ID: {0}", id);
		}
		return contactMethodCategory;
	}

	@GetMapping()
	public RecordsPage<ContactMethodCategory> getContactMethodCategories(
			@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "1") Integer sortOrder,
			@RequestParam(defaultValue = "categoryName") String sortBy) {
		return contactMethodCategoriesService.getContactMethodCategories(pageNo, pageSize, sortOrder, sortBy);
	}
}
