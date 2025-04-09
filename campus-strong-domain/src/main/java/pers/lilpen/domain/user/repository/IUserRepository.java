package pers.lilpen.domain.user.repository;

import pers.lilpen.domain.user.model.entity.UserEntity;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
public interface IUserRepository {
    UserEntity save(UserEntity userEntity);

    UserEntity getByUserMainInfo(String userId, String password);

    boolean cacheUserInformation(String cacheKey, UserEntity userEntity, long expireTime);
}
