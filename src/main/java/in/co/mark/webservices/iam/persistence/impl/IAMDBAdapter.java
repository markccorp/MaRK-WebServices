package in.co.mark.webservices.iam.persistence.impl;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.impl.RecordsPageImpl;
import in.co.mark.webservices.iam.persistence.OrganizationsDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.OrganizationEObj;
import in.co.mark.webservices.iam.persistence.repositories.OrganizationsRepository;

@Component
public class IAMDBAdapter implements OrganizationsDBAdapter {
	private final OrganizationsRepository orgRepo;

	public IAMDBAdapter(OrganizationsRepository orgRepo) {
		this.orgRepo = orgRepo;
	}

	@Override
	public OrganizationEObj createOrganization(OrganizationEObj orgEObj) {
		return orgRepo.save(orgEObj);
	}

	@Override
	public OrganizationEObj getOrganizationById(long id) {
		Optional<OrganizationEObj> optionalOrgEObj = orgRepo.findById(id);
		return optionalOrgEObj.orElse(null);
	}

	@Override
	public RecordsPage<OrganizationEObj> getOrganizations(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Slice<OrganizationEObj> slicedResult = orgRepo.findAll(paging);
		return new RecordsPageImpl<OrganizationEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<OrganizationEObj> getOrganizations(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<OrganizationEObj> slicedResult = orgRepo.findAll(paging);
		return new RecordsPageImpl<OrganizationEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}
}
