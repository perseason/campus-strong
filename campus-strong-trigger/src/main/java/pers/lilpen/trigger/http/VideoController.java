package pers.lilpen.trigger.http;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author : penghuaishun
 * @version : 1.0
 * @date : 2025-02-08 14:12
 **/
@RestController
@RequestMapping("/api/video")
public class VideoController {
    @PostMapping("/upload")
    public String uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
        // 保存上传的文件到临时目录
        String uploadedFilePath = "/tmp/" + file.getOriginalFilename();
        file.transferTo(new File(uploadedFilePath));

        // 使用 FFmpeg 推送视频到 ZLMediaKit， 后续替换有业务逻辑的key
        String streamKey = "stream_" + System.currentTimeMillis(); // 动态生成流密钥
        String ffmpegCommand = "ffmpeg -i " + uploadedFilePath + " -c copy -f flv rtmp://your-zlmediakit-server/live/" + streamKey;
        Runtime.getRuntime().exec(ffmpegCommand);

        return "视频上传成功，流密钥: " + streamKey;
    }

    @GetMapping("/play")
    public String playVideo(@RequestParam("streamKey") String streamKey) {
        // 生成 ZLMediaKit 的 HLS 播放 URL
        return "http://your-zlmediakit-server:8080/live/" + streamKey + "/index.m3u8";
    }

    @GetMapping("/list")
    public List<String> listVideos() {
        // 假设从数据库获取视频流密钥列表

        return Arrays.asList("stream_123", "stream_456");
    }
}
