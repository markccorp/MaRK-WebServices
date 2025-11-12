package in.co.mark.webservices.iam.persistence.impl;

import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.impl.RecordsPageImpl;
import in.co.mark.webservices.iam.persistence.OrgUsersDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.OrgUserEObj;
import in.co.mark.webservices.iam.persistence.entities.OrgUserIdentifier;
import in.co.mark.webservices.iam.persistence.entities.OrganizationEObj;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.persistence.repositories.OrgUsersRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

/**
 * @author Rakesh Kumar
 */
@Component
public class OrgUsersDBAdapterImpl implements OrgUsersDBAdapter {
	private final EntityManager entityManager;

	private final OrgUsersRepository orgUsersRepo;

	public OrgUsersDBAdapterImpl(EntityManager entityManager, OrgUsersRepository orgUsersRepo) {
		this.entityManager = entityManager;

		this.orgUsersRepo = orgUsersRepo;
	}

	@Override
	public boolean existsById(OrgUserIdentifier orgUserId) {
		return orgUsersRepo.existsById(orgUserId);
	}

	@Override
	@Transactional
	public void persist(OrgUserEObj orgUserEObj) {
		// Check and set OrganizationEObj reference object, if it is not already set
		if (orgUserEObj.getOrganizationEObj() == null) {
			OrganizationEObj orgRef = entityManager.getReference(OrganizationEObj.class, orgUserEObj.getOrgId());
			orgUserEObj.setOrganizationEObj(orgRef);
		}
		// Check and set UserEObj reference object, if it is not already set
		if (orgUserEObj.getUserEObj() == null) {
			UserEObj userRef = entityManager.getReference(UserEObj.class, orgUserEObj.getUserId());
			orgUserEObj.setUserEObj(userRef);
		}

		entityManager.persist(orgUserEObj);
	}

	@Override
	public OrgUserEObj getOrgUser(long orgId, long userId) {
		return orgUsersRepo.findByOrgUserId(orgId, userId);
	}

	@Override
	public RecordsPage<OrgUserEObj> getOrgUsers(long orgId, int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		// TODO: Get the paginated and sorted result
		// Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		// Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection,
		// sortByProperties);
		// Slice<OrgUserEObj> slicedResult = orgUsersRepo.findAll(paging);
		Slice<OrgUserEObj> slicedResult = orgUsersRepo.findUsersByOrganizationWithUser(orgId);
		return new RecordsPageImpl<OrgUserEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<OrgUserEObj> getUserOrgs(long userId, int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		// TODO Get the list of organizations the user is associated with
		return null;
	}
}
