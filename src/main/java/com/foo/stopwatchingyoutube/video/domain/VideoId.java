package com.foo.stopwatchingyoutube.video.domain;

import lombok.Getter;

@Getter
public class VideoId {
    private final String videoId;

    public VideoId(String videoId) {
        validateId(videoId);
        this.videoId = videoId;
    }

    private void validateId(String videoId) {
        var YOUTUBE_VIDEO_ID_PATTERN = "^[A-Za-z0-9_-]+$";
        if (!videoId.matches(YOUTUBE_VIDEO_ID_PATTERN))
            throw new IllegalArgumentException("invalid youtube video url");
    }
}
