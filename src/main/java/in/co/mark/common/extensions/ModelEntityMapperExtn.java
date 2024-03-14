package in.co.mark.common.extensions;

import in.co.mark.common.domain.model.ModelBase;
import in.co.mark.common.domain.model.OwnerModelBase;
import in.co.mark.common.persistence.EntityBase;
import in.co.mark.common.persistence.OwnerEntityBase;

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
	public static void updateTimestamp(EntityBase entityInstance, ModelBase modelInstance) {
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
	public static void updateTimestamp(ModelBase modelInstance, EntityBase entityInstance) {
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
	public static void updateUserIdAndTimestamp(OwnerModelBase modelInstance, OwnerEntityBase entityInstance) {
		modelInstance.setOwnerId(entityInstance.getOwnerId());
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
	public static void updateUserIdAndTimestamp(OwnerEntityBase entityInstance, OwnerModelBase modelInstance) {
		entityInstance.setOwnerId(modelInstance.getOwnerId());
		entityInstance.setCreatedOn(modelInstance.getCreatedOn());
		entityInstance.setLastUpdatedOn(modelInstance.getLastUpdatedOn());
	}
}
