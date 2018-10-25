package com.isbing.blog.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by songbing on 2018/10/25 20:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    private long id;//文章分类ID
    private String name;//分类的名字
    private int sort;//文章分类的排序
    private int status;//状态
    private Date createAt;//创建时间

    public class Status {
        public static final int SUCCESS = 1;
        public static final int DELETE = 2;
    }
}
