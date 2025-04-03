package in.co.mark.webservices.iam.persistence.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * {@code Embeddable} identifier class for Org-User mapping
 * 
 * @author Rakesh Kumar
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrgUserIdentifier implements Serializable {
	@Getter
	@Setter
	@Column(name = "org_id")
	private long orgId;

	@Getter
	@Setter
	@Column(name = "user_id")
	private long userId;

	@Override
	public int hashCode() {
		return Objects.hash(orgId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		OrgUserIdentifier other = (OrgUserIdentifier) obj;
		if (orgId != other.orgId || userId != other.userId) {
			return false;
		}

		return true;
	}
}
