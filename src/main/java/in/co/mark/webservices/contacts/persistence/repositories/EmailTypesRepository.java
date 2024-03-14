package in.co.mark.webservices.contacts.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.mark.webservices.contacts.persistence.entities.EmailTypeEObj;

@Repository
public interface EmailTypesRepository extends JpaRepository<EmailTypeEObj, Long> {

}
