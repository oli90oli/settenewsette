package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Mediums;
import com.sette.clipping.main.services.MediumsService;
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
@RequestMapping("/mediums")
public class MediumsController {

    private final MediumsService mediumService;

    public MediumsController(MediumsService mediumService) {
        this.mediumService = mediumService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Mediums>> getAllMediums() {
        List<Mediums> mediums = mediumService.findAllMediums();
        return new ResponseEntity<>(mediums, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Mediums> getMediumsByID(@PathVariable("id") int id) {
        Mediums medium = mediumService.findMedium(id);
        return new ResponseEntity<>(medium, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Mediums> addMediums(@RequestBody Mediums medium) {
        Mediums newMedium = mediumService.addMediums(medium);
        return new ResponseEntity<>(newMedium, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public void updateMediums(@PathVariable int id, @RequestBody Mediums medium) {
        mediumService.updateMediums(id, medium);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMediumsByID(@PathVariable("id") int id) {
        mediumService.deleteMedium(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

