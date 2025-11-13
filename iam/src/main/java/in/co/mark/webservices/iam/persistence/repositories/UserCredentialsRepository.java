package in.co.mark.webservices.iam.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.mark.webservices.iam.persistence.entities.UserCredentialEObj;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentialEObj, Long> {

}
