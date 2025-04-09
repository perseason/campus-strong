package pers.lilpen.app.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pers.lilpen.domain.user.model.entity.UserEntity;
import pers.lilpen.infrastructure.redis.IRedisService;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private IRedisService redisService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = redisService.getValue(username);
        if (null == userEntity) return null;
        return new UserDetailAuthSecurity(userEntity);
    }

}
