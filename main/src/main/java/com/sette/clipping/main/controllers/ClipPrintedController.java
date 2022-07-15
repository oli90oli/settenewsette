package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Clip;
import com.sette.clipping.main.model.ClipPrinted;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sette.clipping.main.services.ClipPrintedService;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/clip-printed")
public class ClipPrintedController {

    private final ClipPrintedService clipPrintedService;
    public ClipPrintedController(ClipPrintedService clipPrintedService){
        this.clipPrintedService = clipPrintedService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<ClipPrinted>> getAllClipPrinted() {
        List<ClipPrinted> clip = clipPrintedService.findAllClipPrinted();
        return new ResponseEntity<>(clip, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<ClipPrinted> getClipPrintedByID(@PathVariable("id") long id) {
        ClipPrinted clip = clipPrintedService.findClipPrinted(id);
        return new ResponseEntity<>(clip, HttpStatus.OK);
    }  
 
    @PostMapping("/add")
    public ResponseEntity<ClipPrinted> addClipPrinted(@RequestBody ClipPrinted clip) {
        ClipPrinted newClip = clipPrintedService.addClipPrinted(clip);
        return new ResponseEntity<>(newClip, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateClipPrinted(@PathVariable long id, @RequestBody ClipPrinted clip){
        clipPrintedService.updateClipPrinted(id, clip);
    }
    
    @PutMapping("/update/group/{id}")
    public void updateClipPrintedGroup(@PathVariable long id, @RequestBody ClipPrinted clip){
        clipPrintedService.updateClipPrintedGroup(id, clip);
    }
    
    @PutMapping("/update/remove/{id}")
    public void removeClipPrintedFromGroup(@PathVariable long id, @RequestBody ClipPrinted clip){
        clipPrintedService.removeClipPrintedFromGroup(id, clip);
    }
    
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClipPrintedByID(@PathVariable("id") long id) {
        clipPrintedService.deleteClipPrinted(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
