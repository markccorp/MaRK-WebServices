package in.co.mark.webservices.iam.persistence.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.impl.RecordsPageImpl;
import in.co.mark.webservices.iam.persistence.UsersDBAdapter;
import in.co.mark.webservices.iam.persistence.entities.UserEObj;
import in.co.mark.webservices.iam.persistence.entities.projections.UserSummary;
import in.co.mark.webservices.iam.persistence.repositories.UsersRepository;

@Component
public class UsersDBAdapterImpl implements UsersDBAdapter {
	private final UsersRepository usersRepo;

	public UsersDBAdapterImpl(UsersRepository usersRepo) {
		this.usersRepo = usersRepo;
	}

	@Override
	public boolean existsById(long id) {
		return usersRepo.existsById(id);
	}

	@Override
	public boolean existsByEmail(String email) {
		return usersRepo.getUserSummaryByEmail(email).isPresent();
	}

	@Override
	public UserEObj createUser(UserEObj userEObj) {
		return usersRepo.save(userEObj);
	}

	@Override
	public UserSummary getUserSummaryById(long id) {
		return usersRepo.getUserSummaryById(id).orElse(null);
	}

	@Override
	public UserSummary getUserSummaryByEmail(String email) {
		return usersRepo.getUserSummaryByEmail(email).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public RecordsPage<UserSummary> getUsersSummary(int pageNo, int pageSize, int sortOrder,
			String... sortByProperties) {
		Direction sortDirection = sortOrder != 0 ? Direction.ASC : Direction.DESC;
		Pageable pageable = PageRequest.of(pageNo, pageSize, sortDirection, sortByProperties);
		Slice<UserSummary> slicedResult = usersRepo.getUsersSummary(pageable);
		return new RecordsPageImpl<UserSummary>(slicedResult.getContent(), slicedResult.getNumber(),
				slicedResult.getSize(), slicedResult.hasNext());
	}
}
