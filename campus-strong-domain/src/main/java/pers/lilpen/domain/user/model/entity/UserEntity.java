package pers.lilpen.domain.user.model.entity;

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
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private Long id;
    private String userId;
    private String username;
    private String password;
    private List<RoleTypeEnum> roles;
    private String location;
}
