package in.co.mark.webservices.iam.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import in.co.mark.common.exceptions.ResourceNotFoundException;
import in.co.mark.common.persistence.util.EntityActiveStatus;
import in.co.mark.webservices.iam.domain.model.UserCredential;
import in.co.mark.webservices.iam.modelmapper.UserCredentialEntityMapper;
import in.co.mark.webservices.iam.persistence.UserCredentialsDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.UserCredentialEObj;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.services.UserCredentialsService;
import jakarta.transaction.Transactional;

@Service
public class UserCredentialsServiceImpl implements UserCredentialsService {
	private static final Logger logger = LoggerFactory.getLogger(UserCredentialsServiceImpl.class);

	private final UserCredentialEntityMapper userCredEntityMapper;
	private final UserCredentialsDBAdapter userCredDBAdapter;

	public UserCredentialsServiceImpl(UserCredentialsDBAdapter userCredDBAdapter,
			UserCredentialEntityMapper userCredEntityMapper) {
		this.userCredDBAdapter = userCredDBAdapter;
		this.userCredEntityMapper = userCredEntityMapper;
	}

	@Override
	public UserCredential createUserCredential(long userId, String password) {
		return createUserCredential(userId, password, EntityActiveStatus.Active);
	}

	@Override
	@Transactional
	public UserCredential createUserCredential(long userId, String password, EntityActiveStatus status) {
		UserCredentialEObj userCredEObj = new UserCredentialEObj();
		userCredEObj.setPassword(password);
		userCredEObj.setStatus(status);
		userCredEObj = userCredDBAdapter.createUserCredential(userId, userCredEObj);
		logger.debug("User credential created for user ID: {}", userId);
		return userCredEntityMapper.mapToModel(userCredEObj);
	}

	@Override
	public UserCredential createUserCredential(UserEObj userEObj, String password, EntityActiveStatus status) {
		UserCredentialEObj userCredEObj = new UserCredentialEObj();
		userCredEObj.setPassword(password);
		userCredEObj.setStatus(status);
		userCredEObj.setUserEObj(userEObj);
		userCredEObj = userCredDBAdapter.createUserCredential(userCredEObj);
		logger.debug("User credential created for user: {}", userCredEObj.getId());
		return userCredEntityMapper.mapToModel(userCredEObj);
	}

	@Override
	public UserCredential getUserCredentialById(long id) {
		UserCredentialEObj userCredEObj = userCredDBAdapter.getUserCredentialById(id);
		return userCredEntityMapper.mapToModel(userCredEObj);
	}

	@Override
	public UserCredential updateUserCredential(long id, String password, EntityActiveStatus status) {
		UserCredentialEObj userCredEObj = userCredDBAdapter.getUserCredentialById(id);
		if (userCredEObj == null) {
			throw new ResourceNotFoundException("No matching credential found");
		}

		userCredEObj.setPassword(password);
		userCredEObj.setStatus(status);
		userCredEObj = userCredDBAdapter.updateUserCredential(userCredEObj);
		logger.debug("Updated credential: {}", id);
		return userCredEntityMapper.mapToModel(userCredEObj);
	}
}
