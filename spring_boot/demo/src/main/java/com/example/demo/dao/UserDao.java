package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getUser() {
        System.out.println("jdbc template: " + jdbcTemplate);
        String query = "select * from user";

        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(User.class));
    }

    public void createProduct(User user) {
        String query = "insert into user(fname,lname,city)values(?,?,?)";
        jdbcTemplate.update(query,user.getFname(),user.getLname(),user.getCity());
    }

    public void deleteProduct(int userId) {
        // TODO Auto-generated method stub
        String query = "delete from user where id=?";
        jdbcTemplate.update(query, userId);
    }

    public User getPtoduct(int userId) {
        String query = "select * from user where id=?";
        return jdbcTemplate.queryForObject(query, new Object[] { userId },
                new BeanPropertyRowMapper<User>(User.class));
    }

    public int setUpdate(User user) {
        System.out.print("dao page");
        String query = "update user set fname='" + user.getFname() + "',lname='" + user.getLname()
                + "',city='" + user.getCity() + "' where id='" + user.getId() + "'";
        return jdbcTemplate.update(query);
    }
}
