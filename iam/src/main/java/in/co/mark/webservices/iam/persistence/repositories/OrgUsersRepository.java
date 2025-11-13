package in.co.mark.webservices.iam.persistence.repositories;

import java.util.List;

import org.springframework.data.domain.Slice;
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

	@Query("SELECT ou FROM OrgUserEObj ou WHERE ou.organizationEObj.id = :orgId")
	Slice<OrgUserEObj> findUsersByOrganizationWithUser(@Param("orgId") Long orgId);

	@Query("SELECT ou FROM OrgUserEObj ou JOIN FETCH ou.organizationEObj WHERE ou.userEObj.id = :userId")
	List<OrgUserEObj> findOrganizationsByUserWithOrganisation(@Param("userId") Long userId);
}
