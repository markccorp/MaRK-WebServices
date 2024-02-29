package in.co.mark.webservices.contacts.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.NameSuffix;
import in.co.mark.webservices.contacts.gateway.dto.CreateNameSuffixRequest;
import in.co.mark.webservices.contacts.gateway.dto.CreateNameSuffixResponse;

public interface NameSuffixesService {
	/**
	 * To create a new name suffix
	 * 
	 * @param reqDto Request DTO for creating a new name suffix
	 * @return Response DTO on successful creation of the name suffix
	 */
	public CreateNameSuffixResponse createNameSuffix(CreateNameSuffixRequest reqDto);

	/**
	 * To get a name suffix by ID
	 * 
	 * @param id ID of a name suffix to get its details
	 * @return A {@link NameSuffix}, if found for the given {@code id}; otherwise,
	 *         {@code null}
	 */
	public NameSuffix getNameSuffixById(int id);

	/**
	 * To get a paginated list of name suffixes
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of name suffix entities
	 */
	public RecordsPage<NameSuffix> getNameSuffixes(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of name suffixes from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of name suffix entities
	 */
	public RecordsPage<NameSuffix> getNameSuffixes(int pageNo, int pageSize, int sortOrder, String... sortByProperties);
}
