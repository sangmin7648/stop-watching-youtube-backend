package com.foo.stopwatchingyoutube.video;

import com.foo.stopwatchingyoutube.channel.transfer.Channel;
import com.foo.stopwatchingyoutube.video.tranfer.VideoId;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Language;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Region;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v0/videos")
@AllArgsConstructor
public class VideoRestController {
    private final VideoService videoService;

    @GetMapping("/watchable")
    public Map<String, Boolean> watchable(@RequestParam Region region,
                                         @RequestParam Language language,
                                         @RequestParam VideoId videoId,
                                         @RequestParam Channel channel)
    {
        return Map.of("watchable", videoService.isWatchable(region, language, videoId, channel));
    }
}
