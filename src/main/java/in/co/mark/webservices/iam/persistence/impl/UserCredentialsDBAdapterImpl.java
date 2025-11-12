package in.co.mark.webservices.iam.persistence.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import in.co.mark.webservices.iam.persistence.UserCredentialsDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.UserCredentialEObj;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.persistence.repositories.UserCredentialsRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Component
public class UserCredentialsDBAdapterImpl implements UserCredentialsDBAdapter {
	private final EntityManager entityManager;

	private final UserCredentialsRepository userCredRepo;

	public UserCredentialsDBAdapterImpl(EntityManager entityManager, UserCredentialsRepository userCredRepo) {
		this.entityManager = entityManager;

		this.userCredRepo = userCredRepo;
	}

	@Override
	@Transactional
	public UserCredentialEObj createUserCredential(long userId, UserCredentialEObj userCredEObj) {
		if (userCredEObj.getUserEObj() == null) {
			UserEObj userEObjRef = entityManager.getReference(UserEObj.class, userId);
			userCredEObj.setUserEObj(userEObjRef);
		}

		return createUserCredential(userCredEObj);
	}

	@Override
	public UserCredentialEObj createUserCredential(UserCredentialEObj userCredEObj) {
		return userCredRepo.save(userCredEObj);
	}

	@Override
	public UserCredentialEObj getUserCredentialById(long id) {
		Optional<UserCredentialEObj> optionalUserCredEObj = userCredRepo.findById(id);
		return optionalUserCredEObj.orElse(null);
	}

	@Override
	public UserCredentialEObj updateUserCredential(UserCredentialEObj userCredEObj) {
		return userCredRepo.save(userCredEObj);
	}
}
