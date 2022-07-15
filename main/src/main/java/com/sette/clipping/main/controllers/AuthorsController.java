package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Authors;
import com.sette.clipping.main.services.AuthorsService;
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

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private  final AuthorsService authorService;
    public AuthorsController(AuthorsService authorService) {
        this.authorService = authorService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<Authors>> getAllAuthors() {
        List<Authors> authors = authorService.findAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Authors> getAuthorsByID(@PathVariable("id") int id) {
        Authors author = authorService.findAuthor(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    } 
 
    @PostMapping("/add")
    public ResponseEntity<Authors> addAuthors(@RequestBody Authors author) {
        Authors newAuthor = authorService.addAuthors(author);
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateAuthors(@PathVariable int id, @RequestBody Authors author){
        authorService.updateAuthors(id, author);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthorsByID(@PathVariable("id") int id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
