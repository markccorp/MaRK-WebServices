package in.co.mark.webservices.iam.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
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

	// @Query("SELECT ou FROM OrgUser ou JOIN FETCH ou.userEObj WHERE ou.id.orgId =
	// :orgId")
	// List<OrgUserBasicProjection> findOrgUsersByOrgIdWithJoinFetch(Long orgId);

	// Page<> findAll(Pageable pageable);
}
