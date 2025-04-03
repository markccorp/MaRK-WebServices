package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.webservices.iam.domain.model.OrgUser;
import in.co.mark.webservices.iam.domain.model.User;
import in.co.mark.webservices.iam.gateway.dto.OrgUserRequestDTO;
import in.co.mark.webservices.iam.gateway.dto.OrgUserResponseDTO;

/**
 * @author Rakesh Kumar
 */
@Component
public class OrgUsersDTOMapper {
	/**
	 * To map the given {@code reqDto} to an equivalent {@link OrgUser} model object
	 * 
	 * @param reqDto A request DTO of type {@link OrgUserRequestDTO}
	 * @param userId ID of the user to associate with the specified organization
	 * @return A {@link OrgUser} model object
	 */
	public OrgUser mapToOrgUser(OrgUserRequestDTO reqDto, long userId) {
		return new OrgUser(reqDto.getOrgId(), userId, reqDto.getOrgUserRole(), reqDto.getOrgUserStatus());
	}

	/**
	 * To map the given {@code orgUser} and {@code user} to an equivalent
	 * {@link OrgUserResponseDTO} DTO object
	 * 
	 * @param orgUser A model object of type {@link OrgUser}
	 * @param user    A model object of type {@link User}
	 * 
	 * @return A {@link OrgUserResponseDTO} DTO object
	 */
	public OrgUserResponseDTO mapToCreateOrgUserResponse(OrgUser orgUser, User user) {
		OrgUserResponseDTO orgUserResDTO = new OrgUserResponseDTO(orgUser.getOrgId(), orgUser.getOrgUserRole(),
				orgUser.getOrgUserStatus());
		if (user != null) {
			orgUserResDTO.setUserId(user.getId());
			orgUserResDTO.setEmail(user.getEmail());
			orgUserResDTO.setUsername(user.getUsername());
			orgUserResDTO.setInitial(user.getInitial());
			orgUserResDTO.setFirstName(user.getFirstName());
			orgUserResDTO.setMiddleName(user.getMiddleName());
			orgUserResDTO.setLastName(user.getLastName());
			orgUserResDTO.setDisplayName(user.getDisplayName());
			orgUserResDTO.setGender(user.getGender());
			orgUserResDTO.setDobDate(user.getDobDate());
			orgUserResDTO.setDobMonth(user.getDobMonth());
			orgUserResDTO.setDobYear(user.getDobYear());
			orgUserResDTO.setCreatedOn(user.getCreatedOn());
			orgUserResDTO.setLastUpdatedOn(user.getLastUpdatedOn());
		}
		return orgUserResDTO;
	}
}
