package in.co.mark.common.persistence.util;

import java.util.ArrayList;
import java.util.List;

import in.co.mark.common.persistence.RecordsPage;
import in.co.mark.common.persistence.impl.RecordsPageImpl;

public class ModelEntityRecordsPageMapper<M, E> {
	public RecordsPage<M> mapToModelRecordsPage(RecordsPage<E> entityRecordsPage,
			ModelEntityMapper<M, E> modelEntityMapper) {
		List<E> entityItemsList = entityRecordsPage.getRecords();
		List<M> modelItemsList = new ArrayList<M>(entityItemsList.size());
		for (E entity : entityItemsList) {
			modelItemsList.add(modelEntityMapper.mapToModel(entity));
		}
		RecordsPage<M> modelRecordsPage = new RecordsPageImpl<M>(modelItemsList, entityRecordsPage.getPageNumber(),
				entityRecordsPage.getPageSize(), entityRecordsPage.hasNextPage());
		return modelRecordsPage;
	}
}
