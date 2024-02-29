package in.co.mark.webservices.iam.persistence.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import in.co.mark.webservices.iam.persistence.LoginCredentialDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.LoginCredentialEObj;
import in.co.mark.webservices.iam.persistence.repositories.LoginCredentialsRepository;

@Component
public class LoginCredentialDBAdapterImpl implements LoginCredentialDBAdapter {

	private final LoginCredentialsRepository loginCredRepo;

	public LoginCredentialDBAdapterImpl(LoginCredentialsRepository loginCredRepo) {
		this.loginCredRepo = loginCredRepo;
	}

	@Override
	public LoginCredentialEObj CreateLoginCredential(LoginCredentialEObj loginCredEObj) {
		return loginCredRepo.save(loginCredEObj);
	}

	@Override
	public LoginCredentialEObj getLoginCredentialById(long id) {
		Optional<LoginCredentialEObj> optionalLoginCredEObj = loginCredRepo.findById(id);
		return optionalLoginCredEObj.orElse(null);
	}

	@Override
	public LoginCredentialEObj getLoginCredentialByUsername(String username) {
		return loginCredRepo.findByUsername(username);
	}

	@Override
	public void UpdateLoginPassword(long id, String newPassword) {
		loginCredRepo.updateLoginPassword(id, newPassword);
	}

	@Override
	public LoginCredentialEObj UpdateLoginCredential(LoginCredentialEObj loginCredEObj) {
		return loginCredRepo.save(loginCredEObj);
	}
}
