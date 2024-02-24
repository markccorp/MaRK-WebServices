package in.co.mark.webservices.iam.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.co.mark.webservices.iam.persistence.entities.UserEObj;

@Repository
public interface UsersRepository extends JpaRepository<UserEObj, Long> {
	UserEObj findByEmail(String email);
}
