package com.foo.stopwatchingyoutube.youtubeapi.repository;

import com.foo.stopwatchingyoutube.category.domain.Category;
import com.foo.stopwatchingyoutube.video.domain.VideoId;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Language;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Region;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Repository
public class ApiKeyYoutubeApiRepository implements YoutubeApiRepository {
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new GsonFactory();
    private static YouTube youtube;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    static {
        youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
            public void initialize(HttpRequest request) throws IOException {}
        }).setApplicationName("youtube-get-category-list").build();
    }

    @Value("${youtube.data-api.key}")
    private String apiKey;

    @Override
    public List<Category> getAllCategories(Region region, Language language) {
        try {
            YouTube.VideoCategories.List categoryListRequest = youtube.videoCategories().list(List.of("id"));
            logger.info("apiKey -> " + apiKey);
            categoryListRequest.setKey(apiKey);
            categoryListRequest.setRegionCode(region.getRegionName());
            categoryListRequest.setHl(language.getLanguage());
            var results = categoryListRequest.execute().getItems();

            var categoryList = new ArrayList<Category>();
            results.forEach(result -> categoryList.add(new Category(Integer.parseInt(result.getId()), region, result.getSnippet().getTitle())));
            return categoryList;
        } catch (IOException e) {
            logger.error("could not get categoryList from youtube api", e);
            return Collections.emptyList();
        }
    }

    @Override
    public List<Category> getVideoCategories(Region region, Language language, VideoId videoId) {
        try {
            YouTube.Videos.List categoryListRequest = youtube.videos().list(List.of("snippet","contentDetails","statistics"));
            categoryListRequest.setKey(apiKey);
            categoryListRequest.setId(List.of(videoId.getVideoId()));
            categoryListRequest.setRegionCode(region.getRegionName());
            categoryListRequest.setHl(language.getLanguage());
            var results = categoryListRequest.execute().getItems();

            var categoryList = new ArrayList<Category>();
            results.forEach(result -> categoryList.add(new Category(Integer.parseInt(result.getSnippet().getCategoryId()), region)));
            return categoryList;
        } catch (IOException e) {
            logger.error("could not get categoryList from youtube api", e);
            return Collections.emptyList();
        }
    }
}
