package com.foo.stopwatchingyoutube.category.domain;

import com.foo.stopwatchingyoutube.category.transfer.Category;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CategoryBlacklist {
    private final List<Category> categoryBlacklist;

    public CategoryBlacklist() {
        categoryBlacklist = new ArrayList<>();
    }

    public CategoryBlacklist(List<Category> categoryList) {
        categoryBlacklist = categoryList;
    }

    public void addCategory(Category category) {
        if (!contains(category))
            categoryBlacklist.add(category);
    }

    public void removeCategory(Category category) {
        categoryBlacklist.remove(category);
    }

    public boolean contains(Category category) {
        return categoryBlacklist.stream()
            .anyMatch(blockCategory -> blockCategory.equals(category));
    }

    @Override
    public String toString() {
        return categoryBlacklist.toString();
    }
}
