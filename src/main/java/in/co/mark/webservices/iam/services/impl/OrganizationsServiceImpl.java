package in.co.mark.webservices.iam.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.iam.domain.model.Organization;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.modelmapper.OrganizationEntityMapper;
import in.co.mark.webservices.iam.persistence.OrganizationsDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.OrganizationEObj;
import in.co.mark.webservices.iam.services.OrganizationsService;
import in.co.mark.webservices.iam.services.UsersService;

@Service
public class OrganizationsServiceImpl implements OrganizationsService {
	private final OrganizationsDBAdapter dbAdapter;
	private final OrganizationEntityMapper modelEntityMapper;
	private final UsersService usersService;

	public OrganizationsServiceImpl(OrganizationsDBAdapter dbAdapter, OrganizationEntityMapper modelEntityMapper,
			UsersService usersService) {
		this.dbAdapter = dbAdapter;
		this.modelEntityMapper = modelEntityMapper;
		this.usersService = usersService;
	}

	@Override
	public Organization createOrganization(Organization reqObj) {
		Organization org = null;
		// Check if a valid SuperAdmin value is provided.
		// A positive value for SuperAdmin ID will avoid processing -1
		if (reqObj.getSuperAdminId() >= 0L) {
			User superAdminUser = usersService.getUserById(reqObj.getSuperAdminId());
			if (superAdminUser != null) {
				OrganizationEObj orgEObj = modelEntityMapper.mapToEntity(reqObj);
				org = modelEntityMapper.mapToModel(dbAdapter.createOrganization(orgEObj));

			}
		}

		return org;
	}

	@Override
	public Organization getOrganizationById(long id) {
		Organization org = null;
		OrganizationEObj orgEObj = dbAdapter.getOrganizationById(id);
		if (orgEObj != null) {
			org = modelEntityMapper.mapToModel(orgEObj);
		}

		return org;
	}

	@Override
	public RecordsPage<Organization> getOrganizations(int pageNo, int pageSize) {
		RecordsPage<OrganizationEObj> entityRecordsPage = dbAdapter.getOrganizations(pageNo, pageSize);
		ModelEntityRecordsPageMapper<Organization, OrganizationEObj> merpMapper = new ModelEntityRecordsPageMapper<Organization, OrganizationEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<Organization> getOrganizations(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		RecordsPage<OrganizationEObj> entityRecordsPage = dbAdapter.getOrganizations(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<Organization, OrganizationEObj> merpMapper = new ModelEntityRecordsPageMapper<Organization, OrganizationEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
