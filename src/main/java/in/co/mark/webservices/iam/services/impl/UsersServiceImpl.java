package in.co.mark.webservices.iam.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.iam.domain.model.LoginCredential;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.gateway.dto.CreateUserRequest;
import in.co.mark.webservices.iam.gateway.dto.CreateUserResponse;
import in.co.mark.webservices.iam.modelmapper.LoginCredentialDTOMapper;
import in.co.mark.webservices.iam.modelmapper.LoginCredentialEntityMapper;
import in.co.mark.webservices.iam.modelmapper.UserEntityMapper;
import in.co.mark.webservices.iam.modelmapper.UsersDTOMapper;
import in.co.mark.webservices.iam.persistence.LoginCredentialDBAdapter;
import in.co.mark.webservices.iam.persistence.UsersDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.LoginCredentialEObj;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	private final LoginCredentialDBAdapter loginCredDBAdapter;
	private final LoginCredentialDTOMapper loginCredModelDTOMapper;
	private final LoginCredentialEntityMapper loginCredModelEntityMapper;
	private final UsersDBAdapter userDBAdapter;
	private final UsersDTOMapper userModelDTOMapper;
	private final UserEntityMapper userModelEntityMapper;

	public UsersServiceImpl(LoginCredentialDBAdapter loginCredDBAdapter,
			LoginCredentialDTOMapper loginCredModelDTOMapper, LoginCredentialEntityMapper loginCredModelEntityMapper,
			UsersDBAdapter userDBAdapter, UsersDTOMapper userModelDTOMapper, UserEntityMapper userModelEntityMapper) {
		this.loginCredDBAdapter = loginCredDBAdapter;
		this.loginCredModelDTOMapper = loginCredModelDTOMapper;
		this.loginCredModelEntityMapper = loginCredModelEntityMapper;
		this.userDBAdapter = userDBAdapter;
		this.userModelDTOMapper = userModelDTOMapper;
		this.userModelEntityMapper = userModelEntityMapper;
	}

	@Override
	public CreateUserResponse createUser(CreateUserRequest reqDto) {
		LoginCredential loginCred = loginCredModelDTOMapper.mapToLoginCredential(reqDto);
		LoginCredentialEObj loginCredEObj = loginCredModelEntityMapper.mapToEntity(loginCred);
		loginCred = loginCredModelEntityMapper.mapToModel(loginCredDBAdapter.CreateLoginCredential(loginCredEObj));

		User user = userModelDTOMapper.mapToUser(reqDto);
		user.setId(loginCred.getId());
		UserEObj userEObj = userModelEntityMapper.mapToEntity(user);
		user = userModelEntityMapper.mapToModel(userDBAdapter.createUser(userEObj));

		return userModelDTOMapper.mapToCreateUserResponse(user);
	}

	@Override
	public User getUserById(long id) {
		User user = null;
		UserEObj userEObj = userDBAdapter.getUserById(id);
		if (userEObj != null) {
			user = userModelEntityMapper.mapToModel(userEObj);
		}

		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		UserEObj userEObj = userDBAdapter.getUserByEmail(email);
		if (userEObj != null) {
			user = userModelEntityMapper.mapToModel(userEObj);
		}

		return user;
	}

	@Override
	public RecordsPage<User> getUsers(int pageNo, int pageSize) {
		RecordsPage<UserEObj> entityRecordsPage = userDBAdapter.getUsers(pageNo, pageSize);
		ModelEntityRecordsPageMapper<User, UserEObj> merpMapper = new ModelEntityRecordsPageMapper<User, UserEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, userModelEntityMapper);
	}

	@Override
	public RecordsPage<User> getUsers(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		RecordsPage<UserEObj> entityRecordsPage = userDBAdapter.getUsers(pageNo, pageSize, sortOrder, sortByProperties);
		ModelEntityRecordsPageMapper<User, UserEObj> merpMapper = new ModelEntityRecordsPageMapper<User, UserEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, userModelEntityMapper);
	}
}
