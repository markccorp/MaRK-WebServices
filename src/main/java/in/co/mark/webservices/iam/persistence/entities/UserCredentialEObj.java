package in.co.mark.webservices.iam.persistence.entities;

import java.time.Instant;

import in.co.mark.webservices.iam.domain.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_credentials")
public class UserCredentialEObj {
	/**
	 * The <i>primary key</i> of this entity.<br/>
	 * It is actually ID of the respective {@link User}.
	 */
	@Getter
	@Setter
	@Id
	private long id;

	@Getter
	@Setter
	@Column(name = "username", nullable = false)
	private String username;

	@Getter
	@Setter
	@Column(name = "password")
	private String password;

	@Getter
	@Setter
	@Column(name = "created_on", nullable = false)
	private long createdOn;

	@Getter
	@Setter
	@Column(name = "last_updated_on", nullable = false)
	private long lastUpdatedOn;

	@Getter
	@Setter
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private UserEObj userEObj;

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
