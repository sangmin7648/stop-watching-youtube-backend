package com.foo.stopwatchingyoutube.category;

import com.foo.stopwatchingyoutube.category.transfer.Category;
import com.foo.stopwatchingyoutube.category.domain.CategoryBlacklist;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryCategoryRepository implements CategoryRepository {
    private final CategoryBlacklist categoryBlacklist = new CategoryBlacklist();

    @Override
    public CategoryBlacklist getBlacklist() {
        return categoryBlacklist;
    }

    @Override
    public CategoryBlacklist insertBlacklist(CategoryBlacklist categoryBlacklist) {
        categoryBlacklist.getCategoryBlacklist().forEach(this.categoryBlacklist::addCategory);
        return categoryBlacklist;
    }

    @Override
    public void deleteCategoryFromBlacklist(Category category) {
        categoryBlacklist.removeCategory(category);
    }
}
