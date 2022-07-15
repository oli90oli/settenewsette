package com.sette.clipping.main.services;

import com.sette.clipping.main.model.RolesAndRights;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.RolesAndRightsRepository;

@Service
public class RolesAndRightsService {
    private final RolesAndRightsRepository roleAndRightsRepository;
       
        @Autowired
        public RolesAndRightsService(RolesAndRightsRepository roleAndRightsRepository) {
            this.roleAndRightsRepository = roleAndRightsRepository;
        }
        
        public RolesAndRights addRolesAndRights(RolesAndRights rolesAndRights) {
            return roleAndRightsRepository.save(rolesAndRights);
        }
        
        public List<RolesAndRights> findAllRolesAndRights() {
            return roleAndRightsRepository.findAll();
        }
        
        public void updateRolesAndRights(int id, RolesAndRights rolesAndRights) {
            RolesAndRights roleAndRight = this.findRolesAndRights(id);
            if(rolesAndRights.getPermission_id() != -1) {
                roleAndRight.setPermission_id(rolesAndRights.getPermission_id());
            }
            if(rolesAndRights.getRole_id() != -1) {
                roleAndRight.setRole_id(rolesAndRights.getRole_id());
            }
            if(!rolesAndRights.getRoles_and_rights_status().equals("")) {
                roleAndRight.setRoles_and_rights_status(rolesAndRights.getRoles_and_rights_status());
            }
            roleAndRightsRepository.save(roleAndRight);
        }
        
       public RolesAndRights findRolesAndRights(int id) {
            return this.findAllRolesAndRights().stream().filter(t -> t.getRoles_and_rights_id()== id).findFirst().get();
     } 
        
        public void deleteRolesAndRights(int id) {
            roleAndRightsRepository.deleteById(id);
        }  
}
