package in.co.mark.common.persistence.util;

/**
 * Defines a contract to map (convert) a <i>model</i> object to an equivalent
 * <i>entity</i> object, and vice-versa
 * 
 * @param <M> Type of the <i>model</i> object
 * @param <E> Type of the <i>entity</i> object
 */
public interface ModelEntityMapper<M, E> {
	/**
	 * To map the given <i>entity</i> object to an equivalent <i>model</i> object
	 * 
	 * @param entity An <i>entity</i> object of type {@code E}
	 * @return An equivalent <i>model</i> object
	 */
	public M mapToModel(E entity);

	/**
	 * To map the given <i>model</i> object to an equivalent <i>entity</i> object
	 * 
	 * @param model A <i>model</i> object of type {@code M}
	 * @return An equivalent <i>entity</i> object
	 */
	public E mapToEntity(M model);
}
