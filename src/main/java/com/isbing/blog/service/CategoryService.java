package com.isbing.blog.service;

import com.google.common.collect.Maps;
import com.isbing.blog.bean.Category;
import com.isbing.blog.dao.CategoryDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by songbing on 2018/10/25 20:39
 */
@Service
public class CategoryService {
    @Resource
    private CategoryDao categoryDao;

    public Category findById(long id) {
        return categoryDao.findById(id);
    }

    public void create(Category category) {
        category.setStatus(Category.Status.SUCCESS);
        categoryDao.insert(category);
    }

    public void updateNameOrSortById(Category category) {
        Map<String, Object> map = Maps.newHashMap();
        if (StringUtils.isNotBlank(category.getName())) {
            map.put("name", category.getName());
        }
        if (category.getSort() > 0) {
            map.put("sort", category.getSort());
        }
        if (category.getStatus() > 0) {
            map.put("status", category.getStatus());
        }
        categoryDao.updateById(category.getId(), map);
    }
}
