package in.co.mark.webservices.iam.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.co.mark.webservices.iam.persistence.entities.OrgUserEObj;
import in.co.mark.webservices.iam.persistence.entities.OrgUserIdentifier;

/**
 * @author Rakesh Kumar
 **/
@Repository
public interface OrgUsersRepository extends JpaRepository<OrgUserEObj, OrgUserIdentifier> {
	OrgUserEObj findByOrgUserId(OrgUserIdentifier orgUserId);

	default OrgUserEObj findByOrgUserId(long orgId, long userId) {
		return findByOrgUserId(new OrgUserIdentifier(orgId, userId));
	}

	@Query("SELECT ou FROM OrgUserEObj ou JOIN FETCH ou.user WHERE ou.organization.id = :orgId")
	List<OrgUserEObj> findUsersByOrganizationWithUser(@Param("orgId") Long orgId);

	@Query("SELECT ou FROM OrgUserEObj ou JOIN FETCH ou.organization WHERE ou.user.id = :userId")
	List<OrgUserEObj> findOrganizationsByUserWithOrganisation(@Param("userId") Long userId);

	// @Query("SELECT ou FROM OrgUser ou JOIN FETCH ou.userEObj WHERE ou.id.orgId =
	// :orgId")
	// List<OrgUserBasicProjection> findOrgUsersByOrgIdWithJoinFetch(Long orgId);

	// Page<> findAll(Pageable pageable);
}
