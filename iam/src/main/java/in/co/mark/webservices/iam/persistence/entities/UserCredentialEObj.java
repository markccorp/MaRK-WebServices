package in.co.mark.webservices.iam.persistence.entities;

import in.co.mark.common.persistence.EntityBase;
import in.co.mark.common.persistence.util.EntityActiveStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a <i>User Credential</i> entity which contains user password.
 * 
 * @author Rakesh Kumar
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_credentials")
public class UserCredentialEObj extends EntityBase {
	/**
	 * <i>Primary key</i> of this entity. It is also a <i>Reference key</i>
	 * referring to the {@code id} property of {@link UserEObj}.
	 */
	@Getter
	@Setter
	@Id
	private long id;

	@Getter
	@Setter
	@Column(name = "password", nullable = false)
	private String password;

	@Getter
	@Setter
	@Column(name = "status")
	private EntityActiveStatus status;

	@Getter
	@Setter
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private UserEObj userEObj;
}
