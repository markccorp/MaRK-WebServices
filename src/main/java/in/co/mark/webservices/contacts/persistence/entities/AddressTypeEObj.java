package in.co.mark.webservices.contacts.persistence.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "address_types")
public class AddressTypeEObj {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Getter
	@Setter
	@Column(name = "type", nullable = false)
	private String type;

	@Getter
	@Setter
	@Column(name = "description")
	private String desc;

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
