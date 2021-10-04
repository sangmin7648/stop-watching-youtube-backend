package com.foo.stopwatchingyoutube.category;

import com.foo.stopwatchingyoutube.category.transfer.Category;
import com.foo.stopwatchingyoutube.category.domain.CategoryBlacklist;
import com.foo.stopwatchingyoutube.category.transfer.request.CategoryBlacklistRequest;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Language;
import com.foo.stopwatchingyoutube.youtubeapi.transfer.Region;
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
