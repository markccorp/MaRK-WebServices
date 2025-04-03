package in.co.mark.webservices.iam.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.co.mark.webservices.iam.persistence.entities.UserCredentialEObj;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentialEObj, Long> {
	UserCredentialEObj findByUsername(String username);

	@Modifying
	@Query("UPDATE user_credentials uc SET uc.password = :password WHERE uc.id = :id")
	void updateLoginPassword(@Param(value = "id") long id, @Param(value = "password") String password);
}
