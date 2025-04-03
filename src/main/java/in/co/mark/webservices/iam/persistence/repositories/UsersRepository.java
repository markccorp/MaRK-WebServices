package in.co.mark.webservices.iam.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.persistence.entities.projections.UserBasicProjection;
import in.co.mark.webservices.iam.persistence.entities.projections.UserProjection;

@Repository
public interface UsersRepository extends JpaRepository<UserEObj, Long> {
	UserEObj findByEmail(String email);

	@Query("SELECT u.id AS id, uc.username AS username, u.email AS email, u.initial AS initial, u.firstName AS firstName, u.middleName AS middleName, u.lastName AS lastName, u.displayName AS displayName, u.gender AS gender, u.dobDate AS dobDate, u.dobMonth AS dobMonth, u.dobYear AS dobYear, u.avatarUri AS avatarUri, u.createdOn AS createdOn, u.lastUpdatedOn AS lastUpdatedOn FROM users u LEFT JOIN user_credentials uc ON u.id = uc.id")
	List<UserProjection> findAllUsers();

	@Query("SELECT u.id AS id, uc.username AS username, u.email AS email, u.initial AS initial, u.firstName AS firstName, u.middleName AS middleName, u.lastName AS lastName, u.displayName AS displayName, u.createdOn AS createdOn, u.lastUpdatedOn AS lastUpdatedOn FROM users u LEFT JOIN user_credentials uc ON u.id = uc.id")
	List<UserBasicProjection> findAllUsersBasicInfo();
}
