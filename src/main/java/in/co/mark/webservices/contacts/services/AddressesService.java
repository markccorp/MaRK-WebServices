package in.co.mark.webservices.contacts.services;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.webservices.contacts.domain.model.Address;
import in.co.mark.webservices.contacts.gateway.dto.CreateAddressRequest;
import in.co.mark.webservices.contacts.gateway.dto.CreateAddressResponse;

public interface AddressesService {
	/**
	 * To create a new address
	 * 
	 * @param reqDto Request DTO for creating a new address
	 * @return Response DTO on successful creation of the address
	 */
	public CreateAddressResponse createAddress(CreateAddressRequest reqDto);

	/**
	 * To get an address by ID
	 * 
	 * @param id ID of an address to get its details
	 * @return A {@link Address}, if found for the given {@code id}; otherwise,
	 *         {@code null}
	 */
	public Address getAddressById(long id);

	/**
	 * To get a paginated list of addresses
	 * 
	 * @param pageNo   Current page number
	 * @param pageSize Size of the records per page
	 * @return A {@link RecordsPage} containing list of address entities
	 */
	public RecordsPage<Address> getAddresses(int pageNo, int pageSize);

	/**
	 * To get a paginated and sorted list of addresses from DB
	 * 
	 * @param pageNo           Current page number
	 * @param pageSize         Size of the records per page
	 * @param sortOrder        Set to 0 for sorting in descending order; otherwise,
	 *                         it sorts in ascending order
	 * @param sortByProperties Column names to the sort the records. It must not be
	 *                         {@code null}
	 * @return A {@link RecordsPage} containing list of address entities
	 */
	public RecordsPage<Address> getAddresses(int pageNo, int pageSize, int sortOrder, String... sortByProperties);
}
