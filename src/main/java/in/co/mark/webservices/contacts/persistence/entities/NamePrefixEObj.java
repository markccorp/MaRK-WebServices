package in.co.mark.webservices.contacts.persistence.entities;

import in.co.mark.common.persistence.UserSpecificEntity;
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
@Entity(name = "name_prefixes")
public class NamePrefixEObj extends UserSpecificEntity {
	/**
	 * The <i>primary key</i> of this entity. It will be auto-generated by the DB
	 * system on successful creation of the respective record.
	 */
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;

	@Getter
	@Setter
	@Column(name = "name_prefix")
	private String namePrefix;

	@Getter
	@Setter
	@Column(name = "description")
	private String desc;
}