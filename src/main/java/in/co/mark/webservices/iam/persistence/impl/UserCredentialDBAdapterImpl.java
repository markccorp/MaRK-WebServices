package in.co.mark.webservices.iam.persistence.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import in.co.mark.webservices.iam.persistence.UserCredentialDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.UserCredentialEObj;
import in.co.mark.webservices.iam.persistence.repositories.UserCredentialsRepository;

@Component
public class UserCredentialDBAdapterImpl implements UserCredentialDBAdapter {

	private final UserCredentialsRepository userCredRepo;

	public UserCredentialDBAdapterImpl(UserCredentialsRepository userCredRepo) {
		this.userCredRepo = userCredRepo;
	}

	@Override
	public UserCredentialEObj CreateUserCredential(UserCredentialEObj userCredEObj) {
		return userCredRepo.save(userCredEObj);
	}

	@Override
	public UserCredentialEObj getUserCredentialById(long id) {
		Optional<UserCredentialEObj> optionalUserCredEObj = userCredRepo.findById(id);
		return optionalUserCredEObj.orElse(null);
	}

	@Override
	public UserCredentialEObj getUserCredentialByUsername(String username) {
		return userCredRepo.findByUsername(username);
	}

	@Override
	public void UpdateUserPassword(long id, String newPassword) {
		userCredRepo.updateLoginPassword(id, newPassword);
	}

	@Override
	public UserCredentialEObj UpdateUserCredential(UserCredentialEObj userCredEObj) {
		return userCredRepo.save(userCredEObj);
	}
}
