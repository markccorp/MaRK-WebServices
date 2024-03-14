package in.co.mark.webservices.contacts.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.mark.webservices.contacts.persistence.entities.MaritalStatusEObj;

@Repository
public interface MaritalStatusesRepository extends JpaRepository<MaritalStatusEObj, Long> {

}
