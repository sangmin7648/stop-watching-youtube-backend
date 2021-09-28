package com.foo.stopwatchingyoutube.category.domain;

import com.foo.stopwatchingyoutube.youtubeapi.domain.Region;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@Getter
public class Category {
    private int categoryId;
    private Region region;
    private String categoryName;

    public Category(int categoryId, Region region) {
        this.categoryId = categoryId;
        this.region = region;
        this.categoryName = "";
    }

    public Category(int categoryId, Region region, String categoryName) {
        this.categoryId = categoryId;
        this.region = region;
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId && Objects.equals(region, category.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, region);
    }

    @Override
    public String toString() {
        return "Category{" +
            "categoryId=" + categoryId +
            ", region=" + region +
            ", categoryName='" + categoryName + '\'' +
            '}';
    }
}
