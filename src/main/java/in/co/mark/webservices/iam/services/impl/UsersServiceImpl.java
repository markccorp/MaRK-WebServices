package in.co.mark.webservices.iam.services.impl;

import org.springframework.stereotype.Service;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.util.ModelEntityRecordsPageMapper;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.gateway.dto.CreateUserRequest;
import in.co.mark.webservices.iam.gateway.dto.CreateUserResponse;
import in.co.mark.webservices.iam.modelmapper.UserEntityMapper;
import in.co.mark.webservices.iam.modelmapper.UsersDTOMapper;
import in.co.mark.webservices.iam.persistence.UsersDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	private final UsersDBAdapter dbAdapter;
	private final UsersDTOMapper modelDTOMapper;
	private final UserEntityMapper modelEntityMapper;

	public UsersServiceImpl(UsersDBAdapter dbAdapter, UsersDTOMapper modelDTOMapper,
			UserEntityMapper modelEntityMapper) {
		this.dbAdapter = dbAdapter;
		this.modelDTOMapper = modelDTOMapper;
		this.modelEntityMapper = modelEntityMapper;
	}

	@Override
	public CreateUserResponse createUser(CreateUserRequest reqDto) {
		User user = modelDTOMapper.mapToUser(reqDto);
		UserEObj userEObj = modelEntityMapper.mapToEntity(user);
		user = modelEntityMapper.mapToModel(dbAdapter.createUser(userEObj));
		return modelDTOMapper.mapToCreateUserResponse(user);
	}

	@Override
	public User getUserById(long id) {
		User user = null;
		UserEObj userEObj = dbAdapter.getUserById(id);
		if (userEObj != null) {
			user = modelEntityMapper.mapToModel(userEObj);
		}

		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;
		UserEObj userEObj = dbAdapter.getUserByEmail(email);
		if (userEObj != null) {
			user = modelEntityMapper.mapToModel(userEObj);
		}

		return user;
	}

	@Override
	public RecordsPage<User> getUsers(int pageNo, int pageSize) {
		RecordsPage<UserEObj> entityRecordsPage = dbAdapter.getUsers(pageNo, pageSize);
		ModelEntityRecordsPageMapper<User, UserEObj> merpMapper = new ModelEntityRecordsPageMapper<User, UserEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}

	@Override
	public RecordsPage<User> getUsers(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		RecordsPage<UserEObj> entityRecordsPage = dbAdapter.getUsers(pageNo, pageSize, sortOrder, sortByProperties);
		ModelEntityRecordsPageMapper<User, UserEObj> merpMapper = new ModelEntityRecordsPageMapper<User, UserEObj>();
		return merpMapper.mapToModelRecordsPage(entityRecordsPage, modelEntityMapper);
	}
}
