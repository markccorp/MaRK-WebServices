package in.co.mark.webservices.contacts.persistence.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "addresses")
public class AddressEObj {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AddressIdSequence")
	@SequenceGenerator(name = "AddressIdSequence", sequenceName = "AddressIdSequence")
	private long id;

	@Getter
	@Setter
	@Column(name = "address_line_one")
	private String addressLineOne;
	@Getter
	@Setter
	@Column(name = "address_line_two")
	private String addressLineTwo;
	@Getter
	@Setter
	private String locality;
	@Getter
	@Setter
	private String city;
	@Getter
	@Setter
	private String state;
	@Getter
	@Setter
	@Column(name = "country_code")
	private long countryCode;
	@Getter
	@Setter
	@Column(name = "postal_code")
	private String postalCode;
	@Getter
	@Setter
	@Column(name = "created_on")
	private long createdOn;
	@Getter
	@Setter
	@Column(name = "last_updated_on")
	private long lastUpdatedOn;

	@PrePersist
	public void prePersist() {
		long currTimeMilli = Instant.now().toEpochMilli();
		createdOn = currTimeMilli;
		lastUpdatedOn = currTimeMilli;
	}

	@PreUpdate
	public void preUpdate() {
		lastUpdatedOn = Instant.now().toEpochMilli();
	}
}
