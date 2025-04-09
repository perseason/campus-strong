package pers.lilpen.infrastructure.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pers.lilpen.domain.user.model.valobj.RoleTypeEnum;

import java.util.List;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userId;
    private String username;
    private String usernameSuffix;
    private String password;
    private List<RoleTypeEnum> roles;
    private String location;
}
