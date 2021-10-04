package com.foo.stopwatchingyoutube.youtubeapi;

import com.foo.stopwatchingyoutube.category.transfer.Category;
import com.foo.stopwatchingyoutube.video.tranfer.VideoId;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Language;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Region;

import java.util.List;

public interface YoutubeApiRepository {
    List<Category> getAllCategories(Region region, Language language);
    List<Category> getVideoCategories(Region region, Language language, VideoId url);
}
