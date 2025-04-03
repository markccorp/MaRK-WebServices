package in.co.mark.webservices.iam.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.iam.domain.model.OrgUser;
import in.co.mark.webservices.iam.domain.model.OrgUserRole;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.gateway.dto.OrgUserRequestDTO;
import in.co.mark.webservices.iam.gateway.dto.OrgUserResponseDTO;
import in.co.mark.webservices.iam.modelmapper.OrgUserEntityMapper;
import in.co.mark.webservices.iam.modelmapper.OrgUsersDTOMapper;
import in.co.mark.webservices.iam.persistence.OrgUsersDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.OrgUserEObj;
import in.co.mark.webservices.iam.services.OrgUsersService;
import in.co.mark.webservices.iam.services.UsersService;
import in.co.mark.webservices.iam.util.OrgUserStatus;

/**
 * @author Rakesh Kumar
 */
@Service
public class OrgUsersServiceImpl implements OrgUsersService {
	private static final Logger logger = LoggerFactory.getLogger(OrgUsersServiceImpl.class);

	private final OrgUsersDBAdapter dbAdapter;
	private OrgUsersDTOMapper orgUserModelDTOMapper;
	private final OrgUserEntityMapper modelEntityMapper;
	private final UsersService userService;

	public OrgUsersServiceImpl(OrgUsersDBAdapter dbAdapter, OrgUsersDTOMapper orgUserModelDTOMapper,
			OrgUserEntityMapper modelEntityMapper, UsersService userService) {
		this.dbAdapter = dbAdapter;
		this.orgUserModelDTOMapper = orgUserModelDTOMapper;
		this.modelEntityMapper = modelEntityMapper;
		this.userService = userService;
	}

	@Override
	public OrgUserResponseDTO createOrgUser(OrgUserRequestDTO reqObj) {
		long userId = 0;
		User user = userService.getUserByEmail(reqObj.getEmail());
		if (user != null) {
			userId = user.getId();
			logger.info("UserId {} found for the specified email", userId);
		} else {
			logger.info("No user found for the specified email, creating new one", userId);
			// TODO: Check and handle password case
			user = userService.createUser(reqObj, false);
			userId = user.getId();
		}

		OrgUser orgUser = orgUserModelDTOMapper.mapToOrgUser(reqObj, userId);
		if (orgUser.getOrgUserRole() == null) {
			orgUser.setOrgUserRole(OrgUserRole.USER);
		}
		if (orgUser.getOrgUserStatus() == null) {
			orgUser.setOrgUserStatus(OrgUserStatus.INVITED);
		}

		OrgUserEObj orgUserEObj = dbAdapter.addOrgUser(modelEntityMapper.mapToEntity(orgUser));
		orgUser = modelEntityMapper.mapToModel(orgUserEObj);
		logger.info("Added user {} to Org {}", orgUser.getUserId(), orgUser.getOrgId());
		return orgUserModelDTOMapper.mapToCreateOrgUserResponse(orgUser, user);
	}

	@Override
	public OrgUser getOrgUser(long orgId, long userId) {
		OrgUser orgUser = null;
		OrgUserEObj orgUserEObj = dbAdapter.getOrgUser(orgId, userId);
		if (orgUserEObj != null) {
			orgUser = modelEntityMapper.mapToModel(orgUserEObj);
		}

		return orgUser;
	}

	@Override
	public RecordsPage<OrgUser> getOrgUsers(int pageNo, int pageSize) {
		RecordsPage<OrgUserEObj> entityRecordsPage = dbAdapter.getOrgUsers(pageNo, pageSize);
		ModelEntityRecordsPageMapper<OrgUser, OrgUserEObj> merpMapper = new ModelEntityRecordsPageMapper<OrgUser, OrgUserEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<OrgUser> getOrgUsers(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		RecordsPage<OrgUserEObj> entityRecordsPage = dbAdapter.getOrgUsers(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<OrgUser, OrgUserEObj> merpMapper = new ModelEntityRecordsPageMapper<OrgUser, OrgUserEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<OrgUser> getUserOrgs(long userId, int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		// TODO Auto-generated method stub
		return null;
	}
}
