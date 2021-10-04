package com.foo.stopwatchingyoutube.category;

import com.foo.stopwatchingyoutube.category.transfer.Category;
import com.foo.stopwatchingyoutube.category.domain.CategoryBlacklist;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Language;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Region;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoryList(Region region, Language language);
    CategoryBlacklist getBlacklist();
    CategoryBlacklist createBlackList(List<Category> categoryList);
    CategoryBlacklist removeCategoriesFromBlacklist(List<Category> categoryList);
}
