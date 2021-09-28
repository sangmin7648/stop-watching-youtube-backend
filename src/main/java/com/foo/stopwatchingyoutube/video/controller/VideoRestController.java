package com.foo.stopwatchingyoutube.video.controller;

import com.foo.stopwatchingyoutube.channel.domain.Channel;
import com.foo.stopwatchingyoutube.video.domain.VideoId;
import com.foo.stopwatchingyoutube.video.service.VideoService;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Language;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Region;
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
