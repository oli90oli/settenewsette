package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Users;
import com.sette.clipping.main.services.UsersService;

import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UsersController {

    private  final UsersService userService;
    public UsersController(UsersService userService) { this.userService = userService;}
    
    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUsersByID(@PathVariable("id") int id) {
        Users user = userService.findUsers(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    } 
 
    @PostMapping("/add")
    public ResponseEntity<Users> addUsers(@RequestBody Users user) {
        Users newUser = userService.addUsers(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateUsers(@PathVariable int id, @RequestBody Users user){
        userService.updateUsers(id, user);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsersByID(@PathVariable("id") int id) {
        userService.deleteUsers(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //register
//    @PostMapping("/register")
//    public ResponseEntity<Users> registerUser(@RequestBody Users user) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/register").toUriString());
//        return ResponseEntity.created(uri).body(userService.register(user));
//    }
}
