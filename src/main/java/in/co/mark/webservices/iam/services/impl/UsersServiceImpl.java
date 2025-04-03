package in.co.mark.webservices.iam.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.gateway.dto.UserRequestDTO;
import in.co.mark.webservices.iam.modelmapper.UserCredentialEntityMapper;
import in.co.mark.webservices.iam.modelmapper.UserDTOMapper;
import in.co.mark.webservices.iam.modelmapper.UserEntityMapper;
import in.co.mark.webservices.iam.modelmapper.UserEntityProjectionMapper;
import in.co.mark.webservices.iam.persistence.UserCredentialDBAdapter;
import in.co.mark.webservices.iam.persistence.UsersDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.UserCredentialEObj;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.persistence.entities.projections.UserProjection;
import in.co.mark.webservices.iam.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

	private final UserCredentialEntityMapper userCredEntityMapper;
	private final UsersDBAdapter userDBAdapter;
	private final UserDTOMapper userModelDTOMapper;
	private final UserEntityMapper userEntityMapper;
	private final UserEntityProjectionMapper userEntityProjMapper;

	public UsersServiceImpl(UserCredentialDBAdapter userCredDBAdapter,
			UserCredentialEntityMapper userCredModelEntityMapper, UsersDBAdapter userDBAdapter,
			UserDTOMapper userModelDTOMapper, UserEntityMapper userModelEntityMapper,
			UserEntityProjectionMapper userEntityProjMapper) {
		this.userCredEntityMapper = userCredModelEntityMapper;
		this.userDBAdapter = userDBAdapter;
		this.userModelDTOMapper = userModelDTOMapper;
		this.userEntityMapper = userModelEntityMapper;
		this.userEntityProjMapper = userEntityProjMapper;
	}

	@Override
	@Transactional
	public User createUser(UserRequestDTO reqDto) {
		String username;
		if (StringUtils.hasText(reqDto.getUsername())) {
			username = reqDto.getUsername().trim();
		} else {
			logger.debug("Creating user with the email as username, as no separate username provided");
			username = reqDto.getEmail();
		}
		UserCredentialEObj userCredEObj = new UserCredentialEObj();
		userCredEObj.setUsername(username);
		userCredEObj.setPassword(reqDto.getPassword());

		UserEObj userEObj = userEntityMapper.mapToEntity(userModelDTOMapper.mapToUser(reqDto));
		userEObj.setUserCredEObj(userCredEObj);
		userEObj = userDBAdapter.createUser(userEObj);
		User user = userEntityMapper.mapToModel(userEObj);
		user.setUsername(userCredEObj.getUsername());
		return user;
	}

	@Override
	@Transactional
	public User createUser(UserRequestDTO reqDto, boolean hasCredentials) {
		UserEObj userEObj = userEntityMapper.mapToEntity(userModelDTOMapper.mapToUser(reqDto));

		String username = null;
		if (hasCredentials) {
			logger.debug("Creating user with credentials");
			if (StringUtils.hasText(reqDto.getUsername())) {
				username = reqDto.getUsername().trim();
			} else {
				logger.debug("Using email as username, as no separate username provided");
				username = reqDto.getEmail();
			}
			UserCredentialEObj userCredEObj = new UserCredentialEObj();
			userCredEObj.setUsername(username);
			userCredEObj.setPassword(reqDto.getPassword());
			userEObj.setUserCredEObj(userCredEObj);
		}

		userEObj = userDBAdapter.createUser(userEObj);
		User user = userEntityMapper.mapToModel(userEObj);
		user.setUsername(username);
		return user;
	}

	/*
	 * public User addOrgUser(User user) { UserEObj userEObj =
	 * userEntityMapper.mapToEntity(user); userEObj =
	 * userDBAdapter.createUser(userEObj); return
	 * userEntityMapper.mapToModel(userEObj); }
	 */

	@Override
	public User getUserById(long id) {
		User user = null;
		UserEObj userEObj = userDBAdapter.getUserById(id);
		if (userEObj != null) {
			user = userEntityMapper.mapToModel(userEObj);
		}

		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		UserEObj userEObj = userDBAdapter.getUserByEmail(email);
		if (userEObj != null) {
			user = userEntityMapper.mapToModel(userEObj);
		}

		return user;
	}

	@Override
	public RecordsPage<User> getUsers(int pageNo, int pageSize) {
		RecordsPage<UserEObj> entityRecordsPage = userDBAdapter.getUsers(pageNo, pageSize);
		ModelEntityRecordsPageMapper<User, UserEObj> merpMapper = new ModelEntityRecordsPageMapper<User, UserEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, userEntityMapper);
	}

	@Override
	public RecordsPage<User> getUsers(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		RecordsPage<UserEObj> entityRecordsPage = userDBAdapter.getUsers(pageNo, pageSize, sortOrder, sortByProperties);
		ModelEntityRecordsPageMapper<User, UserEObj> merpMapper = new ModelEntityRecordsPageMapper<User, UserEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, userEntityMapper);
	}

	@Override
	public List<User> getAllUsers(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		List<UserProjection> userProjList = userDBAdapter.getAllUsers(pageNo, pageSize, sortOrder, sortByProperties);
		List<User> usersList = new ArrayList<User>(userProjList.size());
		for (UserProjection uersProj : userProjList) {
			usersList.add(userEntityProjMapper.mapEntityProjectionToModel(uersProj));
		}

		return usersList;
	}
}
