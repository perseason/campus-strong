package pers.lilpen.domain.user.service.auth;

import pers.lilpen.domain.user.model.entity.UserEntity;
import pers.lilpen.types.common.Result;

public interface IAuthService {
    Result<UserEntity> register(UserEntity userEntity);

    Result<UserEntity> login(String userId, String password);
}