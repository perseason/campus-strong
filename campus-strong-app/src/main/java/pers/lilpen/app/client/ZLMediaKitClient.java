package pers.lilpen.app.client;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import pers.lilpen.app.config.ZLMediaKitConfigProperties;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@Slf4j
@Getter
@Setter
@Builder
public class ZLMediaKitClient {
    private String host;
    private int httpPort;
    private int rtmpPort;
    private int rtspPort;
    private int rtpPort;
    private String recordPath;
    private String ffmpegPath;

    public static ZLMediaKitClient create(ZLMediaKitConfigProperties zlMediaKitConfigProperties) {
        return builder()
                .host(zlMediaKitConfigProperties.getHost())
                .httpPort(zlMediaKitConfigProperties.getHttpPort())
                .rtmpPort(zlMediaKitConfigProperties.getRtmpPort())
                .rtspPort(zlMediaKitConfigProperties.getRtspPort())
                .rtpPort(zlMediaKitConfigProperties.getRtpPort())
                .recordPath(zlMediaKitConfigProperties.getRecordPath())
                .ffmpegPath(zlMediaKitConfigProperties.getFfmpegPath())
                .build();
    }

    private String getPlayUrl(String streamId) {
        return "http://" + host + ":" + httpPort + "/index/" + streamId + ".m3u8";
    }

    public String uploadVideo(MultipartFile file, String streamKey) throws IOException {
        // 生成 RTMP 推送地址
        String rtmpUrl = "rtmp://" + host + ":" + rtmpPort + "/live/" + streamKey;

        // 创建 FFmpeg 命令，使用标准输入
        String ffmpegCommand = "ffmpeg -i - -c copy -f flv " + rtmpUrl;

        // 使用 ProcessBuilder 启动 FFmpeg 进程
        ProcessBuilder processBuilder = new ProcessBuilder(ffmpegCommand.split(" "));
        processBuilder.redirectErrorStream(true); // 合并错误输出到标准输出
        Process process = processBuilder.start();

        // 获取 FFmpeg 的输入流并将上传数据写入
        try (OutputStream ffmpegInput = process.getOutputStream();
             InputStream fileInput = file.getInputStream()) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = fileInput.read(buffer)) != -1) {
                ffmpegInput.write(buffer, 0, bytesRead);
            }
        } // 自动关闭流

        // 等待 FFmpeg 进程完成并检查退出码
        try {
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new RuntimeException("FFmpeg 进程异常退出，退出码: " + exitCode);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("FFmpeg 进程被中断", e);
        }
        log.info("视频上传成功，流密钥: {}", streamKey);
        return streamKey;
    }
}
