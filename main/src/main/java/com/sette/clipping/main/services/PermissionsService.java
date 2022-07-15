package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Permissions;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.PermissionsRepository;

@Service
public class PermissionsService {
    private final PermissionsRepository permissionRepository;
       
        @Autowired
        public PermissionsService(PermissionsRepository permissionRepository) {
            this.permissionRepository = permissionRepository;
        }
        
        public Permissions addPermissions(Permissions permissions) {
            return permissionRepository.save(permissions);
        }
        
        public List<Permissions> findAllPermissions() {
            return permissionRepository.findAll();
        }
        
        public void updatePermissions(int id, Permissions permissions) {
            Permissions permission = this.findPermissions(id);
            if(!permissions.getPermissions_name().equals("")) {
                permission.setPermissions_name(permissions.getPermissions_name());
            }
            permissionRepository.save(permission);
        }
        
       public Permissions findPermissions(int id) {
            return this.findAllPermissions().stream().filter(t -> t.getPermissions_id()== id).findFirst().get();
     } 
        
        public void deletePermission(int id) {
            permissionRepository.deleteById(id);
        } 
}
