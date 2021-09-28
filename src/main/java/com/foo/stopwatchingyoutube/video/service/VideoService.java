package com.foo.stopwatchingyoutube.video.service;

import com.foo.stopwatchingyoutube.channel.domain.Channel;
import com.foo.stopwatchingyoutube.video.domain.VideoId;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Language;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Region;

public interface VideoService {
    boolean isWatchable(Region region, Language language, VideoId videoId, Channel channel);
}
