package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.ClipTv;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sette.clipping.main.services.ClipTvService;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/clip-tv")
public class ClipTvController {

    private final ClipTvService clipTvService;
    public ClipTvController(ClipTvService clipTvService){
        this.clipTvService = clipTvService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<ClipTv>> getAllClipTv() {
        List<ClipTv> clipTv = clipTvService.findAllClipTv();
        return new ResponseEntity<>(clipTv, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<ClipTv> getClipTvByID(@PathVariable("id") long id) {
        ClipTv clipTv = clipTvService.findClipTv(id);
        return new ResponseEntity<>(clipTv, HttpStatus.OK);
    }  
 
    @PostMapping("/add")
    public ResponseEntity<ClipTv> addClipTv(@RequestBody ClipTv clipTv) {
        ClipTv newClipTv = clipTvService.addClipTv(clipTv);
        return new ResponseEntity<>(newClipTv, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateClipTv(@PathVariable long id, @RequestBody ClipTv clipTv){
        clipTvService.updateClipTv(id, clipTv);
    }
    
    @PutMapping("/update/group/{id}")
    public void updateClipTvGroup(@PathVariable long id, @RequestBody ClipTv clipTv){
        clipTvService.updateClipTvGroup(id, clipTv);
    }
    
    @PutMapping("/update/remove/{id}")
    public void removeClipTvFromGroup(@PathVariable long id, @RequestBody ClipTv clipTv){
        clipTvService.removeClipTvFromGroup(id, clipTv);
    }
    
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClipTvByID(@PathVariable("id") long id) {
        clipTvService.deleteClipTv(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
