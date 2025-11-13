package in.co.mark.webservices.contacts.gateway.dto;

public record CreateAddressRequest(String addressLineOne, String addressLineTwo, String locality, String city,
		String state, long countryCode, String postalCode) {
}
