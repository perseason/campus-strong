package pers.lilpen.app.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "zlmediakit")
public class ZLMediaKitConfigProperties {
    private String host;
    private int httpPort;
    private int rtmpPort;
    private int rtspPort;
    private int rtpPort;
    private String recordPath;
    private String ffmpegPath;
}
