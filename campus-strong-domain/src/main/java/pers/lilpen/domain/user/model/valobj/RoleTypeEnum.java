package pers.lilpen.domain.user.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RoleTypeEnum {

    ADMIN("ADMIN", "管理员"),
    USER("USER", "用户"),
    ;

    private String code;
    private String desc;

}