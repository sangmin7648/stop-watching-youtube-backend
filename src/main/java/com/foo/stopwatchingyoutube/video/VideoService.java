package com.foo.stopwatchingyoutube.video;

import com.foo.stopwatchingyoutube.channel.transfer.Channel;
import com.foo.stopwatchingyoutube.video.tranfer.VideoId;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Language;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Region;

public interface VideoService {
    boolean isWatchable(Region region, Language language, VideoId videoId, Channel channel);
}
