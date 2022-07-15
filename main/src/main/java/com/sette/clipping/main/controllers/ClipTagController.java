package com.sette.clipping.main.controllers;

import com.sette.clipping.main.services.ClipTagService;
import java.util.List;
import org.springframework.http.HttpStatus;
import com.sette.clipping.main.model.ClipTag;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/clip-tags")
public class ClipTagController {

    private final ClipTagService clipTagService;
    public ClipTagController(ClipTagService clipTagService){
        this.clipTagService = clipTagService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<ClipTag>> getAllClipTags() {
        List<ClipTag> clipTags = clipTagService.findAllClipTag();
        return new ResponseEntity<>(clipTags, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClipTag> getClipTagByID(@PathVariable("id") int id) {
        ClipTag clipTag = clipTagService.findClipTag(id);
        return new ResponseEntity<>(clipTag, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ClipTag> addClipTag(@RequestBody ClipTag clipTag) {
        ClipTag newClipTag = clipTagService.addClipTag(clipTag);
        return new ResponseEntity<>(newClipTag, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public void updateClipTag(@PathVariable int id, @RequestBody ClipTag clipTag){
        clipTagService.updateClipTag(id, clipTag);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClipTagByID(@PathVariable("id") int id) {
        clipTagService.deleteClipTag(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
