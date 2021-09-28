package com.foo.stopwatchingyoutube.category.service;

import com.foo.stopwatchingyoutube.category.domain.Category;
import com.foo.stopwatchingyoutube.category.domain.CategoryBlacklist;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Language;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Region;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoryList(Region region, Language language);
    CategoryBlacklist getBlacklist();
    CategoryBlacklist createBlackList(List<Category> categoryList);
    CategoryBlacklist removeCategoriesFromBlacklist(List<Category> categoryList);
}
