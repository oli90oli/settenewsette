package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Roles;
import com.sette.clipping.main.services.RolesService;
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
@RequestMapping("/roles")
public class RolesController {
    
    private final RolesService roleService;
    public RolesController(RolesService roleService){
        this.roleService = roleService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<Roles>> getAllRoles() {
        List<Roles> roles = roleService.findAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Roles> getRolesByID(@PathVariable("id") int id) {
        Roles roles = roleService.findRoles(id);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }  
 
    @PostMapping("/add")
    public ResponseEntity<Roles> addRoles(@RequestBody Roles role) {
        Roles newRole = roleService.addRoles(role);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateRoles(@PathVariable int id, @RequestBody Roles role){
        roleService.updateRoles(id, role);
    }
    
   @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRolesByID(@PathVariable("id") int id) {
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
    

