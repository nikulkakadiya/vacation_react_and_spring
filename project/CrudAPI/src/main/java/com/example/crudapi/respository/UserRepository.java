package com.example.crudapi.respository;

import com.example.crudapi.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUser() {
        String query = "SELECT * FROM user";
        List<User> users = jdbcTemplate.query(query,
                    BeanPropertyRowMapper.newInstance(User.class));
        return users;

    }

    public User findById(Integer id) {
        String sql = "SELECT * FROM user WHERE ID = ?";
        try {
            return (User) this.jdbcTemplate.queryForObject(sql, new Object[] { id },
                    new BeanPropertyRowMapper<User>(User.class));
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    public void saveUser(User user) {
        String query = "insert into user(id,fname,lname,city)values(?,?,?,?)";
        jdbcTemplate.update(query, user.getId(), user.getFname(), user.getLname(), user.getCity());
    }

    public void deleteUserById(Integer id) {
        String query = "delete from user where id=?";
        jdbcTemplate.update(query, id);
    }

    public int updateUser(User user) {
        String query = "update user set fname='" + user.getFname() + "',lname='" + user.getLname()
                + "',city='" + user.getCity() + "' where id='" + user.getId() + "'";
        return jdbcTemplate.update(query);
    }
}
