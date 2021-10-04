package com.foo.stopwatchingyoutube.category.transfer.request;


import com.foo.stopwatchingyoutube.category.transfer.Category;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CategoryBlacklistRequest {
    public List<Category> categoryList;
}
