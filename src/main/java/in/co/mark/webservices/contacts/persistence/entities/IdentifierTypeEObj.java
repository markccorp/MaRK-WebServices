package in.co.mark.webservices.contacts.persistence.entities;

import in.co.mark.common.persistence.OwnerSpecificEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "identifier_types")
public class IdentifierTypeEObj extends OwnerSpecificEntityBase {
	/**
	 * The <i>primary key</i> of this entity. It will be auto-generated by the DB
	 * system on successful creation of the respective record.
	 */
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Getter
	@Setter
	@Column(name = "identifier_type")
	private String identifierType;

	@Getter
	@Setter
	@Column(name = "description")
	private String desc;
}