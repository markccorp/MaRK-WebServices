package in.co.mark.webservices.iam.persistence.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.impl.RecordsPageImpl;
import in.co.mark.webservices.iam.persistence.OrgUsersDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.OrgUserEObj;
import in.co.mark.webservices.iam.persistence.repositories.OrgUsersRepository;

/**
 * @author Rakesh Kumar
 */
@Component
public class OrgUsersDBAdapterImpl implements OrgUsersDBAdapter {
	private final OrgUsersRepository orgUsersRepo;

	public OrgUsersDBAdapterImpl(OrgUsersRepository orgUsersRepo) {
		this.orgUsersRepo = orgUsersRepo;
	}

	@Override
	public OrgUserEObj addOrgUser(OrgUserEObj orgUserEObj) {
		return orgUsersRepo.save(orgUserEObj);
	}

	@Override
	public OrgUserEObj getOrgUser(long orgId, long userId) {
		return orgUsersRepo.findByOrgUserId(orgId, userId);
	}

	@Override
	public RecordsPage<OrgUserEObj> getOrgUsers(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Slice<OrgUserEObj> slicedResult = orgUsersRepo.findAll(paging);
		return new RecordsPageImpl<OrgUserEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<OrgUserEObj> getOrgUsers(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<OrgUserEObj> slicedResult = orgUsersRepo.findAll(paging);
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
