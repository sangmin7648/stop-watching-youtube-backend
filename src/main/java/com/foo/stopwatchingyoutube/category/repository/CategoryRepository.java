package com.foo.stopwatchingyoutube.category.repository;

import com.foo.stopwatchingyoutube.category.domain.Category;
import com.foo.stopwatchingyoutube.category.domain.CategoryBlacklist;

public interface CategoryRepository {
    CategoryBlacklist getBlacklist();
    CategoryBlacklist insertBlacklist(CategoryBlacklist channelBlacklist);
    void deleteCategoryFromBlacklist(Category category);
}
