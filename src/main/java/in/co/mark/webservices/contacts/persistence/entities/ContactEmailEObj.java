package in.co.mark.webservices.contacts.persistence.entities;

import in.co.mark.common.persistence.OwnerEntityBase;
import in.co.mark.common.persistence.util.EntityActiveStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "contact_emails")
public class ContactEmailEObj extends OwnerEntityBase {
	/**
	 * The <i>primary key</i> of this entity. It will be auto-generated by the DB
	 * system on successful creation of the respective record.
	 */
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ContactEmailIdSequence")
	@SequenceGenerator(name = "ContactEmailIdSequence", sequenceName = "ContactEmailIdSequence")
	private long id;

	@Getter
	@Setter
	@Column(name = "email_type_id")
	private long emailTypeId;

	@Getter
	@Setter
	@Column(name = "email_address")
	private String emailAddress;

	@Getter
	@Setter
	@Column(name = "status")
	private EntityActiveStatus Status;
}
