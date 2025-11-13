package in.co.mark.webservices.iam.services.impl;

import java.security.InvalidParameterException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.iam.domain.model.Organization;
import in.co.mark.webservices.iam.modelmapper.OrganizationEntityMapper;
import in.co.mark.webservices.iam.persistence.OrganizationsDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.OrganizationEObj;
import in.co.mark.webservices.iam.services.OrganizationsService;
import in.co.mark.webservices.iam.services.UsersService;

@Service
public class OrganizationsServiceImpl implements OrganizationsService {
	private static final Logger logger = LoggerFactory.getLogger(OrganizationsServiceImpl.class);

	private final OrganizationsDBAdapter orgsDBAdapter;
	private final OrganizationEntityMapper modelEntityMapper;
	private final UsersService usersService;

	public OrganizationsServiceImpl(OrganizationsDBAdapter orgsDBAdapter, OrganizationEntityMapper modelEntityMapper,
			UsersService usersService) {
		this.orgsDBAdapter = orgsDBAdapter;
		this.modelEntityMapper = modelEntityMapper;
		this.usersService = usersService;
	}

	@Override
	public boolean existsById(long id) {
		return orgsDBAdapter.existsById(id);
	}

	@Override
	public Organization createOrganization(Organization reqObj) {
		Organization org = null;
		// Check if a valid SuperAdmin value is provided.
		if (reqObj.getSuperAdminId() > 0L) { // Greater than 0 will avoid processing for -1
			if (usersService.existsById(reqObj.getSuperAdminId())) {
				OrganizationEObj orgEObj = modelEntityMapper.mapToEntity(reqObj);
				org = modelEntityMapper.mapToModel(orgsDBAdapter.createOrganization(orgEObj));
				logger.info("Organization created with ID: {}, SuperAdmin: {}", org.getId(), org.getSuperAdminId());
			} else {
				throw new InvalidParameterException("Invalid Super Admin ID");
			}
		}

		return org;
	}

	@Override
	public Organization getOrganizationById(long id) {
		Organization org = null;
		OrganizationEObj orgEObj = orgsDBAdapter.getOrganizationById(id);
		if (orgEObj != null) {
			org = modelEntityMapper.mapToModel(orgEObj);
		}

		return org;
	}

	@Override
	public RecordsPage<Organization> getOrganizations(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		RecordsPage<OrganizationEObj> entityRecordsPage = orgsDBAdapter.getOrganizations(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<Organization, OrganizationEObj> merpMapper = new ModelEntityRecordsPageMapper<Organization, OrganizationEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
