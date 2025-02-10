package com.project.UserManagament.controllers;

import com.project.UserManagament.dto.Task;
import com.project.UserManagament.dto.User;
import com.project.UserManagament.services.UserService;
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

//    @GetMapping("/hello")
//    public String sayHello(@RequestParam("mensaje") String mensaje){
//        return mensaje;
//    }
//
//    @GetMapping("/hello/{mensaje}")
//    public String sayHello2(@PathVariable("mensaje") String mensaje){
//        return mensaje;
//    }

    @PostMapping("/task")
    public ResponseEntity<String> Task(@RequestBody Task task){
        String response = task.getName().concat("_"+task.getId());
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(response, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        user = userService.saveUser(user);
        ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        ResponseEntity<List<User>> responseEntity = new ResponseEntity<>(users, HttpStatus.OK);
        return responseEntity;
    }

}
