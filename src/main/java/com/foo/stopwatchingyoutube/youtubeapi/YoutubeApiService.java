package com.foo.stopwatchingyoutube.youtubeapi;

import com.foo.stopwatchingyoutube.category.transfer.Category;
import com.foo.stopwatchingyoutube.video.tranfer.VideoId;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Language;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Region;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class YoutubeApiService {
    private final YoutubeApiRepository youtubeApiRepository;

    public List<Category> getAllCategories(Region region, Language language) {
        return youtubeApiRepository.getAllCategories(region, language);
    }

    public List<Category> getVideoCategories(Region region, Language language, VideoId videoId) {
        return youtubeApiRepository.getVideoCategories(region, language, videoId);
    }
}
