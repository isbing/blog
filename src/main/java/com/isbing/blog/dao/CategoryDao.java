package com.isbing.blog.dao;

import com.isbing.blog.bean.Category;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by songbing on 2018/10/25 20:39
 */
@Repository
public class CategoryDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public Category findById(long id) {
        String sql = "select * from category where id = ?";
        Object[] params = {
                id
        };
        List<Category> categoryList = jdbcTemplate.query(sql, params, new CategoryRowMapper());
        if (CollectionUtils.isNotEmpty(categoryList)) {
            return categoryList.get(0);
        }
        return null;
    }


    public void insert(Category category) {
//        KeyHolder holder = new GeneratedKeyHolder();
//        jdbcTemplate.update(connection -> {
//            String insertSql = "INSERT INTO category (`name`, sort, status, create_at) VALUES (?,?,?,?);";
//            PreparedStatement ps = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1,category.getName());
//            ps.setInt(2,category.getSort());
//            ps.setInt(3,category.getStatus());
//            ps.setTimestamp(4,new Date());
//            return ps;
//        },holder);
//        final long id = holder.getKey().longValue();
//        return id;
        String sql = "INSERT INTO category (`name`, sort, status, create_at) VALUES (?,?,?,?)";
        Object[] params = {
                category.getName(),
                category.getSort(),
                category.getStatus(),
                new Date()
        };
        jdbcTemplate.update(sql, params);
    }


    public void updateById(long categoryId, Map<String, Object> updateFields) {
        //拼装sql语句
        StringBuilder sqlBuilder = new StringBuilder("UPDATE category SET ");
        Object[] params = new Object[updateFields.size() + 2];
        int index = 0;
        for (String field : updateFields.keySet()) {
            sqlBuilder.append(field).append(" = ?,");
            params[index++] = updateFields.get(field);
        }
        sqlBuilder.append("modify_time=? ");
        params[index++] = new Date();
        sqlBuilder.append(" WHERE id=?");
        params[index] = categoryId;
        jdbcTemplate.update(sqlBuilder.toString(), params);
    }


    static class CategoryRowMapper implements RowMapper<Category> {
        public Category mapRow(ResultSet resultSet, int i) throws SQLException {
            return Category.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .sort(resultSet.getInt("sort"))
                    .status(resultSet.getInt("status"))
                    .createAt(resultSet.getTimestamp("create_at"))
                    .build();
        }
    }
}
