package com.foo.stopwatchingyoutube.category;

import com.foo.stopwatchingyoutube.category.transfer.Category;
import com.foo.stopwatchingyoutube.category.domain.CategoryBlacklist;

public interface CategoryRepository {
    CategoryBlacklist getBlacklist();
    CategoryBlacklist insertBlacklist(CategoryBlacklist channelBlacklist);
    void deleteCategoryFromBlacklist(Category category);
}
