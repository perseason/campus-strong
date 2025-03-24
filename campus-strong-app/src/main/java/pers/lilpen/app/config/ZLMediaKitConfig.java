package pers.lilpen.app.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import pers.lilpen.app.client.ZLMediaKitClient;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@EnableConfigurationProperties(ZLMediaKitConfigProperties.class)
public class ZLMediaKitConfig {

    @Bean
    public ZLMediaKitClient zlMediaKitClient(ZLMediaKitConfigProperties zlMediaKitConfigProperties) {
        return ZLMediaKitClient.create(zlMediaKitConfigProperties);
    }
}
