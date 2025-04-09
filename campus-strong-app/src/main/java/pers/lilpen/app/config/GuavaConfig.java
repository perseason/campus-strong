package pers.lilpen.app.config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.lilpen.domain.user.model.entity.UserEntity;

import java.util.concurrent.TimeUnit;

@Configuration
public class GuavaConfig {

    @Bean(name = "cache")
    public Cache<String, String> cache() {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build();
    }

    @Bean(name = "userCache")
    public Cache<String, UserEntity> userEntityCache() {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(365, TimeUnit.DAYS)
                .build();
    }

}
