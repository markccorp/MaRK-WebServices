package in.co.mark.webservices.iam.persistence.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.co.mark.webservices.iam.persistence.entities.OrganizationEObj;

@Repository
public interface OrganizationsRepository extends JpaRepository<OrganizationEObj, Long> {
	@Query("SELECT o FROM OrganizationEObj o WHERE o.id = ?1")
	Optional<OrganizationEObj> getOrganizationById(long id);
}
