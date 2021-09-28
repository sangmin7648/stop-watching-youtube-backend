package com.foo.stopwatchingyoutube.category.service;

import com.foo.stopwatchingyoutube.category.domain.Category;
import com.foo.stopwatchingyoutube.category.domain.CategoryBlacklist;
import com.foo.stopwatchingyoutube.category.repository.CategoryRepository;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Language;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Region;
import com.foo.stopwatchingyoutube.youtubeapi.service.YoutubeApiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultCategoryService implements CategoryService{
    private final YoutubeApiService youtubeApiService;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategoryList(Region region, Language language) {
        return youtubeApiService.getAllCategories(region, language);
    }

    @Override
    public CategoryBlacklist getBlacklist() {
        return categoryRepository.getBlacklist();
    }

    @Override
    public CategoryBlacklist createBlackList(List<Category> categoryList) {
        var categoryBlacklist = new CategoryBlacklist(categoryList);
        return categoryRepository.insertBlacklist(categoryBlacklist);
    }

    @Override
    @Transactional
    public CategoryBlacklist removeCategoriesFromBlacklist(List<Category> categoryList) {
        var categoryBlacklist = new CategoryBlacklist(categoryList);
        categoryBlacklist.getCategoryBlacklist().forEach(categoryRepository::deleteCategoryFromBlacklist);
        return getBlacklist();
    }
}
