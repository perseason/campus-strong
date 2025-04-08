package pers.lilpen.app.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Configuration
@EnableConfigurationProperties(IdGeneratorConfigProperties.class)
public class IdGeneratorConfig {

}
