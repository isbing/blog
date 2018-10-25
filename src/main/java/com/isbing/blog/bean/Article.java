package com.isbing.blog.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by songbing on 2018/10/25 20:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {
    private long id;
    private String name;//文章标题
    private String summary;//文章的摘要
    private String content;//文章的内容
    private int viewCount;//文章查看数量
    private int categoryId;//文章的分类
    private int status;//文章的编写状态
    private String createBy;//文章的编写人
    private Date createAt;//文章的创建时间
    private Date modifyAt;//文章的修改时间

    public class Status {
        public static final int PUBLISH = 1;
        public static final int NOT_PUBLISH = 2;
        public static final int DELETE = 3;
    }
}
