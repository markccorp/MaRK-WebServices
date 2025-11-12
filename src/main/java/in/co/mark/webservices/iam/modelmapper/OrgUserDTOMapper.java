package in.co.mark.webservices.iam.modelmapper;

import org.springframework.stereotype.Component;

import in.co.mark.webservices.iam.domain.model.OrgUser;
import in.co.mark.webservices.iam.gateway.dto.OrgUserRequestDTO;
import in.co.mark.webservices.iam.gateway.dto.OrgUserResponseDTO;

/**
 * @author Rakesh Kumar
 */
@Component
public class OrgUserDTOMapper {
	public OrgUser mapToOrgUser(long orgId, long userId, OrgUserRequestDTO reqDto) {
		return new OrgUser(orgId, userId, reqDto.getUsername(), reqDto.getEmail(), reqDto.getInitial(),
				reqDto.getFirstName(), reqDto.getMiddleName(), reqDto.getLastName(), reqDto.getDisplayName(),
				reqDto.getGender(), reqDto.getDobDate(), reqDto.getDobMonth(), reqDto.getDobYear(), null,
				reqDto.getOrgUserRole(), reqDto.getOrgUserStatus());
	}

	public OrgUserResponseDTO mapToCreateOrgUserResponse(OrgUser orgUser) {
		OrgUserResponseDTO orgUserResDTO = new OrgUserResponseDTO(orgUser.getOrgId(), orgUser.getOrgUserRole(),
				orgUser.getOrgUserStatus(), orgUser.getOrgUserCreatedOn(), orgUser.getOrgUserLastUpdatedOn());
		// Set User details
		orgUserResDTO.setUserId(orgUser.getId());
		orgUserResDTO.setUsername(orgUser.getUsername());
		orgUserResDTO.setEmail(orgUser.getEmail());
		orgUserResDTO.setInitial(orgUser.getInitial());
		orgUserResDTO.setFirstName(orgUser.getFirstName());
		orgUserResDTO.setMiddleName(orgUser.getMiddleName());
		orgUserResDTO.setLastName(orgUser.getLastName());
		orgUserResDTO.setDisplayName(orgUser.getDisplayName());
		orgUserResDTO.setGender(orgUser.getGender());
		orgUserResDTO.setDobDate(orgUser.getDobDate());
		orgUserResDTO.setDobMonth(orgUser.getDobMonth());
		orgUserResDTO.setDobYear(orgUser.getDobYear());
		orgUserResDTO.setCreatedOn(orgUser.getCreatedOn());
		orgUserResDTO.setLastUpdatedOn(orgUser.getLastUpdatedOn());

		return orgUserResDTO;
	}
}
