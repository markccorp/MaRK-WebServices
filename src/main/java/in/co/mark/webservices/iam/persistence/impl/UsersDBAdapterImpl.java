package in.co.mark.webservices.iam.persistence.impl;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.impl.RecordsPageImpl;
import in.co.mark.webservices.iam.persistence.UsersDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.persistence.repositories.UsersRepository;

@Component
public class UsersDBAdapterImpl implements UsersDBAdapter {
	private final UsersRepository usersRepo;

	public UsersDBAdapterImpl(UsersRepository usersRepo) {
		this.usersRepo = usersRepo;
	}

	@Override
	public UserEObj createUser(UserEObj userEObj) {
		return usersRepo.save(userEObj);
	}

	@Override
	public UserEObj getUserById(long id) {
		Optional<UserEObj> optionalUserEObj = usersRepo.findById(id);
		return optionalUserEObj.orElse(null);
	}

	@Override
	public UserEObj getUserByEmail(String email) {
		return usersRepo.findByEmail(email);
	}

	@Override
	public RecordsPage<UserEObj> getUsers(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Slice<UserEObj> slicedResult = usersRepo.findAll(paging);
		return new RecordsPageImpl<UserEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}

	@Override
	public RecordsPage<UserEObj> getUsers(int pageNo, int pageSize, int sortOrder, String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable paging = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<UserEObj> slicedResult = usersRepo.findAll(paging);
		return new RecordsPageImpl<UserEObj>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}
}
