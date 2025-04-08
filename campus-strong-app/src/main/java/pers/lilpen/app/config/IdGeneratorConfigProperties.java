package pers.lilpen.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Data
@ConfigurationProperties(prefix = "id.generator.config", ignoreInvalidFields = true)
public class IdGeneratorConfigProperties {
    private long datacenterId;
    private long machineId;
}
