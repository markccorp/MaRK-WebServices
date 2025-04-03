package in.co.mark.common.persistence.util;

/**
 * Defines a contract to map or convert a <i>model</i> to an equivalent
 * <i>entity</i>, an <i>entity</i> to an equivalent <i>model</i>, and an
 * <i>entity-projection</i> to an equivalent <i>model</i>
 * 
 * @param <M> Type of the <i>model</i> object
 * @param <E> Type of the <i>entity</i> object
 * @param <P> Type of the <i>entity-projection</i> object
 * 
 * @author Rakesh Kumar
 */
public interface ModelEntityProjectionMapper<M, E, P> {
	/**
	 * To map the given <i>model</i> object of type {@code M} to an equivalent
	 * <i>entity</i> object of type {@code E}
	 * 
	 * @param model A <i>model</i> object of type {@code M}
	 * @return An equivalent <i>entity</i> object of type {@code E}
	 */
	public E mapModelToEntity(M model);

	/**
	 * To map the given <i>entity-projection</i> object of type {@code P} to an
	 * equivalent <i>model</i> object of type {@code M}
	 * 
	 * @param entityPObj An <i>entity-projection</i> object of type {@code P}
	 * @return An equivalent <i>model</i> object of type {@code M}
	 */
	public M mapEntityProjectionToModel(P entityPObj);
}
