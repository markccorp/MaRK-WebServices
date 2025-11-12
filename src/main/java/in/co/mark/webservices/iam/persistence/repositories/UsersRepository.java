package in.co.mark.webservices.iam.persistence.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.persistence.entities.projections.UserSummary;

@Repository
public interface UsersRepository extends JpaRepository<UserEObj, Long> {
	@Query("SELECT u.id AS id, u.username AS username, u.email AS email, u.firstName AS firstName, u.lastName AS lastName"
			+ ", u.displayName AS displayname, u.avatarUri AS avatarUri FROM UserEObj u WHERE u.id = ?1")
	Optional<UserSummary> getUserSummaryById(long id);

	@Query("SELECT u.id AS id, u.username AS username, u.email AS email, u.firstName AS firstName, u.lastName AS lastName"
			+ ", u.displayName AS displayname, u.avatarUri AS avatarUri FROM UserEObj u WHERE u.email = ?1")
	Optional<UserSummary> getUserSummaryByEmail(String email);

	@Query("SELECT u.id AS id, u.username AS username, u.email AS email, u.firstName AS firstName, u.lastName AS lastName"
			+ ", u.displayName AS displayname, u.avatarUri AS avatarUri FROM UserEObj u")
	Page<UserSummary> getUsersSummary(Pageable pageable);
}
