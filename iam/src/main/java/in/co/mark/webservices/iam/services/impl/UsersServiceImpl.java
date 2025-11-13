package in.co.mark.webservices.iam.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.EntityActiveStatus;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.modelmapper.UserEntityMapper;
import in.co.mark.webservices.iam.modelmapper.UserProjectedEntityMapper;
import in.co.mark.webservices.iam.persistence.UsersDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.persistence.entities.projections.UserSummary;
import in.co.mark.webservices.iam.services.UserCredentialsService;
import in.co.mark.webservices.iam.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

	private final UsersDBAdapter usersDBAdapter;
	private final UserEntityMapper userEntityMapper;
	private final UserProjectedEntityMapper userProjEntityMapper;

	private final UserCredentialsService userCredsService;

	public UsersServiceImpl(UsersDBAdapter userDBAdapter, UserEntityMapper userModelEntityMapper,
			UserProjectedEntityMapper userEntityProjMapper, UserCredentialsService userCredService) {
		this.usersDBAdapter = userDBAdapter;
		this.userEntityMapper = userModelEntityMapper;
		this.userProjEntityMapper = userEntityProjMapper;

		this.userCredsService = userCredService;
	}

	@Override
	public boolean existsById(long id) {
		return usersDBAdapter.existsById(id);
	}

	@Override
	public boolean existsByEmail(String email) {
		return usersDBAdapter.existsByEmail(email);
	}

	@Override
	public User createUser(User user, String password) {
		return createUser(user, password, EntityActiveStatus.Active);
	}

	@Override
	@Transactional
	public User createUser(User user, String password, EntityActiveStatus passwordStatus) {
		UserEObj userEObj = userEntityMapper.mapToEntity(user);
		userEObj = usersDBAdapter.createUser(userEObj);

		boolean hasPassword = StringUtils.hasText(password);
		if (hasPassword) {
			userCredsService.createUserCredential(userEObj, password, passwordStatus);
		}

		logger.debug("New user created with ID: {}, Password: {}", userEObj.getId(), hasPassword);
		return userEntityMapper.mapToModel(userEObj);
	}

	@Override
	public User getUserSummaryById(long id) {
		UserSummary userSummary = usersDBAdapter.getUserSummaryById(id);
		if (userSummary == null) {
			return null;
		}

		return userProjEntityMapper.mapToModel(userSummary);
	}

	@Override
	public User getUserSummaryByEmail(String email) {
		UserSummary userSummary = usersDBAdapter.getUserSummaryByEmail(email);
		if (userSummary == null) {
			return null;
		}

		return userProjEntityMapper.mapToModel(userSummary);
	}

	@Override
	public RecordsPage<User> getUsersSummary(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		RecordsPage<UserSummary> entityRecordsPage = usersDBAdapter.getUsersSummary(pageNo, pageSize, sortOrder,
				sortByProperties);
		ModelEntityRecordsPageMapper<User, UserSummary> merpMapper = new ModelEntityRecordsPageMapper<User, UserSummary>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, userProjEntityMapper);
	}
}
