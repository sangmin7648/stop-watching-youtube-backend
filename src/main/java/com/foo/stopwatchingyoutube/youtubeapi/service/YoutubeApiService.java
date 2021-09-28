package com.foo.stopwatchingyoutube.youtubeapi.service;

import com.foo.stopwatchingyoutube.category.domain.Category;
import com.foo.stopwatchingyoutube.video.domain.VideoId;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Language;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Region;
import com.foo.stopwatchingyoutube.youtubeapi.repository.YoutubeApiRepository;
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
