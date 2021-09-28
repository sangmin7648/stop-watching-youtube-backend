package com.foo.stopwatchingyoutube.youtubeapi.repository;

import com.foo.stopwatchingyoutube.category.domain.Category;
import com.foo.stopwatchingyoutube.video.domain.VideoId;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Language;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Region;

import java.util.List;

public interface YoutubeApiRepository {
    List<Category> getAllCategories(Region region, Language language);
    List<Category> getVideoCategories(Region region, Language language, VideoId url);
}
