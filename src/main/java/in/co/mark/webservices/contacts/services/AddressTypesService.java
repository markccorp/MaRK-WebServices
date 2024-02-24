package in.co.mark.webservices.contacts.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.AddressType;
import in.co.mark.webservices.contacts.gateway.dto.CreateAddressTypeRequest;
import in.co.mark.webservices.contacts.gateway.dto.CreateAddressTypeResponse;

public interface AddressTypesService {
	/**
	 * To create a new address type
	 * 
	 * @param reqDto Request DTO for creating a new address type
	 * @return Response DTO on successful creation of the address type
	 */
	public CreateAddressTypeResponse createAddressType(CreateAddressTypeRequest reqDto);

	/**
	 * To get an address type by ID
	 * 
	 * @param id ID of an address type to get its details
	 * @return A {@link AddressType}, if found for the given {@code id}; otherwise,
	 *         {@code null}
	 */
	public AddressType getAddressTypeById(long id);

	/**
	 * To get a paginated list of address types
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of address-type entities
	 */
	public RecordsPage<AddressType> getAddressTypes(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of address types from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of address-type entities
	 */
	public RecordsPage<AddressType> getAddressTypes(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties);
}
