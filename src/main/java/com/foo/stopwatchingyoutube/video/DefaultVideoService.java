package com.foo.stopwatchingyoutube.video;

import com.foo.stopwatchingyoutube.category.transfer.Category;
import com.foo.stopwatchingyoutube.category.domain.CategoryBlacklist;
import com.foo.stopwatchingyoutube.category.CategoryService;
import com.foo.stopwatchingyoutube.channel.transfer.Channel;
import com.foo.stopwatchingyoutube.channel.ChannelService;
import com.foo.stopwatchingyoutube.video.tranfer.VideoId;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Language;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Region;
import com.foo.stopwatchingyoutube.youtubeapi.YoutubeApiService;
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
