package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Tags;
import com.sette.clipping.main.services.TagsService;
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
@RequestMapping("/tags")
public class TagsController {
    
    private final TagsService tagService;
    public TagsController(TagsService tagService){
        this.tagService = tagService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<Tags>> getAllTags() {
        List<Tags> tags = tagService.findAllTags();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Tags> getTagsByID(@PathVariable("id") int id) {
        Tags tags = tagService.findTags(id);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }  
 
    @PostMapping("/add")
    public ResponseEntity<Tags> addTags(@RequestBody Tags tag) {
        Tags newTag = tagService.addTags(tag);
        return new ResponseEntity<>(newTag, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateTags(@PathVariable int id, @RequestBody Tags tag){
        tagService.updateTags(id, tag);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTagsByID(@PathVariable("id") int id) {
        tagService.deleteTag(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
