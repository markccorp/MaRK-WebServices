package in.co.mark.common.extensions;

import in.co.mark.common.domain.model.ModelTimestamp;
import in.co.mark.common.domain.model.UserSpecificModel;
import in.co.mark.common.persistence.EntityTimestamp;
import in.co.mark.common.persistence.UserSpecificEntity;

public class ModelEntityMapperExtn {
	/**
	 * To update the values of {@code createdOn} and {@code lastUpdatedOn}
	 * properties of this <i>entity</i> instance by that of given <i>model</i>
	 * instance
	 * 
	 * 
	 * @param entityInstance This <i>entity</i> instance of type
	 *                       {@code EntityTimestamp} to update the values to
	 * @param modelInstance  A <i>model</i> instance of type {@code ModelTimestamp}
	 *                       to update the values from
	 */
	public static void updateTimestamp(EntityTimestamp entityInstance, ModelTimestamp modelInstance) {
		entityInstance.setCreatedOn(modelInstance.getCreatedOn());
		entityInstance.setLastUpdatedOn(modelInstance.getLastUpdatedOn());
	}

	/**
	 * To update the values of {@code createdOn} and {@code lastUpdatedOn}
	 * properties of this <i>model</i> instance by that of given <i>entity</i>
	 * instance
	 * 
	 * @param modelInstance  This <i>model</i> instance of type
	 *                       {@code ModelTimestamp} to update the values to
	 * @param entityInstance An <i>entity</i> instance of type
	 *                       {@code EntityTimestamp} to update the values from
	 */
	public static void updateTimestamp(ModelTimestamp modelInstance, EntityTimestamp entityInstance) {
		modelInstance.setCreatedOn(entityInstance.getCreatedOn());
		modelInstance.setLastUpdatedOn(entityInstance.getLastUpdatedOn());
	}

	/**
	 * To update the values of {@code ownerUserId}, {@code createdOn}, and
	 * {@code lastUpdatedOn} properties of this <i>model</i> instance by that of
	 * given <i>entity</i> instance
	 * 
	 * @param modelInstance  This <i>model</i> instance of type
	 *                       {@code UserSpecificModel} to update the values to
	 * @param entityInstance An <i>entity</i> instance of type
	 *                       {@code UserSpecificEntity} to update the values from
	 */
	public static void updateUserIdAndTimestamp(UserSpecificModel modelInstance, UserSpecificEntity entityInstance) {
		modelInstance.setOwnerUserId(entityInstance.getOwnerUserId());
		modelInstance.setCreatedOn(entityInstance.getCreatedOn());
		modelInstance.setLastUpdatedOn(entityInstance.getLastUpdatedOn());
	}

	/**
	 * To update the values of {@code ownerUserId}, {@code createdOn}, and
	 * {@code lastUpdatedOn} properties of this <i>entity</i> instance by that of
	 * given <i>model</i> instance
	 * 
	 * 
	 * @param entityInstance This <i>entity</i> instance of type
	 *                       {@code UserSpecificEntity} to update the values to
	 * @param modelInstance  A <i>model</i> instance of type
	 *                       {@code UserSpecificModel} to update the values from
	 */
	public static void updateUserIdAndTimestamp(UserSpecificEntity entityInstance, UserSpecificModel modelInstance) {
		entityInstance.setOwnerUserId(modelInstance.getOwnerUserId());
		entityInstance.setCreatedOn(modelInstance.getCreatedOn());
		entityInstance.setLastUpdatedOn(modelInstance.getLastUpdatedOn());
	}
}
