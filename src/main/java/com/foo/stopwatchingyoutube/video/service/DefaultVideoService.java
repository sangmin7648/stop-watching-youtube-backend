package com.foo.stopwatchingyoutube.video.service;

import com.foo.stopwatchingyoutube.category.domain.Category;
import com.foo.stopwatchingyoutube.category.domain.CategoryBlacklist;
import com.foo.stopwatchingyoutube.category.service.CategoryService;
import com.foo.stopwatchingyoutube.channel.domain.Channel;
import com.foo.stopwatchingyoutube.channel.service.ChannelService;
import com.foo.stopwatchingyoutube.video.domain.VideoId;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Language;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Region;
import com.foo.stopwatchingyoutube.youtubeapi.service.YoutubeApiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultVideoService implements VideoService {
    private final YoutubeApiService youtubeApiService;
    private final CategoryService categoryService;
    private final ChannelService channelService;

    @Override
    public boolean isWatchable(Region region, Language language, VideoId videoId, Channel channel) {
        return isWatchableCategory(region, language, videoId) && isWatchableChannel(channel);
    }

    private boolean isWatchableCategory(Region region, Language language, VideoId videoId) {
        CategoryBlacklist categoryBlacklist = categoryService.getBlacklist();
        List<Category> videoCategoryList = youtubeApiService.getVideoCategories(region, language, videoId);
        System.out.println(videoCategoryList.toString());
        return categoryBlacklist.getCategoryBlacklist().stream()
            .noneMatch(videoCategoryList::contains);
    }

    private boolean isWatchableChannel(Channel channel) {
        var channelBlacklist = channelService.getBlacklist();
        return !channelBlacklist.contains(channel);
    }
}
