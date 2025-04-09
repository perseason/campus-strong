package pers.lilpen.infrastructure.persistent.repository;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import pers.lilpen.domain.user.model.entity.UserEntity;
import pers.lilpen.domain.user.repository.IUserRepository;
import pers.lilpen.infrastructure.persistent.dao.UserDao;
import pers.lilpen.infrastructure.redis.IRedisService;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Repository
public class UserRepository implements IUserRepository {
    @Resource
    private IRedisService redisService;
    @Resource
    private UserDao userDao;

    @Override
    public UserEntity save(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity getByUserMainInfo(String userId, String password) {
        return null;
    }

    @Override
    public boolean cacheUserInformation(String cacheKey, UserEntity userEntity, long expireTime) {
        try {
            redisService.setValue(cacheKey, userEntity, expireTime);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
