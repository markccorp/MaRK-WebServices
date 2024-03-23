package in.co.mark.webservices.iam.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.mark.webservices.iam.persistence.entities.OrganizationEObj;

@Repository
public interface OrganizationsRepository extends JpaRepository<OrganizationEObj, Long> {

}
