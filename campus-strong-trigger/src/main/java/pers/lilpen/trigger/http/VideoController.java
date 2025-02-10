package pers.lilpen.trigger.http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.lilpen.types.model.Response;

/**
 * @author : penghuaishun
 * @version : 1.0
 * @date : 2025-02-08 14:12
 **/
@RestController
@RequestMapping("/api/video")
public class VideoController {

    private static final String VIDEO_DIR = "videos/";
    private static final String FFMPEG_PATH = "/usr/bin/ffmpeg";
    private static final String FFPROBE_PATH = "/usr/bin/ffprobe";

    @PostMapping("/upload")
    public Response<String> upload() {

        return null;
    }
}
