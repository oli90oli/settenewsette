package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Administrators;
import com.sette.clipping.main.services.AdministratorsService;
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
@RequestMapping("/administrators")
public class AdministratorsController {

    private final AdministratorsService adminService;
    public AdministratorsController(AdministratorsService adminService){
        this.adminService = adminService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<Administrators>> getAllAdministrators() {
        List<Administrators> administrators = adminService.findAllAdministrators();
        return new ResponseEntity<>(administrators, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Administrators> getAdministratorsByID(@PathVariable("id") int id) {
        Administrators administrator = adminService.findAdministrator(id);
        return new ResponseEntity<>(administrator, HttpStatus.OK);
    } 
 
    @PostMapping("/add")
    public ResponseEntity<Administrators> addAdministrators(@RequestBody Administrators administrator) {
        Administrators newAdministrator = adminService.addAdministrators(administrator);
        return new ResponseEntity<>(newAdministrator, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateAdministrators(@PathVariable int id, @RequestBody Administrators administrator){
        adminService.updateAdministrators(id, administrator);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAdministratorsByID(@PathVariable("id") int id) {
        adminService.deleteAdministrator(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
