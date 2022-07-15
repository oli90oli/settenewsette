package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.MediumType;
import com.sette.clipping.main.services.MediumTypeService;
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
@RequestMapping("/mediumType")
public class MediumTypeController {

    private final MediumTypeService mediumTypeService;
    public MediumTypeController(MediumTypeService mediumTypeService){
        this.mediumTypeService = mediumTypeService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<MediumType>> getAllMediumType() {
        List<MediumType> mediumType = mediumTypeService.findAllMediumType();
        return new ResponseEntity<>(mediumType, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<MediumType> getMediumTypeByID(@PathVariable("id") int id) {
        MediumType mediumType = mediumTypeService.findMediumType(id);
        return new ResponseEntity<>(mediumType, HttpStatus.OK);
    }  
 
    @PostMapping("/add")
    public ResponseEntity<MediumType> addMediumType(@RequestBody MediumType mediumType) {
        MediumType newMediumType = mediumTypeService.addMediumType(mediumType);
        return new ResponseEntity<>(newMediumType, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateMediumType(@PathVariable int id, @RequestBody MediumType mediumType){
        mediumTypeService.updateMediumType(id, mediumType);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMediumTypeByID(@PathVariable("id") int id) {
        mediumTypeService.deleteMediumType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
