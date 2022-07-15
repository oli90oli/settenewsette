package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.ClipGroup;
import com.sette.clipping.main.services.ClipGroupService;
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
@RequestMapping("/groups")
public class ClipGroupController {

    private  final ClipGroupService clipGroupService;
    public ClipGroupController(ClipGroupService clipGroupService) {
        this.clipGroupService = clipGroupService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<ClipGroup>> getAllGroups() {
        List<ClipGroup> clipGroup = clipGroupService.findAllClipGroup();
        return new ResponseEntity<>(clipGroup, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<ClipGroup> getGroupByID(@PathVariable("id") int id) {
        ClipGroup clipGroup = clipGroupService.findClipGroup(id);
        return new ResponseEntity<>(clipGroup, HttpStatus.OK);
    } 
 
    @PostMapping("/add")
    public ResponseEntity<ClipGroup> addGroup (@RequestBody ClipGroup clipGroup) {
        ClipGroup newGroup = clipGroupService.addClipGroup(clipGroup);
        return new ResponseEntity<>(newGroup, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateGroup(@PathVariable int id, @RequestBody ClipGroup clipGroup){
        clipGroupService.updateClipGroup(id, clipGroup);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGroupByID(@PathVariable("id") int id) {
        clipGroupService.deleteClipGroup(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
