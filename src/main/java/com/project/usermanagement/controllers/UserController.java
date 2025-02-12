package com.project.usermanagement.controllers;

import com.project.usermanagement.dtos.Task;
import com.project.usermanagement.dtos.User;
import com.project.usermanagement.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/task")
    public ResponseEntity<String> task(@RequestBody Task task){
        String response = task.getTask().concat("_"+task.getId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        user = userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id){
        user = userService.updateUser(user, id);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PatchMapping("/user/update-active/{id}")
    public ResponseEntity<User> updateUserActive(@RequestBody User user, @PathVariable Integer id){
        user = userService.updateUserActive(user, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping("/user/update-date-born/{id}")
    public ResponseEntity<User> updateUserDateBorn(@RequestBody User user, @PathVariable Integer id){
        user = userService.updateUserDateBorn(user, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(path = "/login", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<User> login(@RequestBody User user){
        user = userService.login(user.getEmail(), user.getPassword());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
