package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.TagsCategories;
import com.sette.clipping.main.services.TagsCategoriesService;
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
@RequestMapping("/tagsCategories")
public class TagsCategoriesController {
    
    private final TagsCategoriesService tagsCategoriesService;
    public TagsCategoriesController(TagsCategoriesService tagsCategoriesService){
        this.tagsCategoriesService = tagsCategoriesService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<TagsCategories>> getAllTagsCategories() {
        List<TagsCategories> tags = tagsCategoriesService.findAllTagsCategories();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<TagsCategories> getTagsCategoriesByID(@PathVariable("id") int id) {
        TagsCategories tags = tagsCategoriesService.findTagsCategory(id);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }  
 
    @PostMapping("/add")
    public ResponseEntity<TagsCategories> addTagsCategories(@RequestBody TagsCategories tag) {
        TagsCategories newTag = tagsCategoriesService.addTagsCategory(tag);
        return new ResponseEntity<>(newTag, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateTagsCategories(@PathVariable int id, @RequestBody TagsCategories tag){
        tagsCategoriesService.updateTagsCategory(id, tag);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTagsCategoriesByID(@PathVariable("id") int id) {
        tagsCategoriesService.deleteTagsCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
