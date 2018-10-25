package com.isbing.blog.service;

import com.isbing.blog.dao.ArticleDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by songbing on 2018/10/26 0:01
 */
@Service
public class ArticleService {
    @Resource
    private ArticleDao articleDao;
}
