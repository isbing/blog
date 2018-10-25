package com.isbing.blog.controller;

import com.isbing.blog.bean.Category;
import com.isbing.blog.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by songbing on 2018/10/25 20:38
 */
@RestController
@RequestMapping(value = "/v1/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public Category getById(@PathVariable long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/")
    public void create(@RequestBody Category category) {
        categoryService.create(category);
    }

    @PutMapping("/")
    public void update(@RequestBody Category category) {
        categoryService.updateNameOrSortById(category);
    }
}
