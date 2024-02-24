package in.co.mark.common.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import in.co.mark.common.persistence.RecordsPage;

public class RecordsPageImpl<T> implements RecordsPage<T> {
	private final List<T> records;
	private int pageNumber;
	private int pageSize;
	private boolean hasMore;

	/**
	 * Initializes this instance with the given parameters.
	 * <p>
	 * If the parameter <i>records</i> is null then it initializes the
	 * {@code records} property of this instance with an empty {@link ArrayList}.
	 * </p>
	 * 
	 * @param records    A {@code List} of records
	 * @param pageNumber Current page number. It must be a non-negtive number.
	 * @param pageSize   Page size. It must be a non-negative number.
	 * @param hasMore    Set to {@code true}, if there are more records available in
	 *                   the data source; otherwise, {@code false}
	 */
	public RecordsPageImpl(List<T> records, int pageNumber, int pageSize, boolean hasMore) {
		if (pageNumber < 0) {
			throw new IllegalArgumentException("Current page number must be a non-negative number");
		}

		if (pageSize < 0) {
			throw new IllegalArgumentException("Page size must be a non-negative number");
		}

		if (records == null) {
			this.records = new ArrayList<T>();
		} else {
			this.records = records;
		}

		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.hasMore = hasMore;
	}

	/**
	 * Initializes this instance with the given parameters.
	 * <p>
	 * If the parameter <i>records</i> is null then it initializes the
	 * {@code records} property of this instance with an empty {@link ArrayList}.
	 * </p>
	 * <p>
	 * Also, if the size of the <i>records</i> parameter is greater than the value
	 * of <i>pageSize</i> parameter then it removes the last item from the
	 * {@code records} and sets the {@code hasMore} to {@code true}.
	 * </p>
	 * 
	 * @param records    A {@code List} of records
	 * @param pageNumber Current page number. It must be a non-negtive number.
	 * @param pageSize   Page size. It must be a non-negative number.
	 */
	public RecordsPageImpl(List<T> records, int pageNumber, int pageSize) {
		this(records, pageNumber, pageSize, false);

		if (this.records.size() > pageSize) {
			this.records.removeLast();
			this.hasMore = true;
		}
	}

	@Override
	public int getPageSize() {
		return pageSize;
	}

	@Override
	public int getPageNumber() {
		return pageNumber;
	}

	@Override
	public boolean isFirstPage() {
		return pageNumber == 0;
	}

	@Override
	public boolean isLastPage() {
		return !hasMore;
	}

	@Override
	public boolean hasNextPage() {
		return hasMore;
	}

	@Override
	public boolean hasPreviousPage() {
		return pageNumber > 0;
	}

	@Override
	public boolean hasRecords() {
		return records.size() > 0;
	}

	@Override
	public int getCount() {
		return records.size();
	}

	@Override
	public List<T> getRecords() {
		return records;
	}
}
