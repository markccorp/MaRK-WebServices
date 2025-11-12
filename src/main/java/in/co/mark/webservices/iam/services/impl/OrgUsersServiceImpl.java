package in.co.mark.webservices.iam.services.impl;

import java.security.InvalidParameterException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.iam.domain.model.OrgUser;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.modelmapper.OrgUserEntityMapper;
import in.co.mark.webservices.iam.persistence.OrgUsersDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.OrgUserEObj;
import in.co.mark.webservices.iam.persistence.entities.OrgUserIdentifier;
import in.co.mark.webservices.iam.services.OrgUsersService;
import in.co.mark.webservices.iam.services.OrganizationsService;
import in.co.mark.webservices.iam.services.UsersService;
import in.co.mark.webservices.iam.util.OrgUserRole;
import in.co.mark.webservices.iam.util.OrgUserStatus;
import jakarta.persistence.EntityNotFoundException;

/**
 * @author Rakesh Kumar
 */
@Service
public class OrgUsersServiceImpl implements OrgUsersService {
	private static final Logger logger = LoggerFactory.getLogger(OrgUsersServiceImpl.class);

	private final OrgUsersDBAdapter orgUserDBAdapter;
	private final OrgUserEntityMapper orgUserModelEntityMapper;

	private final OrganizationsService orgsService;
	private final UsersService usersService;

	public OrgUsersServiceImpl(OrgUsersDBAdapter orgUserDBAdapter, OrgUserEntityMapper orgUserModelEntityMapper,
			OrganizationsService orgsService, UsersService usersService) {
		this.orgUserDBAdapter = orgUserDBAdapter;
		this.orgUserModelEntityMapper = orgUserModelEntityMapper;

		this.orgsService = orgsService;
		this.usersService = usersService;

	}

	@Override
	public OrgUser addOrgUser(long orgId, OrgUser orgUser) {
		// Check if the Organization exists
		if (!orgsService.existsById(orgId)) {
			throw new EntityNotFoundException("No organization esists with ID: " + orgId);
		}

		OrgUserIdentifier orgUserId = null;

		long userId = orgUser.getId();
		if (userId > 0) {
			// Check if the user exists
			if (usersService.existsById(userId)) {
				// Check if the Organization-User mapping exists
				orgUserId = new OrgUserIdentifier(orgId, userId);
				if (orgUserDBAdapter.existsById(orgUserId)) {
					throw new IllegalStateException("An OrgUser mapping already exists");
				}
			} else {
				throw new EntityNotFoundException("No user exists with ID: " + userId);
			}
		} else if (StringUtils.hasText(orgUser.getEmail())) {
			// Check if a user with the specified email address exists
			User user = usersService.getUserSummaryByEmail(orgUser.getEmail());
			if (user == null) {
				// No user found by email, create one
				user = usersService.createUser(orgUser, null); // TODO: Handle OrgAdmin adding user with a password
			}
			userId = user.getId();
		} else {
			// Cannot create a user without a valid email address
			throw new InvalidParameterException("Missing mandatory values for creating user");
		}

		// Create and persist OrgUserEObj
		OrgUserEObj orgUserEObj = new OrgUserEObj();
		if (orgUserId == null) {
			orgUserId = new OrgUserIdentifier(orgId, userId);
		}
		orgUserEObj.setOrgUserId(orgUserId);
		if (orgUser.getOrgUserRole() == null) {
			orgUserEObj.setOrgUserRole(OrgUserRole.USER);
		}
		if (orgUser.getOrgUserStatus() == null) {
			orgUserEObj.setOrgUserStatus(OrgUserStatus.INVITED);
		}

		orgUserDBAdapter.persist(orgUserEObj);
		logger.info("Added Org-user: {}", orgUserId.toJson());

		orgUser.setUserId(userId); // Set userId for new user creation case handling
		return orgUser;
	}

	@Override
	public OrgUser getOrgUser(long orgId, long userId) {
		OrgUser orgUser = null;
		OrgUserEObj orgUserEObj = orgUserDBAdapter.getOrgUser(orgId, userId);
		if (orgUserEObj != null) {
			orgUser = orgUserModelEntityMapper.mapToModel(orgUserEObj);
		}

		return orgUser;
	}

	@Override
	public RecordsPage<OrgUser> getOrgUsers(long orgId, int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		RecordsPage<OrgUserEObj> entityRecordsPage = orgUserDBAdapter.getOrgUsers(orgId, pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<OrgUser, OrgUserEObj> merpMapper = new ModelEntityRecordsPageMapper<OrgUser, OrgUserEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, orgUserModelEntityMapper);
	}

	@Override
	public RecordsPage<OrgUser> getUserOrgs(long userId, int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		// TODO Auto-generated method stub
		return null;
	}
}
