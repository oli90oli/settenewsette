package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.ClipAuthors;
import com.sette.clipping.main.model.ClipTag;
import com.sette.clipping.main.services.ClipAuthorsService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/clip-authors")
public class ClipAuthorsController {

    private final ClipAuthorsService clipAuthorsService;
    public ClipAuthorsController(ClipAuthorsService clipAuthorsService){
        this.clipAuthorsService = clipAuthorsService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<ClipAuthors>> getAllClipAuthors() {
        List<ClipAuthors> clipAuthors = clipAuthorsService.findAllClipAuthors();
        return new ResponseEntity<>(clipAuthors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClipAuthors> getClipAuthorByID(@PathVariable("id") int id) {
        ClipAuthors clipAuthor = clipAuthorsService.findClipAuthors(id);
        return new ResponseEntity<>(clipAuthor, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ClipAuthors> addClipAuthor(@RequestBody ClipAuthors clipAuthor) {
        ClipAuthors newClipAuthor = clipAuthorsService.addClipAuthors(clipAuthor);
        return new ResponseEntity<>(newClipAuthor, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public void updateClipAuthor(@PathVariable int id, @RequestBody ClipAuthors clipAuthor){
        clipAuthorsService.updateClipAuthors(id, clipAuthor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClipAuthorByID(@PathVariable("id") int id) {
        clipAuthorsService.deleteClipAuthors(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
