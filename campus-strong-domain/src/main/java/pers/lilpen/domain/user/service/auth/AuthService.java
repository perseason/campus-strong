package pers.lilpen.domain.user.service.auth;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import pers.lilpen.domain.user.model.entity.UserEntity;
import pers.lilpen.domain.user.model.valobj.UserRedisCommon;
import pers.lilpen.domain.user.repository.IUserRepository;
import pers.lilpen.types.common.Result;


/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Component
public class AuthService implements IAuthService {
    @Resource
    public IUserRepository userRepository;

    @Override
    public Result<UserEntity> register(UserEntity userEntity) {
        UserEntity userRes = userRepository.save(userEntity);
        if (null == userRes) {
            return Result.fail(null);
        }
        return Result.success(userRes);
    }

    @Override
    public Result<UserEntity> login(String userId, String password) {
        UserEntity userEntity = userRepository.getByUserMainInfo(userId, password);
        if (null == userEntity) {
            return Result.fail(null);
        }
        boolean isCachedSuccess = userRepository.cacheUserInformation(UserRedisCommon.getAuthKey(userId), userEntity, System.currentTimeMillis() + UserRedisCommon.USER_AUTH_EXPIRE_TIME);
        if (!isCachedSuccess) {
            return Result.fail(null);
        }
        return Result.success(userEntity);
    }
}
