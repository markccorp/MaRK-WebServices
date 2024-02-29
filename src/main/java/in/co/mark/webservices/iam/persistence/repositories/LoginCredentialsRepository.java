package in.co.mark.webservices.iam.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.co.mark.webservices.iam.persistence.entities.LoginCredentialEObj;

@Repository
public interface LoginCredentialsRepository extends JpaRepository<LoginCredentialEObj, Long> {
	LoginCredentialEObj findByUsername(String username);

	@Modifying
	@Query("UPDATE login_credentials lc SET lc.password = :password WHERE lc.id = :id")
	void updateLoginPassword(@Param(value = "id") long id, @Param(value = "password") String password);
}
