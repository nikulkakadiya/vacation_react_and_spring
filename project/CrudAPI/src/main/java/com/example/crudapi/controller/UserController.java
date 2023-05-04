package com.example.crudapi.controller;



import com.example.crudapi.bean.User;
import com.example.crudapi.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

//*****************testing function********************

    @GetMapping("/test")
    public String show(){
        return "nikul kakadiya";
    }

//*****************select all record********************

    @GetMapping("/")
    public List<User> getAllUser() {
        return userRepository.getUser();
    }

//*****************select one record********************

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id);
        if (user == null) {
            return new ResponseEntity<String>("No User found with this " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

//*****************insert record********************

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) throws SQLIntegrityConstraintViolationException {
        if (userRepository.findById(user.getId()) != null) {
            return new ResponseEntity<String>("Duplicate Entry " + user.getId(), HttpStatus.IM_USED);
        }
        userRepository.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//*****************delte record********************

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        User user = userRepository.findById(id);
        if (user == null) {
            return new ResponseEntity<String>("Unable to delete as  User id " + id + " not found.",
                    HttpStatus.NOT_FOUND);
        }
        userRepository.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

//*****************update record********************

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        if (userRepository.findById(user.getId()) == null) {
            return new ResponseEntity<String>("Unable to update as  User id " + user.getId() + " not found.",
                    HttpStatus.NOT_FOUND);
        }

        userRepository.updateUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
