package in.co.mark.common.persistence;

import java.util.List;

/**
 * A page of records which wraps paging related info also along with the
 * {@link List} of actual records.
 * 
 * @param <T> Type of the actual records which this class wraps
 * 
 * @author Rakesh Kumar
 */
public interface RecordsPage<T> {
	/**
	 * To get the size of the page - the original requested number of records.
	 * <p>
	 * Note that the count of the actual records this page contains could be lesser
	 * than the size of the page, but it will never be more than that.
	 * </p>
	 *
	 * @return the size of the page
	 */
	int getPageSize();

	/**
	 * To get the current page number. It will always be non-negative.
	 *
	 * @return the current page number
	 */
	int getPageNumber();

	/**
	 * To check whether the current page is the first one
	 *
	 * @return {@code true}, if it is the 1st page; otherwise, {@code false}
	 */
	boolean isFirstPage();

	/**
	 * To check whether the current page is the last one
	 *
	 * @return {@code true}, if it is the last page; otherwise, {@code false}
	 */
	boolean isLastPage();

	/**
	 * To check if there is a next page
	 *
	 * @return {@code true}, if there is a next page; otherwise, {@code false}
	 */
	boolean hasNextPage();

	/**
	 * /** To check if there is a previous page
	 *
	 * @return {@code true}, if there is a previous page; otherwise, {@code false}
	 */
	boolean hasPreviousPage();

	/**
	 * To check whether this page has records at all
	 *
	 * @return {@code true}, if this page has some content; otherwise, {@code false}
	 */
	boolean hasRecords();

	/**
	 * To get the count of records this page has
	 *
	 * @return the count of records this page has
	 */
	int getCount();

	/**
	 * To get a {@link List} of records of type {@code T}
	 *
	 * @return the list of records this page contains
	 */
	List<T> getRecords();
}
