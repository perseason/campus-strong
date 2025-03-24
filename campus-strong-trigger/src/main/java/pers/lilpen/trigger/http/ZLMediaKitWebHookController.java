package pers.lilpen.trigger.http;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author : penghuaishun
 * @version : 1.0
 **/
@RestController
@RequestMapping("/hooks")
public class ZLMediaKitWebHookController {
    @PostMapping("/stream_changed")
    public ResponseEntity<String> onStreamChanged(@RequestBody Map<String, String> payload) {
        String streamId = payload.get("stream");
        String event = payload.get("regist");
        if ("1".equals(event)) {
            System.out.println("Stream started: " + streamId);
        } else {
            System.out.println("Stream stopped: " + streamId);
        }
        return ResponseEntity.ok("OK");
    }
}
