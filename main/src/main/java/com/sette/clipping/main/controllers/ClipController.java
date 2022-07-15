package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Clip;
import com.sette.clipping.main.services.ClipService;
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
@RequestMapping("/clip")
public class ClipController {

    private final ClipService clipService;
    public ClipController(ClipService clipService){
        this.clipService = clipService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<Clip>> getAllClip() {
        List<Clip> clip = clipService.findAllClip();
        return new ResponseEntity<>(clip, HttpStatus.OK);
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<Clip> getClipByID(@PathVariable("id") long id) {
        Clip clip = clipService.findClip(id);
        return new ResponseEntity<>(clip, HttpStatus.OK);
    }  
    
    @GetMapping("/last")
    public ResponseEntity<Clip> getLastClip() {
        Clip clip = clipService.returnLastClip();
        return new ResponseEntity<>(clip, HttpStatus.OK);
    }
 
    @PostMapping("/add")
    public ResponseEntity<Clip> addClip(@RequestBody Clip clip) {
        Clip newClip = clipService.addClip(clip);
        return new ResponseEntity<>(newClip, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateClip(@PathVariable long id, @RequestBody Clip clip){
        clipService.updateClip(id, clip);
    }
    
    @PutMapping("/update/group/{id}")
    public void updateClipGroup(@PathVariable long id, @RequestBody Clip clip){
        clipService.updateClipGroup(id, clip);
    }
    
    @PutMapping("/update/remove/{id}")
    public void removeClipFromGroup(@PathVariable long id, @RequestBody Clip clip){
        clipService.removeClipFromGroup(id, clip);
    }
    
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClipByID(@PathVariable("id") long id) {
        clipService.deleteClip(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
