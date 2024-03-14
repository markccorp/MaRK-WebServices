package in.co.mark.webservices.contacts.persistence.entities;

import java.time.Instant;

import in.co.mark.common.persistence.util.EntityActiveStatus;
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
@Entity(name = "contact_addresses")
public class ContactAddressEObj {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ContactAddressIdSequence")
	@SequenceGenerator(name = "ContactAddressIdSequence", sequenceName = "ContactAddressIdSequence")
	private long id;

	@Getter
	@Setter
	@Column(name = "contact_id", nullable = false)
	private long contactId;

	@Getter
	@Setter
	@Column(name = "address_id", nullable = false)
	private long addressId;

	@Getter
	@Setter
	@Column(name = "address_type_id", nullable = false)
	private long addressTypeId;

	/**
	 * Care-of part of the address. Usually it will be placed above the recipient
	 * line.
	 */
	@Getter
	@Setter
	@Column(name = "care_of")
	private String careOf;

	@Getter
	@Setter
	private EntityActiveStatus Status;

	@Getter
	@Setter
	@Column(name = "created_on", nullable = false)
	private long createdOn;

	@Getter
	@Setter
	@Column(name = "last_updated_on", nullable = false)
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
