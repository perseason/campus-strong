package pers.lilpen.domain.user.model.valobj;

import lombok.Getter;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Getter
public class UserRedisCommon {
    private static final String USER_AUTH_KEY = "user_auth_";
    public static final long USER_AUTH_EXPIRE_TIME = 60 * 60 * 24;// 1天

    public static String getAuthKey(String userId) {
        return USER_AUTH_KEY + userId;
    }
}
