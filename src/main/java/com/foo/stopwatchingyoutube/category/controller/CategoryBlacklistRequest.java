package com.foo.stopwatchingyoutube.category.controller;


import com.foo.stopwatchingyoutube.category.domain.Category;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CategoryBlacklistRequest {
    public List<Category> categoryList;
}
