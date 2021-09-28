package com.foo.stopwatchingyoutube.category.controller;

import com.foo.stopwatchingyoutube.category.domain.Category;
import com.foo.stopwatchingyoutube.category.domain.CategoryBlacklist;
import com.foo.stopwatchingyoutube.category.service.DefaultCategoryService;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Language;
import com.foo.stopwatchingyoutube.youtubeapi.domain.Region;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/categories")
@AllArgsConstructor
public class CategoryRestController {
    private final DefaultCategoryService categoryService;

    @GetMapping("/list")
    public List<Category> getCategoryList(@RequestParam Region region, @RequestParam Language language) {
        return categoryService.getCategoryList(region, language);
    }

    @GetMapping("/blacklist")
    public CategoryBlacklist getCategoryBlacklist() {
        return categoryService.getBlacklist();
    }

    @PutMapping("/blacklist")
    public CategoryBlacklist createChannelBlacklist(@RequestBody CategoryBlacklistRequest categoryBlacklistRequest) {
        return categoryService.createBlackList(categoryBlacklistRequest.categoryList);
    }

    @DeleteMapping("/blacklist")
    public CategoryBlacklist removeChannelsFromBlacklist(@RequestBody CategoryBlacklistRequest categoryBlacklistRequest) {
        return categoryService.removeCategoriesFromBlacklist(categoryBlacklistRequest.categoryList);
    }
}
