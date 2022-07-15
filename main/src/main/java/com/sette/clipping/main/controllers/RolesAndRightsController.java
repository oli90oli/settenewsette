package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.RolesAndRights;
import com.sette.clipping.main.services.RolesAndRightsService;
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
@RequestMapping("/rolesAndRights")
public class RolesAndRightsController {

    private final RolesAndRightsService rolesAndRightsService;
    public RolesAndRightsController(RolesAndRightsService rolesAndRightsService){
        this.rolesAndRightsService = rolesAndRightsService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<RolesAndRights>> getAllRolesAndRights() {
        List<RolesAndRights> rolesAndRights = rolesAndRightsService.findAllRolesAndRights();
        return new ResponseEntity<>(rolesAndRights, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<RolesAndRights> getRolesAndRightsByID(@PathVariable("id") int id) {
        RolesAndRights rolesAndRights = rolesAndRightsService.findRolesAndRights(id);
        return new ResponseEntity<>(rolesAndRights, HttpStatus.OK);
    }  
 
    @PostMapping("/add")
    public ResponseEntity<RolesAndRights> addRolesAndRights(@RequestBody RolesAndRights rolesAndRights) {
        RolesAndRights newRolesAndRights = rolesAndRightsService.addRolesAndRights(rolesAndRights);
        return new ResponseEntity<>(newRolesAndRights, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateRolesAndRights(@PathVariable int id, @RequestBody RolesAndRights rolesAndRights){
        rolesAndRightsService.updateRolesAndRights(id, rolesAndRights);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRolesAndRightsByID(@PathVariable("id") int id) {
        rolesAndRightsService.deleteRolesAndRights(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
    
    
}
