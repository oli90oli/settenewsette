package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Permissions;
import com.sette.clipping.main.services.PermissionsService;
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
@RequestMapping("/permissions")
public class PermissionsController {

    private final PermissionsService permissionService;
    public PermissionsController(PermissionsService permissionService){
        this.permissionService = permissionService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<Permissions>> getAllPermissions() {
        List<Permissions> permissions = permissionService.findAllPermissions();
        return new ResponseEntity<>(permissions, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Permissions> getPermissionsByID(@PathVariable("id") int id) {
        Permissions permissions = permissionService.findPermissions(id);
        return new ResponseEntity<>(permissions, HttpStatus.OK);
    }  
 
    @PostMapping("/add")
    public ResponseEntity<Permissions> addPermissions(@RequestBody Permissions permission) {
        Permissions newPermission = permissionService.addPermissions(permission);
        return new ResponseEntity<>(newPermission, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updatePermissions(@PathVariable int id, @RequestBody Permissions permission){
        permissionService.updatePermissions(id, permission);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePermissionsByID(@PathVariable("id") int id) {
        permissionService.deletePermission(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
